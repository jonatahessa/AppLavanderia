/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDServico;

import CRUDServico.ServicoServico;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeletarServico", urlPatterns = {"/DeletarServico"})
public class DeletarServico extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
    }

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
        try {
            ServicoServico ss = new ServicoServico();
            ss.deletarServico(Integer.parseInt(request.getParameter("id")));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemExclusao.jsp");
                dispatcher.forward(request, response);
        } catch (Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
        }
        
    }

}
