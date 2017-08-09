/*
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
    private DatagramPacket dP;
    private String mensagem;
    private ServidorUI serverui;
    private int prox;

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
        this.prox = 0;
    }

    public void setUI(ServidorUI serverui) {
        this.serverui = serverui;
    }

    public ArrayList<JogadorS> getPlayers() {
        return players;
    }

    public ArrayList getDisponiveis() {
        ArrayList<JogadorS> dPlayers = new ArrayList();

        for (JogadorS j : this.players) {
            if (j.getStatus().equals("0")) {
                dPlayers.add(j);
            }
        }
        return dPlayers;
    }

    public ArrayList getCriadores() {
        ArrayList<JogadorS> cPlayers = new ArrayList();

        for (JogadorS j : this.players) {
            if (j.getStatus().equals("1")) {
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

    public void removePlayer(String ip) {
        for (JogadorS p : this.players) {
            if (p.getIP().getHostAddress().equals(ip)) {
                this.players.remove(p);
            }
        }
    }

    public JogadorS getPlayer(int i) {
        return this.players.get(i);
    }

    public void escuta() {

        while (true) {

            try {
                byte[] resposta = new byte[1024];
                this.dP = new DatagramPacket(resposta, resposta.length);
                dS.receive(dP);

                this.mensagem = new String(dP.getData());

                verificaMensagem(dP);

                this.serverui.atualiza();

            } catch (IOException ex) {
                System.out.println("Erro Escuta");
            }
        }

    }

    @Override
    public void run() {
        DatagramPacket dp = this.dP;
        verificaMensagem(dp);
    }

    public void verificaMensagem(DatagramPacket dt) {
        StringTokenizer tk = new StringTokenizer(mensagem, " ");
        DatagramSocket dsResp;
        DatagramPacket dpResp;
        String ip;
        JogadorS jS;
        byte[] resposta;
        int porta;

        switch (tk.nextToken()) {
            case "000": //Nova Sala
                ArrayList<JogadorS> disponiveis = getDisponiveis();
                int num = Integer.parseInt(tk.nextToken());
                jS = getPlayer(num);
                if (jS != null) {
                    try {
                        porta = Integer.valueOf(tk.nextToken());
                        String convbytes;

                        for (JogadorS j : disponiveis) {  //Enquanto não percorrer todos os disponíveis
                            convbytes = "101 " + j.getEnderecoIP() + " " + j.getPortaUDP(); //Envia o IP dos jogadores
                            resposta = convbytes.getBytes();
                            dsResp = new DatagramSocket();
                            dpResp = new DatagramPacket(resposta, resposta.length, j.getIP(), porta);
                            dsResp.send(dpResp);
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
                try {
                    String convbytes = "100 " //Novo Jogador Online
                            + Integer.toString(this.prox);
                    this.prox++;
                    resposta = convbytes.getBytes();
                    dsResp = new DatagramSocket();
                    dpResp = new DatagramPacket(resposta, resposta.length, jS.getIP(), jS.getPortaUDP());
                    dsResp.send(dpResp); //Envia a resposta

                    for (JogadorS j : criadores) {

                        porta = j.getPortaUDP();
                        convbytes = "102 " //Novo Jogador Online
                                + ip;
                        resposta = convbytes.getBytes();
                        dsResp = new DatagramSocket();
                        dpResp = new DatagramPacket(resposta, resposta.length, j.getIP(), porta);
                        dsResp.send(dpResp); //Envia a resposta

                    }
                } catch (Exception e) {
                    System.out.println("Não foi possível responder a solicitação 001");
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
                try {
                    ip = dt.getAddress().toString();
                    removePlayer(ip);

                } catch (Exception e) {
                    System.out.println("Não foi possível atender a solicitação 007");
                }
            default:
                System.out.println("Default");
        }
        this.serverui.atualiza();
    }

}
