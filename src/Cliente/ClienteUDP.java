/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Gi Benvenuto
 */
public class ClienteUDP implements Runnable{
    private DatagramSocket ds;

    
    @Override
    public void run() {
       while(true){
        try {
            byte[] mensagem = new byte[1024];
            DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length);
            this.ds.receive(dp);
            
            String msg = new String(dp.getData());
            
            verificaMsg(msg,dp);
        } catch (IOException ex) {
            System.out.println("Erro ao receber mensagem UDP cliente");
        }
       }
    }

    private void verificaMsg(String msg, DatagramPacket dp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPorta(){
        return this.ds.getPort();
    }
}
