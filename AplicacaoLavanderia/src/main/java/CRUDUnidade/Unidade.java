package CRUDUnidade;

import java.sql.SQLException;

public class Unidade {
    private String nome;
    private String cnpj;
    private String enabled;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
    
    public void inserirUnidade(Unidade unidade) throws SQLException {
        Daos.DaoUnidade.inseriUnidade(unidade);
    }
    
}
