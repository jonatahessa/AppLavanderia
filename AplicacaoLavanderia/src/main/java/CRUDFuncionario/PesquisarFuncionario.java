
package CRUDFuncionario;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PesquisarFuncionario", urlPatterns = {"/PesquisarFuncionario"})
public class PesquisarFuncionario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        ServicoFuncionario sf = new ServicoFuncionario();
        
        if (request.getParameter("palavra").equals("") || request.getParameter("palavra") == null) {
            try {
                List<Funcionario> resultado = sf.ListarFuncionarios();
                request.setAttribute("resultado", resultado);
                RequestDispatcher dispatcher = request.getRequestDispatcher("consultaFuncionario.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("mensagemErro.jsp"); 
            }
        } else {
            try {
                List<Funcionario> resultado = sf.pesquisarFuncionario(request.getParameter("palavra"));
                if (resultado == null){
                    request.setAttribute("palavra", request.getParameter("palavra"));
                } else {
                    request.setAttribute("palavra", request.getParameter("palavra"));
                    request.setAttribute("resultado", resultado);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("consultaFuncionario.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("mensagemErro.jsp"); 
            }
        }
    }
    
}


