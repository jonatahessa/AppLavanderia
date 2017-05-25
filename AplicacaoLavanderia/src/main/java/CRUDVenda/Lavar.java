/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDVenda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        ArrayList<ItemVenda> itens = (ArrayList<ItemVenda>) session.getAttribute("resultado");
        if(itens == null){
            itens = new ArrayList<ItemVenda>();
            session.setAttribute("resultado", itens);
        }
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setIdServico(Integer.parseInt(request.getParameter("id")));
        itemVenda.setQuantidade(Integer.parseInt(request.getParameter("qtde")));
        itens.add(itemVenda);
        request.setAttribute("lista", this);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/lavar.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
