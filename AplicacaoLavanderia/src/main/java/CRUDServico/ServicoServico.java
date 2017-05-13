package CRUDServico;

public class ServicoServico {
    
    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificarPreco (String preco) {
        preco = preco.replaceAll(",", "\\.");
        
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
        Daos.DaoServico.inserir(servico);
    }
    
    public void deletarServico(int id) throws Exception {
        Daos.DaoServico.deletar(id);
    }
    
    public Servico obterServico(int id) throws Exception {
        return Daos.DaoServico.obter(id);
    }
    
    public void alterarServico(Servico servico, String id) throws Exception {
        Daos.DaoServico.alterar(servico, id);
    }
}
