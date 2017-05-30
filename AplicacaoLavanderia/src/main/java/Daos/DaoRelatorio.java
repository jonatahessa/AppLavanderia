/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CRUDVenda.Venda;
import ConnectionBD.ConnectionUtils;
import Exeptions.RelatorioException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius.vsilva8
 */
public class DaoRelatorio {
    
    public static List<Venda> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Venda";

        return executarConsulta(sql);
    }
   
        public static List<Venda> executarConsulta(String sql) throws
            RelatorioException, SQLException, Exception {
        List<Venda> listaVendas = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaVendas == null) {
                    listaVendas = new ArrayList<Venda>();
                }
                Venda venda = new Venda();
                venda.setDataVenda(result.getDate("Data"));
                venda.setIdCliente(result.getInt("ID_Cliente"));
                venda.setIdFuncionario(result.getInt("ID_Funcionario"));
                venda.setIdVenda(result.getInt("ID"));
                venda.setTotalVenda(result.getDouble("Total"));
                listaVendas.add(venda);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaVendas;
    }

}
