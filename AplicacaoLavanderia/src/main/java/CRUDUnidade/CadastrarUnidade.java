/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDUnidade;

import java.io.IOException;
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
        boolean erro = false;
        boolean nome = vu.verificarNome(request.getParameter("nome"));
        boolean cnpj = vu.verificarCnpj(request.getParameter("cnpj"));
        
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        }
        if (cnpj != true) {
            erro = true;
            request.setAttribute("erroCnpj", true);
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