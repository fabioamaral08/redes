/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import java.util.Random;

/**
 *
 * @author fabio
 */
public class SorteReves extends Casa{

    @Override
    public void aplicaConsequencia(JogadorC j) {
        Random rand = new Random();
        int carta = rand.nextInt(30);
        
        if(carta<5){
            j.alteraCapital(-50); //pague 50
        }
        if(carta>6 && carta<11){ //pague 80
            j.alteraCapital(-80);
        }
        if(carta>11 && carta<17){ //recebe 50
            j.alteraCapital(50);
        }
        if(carta>17 && carta<23){ //recebe 80
            j.alteraCapital(80);
        }
        if(carta>23 && carta<27){ //recebe 100
            j.alteraCapital(100); 
        }
        if(carta == 27){    //vá para a prisão
            j.setPos(10);
            j.setPreso(true);
        }
        if(carta == 28){    //saia da prisão
            j.setCartaPrisao(true);
        }
        if(carta == 29){
            j.setPos(1);
            j.alteraCapital(200);
        }
    }
    
    public static void aplica(int carta, JogadorC j){
        if(carta<5){
            j.alteraCapital(-50); //pague 50
        }
        if(carta>6 && carta<11){ //pague 80
            j.alteraCapital(-80);
        }
        if(carta>11 && carta<17){ //recebe 50
            j.alteraCapital(50);
        }
        if(carta>17 && carta<23){ //recebe 80
            j.alteraCapital(80);
        }
        if(carta>23 && carta<27){ //recebe 100
            j.alteraCapital(100); 
        }
        if(carta == 27){    //vá para a prisão
            j.setPos(10);
            j.setPreso(true);
        }
        if(carta == 28){    //saia da prisão
            j.setCartaPrisao(true);
        }
        if(carta == 29){
            j.setPos(1);
            j.alteraCapital(200);
        }
    }
    
}
