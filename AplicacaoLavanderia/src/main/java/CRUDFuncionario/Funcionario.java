package CRUDFuncionario;

import java.sql.Date;

public class Funcionario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String cargo;
    private Date admissao;
    private int idUnidade;
    private String sexo;
    private String enabled;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int id_unidade) {
        this.idUnidade = id_unidade;
    }
    
    
       
    public void inserirFuncionario (Funcionario funcionario) throws Exception {
        Daos.DaoFuncionario.inserir(funcionario);
    }
}
