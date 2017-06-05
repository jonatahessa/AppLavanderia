package br.senac.tads3.CRUDFuncionario;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoFuncionario {

    public boolean verificarNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            return false;
        }
        if (nome.length() > 100) {
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
        if (login == null || login.trim().equals("")) {
            return false;
        }
        if (login.length() > 10 || login.length() < 5) {
            return false;
        }
        for (int i = 0; i < login.length(); i++) {
            if (login.charAt(i) == ' ') {
                return false;
            }
        }
        return true;
    }

    public boolean verificarSenha(String senha) {
        if (senha == null || senha.trim().equals("")) {
            return false;
        }
        if (senha.length() > 8 || senha.length() < 4) {
            return false;
        }
        for (int i = 0; i < senha.length(); i++) {
            if (senha.charAt(i) == ' ') {
                return false;
            }
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

    public String criptografia(String password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte digestMessage[] = algoritmo.digest(password.getBytes("UTF-8"));
        StringBuilder hexPassword = new StringBuilder();
        for (byte aByte : digestMessage) {
            hexPassword.append(String.format("%02X", 0xFF & aByte));
        }
        return hexPassword.toString();
    }

    public void inserirFuncionario(Funcionario funcionario) throws Exception {
        br.senac.tads3.Daos.DaoFuncionario.inserir(funcionario);
    }

    public void deletarFuncionario(String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        br.senac.tads3.Daos.DaoFuncionario.deletar(id);
    }

    public void alterarFuncionarioAlterandoSenha(Funcionario funcionario, String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        br.senac.tads3.Daos.DaoFuncionario.alterar(funcionario, id);
    }
    
    public void alterarFuncionarioSemAlterarSenha(Funcionario funcionario, String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        br.senac.tads3.Daos.DaoFuncionario.alterarSemAlterarSenha(funcionario, id);
    }

    public Funcionario obterFuncionario(String recebe) throws Exception {
        int id = Integer.parseInt(recebe);
        return br.senac.tads3.Daos.DaoFuncionario.obter(id);
    }

    public Funcionario obterFuncionarioPorLogin(String recebe) throws Exception {
        return br.senac.tads3.Daos.DaoFuncionario.obterPorLogin(recebe);
    }

    public List<Funcionario> ListarFuncionarios() throws Exception {
        return br.senac.tads3.Daos.DaoFuncionario.listar();
    }

    public List<Funcionario> pesquisarFuncionario(String nome) throws Exception {
        return br.senac.tads3.Daos.DaoFuncionario.pesquisarFuncionario(nome);
    }

    public boolean verificarDuplicidade(String login) throws Exception {
        return br.senac.tads3.Daos.DaoFuncionario.verificarDuplicidade(login);
    }

    public String retornaCargo(int id) throws Exception {
        return br.senac.tads3.Daos.DaoFuncionario.obterCargoPorId(id);
    }

    public int obterIdUnidade(int id) throws Exception {
        return br.senac.tads3.Daos.DaoFuncionario.obterIdUnidade(id);
    }
}
