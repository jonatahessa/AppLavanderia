/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDVenda;

import CRUDServico.Servico;
import CRUDServico.ServicoServico;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonata.hmoliveira
 */
@WebServlet(name = "Lavar", urlPatterns = {"/Lavar"})
public class Lavar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<ItemVenda> itens = (ArrayList<ItemVenda>) session.getAttribute("resultado");
        if (itens == null) {
            itens = new ArrayList<ItemVenda>();
            session.setAttribute("resultado", itens);
        }
        ServicoServico ss = new ServicoServico();
        Servico servico = new Servico();
        try {
            servico = ss.obterServico(Integer.parseInt(request.getParameter("id")));
        } catch (Exception ex) {
            Logger.getLogger(Lavar.class.getName()).log(Level.SEVERE, null, ex);
        }

        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setId(Integer.parseInt(request.getParameter("id")));
        itemVenda.setPrecoServico(servico.getPrecoServico());
        itemVenda.setNomeServico(servico.getNomeServico());
        servico = new Servico();
        itemVenda.setQuantidade(Integer.parseInt(request.getParameter("qtde")));
        itens.add(itemVenda);
        request.setAttribute("lista", itens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lavar.jsp");
        dispatcher.forward(request, response);

    }
}
