/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.CRUDVenda;

import br.senac.tads3.CRUDCliente.Cliente;
import br.senac.tads3.CRUDServico.Servico;
import br.senac.tads3.CRUDServico.ServicoServico;
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
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("clienteVenda");
        if (cliente == null) {
            cliente = new Cliente();
        }
        request.setAttribute("cpf", cliente.getCpf());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lavar.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<ItemVenda> itens = (ArrayList<ItemVenda>) session.getAttribute("listaItensVenda");
        Cliente cliente = (Cliente) session.getAttribute("clienteVenda");
        double totalDaVenda = 0;
        int id = 0;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }

        if (cliente == null) {
            cliente = new Cliente();
        }

        if (itens == null) {
            itens = new ArrayList<ItemVenda>();
            session.setAttribute("listaItensVenda", itens);
        }

        ServicoServico ss = new ServicoServico();
        Servico servico = new Servico();
        
        for (ItemVenda item : itens) {
                totalDaVenda += item.getPrecoServico();
            }
            session.setAttribute("total", totalDaVenda);

        if (id != 0) {
            try {
                servico = ss.obterServico(id);
            } catch (Exception ex) {
                Logger.getLogger(Lavar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ItemVenda itemVenda = new ItemVenda();
        if (id != 0) {
            itemVenda.setNomeServico(servico.getNomeServico());
            itemVenda.setId(Integer.parseInt(request.getParameter("id")));
            itemVenda.setQuantidade(Integer.parseInt(request.getParameter("qtde")));
            itemVenda.setPrecoUnitario(servico.getPrecoServico());
            itemVenda.setPrecoServico(servico.getPrecoServico() * itemVenda.getQuantidade());
            itens.add(itemVenda);
            for (ItemVenda item : itens) {
                totalDaVenda += item.getPrecoServico();
            }
            session.setAttribute("total", totalDaVenda);
            response.sendRedirect("Lavar");
            return;
        }

        request.setAttribute("cpf", cliente.getCpf());
        request.setAttribute("listaItensVenda", itens);
        request.setAttribute("total", session.getAttribute("total"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lavar.jsp");
        dispatcher.forward(request, response);

    }
}
