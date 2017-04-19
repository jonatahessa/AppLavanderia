package CRUDCliente;

public class ServicoCliente {
    
    
    public boolean verificarNome (String nome) {
        if (nome.equals("") || nome == null) {
           return false;
        }
       return true;
    }
    
    public boolean verificarCpf (String cpf) {
        if (cpf.equals("") || cpf == null) {
           return false;
        }
       return true;
    }
    
    public boolean verificarTelefone (String telefone) {
        if (telefone.equals("") || telefone == null) {
           return false;
        }
       return true;
    }
    
    public boolean verificarEmail (String email) {
        if (email.equals("") || email == null) {
           return false;
        }
       return true;
    }
}
