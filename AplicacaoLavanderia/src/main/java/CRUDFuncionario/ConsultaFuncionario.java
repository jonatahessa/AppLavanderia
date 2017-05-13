package CRUDFuncionario;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ConsultaFuncionario", urlPatterns = {"/ConsultaFuncionario"})

public class ConsultaFuncionario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("consultaFuncionario.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sexo = request.getParameter("sexo");
        String cargo = request.getParameter("cargo");
        String unidade = request.getParameter("unidade");
       
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setSexo(sexo);
        funcionario.setCargo(cargo);
        funcionario.setNomeUnidade(unidade);

        try {
            funcionario.pesquisarFuncionario(funcionario);
            response.sendRedirect("mensagemCadastro.jsp");
        } catch (Exception ex) {
            response.sendRedirect("mensagemErro.jsp");
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
