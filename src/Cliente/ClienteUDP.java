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
import javax.swing.JOptionPane;
import tpredes.IU.ClienteUI;

/**
 *
 * @author Gi Benvenuto
 */
public class ClienteUDP implements Runnable {

    private DatagramSocket ds;
    private DatagramSocket dsEscuta;
    private Aplicacao app;

    private int status;

    public ClienteUDP(ClienteUI c) {
        try {
            this.ds = new DatagramSocket();
            this.app = new Aplicacao(c);
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void conectaServer(String ip, int portaS) {
        try {
            this.status = 0; //Online
            ds = new DatagramSocket();
            int port = ds.getLocalPort();
            byte[] msg = new byte[1024];
            String texto = "001 " + InetAddress.getLocalHost().getHostAddress() + " ";
            msg = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(msg, msg.length, InetAddress.getByName(ip), portaS);
            this.app.setIpServer(ip);
            this.app.setPortaServer(portaS);
            ds.send(dp);

            ds.close();
            this.dsEscuta = new DatagramSocket(port);

        } catch (IOException ex) {
            System.out.println("Erro ao enviar pacote UDP");
            this.app.erroServerUI();
        }
    }

    public void criarSala(int aberto) {
        int i;
        String ip = this.app.getIpServer();
        int portaS = this.app.getPortaServer();
        this.status = 2;//Criando Sala
        this.app.addJog(InetAddress.getLocalHost().toString(), this.dsEscuta.getLocalPort());

        if (aberto == 0) {
            this.app.setSenha(JOptionPane.showInputDialog(null, "Digite a senha"));
        } else {
            this.app.setSenha("null");
        }
        try {
            ds = new DatagramSocket();
            byte[] msg = new byte[1024];

            String texto = "000 " + this.app.getPosServ() + " " + this.dsEscuta.getLocalPort() + " ";
            msg = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(msg, msg.length, InetAddress.getByName(ip), portaS);
            ds.send(dp);

            ds.close();

        } catch (SocketException ex) {
            System.out.println("Erro ao criar Socket do cliente");
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Criar uma opção de sair na interface !!!
    public void encerrarConexao() {

        try {
            ds = new DatagramSocket();
            byte[] msg = new byte[1024];
            String texto = "070 " + this.app.getPosServ() + " ";
            msg = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(msg, msg.length, InetAddress.getByName(this.app.getIpServer()), this.app.getPortaServer());

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

            switch (tk.nextToken()) {
                case "101": //Recebendo jogadores do servidor
                    System.out.println("134 (ClienteUDP)- Recebeu jogador do servidor");
                    if (this.status == 2) {
                        resp = new byte[1024];
                        ip = InetAddress.getByName(tk.nextToken());
                        porta = Integer.parseInt(tk.nextToken());
                        System.out.println("140 clienteUDP - Porta do jogador " + porta + " " + ip.getHostAddress());
                        texto = "010 " + app.isAberto() + " ";
                        resp = texto.getBytes();
                        ds = new DatagramSocket();
                        dataP = new DatagramPacket(resp, resp.length, ip, porta);
                        ds.send(dataP);
                        System.out.println("144 clienteUDP - Enviou convite");
                        ds.close();
                    }

                    break;

                case "110": // Recebendo resposta do convite
                    if (app.getSenha().equals(tk.nextToken())) {
                        ArrayList<JogadorC> jC = app.getJogadores();
                        int n = jC.size();
                        resp = new byte[1024];
                        ip = dp.getAddress();
                        porta = Integer.parseInt(tk.nextToken());
                        if (n == 4) {
                            texto = "020 -1 ";// Sala cheia

                            resp = texto.getBytes();
                            dataP = new DatagramPacket(resp, resp.length, ip, porta);
                            ds = new DatagramSocket();
                            ds.send(dataP);

                        } else {
                            texto = "020 " + n + " ";
                            resp = texto.getBytes();
                            dataP = new DatagramPacket(resp, resp.length, ip, porta);
                            ds = new DatagramSocket();
                            ds.send(dataP);
                            texto = "120 ";

                            String aux = "021 " + ip + " " + porta + " ";
                            resp = new byte[1024];
                            resp = aux.getBytes();
                            
                            for (JogadorC j : jC) {

                                String ip1 = j.getIP();
                                int porta1 = j.getPorta();
                                texto += ip1 + " " + porta1 + " "; //ip e porta da galera

                                ds = new DatagramSocket();
                                dataP = new DatagramPacket(resp, resp.length, InetAddress.getByName(ip1), porta1);
                                ds.send(dataP);

                            }
                            texto += " ";
                            resp = new byte[1024];
                            resp = texto.getBytes();
                            ds = new DatagramSocket();
                            dataP = new DatagramPacket(resp, resp.length, ip, porta);
                            ds.send(dataP);

                            ds.close();

                        }

                    } else {
                        resp = new byte[1024];
                        ip = dp.getAddress();
                        porta = dp.getPort();
                        texto = "020 -2 ";//Senha errada
                        resp = texto.getBytes();
                        ds = new DatagramSocket();
                        dataP = new DatagramPacket(resp, resp.length, ip, porta);
                        ds.send(dataP);
                        ds.close();
                    }
                    break;

                case "010": //Recebendo convite
                    System.out.println("210 (ClienteUDP) - Recebeu convite");
                    String ipConv = dp.getAddress().getHostAddress();
                    int portaConv = dp.getPort();
                    String senha = tk.nextToken();
                    Convite c = new Convite(ipConv, portaConv, senha);

                    this.app.novoConvite(c);
                    break;
                    
                case "020": //num jogadores
                    this.app.numJogadores (Integer.parseInt(tk.nextToken()));             
                    
                    break;

                case "030": //Saida
                    int n = Integer.parseInt(tk.nextToken());
                    this.app.removeJog(n);

                    break;

                case "040": //Dados
                    int d1,
                     d2;
                    d1 = Integer.parseInt(tk.nextToken());
                    d2 = Integer.parseInt(tk.nextToken());
                    this.app.setDados(d1, d2);
                    break;

                case "041": //Saldo
                    int saldo = Integer.parseInt(tk.nextToken());
                    ArrayList<JogadorC> jC = this.app.getJogadores();
                    jC.get(Integer.parseInt(tk.nextToken())).alteraCapital(saldo);
                    break;

                case "042": //Novo dono propriedade e valor
                    int prop,
                     dono;
                    prop = Integer.parseInt(tk.nextToken());
                    dono = Integer.parseInt(tk.nextToken());

                    this.app.setNovoDono(prop, dono);

                    break;

                case "043": //Propriedades
                    int propriedade = Integer.parseInt(tk.nextToken());
                    this.app.addConstrucao(propriedade);

                    break;

                case "044": //Sorte ou revés num carta
                    int carta = Integer.parseInt(tk.nextToken());
                    int num = Integer.parseInt(tk.nextToken());

                    this.app.conseqCartaSR(carta, num);

                    break;

                case "045": //Fim de turno null
                    this.app.fimTurno();
                    break;

                case "050":
                    int propriedadeP = Integer.parseInt(tk.nextToken());
                    int valorP = Integer.parseInt(tk.nextToken());

                    int opc = JOptionPane.showConfirmDialog(null, "Voce recebeu uma proposta no valor de " + valorP + "pela propriedade " + propriedadeP);

                    if (opc == 0) {
                        ds = new DatagramSocket();
                        resp = new byte[1024];
                        texto = "150 1 ";
                        resp = texto.getBytes();
                        dataP = new DatagramPacket(resp, resp.length,
                                dp.getAddress(), dp.getPort());

                        ds.send(dataP);
                    } else {
                        ds = new DatagramSocket();
                        resp = new byte[1024];
                        texto = "150 0 ";
                        resp = texto.getBytes();
                        dataP = new DatagramPacket(resp, resp.length,
                                dp.getAddress(), dp.getPort());
                        ds.send(dataP);
                    }

                    break;

                case "100":
                    String pos = tk.nextToken();
                    this.app.setPosServ(pos);
                    System.out.println("273 (ClienteUDP) -  minha posição:" + this.app.getPosServ());
                    break;

                case "062": //
                    this.status = 0; //Online
                    ds = new DatagramSocket();
                    resp = new byte[1024];
                    texto = "002 0 ";
                    resp = texto.getBytes();
                    dataP = new DatagramPacket(resp, resp.length, InetAddress.getByName(this.app.getIpServer()), this.app.getPortaServer());
                    ds.send(dataP);
                    JOptionPane.showMessageDialog(null, "Fim de Partida");

                    break;

                case "063":
                    this.status = 1; //Jogando
                    ds = new DatagramSocket();
                    resp = new byte[1024];
                    texto = "002 1 ";
                    resp = texto.getBytes();
                    dataP = new DatagramPacket(resp, resp.length, InetAddress.getByName(this.app.getIpServer()), this.app.getPortaServer());
                    ds.send(dataP);
                    JOptionPane.showMessageDialog(null, "Inicio de Partida");
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

    public void fazerProposta(int pro, int valor, int jog) {
        try {
            ds = new DatagramSocket();
            byte[] resp = new byte[1024];
            String texto = "050 " + pro + " " + valor + " ";
            resp = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(resp, resp.length,
                    InetAddress.getByName((this.app.getJogadores().get(jog).getIP())),
                    this.app.getJogadores().get(jog).getPorta());
            ds.send(dp);
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rDados(int d1, int d2) {

        try {

            byte[] msg = new byte[1024];
            String texto = "040 " + d1 + " " + d2 + " ";
            msg = texto.getBytes();
            for (JogadorC j : app.getJogadores()) {

                DatagramPacket dp = new DatagramPacket(msg, msg.length, InetAddress.getByName(j.getIP()), j.getPorta());
                ds.send(dp);

            }
            ds.close();
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Não sei como fazer aquela do servidor verificando
    @Override
    public void run() {

        while (true) {
            try {
                byte[] mensagem = new byte[1024];
                DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length);
                this.dsEscuta.receive(dp);

                String msg = new String(dp.getData());

                verificaMsg(msg, dp);
            } catch (IOException ex) {
                System.out.println("Erro ao receber mensagem UDP cliente");
                this.app.erroServerUI();
                return;
            }
        }
    }

    public void iniciarPartida() {
        try {
            byte[] mensagem = new byte[1024];
            String texto = "002 1 " + this.app.getPosServ() + " ";
            mensagem = texto.getBytes();
            DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length, 
                    InetAddress.getByName(this.app.getIpServer()), this.app.getPortaServer());
            
            for (JogadorC j: this.app.getJogadores()){
                
            }

        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getStatus() {
        return this.status;
    }

    public int getPorta() {
        return this.ds.getPort();
    }

    public void conctaSala(Convite c) {
        String s;
        try {
            ds = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (c.isSenha()) {
            s = JOptionPane.showInputDialog(null, "Digite a senha");
        } else {
            s = "null";
        }
        String msg = "110 " + s + " " + dsEscuta.getLocalPort() + " ";
        byte[] mensagem = new byte[1024];
        try {
            DatagramPacket dp = new DatagramPacket(mensagem, mensagem.length, InetAddress.getByName(c.getIp()), c.getPorta());

            this.ds.send(dp);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
