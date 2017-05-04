package CRUDFuncionario;

public class ValidacaoFuncionario {
    
    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificarAdmissao(String data) {
        int contador = 0;
        if (data == null || data.equals("")){
            return false;
        }
        for (int i = 0; i < data.length(); i++) {
            contador++;
        }
        if (contador != 10) {
            return false;
        }
        return true;
    }
    
    public boolean verificarLogin(String login) {
        int contador = 0;
        if (login == null || login.equals("")){
            return false;
        }
        for (int i = 0; i < login.length(); i++) {
            contador++;
        }
        if (contador > 12 || contador < 6) {
            return false;
        }
        return true;
    }
    
    public boolean verificarSenha(String senha) {
        int contador = 0;
        if (senha == null || senha.equals("")){
            return false;
        }
        for (int i = 0; i < senha.length(); i++) {
            contador++;
        }
        if (contador > 8 || contador < 4) {
            return false;
        }
        return true;
    }
    
}
