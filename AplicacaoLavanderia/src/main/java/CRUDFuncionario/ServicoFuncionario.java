package CRUDFuncionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoFuncionario {

    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificarCargo(String cargo) {
        if (cargo == null || cargo.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificarUnidade(String unidade) {
        if (unidade == null || unidade.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificarSexo(String sexo) {
        if (sexo == null || sexo.equals("")) {
            return false;
        }
        return true;
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
        int contador = 0;
        if (login == null || login.equals("")) {
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
        if (senha == null || senha.equals("")) {
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

    public void deletarFuncionario(int id) throws Exception {
        Daos.DaoFuncionario.deletar(id);
    }

    // public void alterarFuncionario(Funcionario funcionario, String id) throws Exception {
    //   Daos.DaoFuncionario.alterar(funcionario, id);
    //}
    public Funcionario obterFuncionario(int id) throws Exception {
        return Daos.DaoFuncionario.obter(id);
    }

}
