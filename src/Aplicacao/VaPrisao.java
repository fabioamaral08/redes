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
public class VaPrisao extends Casa{

    @Override
    public void aplicaConsequencia(JogadorC j) {
        j.setPreso(true);
        j.setPos(10);
    }
    
}
