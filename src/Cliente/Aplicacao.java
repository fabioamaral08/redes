package Cliente;

import Aplicacao.JogadorC;
import Aplicacao.Partida;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tpredes.IU.ClienteUI;

public class Aplicacao implements Runnable {

    private DatagramSocket socUDP;
    private int portaUDP;
    private Partida partida;
    private short meuNum;
    private String ipServer;
    private int portaServer;
    private String posServ;

    private boolean aberto;
    private String senha;

    private ClienteUI ui;

    public Aplicacao(ClienteUI ui) {
        this.ui = ui;
    }
    
    

    @Override
    public void run() {

    }

    public String getSenha() {
        return senha;
    }

    
    
    public void fimTurno() {
        partida.fimTurno();
        short jogVez = partida.getJogadorVez();
        if (jogVez == meuNum) {
            ui.setDados(true);
        } else {
            ui.setDados(false);
        }
    }

    public void fazerProposta(int jog, int prop) {
        if (jog == meuNum) {
            JOptionPane.showMessageDialog(ui, "Você não pode fazer Proposta a si mesmo!");
            return;
        }
        JogadorC jogador = this.partida.getJogador(jog); 
        

    }

    public void enviaMensagem(String cod) {

    }

    public int isAberto() {
        if (this.aberto) {
            return 1;
        }
        return 0;
    }
    
    public ArrayList<JogadorC> getJogadores(){
        return this.partida.getJogadores();
    }
    
    public void addJog(String ip, int porta){
        JogadorC j = new JogadorC(ip,porta);
        this.partida.addJogador(j);
        this.ui.addJogador();
    }
    
    public void erroServerUI(){
        this.ui.setServerFalse();
    }
    
    public void setNovoDono(int prop, int dono){
        this.partida.setDono(prop,dono);
    }
    
    public void addConstrucao(int prop){
        this.partida.addCasa(prop);
    }
    
    public void conseqCartaSR(int carta, int jog){
        this.partida.conseqSR(carta, jog);
    }

    public String getIpServer() {
        return ipServer;
    }

    public void setIpServer(String ipServer) {
        this.ipServer = ipServer;
    }

    public int getPortaServer() {
        return portaServer;
    }

    public void setPortaServer(int portaServer) {
        this.portaServer = portaServer;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void removeJog(int i){
        this.partida.removeJog(i);
        if (i < this.meuNum){
            this.meuNum -=1;
        }
    }
    public void setDados(int d1, int d2){
        this.partida.rolaDados(d1,d2);
    }
    
    public void novoConvite(Convite c){
        this.ui.addConvite(c);
    }
    
    public void setPosServ(String pos){
        this.posServ = pos;
    }
    
    public String getPosServ(){
        return this.posServ;
    }
    
    public void numJogadores(int num){
        if(num == -1){
            
        }
    }
}
