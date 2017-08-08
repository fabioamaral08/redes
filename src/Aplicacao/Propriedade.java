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
        if(tp.getDono() != j){
            if (tp.getDono() != null) {
                tp.getDono().alteraCapital(tp.getAluguel());
                j.alteraCapital(-tp.getAluguel());
            }
            else{
                if(JOptionPane.showConfirmDialog(null, "Deseja comprar essa propriedade?") == JOptionPane.YES_OPTION){
                    if (j.getCapital() >= tp.getValor()) {
                        tp.setDono(j);
                        j.alteraCapital(-tp.getValor());
                    }
                    else JOptionPane.showMessageDialog(null, "Capital insuficiente!");
                }
            }
        }
        else{
            if(tp.getNumCasas()<5){
                if(JOptionPane.showConfirmDialog(null, "Deseja construir?") == JOptionPane.YES_OPTION){
                    if(j.getCapital() >= 70){
                        tp.construir();
                        j.alteraCapital(-70);
                    }
                    else JOptionPane.showMessageDialog(null, "Capital insuficiente!");
                }
            }
        }
    }
    
    public void setDono(JogadorC j){
        tp.setDono(j);
    }
    
    public void constroi(){
        tp.construir();
    }
}
