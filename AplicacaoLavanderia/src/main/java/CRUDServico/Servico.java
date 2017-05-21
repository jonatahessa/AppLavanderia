/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDServico;

/**
 *
 * @author livia.cgsantos e eloisa.asilva2
 */
public class Servico {
    
    private int id;
    private String nomeServico;
    private double precoServico;
    private String enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(double precoServico) {
        this.precoServico = precoServico;
    }
  

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
  
}    
 
    


