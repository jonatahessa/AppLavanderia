
package CRUDCliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AlterarCliente", urlPatterns = {"/AlterarCliente"})
public class AlterarCliente extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        Cliente cliente = new Cliente();        

            try {
                cliente = Daos.DaoCliente.obter(request.getParameter("cpf"));
            } catch (Exception ex) {
                Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("nome", cliente.getNome());
            request.setAttribute("cpf", cliente.getCpf());
            request.setAttribute("email", cliente.getEmail());
            request.setAttribute("telefone", cliente.getTelefone());
            request.setAttribute("sexo", cliente.getSexo());
            
            response.sendRedirect("alteraCliente.jsp");
      
            
        
        
        
        //RequestDispatcher dispatcher = 
	//request.getRequestDispatcher("alterarCliente.jsp");
        //dispatcher.forward(request, response);
        

    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    
}