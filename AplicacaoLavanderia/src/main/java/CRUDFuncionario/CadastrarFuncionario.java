
package CRUDFuncionario;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = 
	request.getRequestDispatcher("cadastroFuncionario.jsp");
        dispatcher.forward(request, response);
    }
    
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        UtilsFuncionario utilitario = new UtilsFuncionario();
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String cargo = request.getParameter("cargo");
        String admissao = request.getParameter("admissao");
        String unidade = request.getParameter("unidade");
        String sexo = request.getParameter("sexo");
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setLogin(login);
        funcionario.setSenha(senha);
        funcionario.setCargo(cargo);
        funcionario.setAdmissao(utilitario.converterData(admissao));
      try {
          funcionario.setIdUnidade(Daos.DaoUnidade.retornarUnidade(unidade));
      } catch (Exception ex) {
          Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
      }
        funcionario.setSexo(sexo);

        try {
            funcionario.inserirFuncionario(funcionario);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}