
package CRUDFuncionario;

import CRUDCliente.Cliente;
import CRUDFuncionario.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thalles
 */
@WebServlet(name = "EntradaServlet", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

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
	request.getRequestDispatcher("cadastroFuncionario.jsp");
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
        String cpf = request.getParameter("cpf");
        String ctps = request.getParameter("ctps");
        String nascimento = request.getParameter("nascimento");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String admissao = request.getParameter("admissao");
        String cargo = request.getParameter("cargo");
        String empresa = request.getParameter("empresa");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setCtps(ctps);
        funcionario.setNascimento(nascimento);
        funcionario.setSexo(sexo);
        funcionario.setTelefone(telefone);
        funcionario.setEmail(email);
        funcionario.setEndereco(endereco);
        funcionario.setCep(cep);
        funcionario.setCidade(cidade);
        funcionario.setEstado(estado);
        funcionario.setAdmissao(admissao);
        funcionario.setCargo(cargo);
        funcionario.setEmpresa(empresa);

        try {
            funcionario.inserirFuncionario(funcionario);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}