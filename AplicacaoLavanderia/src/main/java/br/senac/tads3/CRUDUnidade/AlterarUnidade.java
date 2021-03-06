package br.senac.tads3.CRUDUnidade;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        HttpSession idAlterar = request.getSession();
        idAlterar.setAttribute("idAlterar", unidade.getId());
        request.setAttribute("nome", unidade.getNome());
        HttpSession session = request.getSession();
        session.setAttribute("cnpjAtual", unidade.getCnpj());
        request.setAttribute("cnpj", unidade.getCnpj());

            
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alteraUnidade.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ServicoUnidade su = new ServicoUnidade();
        boolean erro = false, duplo = false;
        boolean nome = su.verificarNome(request.getParameter("nome"));
        System.out.println("*************");
        System.out.println(request.getParameter("cnpj"));
        boolean cnpj = su.verificarCnpj(request.getParameter("cnpj"));
        HttpSession session = request.getSession();
        String cnpjUnidade = (String) session.getAttribute("cnpjAtual");
        
        try {
            duplo = su.verificarDuplicadaAlterar(request.getParameter("cnpj"), cnpjUnidade);
        } catch (Exception ex) {
        }
        
        
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
            request.setAttribute("trueNome", true);
        }
        if (cnpj != true || duplo == true) {
            erro = true;
            request.setAttribute("erroCnpj", true);
        } else {
            request.setAttribute("cnpj", request.getParameter("cnpj"));
            request.setAttribute("trueCnpj", true);
        }
        
        if (!erro) {
            Unidade unidade = new Unidade();
            unidade.setNome(request.getParameter("nome").trim());
            unidade.setCnpj(request.getParameter("cnpj").trim());
            
            try {
                su.alterarUnidade(unidade, request.getParameter("idUnidade"));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemAlteracao.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
                Logger.getLogger(CadastrarUnidade.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alteraUnidade.jsp");
            dispatcher.forward(request, response);
        }

    }

}