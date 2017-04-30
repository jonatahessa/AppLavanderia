/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CRUDFilial.Filial;
import ConnectionBD.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Thalles
 */
public class DaoFilial {
    
    public static void inseriFilial (Filial filial) throws SQLException {

        String sql = "INSERT INTO Filial (endereco, numero, cep, cidade, estado, enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, filial.getEndereco());
            statement.setString(2, filial.getNumero());
            statement.setString(3, filial.getCep());
            statement.setString(4, filial.getCidade());
            statement.setString(4, filial.getEstado());
            statement.setString(5, "true");
            System.out.println(statement.toString());

            System.out.println("Executando COMANDO SQL: " + sql);
            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
