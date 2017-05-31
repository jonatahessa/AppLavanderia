/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import ConnectionBD.ConnectionUtils;
import Exeptions.RelatorioException;
import Relatorio.Relatorio;
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
    
    public static List<Relatorio> listarSemDataAdmin()
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente ORDER BY Venda.Data;";

        return executarConsulta(sql);
    }
   
        public static List<Relatorio> executarConsulta(String sql) throws
            RelatorioException, SQLException, Exception {
        List<Relatorio> listaRelatorio = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaRelatorio == null) {
                    listaRelatorio = new ArrayList<Relatorio>();
                }
                Relatorio relatorio = new Relatorio();
                relatorio.setUnidade(result.getString("NomeUnidade"));
                relatorio.setFuncionario(result.getString("NomeFuncionario"));
                relatorio.setCliente(result.getString("NomeCliente"));
                relatorio.setData(result.getDate("Data"));
                relatorio.setTotal(result.getDouble("Total"));
                listaRelatorio.add(relatorio);
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
        return listaRelatorio;
    }

}
