/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorio;

import CRUDCliente.Cliente;
import CRUDCliente.ServicoCliente;
import CRUDFuncionario.Funcionario;
import CRUDVenda.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius.vsilva8
 */
public class relatorioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venda> listaVenda = null;
        ServicoRelatorio sr = new ServicoRelatorio();
        int deData = sr.verificarDeData(request.getParameter("dedata"));
        int ateData = sr.verificarAteData(request.getParameter("atedata"));
        
        if (deData == 1 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.ListarRelatorioSemDataAdmin();
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 2 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.ListarRelatorioDeDataAdmin(request.getParameter("dedata"));
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
