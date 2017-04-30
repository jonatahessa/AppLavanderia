/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDFilial;

import CRUDFilial.Filial;
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
 * @author Thalles
 */
@WebServlet(name = "CadastrarFilial", urlPatterns = {"/CadastrarFilial"})
public class CadastrarFilial extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        RequestDispatcher dispatcher = 
	request.getRequestDispatcher("cadastroFilial.jsp");
        dispatcher.forward(request, response);
    }


  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        String endereco = request.getParameter("endereco");
        String numero = request.getParameter("numero");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
    
        Filial filial = new Filial();
        filial.setEndereco(endereco);
        filial.setNumero(numero);
        filial.setCep(cep);
        filial.setCidade(cidade);
        filial.setEstado(estado);



        try {
            filial.inserirFilial(filial);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp"); 
        }
        
    }


}