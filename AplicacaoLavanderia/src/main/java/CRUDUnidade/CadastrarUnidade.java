
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

@WebServlet(name = "CadastrarUnidade", urlPatterns = {"/CadastrarUnidade"})
public class CadastrarUnidade extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = 
	request.getRequestDispatcher("/WEB-INF/cadastroUnidade.jsp");
        dispatcher.forward(request, response);
    }


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        ServicoUnidade vu = new ServicoUnidade();
        boolean erro = false, duplicidade = false;
        boolean nome = vu.verificarNome(request.getParameter("nome"));
        boolean cnpj = vu.verificarCnpj(request.getParameter("cnpj"));
        try {
            duplicidade = vu.verificarDuplicada(request.getParameter("cnpj"));
        } catch (Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
            dispatcher.forward(request, response);
        }   
        
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
            request.setAttribute("trueNome", true);
        }
        if (cnpj != true || duplicidade == true) {
            erro = true;
            request.setAttribute("erroCnpj", true);
        } else {
            request.setAttribute("cnpj", request.getParameter("cnpj"));
            request.setAttribute("trueCnpj", true);
        }
        
        if (!erro) {
            Unidade unidade = new Unidade();
            unidade.setNome(request.getParameter("nome"));
            unidade.setCnpj(request.getParameter("cnpj"));
            unidade.setEnabled("true");
            try {
                vu.inserirUnidade(unidade);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemCadastro.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            } 
        } else {   
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastroUnidade.jsp");
            dispatcher.forward(request, response);
        }
        
    }


}