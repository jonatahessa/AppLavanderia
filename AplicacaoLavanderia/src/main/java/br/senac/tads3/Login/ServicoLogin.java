
package br.senac.tads3.Login;


public class ServicoLogin {
     
    public boolean verificarLogin (String login) {
        return !(login == null || login.equals(""));
    }

    public boolean verificarSenha (String senha) {
        return  !(senha == null || senha.equals(""));
    }
    
    public boolean verificarUsuario (String login, String senha) throws Exception {
        return br.senac.tads3.Daos.DaoLogin.verificarUsuario(login, senha);   
    }
    
    public String permissao (String login, String senha) throws Exception {
        return br.senac.tads3.Daos.DaoLogin.permissao(login, senha);   
    }
    
    public String Nome (String login, String senha) throws Exception {
        return br.senac.tads3.Daos.DaoLogin.nome(login, senha);   
    }
}
