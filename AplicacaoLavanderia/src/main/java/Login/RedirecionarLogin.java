/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonata.hmoliveira
 */
public class RedirecionarLogin extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
      request.setAttribute("sessaoEncerrada", true);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
      dispatcher.forward(request, response);
        
        
    }

}
