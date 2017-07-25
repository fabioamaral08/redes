/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes;
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
    private Socket sockets;
    private int porta;
    private Peao peao;
    private int num;
    
    
    
    public JogadorC(String ip, int porta,int num){
        
        try {
            this.ip = InetAddress.getByName(ip);
        } catch (UnknownHostException ex) {
            System.out.println("Erro ao ler IP");
        }
        this.porta = porta;
        this.peao = new Peao();
        this.num = num;
        
        addJogador(ip,num);
        
    }
    
    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Peao getPeao() {
        return peao;
    }

    public void setPeao(Peao peao) {
        this.peao = peao;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public void addJogador(String ip, int porta){
        Socket soc = new Socket();
        try {
            InetSocketAddress sa = new InetSocketAddress(InetAddress.getByName(ip),porta);
            soc.connect(sa);
            this.sockets = soc;
        } catch (UnknownHostException ex) {
            System.out.println("Erro ao adicionar Jogador");
        } catch (IOException ex) {
            Logger.getLogger(JogadorC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void finaliza(){
        try {
            this.sockets.close();
        } catch (IOException ex) {
            System.out.println("Erro ao finalizar conexão");
        }
    }
    
    
    
}
