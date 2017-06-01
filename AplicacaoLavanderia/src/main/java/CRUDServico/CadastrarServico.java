/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDServico;

/**
 *
 * @author livia.cgsantos e eloisa.asilva2
 */
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarServico", urlPatterns = {"/CadastrarServico"})
public class CadastrarServico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServicoServico ss = new ServicoServico();
        
        boolean erro = false, duplicidade = false;
        boolean nome = ss.verificarNome(request.getParameter("nome"));
        String precoCorrigido = ss.converterPreco(request.getParameter("preco"));
        boolean preco = ss.verificarPreco(precoCorrigido);
        try {
            duplicidade = ss.verificarDuplicidade(request.getParameter("nome"));
        } catch (Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro");
            dispatcher.forward(request, response);
        }
        
        
        if (nome != true || duplicidade == true) {
            erro = true;
            request.setAttribute("erroNome", true);
        } else {
            request.setAttribute("nome", request.getParameter("nome"));
            request.setAttribute("trueNome", true);
        }
        if (preco != true) {
            erro = true;
            request.setAttribute("erroPreco", true);
        } else {
            request.setAttribute("preco", request.getParameter("preco"));
            request.setAttribute("truePreco", true);
        }

        if (!erro) {
            Servico servico = new Servico();
            servico.setNomeServico(request.getParameter("nome").trim());
            servico.setPrecoServico(Double.parseDouble(precoCorrigido));
            try {
                ss.inserirServico(servico);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemCadastro.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mensagemErro.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cadastroServico.jsp");
            dispatcher.forward(request, response);
        }
    }

}
