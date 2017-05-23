
package CRUDServico;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "PesquisarServico", urlPatterns = {"/PesquisarServico"})
public class PesquisarServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        ServicoServico ss = new ServicoServico();
        
        if (request.getParameter("palavra").equals("") || request.getParameter("palavra") == null) {
            try {
                List<Servico> resultado = ss.ListarServicos();
                request.setAttribute("resultado", resultado);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultaServico.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            try {
                List<Servico> resultado = ss.pesquisarServico(request.getParameter("palavra"));
                if (resultado == null){
                    request.setAttribute("palavra", request.getParameter("palavra"));
                } else {
                    request.setAttribute("palavra", request.getParameter("palavra"));
                    request.setAttribute("resultado", resultado);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultaServico.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    
}


