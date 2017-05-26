package CRUDFuncionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoFuncionario {

    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")) {
            return false;
        }
        if (nome.length()> 100) {
            return false;
        }
        return true;
    }

    public boolean verificarCargo(String cargo) {
        return !(cargo == null || cargo.equals(""));
    }
    
    public boolean verificarUnidade(String unidade) {
        return !(unidade == null || unidade.equals(""));
    }

    public boolean verificarSexo(String sexo) {
        return !(sexo == null || sexo.equals(""));
    }

    public boolean verificarAdmissao(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        if (data.length() > 10) {
            return false;
        }
        
        try {
            Date dataValida = sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public boolean verificarLogin(String login) {
        if (login == null || login.equals("")) {
            return false;
        }
        if (login.length() > 10 || login.length() < 5) {
            return false;
        }
        return true;
    }
    

    public boolean verificarSenha(String senha) {
        if (senha == null || senha.equals("")) {
            return false;
        }
        if (senha.length() > 8 || senha.length() < 4) {
            return false;
        }
        return true;
    }
    
    public java.sql.Date converterData(String recebe) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.sql.Date data = new java.sql.Date(format.parse(recebe).getTime());
            return data;
        } catch (ParseException ex) {
            Logger.getLogger(ServicoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void inserirFuncionario(Funcionario funcionario) throws Exception {
        Daos.DaoFuncionario.inserir(funcionario);
    }

    public void deletarFuncionario(String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        Daos.DaoFuncionario.deletar(id);
    }

    public void alterarFuncionario(Funcionario funcionario, String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        Daos.DaoFuncionario.alterar(funcionario, id);
    }
    
    public Funcionario obterFuncionario(String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        return Daos.DaoFuncionario.obter(id);
    }
    
    public List<Funcionario> ListarFuncionarios() throws Exception {
        return Daos.DaoFuncionario.listar();
    }

    public List<Funcionario> pesquisarFuncionario(String nome) throws Exception {
        return Daos.DaoFuncionario.pesquisarFuncionario(nome);
    }
    
    public boolean verificarDuplicidade (String login, String senha) throws Exception {
        return Daos.DaoFuncionario.verificarDuplicidade(login, senha);
    }
}
