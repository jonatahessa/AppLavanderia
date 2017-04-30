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
	request.getRequestDispatcher("cadastroUnidade.jsp");
        dispatcher.forward(request, response);
    }


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        
    
        Unidade unidade = new Unidade();
        unidade.setNome(nome);
        unidade.setCnpj(cnpj);
        unidade.setEnabled("true");



        try {
            unidade.inserirUnidade(unidade);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
        }
        
    }


}