/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDCliente;

/**
 *
 * @author jonata
 */
public class Cliente {

    private int id;
    private String nome;
    protected String cpf;
    private String telefone;
    private String email;
    private String enabled;
    private String sexo;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void inserirCliente(Cliente cliente) throws Exception {
        Daos.DaoCliente.inserir(cliente);
    }

    public void pesquisarCliente(Cliente cliente) throws Exception {
        Daos.DaoCliente.obter(cpf);
    }
    
    public void deletarCliente(Cliente cliente) throws Exception {
        Daos.DaoCliente.deletar(cpf);
    }
}
