
package Login;


public class ServicoLogin {
     
    public boolean verificarLogin (String login) {
        return !(login == null || login.equals(""));
    }

    public boolean verificarSenha (String senha) {
        return !(senha == null || senha.equals(""));
    }
    
    public boolean verificarUsuario (String login, String senha) throws Exception {
        return Daos.DaoLogin.verificarUsuario(login, senha);   
    }
    
    public String permissao (String login, String senha) throws Exception {
        return Daos.DaoLogin.permissao(login, senha);   
    }
}
