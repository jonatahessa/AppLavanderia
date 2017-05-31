package CRUDUnidade;

import java.sql.SQLException;
import java.util.List;

public class ServicoUnidade {

    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificarCnpj(String cnpj) {
        int contador = 0;
        if (cnpj == null || cnpj.equals("")) {
            return false;
        }
        for (int i = 0; i < cnpj.length(); i++) {
            contador++;
        }
        try {
            int teste = Integer.parseInt(cnpj.substring(0,1));
            int teste2 = Integer.parseInt(cnpj.substring(3,5));
            int teste3 = Integer.parseInt(cnpj.substring(11,14));

            
        } catch (Exception e){
            return false;
        }
        if (contador != 18) {
            return false;
        }
        return true;
    }

    public void inserirUnidade(Unidade unidade) throws SQLException {
        Daos.DaoUnidade.inseriUnidade(unidade);
    }

    public Unidade obterUnidade(String recebe) throws SQLException, Exception {
        int id = Integer.parseInt(recebe);
        return Daos.DaoUnidade.obter(id);
    }
    
    public void deletarUnidade(String id) throws SQLException, Exception {
        Daos.DaoUnidade.deletar(id);
    }
    
    public void alterarUnidade(Unidade unidade, String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
       Daos.DaoUnidade.alterar(unidade, id);
    }
    
    public List<Unidade> pesquisarUnidade(String nome) throws Exception {
        return Daos.DaoUnidade.pesquisarUnidade(nome);
    }
    
    public List<Unidade> ListarUnidades() throws Exception {
        return Daos.DaoUnidade.listar();
    }
    
    public boolean verificarDuplicada (String cnpj) throws Exception {
        return Daos.DaoUnidade.verificarDuplicada(cnpj);
    }
}
