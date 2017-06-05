/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.CRUDVenda;

/**
 *
 * @author jonata.hmoliveira
 */
public class ServicoVenda {
    
    
    public void finalizarVenda(Venda venda) throws Exception {
        br.senac.tads3.Daos.DaoVenda.inserir(venda);
    }
    
    public int retornarIdUltimaVenda() throws Exception{
       return br.senac.tads3.Daos.DaoVenda.retornarMaiorID();
    }
    
    public void inserirItensVenda(ItemVenda item) throws Exception {
        br.senac.tads3.Daos.DaoVenda.inserirItensVenda(item);
    }
    
    public boolean verificarCliente (String cpf) throws Exception {
        return br.senac.tads3.Daos.DaoCliente.verificarCliente(cpf);
    }
        
}
