/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDCliente;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "EntradaServlet", urlPatterns = {"/ConsultaCliente"})

public class ConsultaCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("consultaCliente.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");

        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setSexo(sexo);

        try {
            cliente.pesquisarCliente(cliente);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp");
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
