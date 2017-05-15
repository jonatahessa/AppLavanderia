
package CRUDFuncionario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AlterarFuncionario", urlPatterns = {"/AlterarFuncionario"})
public class AlterarFuncionario extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        Funcionario funcionario = new Funcionario();        
        ServicoFuncionario sf = new ServicoFuncionario();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        try {
            funcionario = sf.obterFuncionario(request.getParameter("id"));
        } catch (Exception ex) {
            Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }        
        request.setAttribute("nome", funcionario.getNome());
        request.setAttribute("sexo", funcionario.getSexo());
        String data = df.format(funcionario.getAdmissao());
        request.setAttribute("admissao", data);
        request.setAttribute("cargo", funcionario.getCargo());
        request.setAttribute("unidade", funcionario.getNomeUnidade());
        request.setAttribute("login", funcionario.getLogin());
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraFuncionario.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ServicoFuncionario sf = new ServicoFuncionario();
        boolean erro = false;
        boolean nome = sf.verificarNome(request.getParameter("nome"));
        boolean cargo = sf.verificarCargo(request.getParameter("cargo"));
        boolean unidade = sf.verificarUnidade(request.getParameter("unidade"));
        boolean sexo = sf.verificarSexo(request.getParameter("sexo"));
    
     
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
        }
        if (cargo != true) {
            erro = true;
            request.setAttribute("erroCargo", true);
        } else {
            request.setAttribute("cargo", request.getParameter("cargo"));
        }
        if (unidade != true) {
            erro = true;
            request.setAttribute("unidade", true);
        } else {
            request.setAttribute("unidade", request.getParameter("unidade"));
        }
        if (sexo != true) {
            erro = true;
            request.setAttribute("erroSexo", true);
        } else {
            request.setAttribute("sexo", request.getParameter("sexo"));
        }
        
        request.setAttribute("sex", request.getParameter("sexo"));
        
        if (!erro) {
            ServicoFuncionario sf2 = new ServicoFuncionario();
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(request.getParameter("nome"));
            funcionario.setCargo(request.getParameter("cargo"));
            funcionario.setNomeUnidade(request.getParameter("unidade"));
            funcionario.setSexo(request.getParameter("sexo"));
            
            try {
                sf2.alterarFuncionario(funcionario, request.getParameter("idCliente"));
                response.sendRedirect("mensagemAlteracao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("alteraCliente.jsp");
            dispatcher.forward(request, response);
        }

    }

}