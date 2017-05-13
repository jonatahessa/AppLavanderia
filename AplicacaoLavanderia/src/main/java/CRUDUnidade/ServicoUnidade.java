package CRUDUnidade;

import java.sql.SQLException;

public class ServicoUnidade {
    
    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificarCnpj (String cnpj) {
        int contador = 0;
        if (cnpj == null || cnpj.equals("")){
            return false;
        }
        for (int i = 0; i < cnpj.length(); i++) {
            contador++;
        }
        if (contador != 18) {
            return false;
        }
        return true;
    }
    
    public void inserirUnidade(Unidade unidade) throws SQLException {
        Daos.DaoUnidade.inseriUnidade(unidade);
    }
    
    public void deletarUnidade(String id) throws SQLException, Exception {
        Daos.DaoUnidade.deletar(id);
    }
}
