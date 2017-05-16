package CRUDFuncionario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        request.setAttribute("unidade", funcionario.getNomeUnidade());
        request.setAttribute("login", funcionario.getLogin());

        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraFuncionario.jsp");
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
        }
        if (login != true) {
            erro = true;
            request.setAttribute("erroLogin", true);
        } else {
            request.setAttribute("login", request.getParameter("login"));
        }
        if (senha != true) {
            erro = true;
            request.setAttribute("erroSenha", true);
        } else {
            request.setAttribute("senha", request.getParameter("senha"));
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
                response.sendRedirect("mensagemAlteracao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("alteraFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }

}
