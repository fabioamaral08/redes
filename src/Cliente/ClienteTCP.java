/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Aplicacao.JogadorC;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ClienteTCP implements Runnable{
    private DatagramSocket ds;
    private Socket soc;
    private int status;
    
    
    public void conectaServer(String ip, int portaS, int portaUDP){
        try {
            this.soc = new Socket(ip, portaS);
            byte[] msg = new byte[1024];

            DataOutputStream serv = new DataOutputStream(this.soc.getOutputStream());
            String texto = "001 "+InetAddress.getLocalHost().getHostAddress() + " " + portaUDP; //Mudar

            serv.writeBytes(texto);
            this.soc.close();
             
        } catch (SocketException ex) {
            System.out.println("Erro ao criar Socket UDP do cliente");
        } catch (IOException ex) {
            System.out.println("Erro ao enviar pacote UDP");
        }
    }

    
    public void criarSala (String ip, int porta, int aberto){
        int i;
        this.status = 2;//Criando S
        try {
           // this.soc = new Socket(ip, porta);
                       
            String resp;
            String texto = "000 "+ InetAddress.getLocalHost().getHostAddress() + " "+
                    //this.porta;
            DataOutputStream serv = new DataOutputStream(this.soc.getOutputStream());
            serv.writeBytes(texto);
            
            BufferedReader br = new BufferedReader(new InputStreamReader (this.soc.getInputStream()));
            
            resp = br.readLine();
            StringTokenizer tk = new StringTokenizer(resp, " ");
            
            if (tk.nextToken() == "100"){ //Mensagem de qntd de jogadores disponiveis
                
                int n = Integer.parseInt(tk.nextToken()); 
                
                for (i = 0; i< n; i++){  //Enquanto não chegar todos os jogadores
                    
                    br = new BufferedReader(new InputStreamReader (this.soc.getInputStream()));
                    resp = br.readLine();
                    tk = new StringTokenizer(resp, " ");
                    
                    if (tk.nextToken() == "101"){
                        texto = "010 " + aberto;
                        Socket sk = new Socket (tk.nextToken(), Integer.parseInt(tk.nextToken()));
                        serv = new DataOutputStream(sk.getOutputStream());
                        serv.writeBytes(texto);
                    }
                    
                }
                
            }
            
            this.soc.close();
                        
            

        } catch (SocketException ex) {
            System.out.println("Erro ao criar Socket do cliente");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Criar uma opção de sair na interface !!!
    public void encerrarConexao (){
        try {
            
            DataOutputStream serv = new DataOutputStream (this.soc.getOutputStream());
            String texto = "070";
            serv.writeBytes(texto);
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Não sei como fazer aquela do servidor verificando

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
