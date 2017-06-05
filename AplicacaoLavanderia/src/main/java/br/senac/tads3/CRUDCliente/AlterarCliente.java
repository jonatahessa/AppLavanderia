
package br.senac.tads3.CRUDCliente;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AlterarCliente", urlPatterns = {"/AlterarCliente"})
public class AlterarCliente extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

        Cliente cliente = new Cliente();        
        ServicoCliente sc = new ServicoCliente();
        try {
            cliente = sc.obterCliente(request.getParameter("cpf"));
        } catch (Exception ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        request.setAttribute("nome", cliente.getNome());
        request.setAttribute("cpf", cliente.getCpf());
        request.setAttribute("email", cliente.getEmail());
        request.setAttribute("telefone", cliente.getTelefone());
        HttpSession sexoAlterar = request.getSession();
        sexoAlterar.setAttribute("sexoAlterar", cliente.getSexo());
        HttpSession idAlterar = request.getSession();
        idAlterar.setAttribute("idAlterar", cliente.getId());

            
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alteraCliente.jsp");
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
            request.setAttribute("trueNome", true);
        }
        if (email != true) {
            erro = true;
            request.setAttribute("erroEmail", true);
        } else {
            request.setAttribute("email", request.getParameter("email"));
            request.setAttribute("trueEmail", true);
        }
        if (telefone != true) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        } else {
            request.setAttribute("telefone", request.getParameter("telefone"));
            request.setAttribute("trueTelefone", true);
        }
        if (cpf != true) {
            erro = true;
            request.setAttribute("erroCpf", true);
        } else {
            request.setAttribute("cpf", request.getParameter("cpf"));
            request.setAttribute("trueCpf", true);
        }
                
        if (!erro) {
            ServicoCliente sc = new ServicoCliente();
            Cliente cliente = new Cliente();
            cliente.setCpf(request.getParameter("cpf").trim());
            cliente.setEmail(request.getParameter("email").trim());
            cliente.setNome(request.getParameter("nome").trim());
            cliente.setTelefone(request.getParameter("telefone").trim());
            cliente.setSexo(request.getParameter("sexo").trim());
            
            try {
                sc.alterarCliente(cliente, request.getParameter("idCliente"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemAlteracao.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
                
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alteraCliente.jsp");
            dispatcher.forward(request, response);
        }

    }

}