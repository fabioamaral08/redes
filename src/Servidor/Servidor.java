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
import java.util.logging.Level;
import java.util.logging.Logger;
import tpredes.JogadorS;

/*
 *
 * @author Gustavoo
 */
public class Servidor implements Runnable{

    private final ArrayList<JogadorS> players;
    private DatagramSocket dS;
    private DatagramPacket dt;
    private byte[] resposta;
    
    public Servidor (){        
        try {
            this.resposta = new byte[1024];
            this.dS = new DatagramSocket();
            this.dt = new DatagramPacket(this.resposta, this.resposta.length);
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.players = new ArrayList();   
    }



    public ArrayList getDisponiveis() {
        ArrayList<JogadorS> dPlayers = new ArrayList();
        
        for (JogadorS j : this.players){
            if (j.getStatus() == 0){
                dPlayers.add(j);
            }
        }
        return dPlayers;
    }
    
    public ArrayList getCriadores() {
        ArrayList<JogadorS> cPlayers = new ArrayList();
        
        for (JogadorS j: this.players){
            if (j.getStatus() == 1){
                cPlayers.add(j);
            }
        }
        return cPlayers;
    }
    
    

    public void alteraStatus(short estado, InetAddress ip) {
        JogadorS jS;
        for(JogadorS j: this.players){
            
        }

    }



    public JogadorS getPlayer(String ip) {
        for (JogadorS p : this.players) {
            if (p.equals(ip)) {
                return p;
            }
        }
        return null;
    }
    
    public void escuta() throws IOException{
        String print;
        boolean fim = true;
        dS.receive(dt);
        
        Thread t = new Thread((Runnable) this);
        t.start();
        
       
    }
    
        @Override
    public void run() {
        
        verificaMensagem(new String(dt.getData()));
    }

    public void verificaMensagem(String mensagem) {
        StringTokenizer tk = new StringTokenizer(mensagem, " ");
        DatagramSocket ds;
        DatagramPacket dp;
        String ip;
        JogadorS jS;
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
                        for(JogadorS j : disponiveis){  //Enquanto não percorrer todos os disponíveis
                            convbytes = "101 " + j.getIP().getHostAddress(); //Envia o IP dos jogadores
                            resposta = convbytes.getBytes();
                            ds = new DatagramSocket();
                            dp = new DatagramPacket(resposta, resposta.length, j.getIP(), porta);
                            ds.send(dp);
                        }
                    } catch (Exception e) {
                        System.out.println("Não foi possível responder a solicitação 000");
                    }
                }
            case "001": //Novo Jogador Online
 
                ip = tk.nextToken(); //IP do novo jogador
                jS = new JogadorS(ip, dt.getPort());
                this.players.add(jS); //Add novo jogador online
                ArrayList<JogadorS> criadores = getCriadores();

                for (JogadorS j : criadores) {
                    try {
                        porta = j.getPorta();
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
                
            case "002": //Novo Status
                try{
                    InetAddress ip1 = dt.getAddress();
                    short status = (short)Integer.parseInt(tk.nextToken());
                    alteraStatus(status, ip1);
                    
                    
                }
                catch(Exception e) {
                    System.out.println("Não foi possível atender a solicitação 002");
                }
                
        }
    }


    
}
