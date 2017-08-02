/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabio
 */
public class ClienteTCP implements Runnable{
    private ServerSocket servSoc;

    public ClienteTCP() {
        try {
            this.servSoc = new ServerSocket();
        } catch (IOException ex) {
            System.out.println("Erro ao criar ServerSocket do cliete");
        }
    }
    
    public void escuta(){
        
    }
    
    @Override
    public void run() {
       //switch
    }
    
    public void trataMensagem(String mensagem){
        StringTokenizer tk = new StringTokenizer(mensagem, " ");
        String msgPartida = "";
        int aux1, aux2;
        
        switch(tk.nextToken()){
            case "040": //Atualiza dados
                aux1 = Integer.valueOf(tk.nextToken()); //valor dado 1
                aux2 = Integer.valueOf(tk.nextToken()); //valor dado 2
                //Partida.atualizaDados(aux1, aux2);   //Método que atualiza dados na aplicação
                break;
                
            case "041": //Novo saldo
                aux1 = Integer.valueOf(tk.nextToken()); //valor saldo
                //Partida.atualizaSaldo(aux1);              //Método pra atualizar saldo
                break;
             
            case "042":
                aux1 = Integer.valueOf(tk.nextToken()); //número da casa da propriedade
                //Partida.novoDono(aux1);
                break;
                
            case "043":
                aux1 = Integer.valueOf(tk.nextToken()); //número da casa da propriedade
                //Partida.constroi(aux1);
                break;
                
            case "044":
                aux1 = Integer.valueOf(tk.nextToken()); //número da carta
                //Partida.sorteOuReves(aux1);
                break;
        }
    }
    
}
