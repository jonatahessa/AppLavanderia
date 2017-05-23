package CRUDFuncionario;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                sf.inserirFuncionario(funcionario);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemCadastro.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastroFuncionario.jsp");
            dispatcher.forward(request, response);
        }
    }

}
