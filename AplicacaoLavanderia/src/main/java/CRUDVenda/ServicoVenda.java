/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDVenda;

/**
 *
 * @author jonata.hmoliveira
 */
public class ServicoVenda {
    
    
    public void finalizarVenda(Venda venda) throws Exception {
        Daos.DaoVenda.inserir(venda);
    }
}
