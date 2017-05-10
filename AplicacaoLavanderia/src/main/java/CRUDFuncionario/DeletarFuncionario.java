/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDFuncionario;

import java.io.IOException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thales.dsouza
 */
public class DeletarFuncionario {
   @WebServlet(name = "DeletarCliente", urlPatterns = {"/DeletarCliente"})
public class DeletarCliente extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        ServicoFuncionario sf = new ServicoFuncionario();
        try {
                sf.deletarFuncionario(request.getParameter("cpf"));
                response.sendRedirect("mensagemExclusao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
            }
    }

    
}
 
}
