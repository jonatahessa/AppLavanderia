package CRUDCliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "EntradaServlet", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = 
	request.getRequestDispatcher("cadastroCliente.jsp");
        dispatcher.forward(request, response);
    }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
    
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setSexo(sexo);



        try {
            cliente.inserirCliente(cliente);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}