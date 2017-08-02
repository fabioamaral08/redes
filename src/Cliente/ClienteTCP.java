/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ClienteTCP implements Runnable{
    private ServerSocket servSoc;

    public ClienteTCP() {
        try {
            this.servSoc = new ServerSocket();
        } catch (IOException ex) {
            System.out.println("Erro ao criar ServerSocket do cliete");
        }
    }
    
    public void escuta(){
        
    }
    
    @Override
    public void run() {
       //switch
    }
    
}
