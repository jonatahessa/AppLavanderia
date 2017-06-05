
package br.senac.tads3.Redirecionar;

import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Redirecionar extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getParameter("tela"));
                dispatcher.forward(request, response);
       
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getParameter("tela"));
                dispatcher.forward(request, response);
        
    }

}