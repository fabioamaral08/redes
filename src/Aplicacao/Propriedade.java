/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import javax.swing.JOptionPane;

/**
 *
 * @author fabio
 */
public class Propriedade extends Casa{
    private TituloPropriedade tp;
    
    public Propriedade(TituloPropriedade tp){
        this.tp = tp;
    }

    @Override
    public void aplicaConsequencia(JogadorC j) {
        if(tp.getDono() != null){
            tp.getDono().alteraCapital(-tp.getAluguel());
        }
        else{
            if(JOptionPane.showConfirmDialog(null, "Deseja comprar essa propriedade?") == JOptionPane.YES_OPTION){
                if(j.getCapital() >= tp.getValor()){
                    tp.setDono(j);
                    j.alteraCapital(-tp.getValor());
                }
                else JOptionPane.showMessageDialog(null, "Capital insuficiente!");
            }
        }
    }
    
}
