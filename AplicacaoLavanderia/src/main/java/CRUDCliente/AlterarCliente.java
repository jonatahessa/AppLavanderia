
package CRUDCliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraCliente.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ValidacaoCliente vc = new ValidacaoCliente();
        boolean erro = false;
        boolean nome = vc.verificarNome(request.getParameter("nome"));
        boolean email = vc.verificarEmail(request.getParameter("email"));
        boolean telefone = vc.verificarTelefone(request.getParameter("telefone"));
        boolean cpf = vc.verificarCpf(request.getParameter("cpf"));
    
     
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        }
        if (email != true) {
            erro = true;
            request.setAttribute("erroEmail", true);
        }
        if (telefone != true) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        }
        if (cpf != true) {
            erro = true;
            request.setAttribute("erroCpf", true);
        }
        
        if (!erro) {
      
            Cliente cliente = new Cliente();
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setNome(request.getParameter("nome"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setSexo(request.getParameter("sexo"));
            
            try {
                cliente.inserirCliente(cliente);
                response.sendRedirect("mensagemCadastro.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
            dispatcher.forward(request, response);
        }

    }

}