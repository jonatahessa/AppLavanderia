
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
        request.setAttribute("id", cliente.getId());
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraCliente.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ServicoCliente vc = new ServicoCliente();
        boolean erro = false;
        boolean nome = vc.verificarNome(request.getParameter("nome"));
        boolean email = vc.verificarEmail(request.getParameter("email"));
        boolean telefone = vc.verificarTelefone(request.getParameter("telefone"));
        boolean cpf = vc.verificarCpf(request.getParameter("cpf"));
    
     
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
        }
        if (email != true) {
            erro = true;
            request.setAttribute("erroEmail", true);
        } else {
            request.setAttribute("email", request.getParameter("email"));
        }
        if (telefone != true) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        } else {
            request.setAttribute("telefone", request.getParameter("telefone"));
        }
        if (cpf != true) {
            erro = true;
            request.setAttribute("erroCpf", true);
        } else {
            request.setAttribute("cpf", request.getParameter("cpf"));
        }
        
        request.setAttribute("sex", request.getParameter("sexo"));
        
        if (!erro) {
            ServicoCliente sc = new ServicoCliente();
            Cliente cliente = new Cliente();
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setNome(request.getParameter("nome"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setSexo(request.getParameter("sexo"));
            
            try {
                sc.alterarCliente(cliente, request.getParameter("sexo"));
                response.sendRedirect("mensagemAlteracao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("alteraCliente.jsp");
            dispatcher.forward(request, response);
        }

    }

}