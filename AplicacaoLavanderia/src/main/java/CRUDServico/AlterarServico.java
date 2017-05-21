
package CRUDServico;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarServico", urlPatterns = {"/AlterarServico"})
public class AlterarServico extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

        Servico servico = new Servico();        
        ServicoServico ss = new ServicoServico();
        try {
            servico = ss.obterServico(Integer.parseInt(request.getParameter("id")));
        } catch (Exception ex) {

        }        
        request.setAttribute("nome", servico.getNomeServico());
        request.setAttribute("preco", servico.getPrecoServico());
        request.setAttribute("id", servico.getId());

        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraServico.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ServicoServico ss = new ServicoServico();
        boolean erro = false;
        boolean nome = ss.verificarNome(request.getParameter("nome"));
        String precoCorrigido = ss.converterPreco(request.getParameter("preco"));
        boolean preco = ss.verificarPreco(precoCorrigido);
     
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
            request.setAttribute("trueNome", true);
        }
        if (preco != true) {
            erro = true;
            request.setAttribute("erroPreco", true);
        } else {
            request.setAttribute("preco", request.getParameter("preco"));
            request.setAttribute("truePreco", true);
        }
        
        if (!erro) {
            Servico servico = new Servico();
            servico.setNomeServico(request.getParameter("nome"));
            servico.setPrecoServico(Double.parseDouble(precoCorrigido));;
            
            try {
                ss.alterarServico(servico, request.getParameter("id"));
                response.sendRedirect("mensagemAlteracao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("alteraServico.jsp");
            dispatcher.forward(request, response);
        }

    }

}
