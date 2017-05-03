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
}
