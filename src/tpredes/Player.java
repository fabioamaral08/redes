/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes;

import java.net.InetAddress;

/**
 *
 * @author Gustavoo
 */
public class Player {
    private InetAddress ip;
    private short status; //0 - Disponível, 1 - Criando partida, 2 - Jogando

    public Player(String ip, int porta){
        try{
            this.ip =  InetAddress.getByName(ip);
        }catch(Exception e){System.out.println("Erro no IP");}
        
        status = 0; //
    }
    
    public InetAddress getIp() {
        return ip;
    }
    
    public boolean equals(String ip){
        if(this.ip.getHostAddress().equals(ip)) return true;
        return false;
    }

    public void setIp(String ip) {
        try{
            this.ip =  InetAddress.getByName(ip);
        }catch(Exception e){System.out.println("Erro no IP");}
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
