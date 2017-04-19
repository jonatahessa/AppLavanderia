package CRUDCliente;

/**
 *
 * @author jonata
 */
public class Cliente {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String enabled;
    
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

    public void inserirCliente(Cliente cliente) throws Exception {
        Daos.DaoCliente.inserir(cliente);
    }
    
    public void alterarCliente(Cliente cliente, String cpf) throws Exception {
        Daos.DaoCliente.alterar(cliente, cpf);
    }
    
}
