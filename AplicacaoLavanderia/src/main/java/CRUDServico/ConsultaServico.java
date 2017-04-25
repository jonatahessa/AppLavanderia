/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDServico;

import CRUDCliente.CadastrarCliente;
import CRUDCliente.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author livia.cgsantos
 */

@WebServlet(name = "EntradaServlet", urlPatterns = {"/ConsultaServico"})

public class ConsultaServico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("consultaServico.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeServico = request.getParameter("nomeServico");
        String precoPorPeca = request.getParameter("precoPorPeca");
        
        double preco = Double.parseDouble(precoPorPeca); 

       Servico servico = new Servico();
        servico.setNomeServico(nomeServico);
        servico.setPrecoPorPeca(preco);
       

        try {
           servico.pesquisarServico(servico);
            response.sendRedirect("mensagemServico.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp");
            Logger.getLogger(CadastrarServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

}
