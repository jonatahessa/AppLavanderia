/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDFuncionario;

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
 * @author thales.dsouza
 */
@WebServlet(name = "AlterarFuncionario", urlPatterns = {"/AlterarFuncionario"})
public class AlterarFuncionario extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();        
        ServicoFuncionario sf = new ServicoFuncionario();
        try {
            funcionario = sf.obterFuncionario(request.getParameter("id"));
        } catch (Exception ex) {
        }        
        request.setAttribute("nome", funcionario.getNome());
        request.setAttribute("admissao", funcionario.getAdmissao());
        request.setAttribute("cargo", funcionario.getCargo());
        request.setAttribute("unidade", funcionario.getIdUnidade());
        request.setAttribute("sexo", funcionario.getSexo());
        request.setAttribute("usuario", funcionario.getLogin());
        request.setAttribute("senha", funcionario.getSenha());
            
        RequestDispatcher dispatcher = request.getRequestDispatcher("alteraFuncionario.jsp");
        dispatcher.forward(request, response);
   
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
        
        ServicoFuncionario sf = new ServicoFuncionario();
        boolean erro = false;
        boolean nome = .verificarNome(request.getParameter("nome"));
        boolean email = vc.verificarEmail(request.getParameter("email"));
        boolean telefone = vc.verificarTelefone(request.getParameter("telefone"));
        boolean cpf = vc.verificarCpf(request.getParameter("cpf"));
    
     
        if (nome != true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
        }
        if (email != true) {
            erro = true;
            request.setAttribute("erroEmail", true);
        } else {
            request.setAttribute("email", request.getParameter("email"));
        }
        if (telefone != true) {
            erro = true;
            request.setAttribute("erroTelefone", true);
        } else {
            request.setAttribute("telefone", request.getParameter("telefone"));
        }
        if (cpf != true) {
            erro = true;
            request.setAttribute("erroCpf", true);
        } else {
            request.setAttribute("cpf", request.getParameter("cpf"));
        }
        
        request.setAttribute("sex", request.getParameter("sexo"));
        
        if (!erro) {
            ServicoCliente sc = new ServicoCliente();
            Cliente cliente = new Cliente();
            cliente.setCpf(request.getParameter("cpf"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setNome(request.getParameter("nome"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setSexo(request.getParameter("sexo"));
            
            try {
                sc.alterarCliente(cliente, request.getParameter("idCliente"));
                response.sendRedirect("mensagemAlteracao.jsp");
            } catch (Exception ex) {
                response.sendRedirect("mensagemErro.jsp"); 
                Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
      
            RequestDispatcher dispatcher = request.getRequestDispatcher("alteraCliente.jsp");
            dispatcher.forward(request, response);
        }

    }
}
