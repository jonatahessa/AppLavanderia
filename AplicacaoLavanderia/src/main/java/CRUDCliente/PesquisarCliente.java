
package CRUDCliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PesquisaCliente", urlPatterns = {"/PesquisaCliente"})
public class PesquisarCliente extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        Cliente cliente = new Cliente();
        try {
            //cliente.pesquisar(request.getParameter("cpf"));
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp");
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
