/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDVenda;

import CRUDCliente.Cliente;
import CRUDCliente.ServicoCliente;
import CRUDServico.Servico;
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
        ServicoVenda sv = new ServicoVenda();
        HttpSession session = request.getSession();
        ArrayList<ItemVenda> itens = (ArrayList<ItemVenda>) session.getAttribute("listaItensVenda");
        boolean verificarCliente = false, erro = false;
        try {
            verificarCliente = sv.verificarCliente(request.getParameter("cpf"));
        } catch (Exception ex) {
        }

        if (verificarCliente == false) {
            request.setAttribute("erroCpf", true);
            erro = true;
        } else {
            request.setAttribute("cpf", request.getParameter("cpf"));
            request.setAttribute("trueNome", true);
        }

        if (itens.isEmpty()) {
            request.setAttribute("carrinhoVazio", true);
            erro = true;
        }

        if (!erro) {

            double totalDaVenda = 0;
            for (ItemVenda item : itens) {
                totalDaVenda += item.getPrecoServico();
            }

            Venda venda = new Venda();
            int funcionarioId = (int) session.getAttribute("idFuncionario");
            
            
            ServicoCliente sc = new ServicoCliente();
            Cliente cliente = new Cliente();
            try {
                cliente = sc.obterCliente(request.getParameter("cpf"));
            } catch (Exception ex) {
            }
            
            venda.setIdCliente(cliente.getId());
            venda.setIdFuncionario(funcionarioId);
            venda.setTotalVenda(totalDaVenda);
            try {
                sv.finalizarVenda(venda);
                for (ItemVenda item : itens) {
                    item.setIdVenda(sv.retornarIdUltimaVenda());
                    sv.inserirItensVenda(item);
                }

                session.removeAttribute("listaItensVenda");
                session.removeAttribute("cpf");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemVendaSucesso.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErroVenda.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lavar.jsp");
            dispatcher.forward(request, response);
        }
    }
}
