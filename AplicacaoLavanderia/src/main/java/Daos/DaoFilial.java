/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CRUDFilial.Filial;
import ConnectionBD.ConnectionUtils;
import Exeptions.FilialException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
            statement.setString(5, filial.getEstado());
            statement.setString(6, filial.getEnabled());
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
    
    public static List<Filial> executarConsulta(String sql) throws
            FilialException, SQLException, Exception {
        List<Filial> listaFiliais = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaFiliais == null) {
                    listaFiliais = new ArrayList<Filial>();
                }
                Filial filiais = new Filial();
                filiais.setEndereco(result.getString("endereco"));
                filiais.setNumero(result.getString("numero"));
                filiais.setCep(result.getString("cep"));
                filiais.setCidade(result.getString("cidade"));
                filiais.setEstado(result.getString("estado"));
                filiais.setEnabled(result.getString("enabled"));
                listaFiliais.add(filiais);
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
        return listaFiliais;
    }

    public static List<Filial> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Filial WHERE enabled = 'true'";

        return executarConsulta(sql);
    }
}
