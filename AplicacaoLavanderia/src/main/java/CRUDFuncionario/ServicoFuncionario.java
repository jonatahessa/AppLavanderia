package CRUDFuncionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoFuncionario {

    public boolean verificarNome(String nome) {
        return !(nome == null || nome.equals(""));
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

        try {
            Date dataValida = sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean verificarLogin(String login) {
        return !(login == null || login.equals(""));
    }

    public boolean verificarSenha(String senha) {
        return !(senha == null || senha.equals(""));
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

}
