package CRUDUnidade;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletarUnidade", urlPatterns = {"/DeletarUnidade"})
public class DeletarUnidade extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    }

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        ServicoUnidade su = new ServicoUnidade();
        try {
                su.deletarUnidade(request.getParameter("id"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemExclusao.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
    }

    
}
