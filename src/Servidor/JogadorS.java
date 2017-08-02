/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

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
    private int portaUDP;
    private int portaTCP;
    private String status;   //0 - Disponivel, 1 - Criando partida, 2 - Jogando
    
    public JogadorS(String IP, int portaUDP){
        try {
            this.IP = InetAddress.getByName(IP);
        } catch (UnknownHostException ex) {
            System.out.println("Erro no IP");
        }
        this.portaUDP = portaUDP;
        status = "0";
    }

    public InetAddress getIP() {
        return IP;
    }

    public void setIP(InetAddress IP) {
        this.IP = IP;
    }

    public int getPortaUDP() {
        return portaUDP;
    }

    public void setPortaUDP(int portaUDP) {
        this.portaUDP = portaUDP;
    }

    public int getPortaTCP() {
        return portaTCP;
    }

    public void setPortaTCP(int portaTCP) {
        this.portaTCP = portaTCP;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
