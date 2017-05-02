/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import CRUDCliente.Cliente;
import CRUDUnidade.Unidade;
import ConnectionBD.ConnectionUtils;
import static Daos.DaoFuncionario.executarConsulta;
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
public class DaoUnidade {
    
    public static void inseriUnidade(Unidade unidade) throws SQLException {

        String sql = "INSERT INTO Unidade (nome, cnpj, enabled) "
                + "VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, unidade.getNome());
            statement.setString(2, unidade.getCnpj());
            statement.setString(3, unidade.getEnabled());
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
    
    public static List<Unidade> executarConsulta(String sql) throws
            FilialException, SQLException, Exception {
        List<Unidade> listaUnidades = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaUnidades == null) {
                    listaUnidades= new ArrayList<Unidade>();
                }
                Unidade unidades = new Unidade();
                unidades.setNome(result.getString("nome"));
                unidades.setCnpj(result.getString("cnpj"));                
                unidades.setEnabled(result.getString("enabled"));
                listaUnidades.add(unidades);
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
        return listaUnidades;
    }

    public static List<Unidade> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Unidade WHERE enabled = 'true'";

        return executarConsulta(sql);
    }
    
    public static Unidade retornarUnidade(String nome) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Unidade "
                + " WHERE Unidade.Nome = ?";
        Unidade unidade = new Unidade();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, nome);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            unidade.setId(result.getInt("id"));
            unidade.setNome(result.getString("nome"));
            unidade.setCnpj(result.getString("cnpj"));
            connection.close();
            return unidade;
        }

        return null;
    }
}