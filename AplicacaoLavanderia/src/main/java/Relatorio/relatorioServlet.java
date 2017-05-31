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
        boolean erro = false;
        List<Venda> listaVenda = null;
        ServicoRelatorio sr = new ServicoRelatorio();
        boolean DeData =  sr.verificarDeData(request.getParameter("DeData"));
        boolean AteData =  sr.verificarDeData(request.getParameter("AteData"));
        
        if(DeData == true){
            erro = true;
            request.setAttribute("DeData", true);
        }else{
            request.setAttribute("ErroDeData", request.getParameter("DeData"));
            request.setAttribute("DeData", true);
            
        }
        
        if(DeData == true){
            erro = true;
            request.setAttribute("AteData", true);
        }else{
            request.setAttribute("ErroAteData", request.getParameter("AteData"));
            request.setAttribute("AteData", true);
            
        }
    }

}


