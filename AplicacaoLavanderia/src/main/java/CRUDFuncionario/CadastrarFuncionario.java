
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