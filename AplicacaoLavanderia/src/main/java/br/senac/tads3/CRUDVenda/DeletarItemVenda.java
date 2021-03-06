package br.senac.tads3.CRUDVenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeletarItemVenda extends HttpServlet {

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
        String totalTexto = (String) session.getAttribute("total");
        double totalDaVenda = Double.parseDouble(totalTexto.replace(',', '.'));
        DecimalFormat formato = new DecimalFormat("0.##");
        for (ItemVenda item : itens) {
            if (item.getId() == Integer.parseInt(request.getParameter("iditem"))) {
                itens.remove(item);
                totalDaVenda -= item.getPrecoServico();
                session.setAttribute("total", formato.format(totalDaVenda));
                RequestDispatcher dispatcher = request.getRequestDispatcher("Lavar");
                dispatcher.forward(request, response);
            }
        }
    }

}
