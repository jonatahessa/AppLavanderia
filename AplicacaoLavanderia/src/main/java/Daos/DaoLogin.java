
package Daos;

import ConnectionBD.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoLogin {
    public static boolean verificarUsuario (String login, String senha) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Funcionario"
                + " WHERE Login = ?"
                + " AND Senha = ?"
                + " AND Enabled = 'true';";
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        
        statement.setString(1, login);
        statement.setString(2, senha);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return true;
        }

        return false;
    }
    
    public static String permissao (String login, String senha) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Funcionario"
                + " WHERE Login = ?"
                + " AND Senha = ?"
                + " AND Enabled = 'true';";
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, login);
        statement.setString(2, senha);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return result.getString("cargo");
        }

        return null;
    }
    
    public static String nome (String login, String senha) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Funcionario"
                + " WHERE Login = ?"
                + " AND Senha = ?"
                + " AND Enabled = 'true';";
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, login);
        statement.setString(2, senha);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return result.getString("NomeFuncionario");
        }

        return null;
    }
}
