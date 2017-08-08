/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author Gi Benvenuto
 */
public class Convite {
    private String ip;
    private int porta;
    private boolean senha;
    
    
    public Convite(String ipConv, int portaConv, String senha) {
        this.ip = ipConv;
        this.porta = portaConv;
        this.senha = senha.equals("1");
    }

    public String getIp() {
        return ip;
    }

    public int getPorta() {
        return porta;
    }

    public boolean isSenha() {
        return senha;
    }
    
    
}
