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
    private int porta;
    private int num;
    private int capital;
    private int pos;
    private boolean preso;
    private boolean cartaPrisao;
    
    public JogadorC(String ip, int num){
        this.num = num;
        this.capital = 2500;
        this.pos = 0;
        this.preso = false;
        this.cartaPrisao = false;
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

    public int getCapital() {
        return capital;
    }

    public void alteraCapital(int capital) {
        this.capital += capital;
    }

    public boolean isCartaPrisao() {
        return cartaPrisao;
    }

    public void setCartaPrisao(boolean cartaPrisao) {
        this.cartaPrisao = cartaPrisao;
    }
    
    public String getIP(){
        return this.ip.getHostAddress();
    }
    
    public int getPorta(){
        return this.porta;
    }
    public void setPorta(int porta){
        this.porta = porta;
    }
}
