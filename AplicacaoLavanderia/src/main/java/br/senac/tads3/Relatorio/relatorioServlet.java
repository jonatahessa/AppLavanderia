/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.Relatorio;

import br.senac.tads3.CRUDFuncionario.ServicoFuncionario;
import br.senac.tads3.CRUDVenda.Venda;
import java.io.IOException;
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
 * @author vinicius.vsilva8
 */
public class relatorioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Venda> listaVenda = null;
        HttpSession session = request.getSession();
        ServicoRelatorio sr = new ServicoRelatorio();
        ServicoFuncionario sf = new ServicoFuncionario();
        int deData = sr.verificarDeData(request.getParameter("dedata"));
        int ateData = sr.verificarAteData(request.getParameter("atedata"));
        int idFuncionario = (int) session.getAttribute("idFuncionario");
        int idUnidade = 0;
        try {
            idUnidade = sf.obterIdUnidade(idFuncionario);
        } catch (Exception ex) {
            Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cargo = null;
        try {
            cargo = sf.retornaCargo(idFuncionario);
        } catch (Exception ex) {
            Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (cargo.equalsIgnoreCase("Gerente T.I")) {

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
        } else if (deData == 1 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataVendedor(idUnidade);
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 2 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataVendedor(request.getParameter("dedata"), idUnidade);
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 2 && ateData == 2) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataAteDataVendedor(request.getParameter("dedata"), request.getParameter("atedata"), idUnidade);
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 1 && ateData == 2) {
            try {
                List<Relatorio> itens = sr.listarRelatorioAteDataVendedor(request.getParameter("atedata"), idUnidade);
                request.setAttribute("itens", itens);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (deData == 1 && ateData == 0) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataVendedor(idUnidade);
                request.setAttribute("itens", itens);
                request.setAttribute("erroAteData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 0 && ateData == 1) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataVendedor(idUnidade);
                request.setAttribute("itens", itens);
                request.setAttribute("erroDeData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 0 && ateData == 0) {
            try {
                List<Relatorio> itens = sr.listarRelatorioSemDataVendedor(idUnidade);
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
                List<Relatorio> itens = sr.listarRelatorioDeDataVendedor(request.getParameter("dedata"), idUnidade);
                request.setAttribute("itens", itens);
                request.setAttribute("erroAteData", true);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/relatorio.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(relatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (deData == 0 && ateData == 2) {
            try {
                List<Relatorio> itens = sr.listarRelatorioDeDataVendedor(request.getParameter("atedata"), idUnidade);
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
