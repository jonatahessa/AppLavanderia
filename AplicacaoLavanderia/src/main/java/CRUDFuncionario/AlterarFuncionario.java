package CRUDFuncionario;

import CRUDUnidade.ServicoUnidade;
import CRUDUnidade.Unidade;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarFuncionario", urlPatterns = {"/AlterarFuncionario"})
public class AlterarFuncionario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Unidade unidade = new Unidade();
        List<Unidade> listaUnidades = null;
        
        Funcionario funcionario = new Funcionario();
        ServicoFuncionario sf = new ServicoFuncionario();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            funcionario = sf.obterFuncionario(request.getParameter("id"));
        } catch (Exception ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("id", funcionario.getId());
        request.setAttribute("nome", funcionario.getNome());
        request.setAttribute("sexo", funcionario.getSexo());
        String data = df.format(funcionario.getAdmissao());
        request.setAttribute("admissao", data);
        request.setAttribute("cargo", funcionario.getCargo());   
        try{
            unidade = Daos.DaoUnidade.obter(funcionario.getIdUnidade());
            ServicoUnidade su = new ServicoUnidade();
            request.setAttribute("unidadeFuncionario", unidade.getNome());
        } catch (Exception e) {
        }

        request.setAttribute("login", funcionario.getLogin());
        request.setAttribute("senha", funcionario.getSenha());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alteraFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServicoFuncionario sf = new ServicoFuncionario();
        boolean erro = false;

        boolean nome = sf.verificarNome(request.getParameter("nome"));
        boolean login = sf.verificarLogin(request.getParameter("login"));
        boolean senha = sf.verificarSenha(request.getParameter("senha"));
        boolean cargo = sf.verificarCargo(request.getParameter("cargo"));
        boolean admissao = sf.verificarAdmissao(request.getParameter("admissao"));
        boolean sexo = sf.verificarSexo(request.getParameter("sexo"));

        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
            request.setAttribute("trueNome", true);
        }
        if (login != true) {
            erro = true;
            request.setAttribute("erroLogin", true);
        } else {
            request.setAttribute("login", request.getParameter("login"));
            request.setAttribute("trueLogin", true);
        }
        if (senha != true) {
            erro = true;
            request.setAttribute("erroSenha", true);
        } else {
            request.setAttribute("senha", request.getParameter("senha"));
            request.setAttribute("trueSenha", true);
        }
        if (cargo != true) {
            erro = true;
            request.setAttribute("erroCargo", true);
        } else {
            request.setAttribute("cargo", request.getParameter("cargo"));
        }
        if (admissao != true) {
            erro = true;
            request.setAttribute("erroAdmissao", true);
        } else {
            request.setAttribute("admissao", request.getParameter("admissao"));
            request.setAttribute("trueAdmissao", true);
        }
        if (sexo != true) {
            erro = true;
            request.setAttribute("erroSexo", true);
        } else {
            request.setAttribute("sex", request.getParameter("sexo"));
        }

        if (!erro) {
            Funcionario funcionario = new Funcionario();
            ServicoFuncionario sf2 = new ServicoFuncionario();

            try {
                funcionario.setIdUnidade(Daos.DaoUnidade.retornarIdUnidade(request.getParameter("unidade")));
            } catch (Exception ex) {
            }
            funcionario.setAdmissao(sf.converterData(request.getParameter("admissao")));
            funcionario.setCargo(request.getParameter("cargo"));
            funcionario.setLogin(request.getParameter("login"));
            funcionario.setNome(request.getParameter("nome"));
            funcionario.setSenha(request.getParameter("senha"));
            funcionario.setSexo(request.getParameter("sexo"));
            try {
                sf2.alterarFuncionario(funcionario, request.getParameter("idFuncionario"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemAlteracao.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alteraFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }

}
