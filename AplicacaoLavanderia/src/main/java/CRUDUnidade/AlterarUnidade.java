package CRUDUnidade;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AlterarUnidade", urlPatterns = {"/AlterarUnidade"})
public class AlterarUnidade extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        Unidade unidade = new Unidade();        
        ServicoUnidade su = new ServicoUnidade();
        
        try {
            unidade = su.obterUnidade(request.getParameter("id"));
        } catch (Exception ex) {
            Logger.getLogger(AlterarUnidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("idUnidade", unidade.getId());
        request.setAttribute("nome", unidade.getNome());
        request.setAttribute("cnpj", unidade.getCnpj());
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraUnidade.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ServicoUnidade sf = new ServicoUnidade();
        boolean erro = false;
        boolean nome = sf.verificarNome(request.getParameter("nome"));
        boolean cnpj = sf.verificarCnpj(request.getParameter("cnpj"));
    
     
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
        }
        if (cnpj != true) {
            erro = true;
            request.setAttribute("erroCargo", true);
        } else {
            request.setAttribute("cnpj", request.getParameter("cnpj"));
        }
        
        if (!erro) {
            ServicoUnidade su2 = new ServicoUnidade();
            Unidade unidade = new Unidade();
            unidade.setNome(request.getParameter("nome"));
            unidade.setCnpj(request.getParameter("cnjp"));
            
            try {
                su2.alterarUnidade(unidade, request.getParameter("idUnidade"));
                response.sendRedirect("mensagemAlteracao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("alteraUnidade.jsp");
            dispatcher.forward(request, response);
        }

    }

}