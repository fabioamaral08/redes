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
    private int meuNum;
    private String ipServer;
    private int portaServer;

    private boolean aberto;
    private String senha;

    private ClienteUI ui;

    @Override
    public void run() {

    }

    public String getSenha() {
        return senha;
    }

    
    
    public void fimTurno() {
        partida.fimTurno();
        int jogVez = partida.getJogadorVez();
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
    
    public void addJog(){
        
    }
}
