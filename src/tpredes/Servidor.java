/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 *
 * @author Gustavoo
 */
public class Servidor {

    private final ArrayList<Player> players = new ArrayList();

    public void addPlayer(Player player) {

    }

    public void removePlayer(Player player) {

    }

   /* public ArrayList getDisponiveis() {
        return caciuabscuabsicabsics;
    }*/

    public void alteraStatus(short estado, Player player) {

    }

    public void verificaOnlines() {

    }

    public Player getPlayer(String ip) {
        for (Player p : this.players) {
            if (p.equals(ip)) {
                return p;
            }
        }
        return null;
    }

    /*public void verificaMensagem(String mensagem) {
        StringTokenizer tk = new StringTokenizer(mensagem, " ");
        DatagramSocket ds;
        DatagramPacket dp;
        byte[] resposta = new byte[1024];
        int porta;

        switch (tk.nextToken()) {
            case "000":
                ArrayList<Player> disponiveis; = getDisponiveis();
                String ip = tk.nextToken();
                Player p = getPlayer(ip);
                if (p != null) {
                    try {
                        porta = Integer.valueOf(tk.nextToken());
                        String convbytes = "100 "
                                + Integer.toString(disponiveis.size());
                        resposta = convbytes.getBytes();
                        ds = new DatagramSocket();
                        dp = new DatagramPacket(resposta, resposta.length, p.getIp(), porta);
                        ds.send(dp);
                        for(Player pl : disponiveis){
                            convbytes = "101 " + pl.getIp().getHostAddress();
                            resposta = convbytes.getBytes();
                            ds = new DatagramSocket();
                            dp = new DatagramPacket(resposta, resposta.length, p.getIp(), porta);
                            ds.send(dp);
                        }
                    } catch (Exception e) {
                        System.out.println("Deu merda");
                    }
                }
        }
    }*/

}