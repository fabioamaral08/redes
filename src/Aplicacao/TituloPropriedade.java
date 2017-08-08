/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

/**
 *
 * @author fabio
 */
public class TituloPropriedade {
    private JogadorC dono;
    private int aluguel;
    private int valor;
    private int numCasas;

    public TituloPropriedade(int aluguel, int valor) {
        this.dono = null;
        this.aluguel = aluguel;
        this.valor = valor;
        this.numCasas = 0;
    }

    public JogadorC getDono() {
        return dono;
    }

    public void setDono(JogadorC dono) {
        this.dono = dono;
    }

    public int getAluguel() {
        return aluguel;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    public int getValor() {
        return valor;
    }
    
    public void construir(){
        if(numCasas < 5){
            numCasas++;
            aluguel += 20;
        }
    }

    public int getNumCasas() {
        return numCasas;
    }
}
