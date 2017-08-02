/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ClienteUDP implements Runnable{
    private DatagramSocket soc;
    private int porta;
    
    public void conectaServer(String ip, int porta){
        try {
            this.soc = new DatagramSocket();
            this.porta = this.soc.getPort();
            
            byte[] msg = new byte[1024];
            String texto = "001 " + InetAddress.getLocalHost().getHostAddress();
            msg = texto.getBytes();
            InetAddress serv = InetAddress.getByName(ip);
            DatagramPacket dp = new DatagramPacket(msg,msg.length,serv, porta);
            
            this.soc.send(dp);
        } catch (SocketException ex) {
            System.out.println("Erro ao criar Socket UDP do cliente");
        } catch (IOException ex) {
            System.out.println("Erro ao enviar pacote UDP");
        }
    }

    @Override
    public void run() {
       while(true){
        try {
            byte[] mensagem = new byte[1024];
            DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length);
            this.soc.receive(dp);
            
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
}
