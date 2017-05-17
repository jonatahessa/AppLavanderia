
package Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            throws ServletException, IOException {
        boolean erro = false, existe = false;
        ServicoLogin sl = new ServicoLogin();
        boolean login = sl.verificarLogin(request.getParameter("login"));
        boolean senha = sl.verificarSenha(request.getParameter("senha"));
       
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
                existe = sl.verificarUsuario(request.getParameter("login"), request.getParameter("senha"));
                
            } catch (Exception e) {
                
            }
            
            if (existe) {
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("erroLogin", true);
                request.setAttribute("erroSenha", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        
    }

}
