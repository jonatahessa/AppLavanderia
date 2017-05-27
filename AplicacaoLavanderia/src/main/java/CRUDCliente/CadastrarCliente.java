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

@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = 
	request.getRequestDispatcher("cadastroCliente.jsp");
        dispatcher.forward(request, response);
    }


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        ServicoCliente vc = new ServicoCliente();
        boolean erro = false;
         boolean duplo = false;
        boolean nome = vc.verificarNome(request.getParameter("nome"));
        boolean email = vc.verificarEmail(request.getParameter("email"));
        boolean telefone = vc.verificarTelefone(request.getParameter("telefone"));
        boolean cpf = vc.verificarCpf(request.getParameter("cpf"));
        boolean sexo = vc.verificarSexo(request.getParameter("sexo"));
      try {
        duplo = vc.verificarDuplicada(request.getParameter("cpf"));
      } catch (Exception ex) {
      }
     
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
        
        if (cpf != true || duplo == true) {
            erro = true;
            request.setAttribute("erroCpf", true);
        } else {
            request.setAttribute("cpf", request.getParameter("cpf"));
            request.setAttribute("trueCpf", true);
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
                sc.inserirCliente(cliente);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemCadastro.jsp");
                dispatcher.forward(request, response);

            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro");
                dispatcher.forward(request, response);
                Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastroCliente.jsp");
            dispatcher.forward(request, response);
        }
        
        
     
        
    }


}