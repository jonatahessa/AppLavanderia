/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDVenda;

import CRUDCliente.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jonat
 */
public class FinalizarVenda extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<ItemVenda> itens = (ArrayList<ItemVenda>) session.getAttribute("listaItensVenda");
        double totalDaVenda = 0;
        for (ItemVenda item : itens) {
            totalDaVenda += item.getPrecoServico();
        }

        ServicoVenda sv = new ServicoVenda();
        Cliente cliente = (Cliente) session.getAttribute("clienteVenda");
        Venda venda = new Venda();
        int funcionarioId = (int) session.getAttribute("idFuncionario");
        venda.setIdCliente(cliente.getId());
        venda.setIdFuncionario(funcionarioId);
        venda.setTotalVenda(totalDaVenda);

        try {
            sv.finalizarVenda(venda);
            for (ItemVenda item : itens) {
                item.setIdVenda(sv.retornarIdUltimaVenda());
                sv.inserirItensVenda(item);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemVendaSucesso.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErroVenda.jsp");
            dispatcher.forward(request, response);
        }

    }

}
