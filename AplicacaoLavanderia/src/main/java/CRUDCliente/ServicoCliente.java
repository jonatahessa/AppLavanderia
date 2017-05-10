package CRUDCliente;

public class ServicoCliente {
    
    public boolean verificarCpf(String cpf) {
        int contador = 0;
        if (cpf == null || cpf.equals("")){
            return false;
        }
        for (int i = 0; i < cpf.length(); i++) {
            contador++;
        }
        if (contador != 14) {
            return false;
        }
        return true;
    }
    
    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificarSexo(String sexo) {
        if (sexo == null || sexo.equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificarEmail(String email) {
        int contador = 0;
        if (email == null || email.equals("")){
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                contador++;
            }
        }
        if (contador != 1) {
            return false;
        }
        
        return true;
    }
    
    public boolean verificarTelefone(String telefone) {
        int contador = 0;
        if (telefone == null || telefone.equals("")){
            return false;
        }
        for (int i = 0; i < telefone.length(); i++) {
            contador++;
        }
        if (contador != 13) {
            return false;
        }
        return true;
    }
    
    public void inserirCliente(Cliente cliente) throws Exception {
        Daos.DaoCliente.inserir(cliente);
    }
    
    public void deletarCliente(String cpf) throws Exception {
        Daos.DaoCliente.deletar(cpf);
    }
    
    public void alterarCliente(Cliente cliente, String id) throws Exception {
        Daos.DaoCliente.alterar(cliente, id);
    }
    
    public Cliente obterCliente(String cpf) throws Exception {
        return Daos.DaoCliente.obter(cpf);
    }
}
