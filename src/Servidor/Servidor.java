/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import tpredes.IU.ServidorUI;


/*
 *
 * @author Gustavoo
 */
public class Servidor implements Runnable {

    private final ArrayList<JogadorS> players;
    private DatagramSocket dS;
    private DatagramPacket dt; 
    private String mensagem;
    private ServidorUI serverui;

    public Servidor() {
        try {

            this.dS = new DatagramSocket(54321);

            try {
                System.out.println(dS.getLocalPort() + "\n" + InetAddress.getLocalHost().getHostAddress());
            } catch (UnknownHostException ex) {
                System.out.println("Erro print construtor");
            }

        } catch (SocketException ex) {
            System.out.println("Erro Construtor");
        }
        this.players = new ArrayList();
    }
    
    public void setUI(ServidorUI serverui){
        this.serverui = serverui;
    }

    public ArrayList<JogadorS> getPlayers() {
        return players;
    }

    public ArrayList getDisponiveis() {
        ArrayList<JogadorS> dPlayers = new ArrayList();

        for(JogadorS j : this.players){
            if(j.getStatus().equals("0")){
                dPlayers.add(j);
            }
        }
        return dPlayers;
    }

    public ArrayList getCriadores() {
        ArrayList<JogadorS> cPlayers = new ArrayList();

        for(JogadorS j : this.players){
            if(j.getStatus().equals("1")){
                cPlayers.add(j);
            }
        }
        return cPlayers;
    }

    public void alteraStatus(String estado, InetAddress ip) {
        for (JogadorS j : this.players) {
            if (j.getIP().getHostAddress().equals(ip.getHostAddress())) {
                j.setStatus(estado);
                return;
            }
        }

    }
    
    public void removePlayer (String ip){
       for (JogadorS p : this.players) {
            if (p.getIP().getHostAddress().equals(ip)) {
                this.players.remove(p);
            }
        } 
    }

    public JogadorS getPlayer(String ip) {
        for (JogadorS p : this.players) {
            if (p.getIP().getHostAddress().equals(ip)) {
                return p;
            }
        }
        return null;
    }

    public void escuta() {

        while (true) {

            try {
                byte[] resposta = new byte[1024];
                this.dt = new DatagramPacket(resposta, resposta.length);
                dS.receive(dt);
          
                this.mensagem = new String(dt.getData());

                verificaMensagem(dt);
                
                this.serverui.atualiza();

            } catch (IOException ex) {
                System.out.println("Erro Escuta");
            }
        }

    }

    @Override
    public void run() {
        DatagramPacket dp = this.dt;
        verificaMensagem(dp);
    }

    public void verificaMensagem(DatagramPacket dt) {
        StringTokenizer tk = new StringTokenizer(mensagem, " ");
        DatagramSocket ds;
        DatagramPacket dp;
        String ip;
        JogadorS jS;
        byte[] resposta;
        int porta;

        switch (tk.nextToken()) {
            case "000": //Nova Sala
                ArrayList<JogadorS> disponiveis = getDisponiveis();
                ip = tk.nextToken();
                jS = getPlayer(ip);
                if (jS != null) {
                    try {
                        porta = Integer.valueOf(tk.nextToken());
                        String convbytes = "100 " //qntdade de jogadores disponiveis
                                + Integer.toString(disponiveis.size());
                        resposta = convbytes.getBytes();
                        ds = new DatagramSocket();
                        dp = new DatagramPacket(resposta, resposta.length, jS.getIP(), porta);
                        ds.send(dp); //Envia a resposta
                        for (JogadorS j : disponiveis) {  //Enquanto não percorrer todos os disponíveis
                            convbytes = "101 " + j.getIP().getHostAddress(); //Envia o IP dos jogadores
                            resposta = convbytes.getBytes();
                            ds = new DatagramSocket();
                            dp = new DatagramPacket(resposta, resposta.length, j.getIP(), porta);
                            ds.send(dp);
                        }
                    } catch (NumberFormatException | IOException e) {
                        System.out.println("Não foi possível responder a solicitação 000");
                    }
                }
                break;
            case "001": //Novo Jogador Online
                ip = tk.nextToken(); //IP do novo jogador
                jS = new JogadorS(ip, dt.getPort());
                this.players.add(jS); //Add novo jogador online
                ArrayList<JogadorS> criadores = getCriadores();

                for (JogadorS j : criadores) {
                    try {
                        porta = j.getPortaUDP();
                        String convbytes = "102 " //Novo Jogador Online
                                + ip;
                        resposta = convbytes.getBytes();
                        ds = new DatagramSocket();
                        dp = new DatagramPacket(resposta, resposta.length, j.getIP(), porta);
                        ds.send(dp); //Envia a resposta

                    } catch (Exception e) {
                        System.out.println("Não foi possível responder a solicitação 001");
                    }

                }
                break;

            case "002": //Novo Status
                try {
                    InetAddress ip1 = dt.getAddress();
                    String status = tk.nextToken();
                    alteraStatus(status, ip1);

                } catch (NumberFormatException e) {
                    System.out.println("Não foi possível atender a solicitação 002");
                }
                break;
                
            case "070":
                try{
                   ip = dt.getAddress().toString();
                   removePlayer(ip);                    
                    
                } catch (Exception e){
                    System.out.println("Não foi possível atender a solicitação 007");
                }
            default:
                System.out.println("Default");
        }
    }

}
