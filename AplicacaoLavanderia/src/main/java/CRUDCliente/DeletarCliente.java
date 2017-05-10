package CRUDCliente;

import Daos.DaoCliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//aula http://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example

@WebServlet(name = "DeletarCliente", urlPatterns = {"/DeletarCliente"})
public class DeletarCliente extends HttpServlet {
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        ServicoCliente sc = new ServicoCliente();
        try {
                sc.deletarCliente(request.getParameter("cpf"));
                response.sendRedirect("mensagemExclusao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
}
