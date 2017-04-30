/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDServico;

/**
 *
 * @author livia.cgsantos e eloisa.asilva2
 */


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CadastrarServico", urlPatterns = {"/CadastrarServico"})
public class CadastrarServico extends HttpServlet {

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = 
	request.getRequestDispatcher("cadastroServico.jsp");
        dispatcher.forward(request, response);
    }
    
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
     
        String nomeServico = request.getParameter("nome");
        String precoPorPeca = request.getParameter("preco");
        
       double preco = Double.parseDouble(precoPorPeca);
        Servico servico = new Servico();
      
        servico.setNomeServico(nomeServico);
        servico.setPrecoPorPeca(preco);
       

        try {
            servico.inserirServico(servico);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
            Logger.getLogger(CadastrarServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}