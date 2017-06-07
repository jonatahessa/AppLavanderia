package br.senac.tads3.CRUDFuncionario;

import br.senac.tads3.Pessoa.Pessoa;
import java.sql.Date;

public class Funcionario extends Pessoa{

    private String login;
    private String senha;
    private String cargo;
    private Date admissao;
    private int idUnidade;
    private String nomeUnidade;


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

    public void setIdUnidade(int unidade) {
        this.idUnidade = unidade;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

}
