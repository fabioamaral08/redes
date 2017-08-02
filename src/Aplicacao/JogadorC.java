/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class JogadorC {
    private InetAddress ip;
    private int num;
    
    private int pos;
    private boolean preso;
    
    public JogadorC(String ip, int num){
        this.num = num;
        this.pos = 0;
        this.preso = false;
        try {
            this.ip = InetAddress.getByName(ip);
        } catch (UnknownHostException ex) {
            System.out.println("Erro com IP");
        }
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public boolean isPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }
    
    
}
