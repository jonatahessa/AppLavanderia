/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorio;

import CRUDVenda.Venda;
import java.io.IOException;
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
                List<Relatorio> itens = sr.listarRelatorioSemDataAdmin();
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 2 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataAdmin(request.getParameter("dedata"));
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 2 && ateData == 2) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataAteDataAdmin(request.getParameter("dedata"), request.getParameter("atedata"));
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 1 && ateData == 2) {
            try {
                List<Relatorio> itens = sr.listarRelatorioAteDataAdmin(request.getParameter("atedata"));
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 1 && ateData == 0) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataAdmin();
                request.setAttribute("itens", itens);
                request.setAttribute("erroAteData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 0 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataAdmin();
                request.setAttribute("itens", itens);
                request.setAttribute("erroDeData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 0 && ateData == 0) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataAdmin();
                request.setAttribute("itens", itens);
                request.setAttribute("erroDeData", true);
                request.setAttribute("erroAteData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 2 && ateData == 0) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataAdmin(request.getParameter("dedata"));
                request.setAttribute("itens", itens);
                request.setAttribute("erroAteData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 0 && ateData == 2) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataAdmin(request.getParameter("atedata"));
                request.setAttribute("itens", itens);
                request.setAttribute("erroDeData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
