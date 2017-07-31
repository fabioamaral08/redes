/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpredes;

import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Aplicacao implements Runnable{
    private ServerSocket ss;
    private DatagramSocket socUDP;
    private int portaUDP;
    private int portaTCP;
    private ArrayList<JogadorC> jogadores;
    private int num;
    private String ipServer;
    private int portaServer;

    @Override
    public void run() {
        
    }
    
    public void fazerProposta(int jog, int prop){
        
    }
    
    public void enviaMensagem(String cod){
        
    }
    
}
