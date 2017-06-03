package Login;

import CRUDFuncionario.Funcionario;
import CRUDFuncionario.ServicoFuncionario;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author Thalles
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException {
        boolean erro = false, existe = false;
        ServicoLogin sl = new ServicoLogin();
        ServicoFuncionario sf = new ServicoFuncionario();
        String cript = null;
        try {
            cript = sf.criptografia(request.getParameter("senha"));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean login = sl.verificarLogin(request.getParameter("login"));
        boolean senha = sl.verificarSenha(cript);

        if (login) {
            request.setAttribute("login", request.getParameter("login"));
        } else {
            erro = true;
            request.setAttribute("erroLogin", true);
        }

        if (senha) {
            request.setAttribute("senha", request.getParameter("senha"));
        } else {
            erro = true;
            request.setAttribute("erroSenha", true);
        }

        if (!erro) {

            try {
                existe = sl.verificarUsuario(request.getParameter("login"), cript);

            } catch (Exception e) {

            }

            if (existe) {
                HttpSession nomeLogado = request.getSession();
                HttpSession permissao = request.getSession();

                try {
                    permissao.setAttribute("permissao", sl.permissao(request.getParameter("login"), cript));
                    nomeLogado.setAttribute("nomeLogado", sl.Nome(request.getParameter("login"), cript));

                } catch (Exception ex) {

                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
                Funcionario funcionario = new Funcionario();
                HttpSession sessao = request.getSession();
                try {
                    funcionario = sf.obterFuncionarioPorLogin(request.getParameter("login"));
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                sessao.setAttribute("idFuncionario", funcionario.getId());
                dispatcher.forward(request, response);

            } else {
                request.setAttribute("erroLogin", true);
                request.setAttribute("erroSenha", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
                dispatcher.forward(request, response);
            }

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            dispatcher.forward(request, response);
        }

    }

}
