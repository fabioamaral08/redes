/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Aplicacao.JogadorC;
import Aplicacao.Casa;
import java.util.ArrayList;

/**
 *
 * @author fabio
 */
public class Partida {
    private ArrayList<JogadorC> jogadores;
    private ArrayList<Casa> casaTab;
    private short jogadorVez;
    private short numJogadores;
    
    public Partida(){
        this.jogadorVez = 0;
        this.jogadores = new ArrayList();
    }
    
    public void comecar(){
        this.numJogadores =( short) this.jogadores.size();
    }
    
    public void proxJogador(){
        this.jogadorVez = (short) ((this.jogadorVez + 1) % this.numJogadores);
    }
    
    public void rolaDados(int d1, int d2){
        JogadorC j = this.jogadores.get(this.jogadorVez);
        
        if(j.isPreso()){
            if(d1 == d2){
                j.setPreso(false);
            }
        }else{
            int novaPos = j.getPos();
            novaPos = (novaPos + d1 + d2) %40;
            j.setPos(novaPos);
        }
    }
}
