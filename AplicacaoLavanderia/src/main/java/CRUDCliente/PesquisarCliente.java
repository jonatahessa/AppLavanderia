package CRUDCliente;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "PesquisarCliente", urlPatterns = {"/PesquisarCliente"})
public class PesquisarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
    }


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        ServicoCliente sc = new ServicoCliente();
        
        if (request.getParameter("palavra").equals("") || request.getParameter("palavra") == null) {
            try {
                List<Cliente> resultado = sc.ListarClientes();
                request.setAttribute("resultado", resultado);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultaCliente.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            try {
                List<Cliente> resultado = sc.pesquisarCliente(request.getParameter("palavra"));
                if (resultado == null){
                    request.setAttribute("palavra", request.getParameter("palavra"));
                } else {
                    request.setAttribute("palavra", request.getParameter("palavra"));
                    request.setAttribute("resultado", resultado);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultaCliente.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("mensagemErro.jsp"); 
            }
        }
    }
    
}
