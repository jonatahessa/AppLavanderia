package br.senac.tads3.CRUDCliente;

import br.senac.tads3.Pessoa.Pessoa;

public class Cliente extends Pessoa{

    protected String cpf;
    private String telefone;
    private String email;

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
