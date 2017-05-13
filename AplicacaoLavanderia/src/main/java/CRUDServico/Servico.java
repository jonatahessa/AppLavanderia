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
    private double precoPorPeca;
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

    public double getPrecoPorPeca() {
        return precoPorPeca;
    }

    public void setPrecoPorPeca(double precoPorPeca) {
        this.precoPorPeca = precoPorPeca;
    }
  

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
  
}    
 
    


