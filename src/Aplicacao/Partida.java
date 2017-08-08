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
    
    private void initTabuleiro(){
        TituloPropriedade aux;
        Casa auxCasa;
        
        auxCasa = new IR_LD_PP(1); //Ponto de Partida
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(100, 6); //Propriedade Leblon
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new SorteReves(); //Sorte ou Reves
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(60, 2); //Propriedade Av. Pres.Vargas
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(60, 2); //Propriedade Av.No. S. Copacabana
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);  
        
        aux = new TituloPropriedade(200, 150); //Propriedade Ferroviária
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(240, 20); //Propriedade Av. Brigadeiro
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(200, 150); //Propriedade Viação
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(220, 18); //Propriedade Av. Rebouças
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(220, 18); //Propriedade Av. 9 Julho
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new Prisao_ParadaLivre(); 
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(200, 16); //Propriedade Av. Europa
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new SorteReves(); //Sorte ou Reves
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(180, 14); //Propriedade Av. Augusta
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(180, 14); //Propriedade Av. Pacaembu
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(200, 150); //Propriedade Taxi
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new SorteReves(); //Sorte ou Reves
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(350, 35); //Propriedade Interlagos
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new IR_LD_PP(-1); //Lucros ou Dividendos
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(400, 50); //Propriedade Morumbi
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new Prisao_ParadaLivre(); //Parada Livre
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade (120, 8); //Propriedade Flamengo
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new SorteReves(); //Sorte ou Reves
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(100, 8); //Propriedade Botafogo
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new IR_LD_PP(-1); //Imposto de renda
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(200, 150); //Navegação
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(160, 10); //Propriedade Av. Brasil
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new SorteReves(); //Sorte ou Reves
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(140, 10); // Propriedade Av. Paulista
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(140, 10); //Propriedade Jardim Europa
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new VaPrisao(); 
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(260, 22); //Propriedade Copacabana
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(200, 150); //Propriedade Aeroporto
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(320, 28); //Propriedade Av. Vieira Souto
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(300, 28); //Propriedade Av. Atlantica
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(200, 150); //Propriedade Taxi Aereo
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(300, 26); //Propriedade Ipanema
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        auxCasa = new SorteReves(); //Sorte ou Reves
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(280, 24); //Propriedade Jardim Paulista
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
        
        aux = new TituloPropriedade(260, 22); //Propriedade Brooklin
        auxCasa = new Propriedade(aux);
        this.casaTab.add(auxCasa);
    }
    
    public Partida(){
        this.jogadorVez = 0;
        this.jogadores = new ArrayList();
    }
    
    public void comecar(){
        this.numJogadores =( short) this.jogadores.size();
        initTabuleiro();
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
