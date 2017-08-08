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
public class IR_LD_PP extends Casa{
    private int multiplicador;
    
    public IR_LD_PP(int multiplicador){
        this.multiplicador = multiplicador;
    }

    @Override
    public void aplicaConsequencia(JogadorC j) {
        j.alteraCapital(200 * this.multiplicador);
    }
    
    
}
