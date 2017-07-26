/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *
 * @author Gustavoo
 */
public class Servidor {

    private final ArrayList<JogadorS> players = new ArrayList();




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

    public void verificaMensagem(DatagramPacket dt, String mensagem) {
        StringTokenizer tk = new StringTokenizer(mensagem, " ");
        DatagramSocket ds;
        DatagramPacket dp;
        String ip;
        JogadorS jS;
        byte[] resposta = new byte[1024];
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
