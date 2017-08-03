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

    public TituloPropriedade(int aluguel, int valor) {
        this.dono = null;
        this.aluguel = aluguel;
        this.valor = valor;
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
}
