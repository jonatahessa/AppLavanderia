package CRUDCliente;

import Daos.DaoCliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//aula http://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example
@WebServlet(name = "DeletarCliente", urlPatterns = {"/DeletarCliente"})
public class DeletarCliente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {

                case "/update":
                    updateBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String title = request.getParameter("cpf");

 /*
        Cliente cliente = new Cliente(cpf);
        DAOCliente.updateBook(cliente);*/
    }
}

