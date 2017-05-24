/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDUnidade;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thales.dsouza
 */
@WebServlet(name = "PesquisarUnidade", urlPatterns = {"/PesquisarUnidade"})
public class PesquisarUnidade extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
    }


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        ServicoUnidade su = new ServicoUnidade();
        
        if (request.getParameter("palavra").equals("") || request.getParameter("palavra") == null) {
            try {
                List<Unidade> resultado = su.ListarUnidades();
                request.setAttribute("resultado", resultado);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultaUnidade.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            try {
                List<Unidade> resultado = su.pesquisarUnidade(request.getParameter("palavra"));
                if (resultado == null){
                    request.setAttribute("palavra", request.getParameter("palavra"));
                } else {
                    request.setAttribute("palavra", request.getParameter("palavra"));
                    request.setAttribute("resultado", resultado);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultaUnidade.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                response.sendRedirect("mensagemErro.jsp"); 
            }
        }
    }
    
}



