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

    private int idServico;
    private String nomeServico;
    private double precoPorPeca;
    private String enabled;
    


    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int IdServico) {
        this.idServico = idServico;
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
       
    public void inserirServico (Servico servico) throws Exception {
        Daos.DaoServico.inserir(servico);
    }
}


