/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Aplicacao.JogadorC;
import java.io.BufferedReader;
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
 * @author Gi Benvenuto
 */
public class ClienteUDP implements Runnable{
    private DatagramSocket ds;
    private Aplicacao app;
    
    private int status;
    
    public ClienteUDP(){
        
    }
    
    
    public void conectaServer(String ip, int portaS){
        try {
            this.status = 0; //Online
            ds = new DatagramSocket();
            byte[] msg = new byte[1024];
            String texto = "001 "+InetAddress.getLocalHost().getHostAddress();
            msg = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(msg, msg.length,InetAddress.getByName(ip), portaS);

            ds.send(dp);
            ds.close();

             
        } catch (IOException ex) {
            System.out.println("Erro ao enviar pacote UDP");
        }
    }

    
    public void criarSala (String ip, int portaS, int aberto){
        int i;
        this.status = 2;//Criando Sala
        try {
            ds = new DatagramSocket();
            byte[] msg = new byte[1024];
            String texto = "000 "+ InetAddress.getLocalHost().getHostAddress();
            DatagramPacket dp = new DatagramPacket(msg, msg.length, InetAddress.getByName(ip), portaS);                       
            
            msg = texto.getBytes();
            ds.send(dp);
            ds.close();             
            

        } catch (SocketException ex) {
            System.out.println("Erro ao criar Socket do cliente");
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // Criar uma opção de sair na interface !!!
    public void encerrarConexao (String ip, int portaS){
        
            
        try {
            ds = new DatagramSocket();
            byte[] msg = new byte[1024];
            String texto = "070";
            msg = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(msg, msg.length, InetAddress.getByName(ip), portaS);

            ds.send(dp);
            ds.close();
            
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
    }
    
    
    
    
    private void verificaMsg(String msg, DatagramPacket dp) {
        try {
            InetAddress ip;
            int porta;
            byte[] resp = new byte[1024];
            String texto;
            DatagramPacket dataP;
            StringTokenizer tk = new StringTokenizer(msg, " ");
            
            switch (tk.nextToken()){
                case "101" : //Recebendo jogadores do servidor
                    if (this.status == 2){
                    resp = new byte[1024];
                    ip = InetAddress.getByName(tk.nextToken());
                    porta = Integer.parseInt(tk.nextToken());
                    texto = "010 "+ app.isAberto();
                    resp = texto.getBytes();
                    ds = new DatagramSocket();
                    dataP = new DatagramPacket (resp, resp.length, ip, porta);
                    ds.send(dp);
                    ds.close();
                    }
                    
                    break;
                    
                case "110": // Recebendo resposta do convite
                    if (app.getSenha() ==  tk.nextToken()){
                        ArrayList<JogadorC> jC = app.getJogadores();
                        int n = jC.size();
                        resp = new byte[1024];
                        ip = dp.getAddress();
                        porta = dp.getPort();
                        if (n == 4){
                            texto = "010 -1 0";// Sala cheia
                         
                        
                        resp = texto.getBytes();
                        dataP = new DatagramPacket(resp, resp.length, ip, porta);
                        ds = new DatagramSocket();
                        ds.send(dp);
                        texto = "120 ";
                        for (JogadorC j : jC){
                            
                            ip = InetAddress.getByName(j.getIP());
                            porta = j.getPorta();
                            texto += ip + " "+ porta + " ";
                            
                            String aux = "021 "+dp.getAddress()+" "+dp.getPort();
                            resp = new byte[1024];
                            resp = aux.getBytes();
                            ds = new DatagramSocket();
                            dataP = new DatagramPacket(resp, resp.length, ip, porta);
                            ds.send(dp);
                            
                        }
                        
                        resp = new byte[1024];
                        resp = texto.getBytes();
                        ds = new DatagramSocket();
                        dataP = new DatagramPacket(resp, resp.length, ip, porta);
                        ds.send(dp);
                        
                        ds.close();
                        
                    } else{
                        texto = "010 "+ n;
                        resp = texto.getBytes();
                        dataP = new DatagramPacket(resp, resp.length, ip, porta);
                        ds = new DatagramSocket();
                        ds.send(dp);
                    }

                    }
                    else {
                        resp = new byte[1024];
                        ip = dp.getAddress();
                        porta = dp.getPort();
                        texto = "010 -1 1";//Senha errada
                        resp = texto.getBytes();
                        ds = new DatagramSocket();
                        dataP = new DatagramPacket(resp, resp.length, ip, porta);
                        ds.send(dp);
                        ds.close();
                    }
                    break;
                    
                case "010": //Recebendo convite
                    
                    
                    break;
            }
            
            
            
            
            
            
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    //Não sei como fazer aquela do servidor verificando

    
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



    public int getPorta(){
        return this.ds.getPort();
    }
}
