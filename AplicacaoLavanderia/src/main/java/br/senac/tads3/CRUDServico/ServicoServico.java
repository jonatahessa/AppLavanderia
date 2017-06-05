package br.senac.tads3.CRUDServico;

import java.util.List;

public class ServicoServico {
    
    public boolean verificarNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            return false;
        }
        if (nome.length()> 100) {
            return false;
        }
        return true;
    }
    
    public String converterPreco (String preco) {
        return preco = preco.replaceAll(",", "\\.");
    }
    
    public boolean verificarPreco (String preco) {
       
        if (preco == null || preco.equals("")){
            return false;
        }
        try {
            double teste = Double.parseDouble(preco);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void inserirServico(Servico servico) throws Exception {
        br.senac.tads3.Daos.DaoServico.inserir(servico);
    }
    
    public void deletarServico(int id) throws Exception {
        br.senac.tads3.Daos.DaoServico.deletar(id);
    }
    
    public Servico obterServico(int id) throws Exception {
        return br.senac.tads3.Daos.DaoServico.obter(id);
    }
    
    public void alterarServico(Servico servico, String id) throws Exception {
        br.senac.tads3.Daos.DaoServico.alterar(servico, id);
    }
    
    public List<Servico> ListarServicos() throws Exception {
        return br.senac.tads3.Daos.DaoServico.listar();
    }

    public List<Servico> pesquisarServico(String nome) throws Exception {
        return br.senac.tads3.Daos.DaoServico.pesquisarServico(nome);
    }
    
    public boolean verificarDuplicidade (String nome) throws Exception {
        return br.senac.tads3.Daos.DaoServico.verificarDuplicada(nome);
    }
}
