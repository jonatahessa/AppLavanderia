/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDFuncionario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thales.dsouza
 */
@WebServlet(name = "DeletarFuncionario", urlPatterns = {"/DeletarFuncionario"})
public class DeletarFuncionario extends HttpServlet {

    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
    }

    /*@Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
        try {
            ServicoFuncionario sf = new ServicoFuncionario();
            sf.deletarFuncionario(request.getParameter(id));
            response.sendRedirect("mensagemExclusao.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
        }
        
    }*/
}

    


