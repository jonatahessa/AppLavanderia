package CRUDFuncionario;

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

@WebServlet(name = "DeletarFuncionario", urlPatterns = {"/DeletarFuncionario"})
public class DeletarFuncionario extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    }

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        ServicoFuncionario sf = new ServicoFuncionario();
        try {
                sf.deletarFuncionario(request.getParameter("id"));
                response.sendRedirect("mensagemExclusao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
}

    


