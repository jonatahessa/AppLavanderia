package Daos;

import CRUDServico.Servico;
import ConnectionBD.ConnectionUtils;
import Exeptions.ServicoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonata
 */
public class DaoServico {

    public static void inserir(Servico servico)
            throws SQLException, Exception {

        String sql = "INSERT INTO Servico(nome, preco, enabled) "
                + "VALUES (?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, servico.getNomeServico());
            statement.setDouble(2, servico.getPrecoPorPeca());
            statement.setString(3, "true");
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
    
    public static void deletar(int id)
            throws SQLException, Exception {
        String sql = "UPDATE Servico SET Enabled = 'false'"
                + " WHERE ID = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

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

    public static void alterar(Servico servico, String idServico)
            throws SQLException, Exception {
        String sql = "UPDATE Servico "
                + "SET Nome = ?, "
                + "preco = ?"
                + "WHERE ID = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            int idtrue = Integer.parseInt(idServico);
            statement.setString(1, servico.getNomeServico());
            statement.setDouble(2, servico.getPrecoPorPeca());
            statement.setInt(3, idtrue);

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

    public static List<Servico> pesquisar(String palavra)
            throws SQLException, Exception {

        String sql = "SELECT * FROM servico "
                + " WHERE servico.enabled = 'true';";

        Connection connection = null;
        PreparedStatement statement = null;
        List<Servico> listaServicos = new ArrayList<>();
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + palavra + "%");

            System.out.println("Executando COMANDO SQL: " + sql);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                if (listaServicos == null) {
                    listaServicos = new ArrayList<Servico>();
                }
                Servico servico = new Servico();
                statement.setString(1, servico.getNomeServico());
                statement.setDouble(2, servico.getPrecoPorPeca());

                listaServicos.add(servico);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaServicos;
    }

    public static Servico obter(int id)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Servico WHERE ID = ?;";

        PreparedStatement statement = null;
        Connection connection = null;
        Servico servico = new Servico();
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println(statement.toString());
         ResultSet result = null;
         result = statement.executeQuery();
         
            while (result.next()) {
  
                servico.setNomeServico(result.getString("Nome"));
                servico.setId(result.getInt("ID"));
                servico.setPrecoPorPeca(result.getDouble("Preco"));
                
            }
 
        return servico;
    }

    public static List<Servico> executarConsulta(String sql) throws
        ServicoException, SQLException, Exception {
        List<Servico> listaServicos = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaServicos == null) {
                    listaServicos = new ArrayList<Servico>();
                }
                Servico servico = new Servico();
                servico.setNomeServico(result.getString("nome"));
                servico.setPrecoPorPeca(result.getDouble("preco"));
                servico.setEnabled(result.getString("enabled"));
                servico.setId(result.getInt("ID"));
                listaServicos.add(servico);
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
        return listaServicos;
    }

    //listar sem where
    public static List<Servico> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Servico WHERE enabled = 'true'";

        return executarConsulta(sql);
    }

    public static Servico retornarPreco(String nomeServico) throws
            SQLException, Exception {
        String sql = "SELECT * FROM servico "
                + " WHERE servico.nome = ?";
        Servico servico = new Servico();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, nomeServico);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            servico.setPrecoPorPeca(result.getDouble("precoPorPeca"));
            connection.close();
            return servico;
        }

        return null;
    }

}
