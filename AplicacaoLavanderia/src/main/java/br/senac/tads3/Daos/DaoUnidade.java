/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.Daos;

import br.senac.tads3.CRUDCliente.Cliente;
import br.senac.tads3.CRUDUnidade.Unidade;
import br.senac.tads3.ConnectionBD.ConnectionUtils;
import static br.senac.tads3.Daos.DaoCliente.retornarClienteId;
import br.senac.tads3.Exceptions.UnidadeException;
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

        String sql = "INSERT INTO Unidade (NomeUnidade, cnpj, enabled) "
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
    
    public static void deletar(String id)
            throws SQLException, Exception { 
             String sql = "UPDATE Unidade SET Enabled = 'false' WHERE ID = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            System.out.println("Executando COMANDO SQL: " + sql);
            statement.execute();
            deletarFuncionariosDeUnidade(id);
            
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void deletarFuncionariosDeUnidade(String id)
            throws SQLException, Exception { 
             String sql = "UPDATE Funcionario SET Enabled = 'false' WHERE ID_Unidade = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
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
    
    public static void alterar(Unidade unidade, int id)
            throws SQLException, Exception {
        String sql = "UPDATE Unidade "
                + "SET NomeUnidade = ?, "
                + "CNPJ = ? "
                + "WHERE ID = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, unidade.getNome());
            statement.setString(2, unidade.getCnpj());
            statement.setInt(3, id);

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

    public static List<Unidade> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Unidade WHERE enabled = 'true'";
        
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
                    listaUnidades = new ArrayList<Unidade>();
                }
                Unidade unidades = new Unidade();
                unidades.setNome(result.getString("NomeUnidade"));
                unidades.setCnpj(result.getString("Cnpj"));
                unidades.setId(result.getInt("ID"));
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
    
    
    
    public static Unidade obter(int id) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Unidade"
                + " WHERE ID = ?;";
        Unidade unidade = new Unidade();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            unidade.setId(result.getInt("ID"));
            unidade.setNome(result.getString("NomeUnidade"));
            unidade.setCnpj(result.getString("CNPJ"));
            connection.close();
            return unidade;
        }

        return null;
    }
    
    public static int retornarIdUnidade(String nome) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Unidade "
                + " WHERE NomeUnidade = ?";
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
            connection.close();
            return unidade.getId();
        }

        return 0;
    }

    public static String retornarNomeUnidade(int id) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Unidade "
                + " WHERE ID = ?";
        Unidade unidade = new Unidade();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            unidade.setId(result.getInt("id"));
            unidade.setNome(result.getString("NomeUnidade"));
            unidade.setCnpj(result.getString("cnpj"));
            connection.close();
            return unidade.getNome();
        }

        return null;
    }
    
    public static List<Unidade> pesquisarUnidade(String nome) throws
        UnidadeException, SQLException, Exception {
        String sql = "SELECT * FROM Unidade WHERE NomeUnidade LIKE ? AND Enabled = 'true'";
        
        List<Unidade> listaUnidades = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);
            nome = "%"+nome+"%";
            statement.setString(1, nome);
            System.out.println(statement.toString());
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery();
            while (result.next()) {
                if (listaUnidades == null) {
                    listaUnidades = new ArrayList<Unidade>();
                }
                Unidade unidade = new Unidade();
                unidade.setId(result.getInt("ID"));
                unidade.setNome(result.getString("NomeUnidade"));
                unidade.setCnpj(result.getString("CNPJ"));
                listaUnidades.add(unidade);
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
    
    public static boolean verificarDuplicada(String cnpj) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Unidade "
                + " WHERE Unidade.Cnpj = ? AND Enabled = 'true'";

        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cnpj);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {

            return true;
        }

        return false;
    }
    
    public static boolean verificarDuplicadaAlterar(String cnpj, String cnpjUnidade) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Unidade "
                + " WHERE Unidade.Cnpj = ? AND Enabled = 'true'";

        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cnpj);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

         if(cnpjUnidade.equalsIgnoreCase(cnpj)){
            return false;
        }
        while (result.next()) {
            return true;
        }

        return false;
    }
}


