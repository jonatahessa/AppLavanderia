package CRUDCliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int erro = 0;
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
    
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEnabled("true");
    
        ServicoCliente servicoCliente = new ServicoCliente();
        boolean validaCpf = servicoCliente.verificarCpf(cpf);
        boolean validaEmail = servicoCliente.verificarEmail(email);
        boolean validaNome = servicoCliente.verificarNome(nome);
        boolean validaTelefone = servicoCliente.verificarTelefone(telefone);
              
        
        try {
            cliente.inserirCliente(cliente);
        } catch (Exception e) {
            System.out.println("Erro ao inserir cliente no banco");
        }
        
        
    //HttpSession sessao = request.getSession();
    //sessao.setAttribute("novoContato", novo);
    //response.sendRedirect("resultado.jsp");

  }


}