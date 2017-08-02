package Cliente;

import java.net.*;
import java.util.ArrayList;

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
