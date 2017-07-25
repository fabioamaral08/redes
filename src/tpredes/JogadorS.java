/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavoo
 */
public class JogadorS {
    private InetAddress IP;
    private String porta;
    private short status;   //0 - Disponivel, 1 - Criando partida, 2 - Jogando
    
    public JogadorS(String IP, String porta){
        try {
            this.IP = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.out.println("Erro no IP");
        }
        this.porta = porta;
        status = 0;
    }

    public InetAddress getIP() {
        return IP;
    }

    public void setIP(InetAddress IP) {
        this.IP = IP;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
