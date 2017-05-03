package Daos;

import CRUDFuncionario.Funcionario;
import ConnectionBD.ConnectionUtils;
import Exeptions.FuncionarioException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoFuncionario {
    
    public static void inserir(Funcionario funcionario)
            throws SQLException, Exception {
           
        String sql = "INSERT INTO Funcionario (Nome, Login, Senha, Cargo, ID_Unidade, Sexo, Admissao, Enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);
            
            
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getLogin());
            statement.setString(3, funcionario.getSenha());           
            statement.setString(4, funcionario.getCargo());
            statement.setInt(5, funcionario.getID_Unidade());
            statement.setString(6, funcionario.getSexo());
            statement.setDate(7, funcionario.getAdmissao());
            statement.setString(8, "true");
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
        String sql = "UPDATE Funcionario SET enabled = ?"
                + " WHERE id = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, "false");
            statement.setInt(2, id);

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

    public static void alterar(Funcionario funcionario, int id)
            throws SQLException, Exception {
        String sql = "UPDATE Funcionario "
                + "SET nome = ?, "
                + "login = ?, "
                + "senha = ?, "
                + "cargo = ?, "
                + "admissao = ?, "
                + "id_unidade = ?, "
                + "sexo = ?, "
                + "WHERE id = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getLogin());
            statement.setString(3, funcionario.getSenha());
            statement.setString(4, funcionario.getCargo());
            statement.setDate(5, funcionario.getAdmissao());
            statement.setString(6, funcionario.getUnidade());
            statement.setString(7, funcionario.getSexo());
            statement.setInt(8, id);
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

    public static List<Funcionario> pesquisar(String palavra)
            throws SQLException, Exception {

        String sql = "SELECT * FROM Funcionario "
                + " WHERE funcionario.enabled = 'true';";

        Connection connection = null;
        PreparedStatement statement = null;
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + palavra + "%");

            System.out.println("Executando COMANDO SQL: " + sql);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<Funcionario>();
                }
                Funcionario funcionario = new Funcionario();
                statement.setString(1, funcionario.getNome());
                statement.setString(2, funcionario.getLogin());
                statement.setString(3, funcionario.getSenha());
                statement.setString(4, funcionario.getCargo());
                statement.setDate(5, funcionario.getAdmissao());
                statement.setString(6, funcionario.getUnidade());
                statement.setString(4, funcionario.getSexo());
                System.out.println(statement.toString());

                listaFuncionarios.add(funcionario);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaFuncionarios;
    }

    public static Funcionario obter(String cpf)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Funcionario WHERE id = ? AND "
                + "enabled = 'true';";
        PreparedStatement statement = null;
        Connection connection = null;

        statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        List<Funcionario> listaFuncionarios = (List<Funcionario>) executarConsulta(sql);

        if (listaFuncionarios != null && listaFuncionarios.size() > 0) {
            return listaFuncionarios.get(0);
        }

        return null;
    }

    public static List<Funcionario> executarConsulta(String sql) throws
            FuncionarioException, SQLException, Exception {
        List<Funcionario> listaFuncionarios = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<Funcionario>();
                }
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("ID"));
                funcionario.setNome(result.getString("Nome"));
                funcionario.setLogin(result.getString("Login"));
                funcionario.setSenha(result.getString("Senha"));
                funcionario.setCargo(result.getString("Cargo"));
                funcionario.setAdmissao(result.getDate("Admissao"));
                funcionario.setUnidade(result.getString("Unidade"));
                funcionario.setSexo(result.getString("Sexo"));
                funcionario.setEnabled(result.getString("Enabled"));
                listaFuncionarios.add(funcionario);
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
        return listaFuncionarios;
    }
    
    
    //listar sem where
        public static List<Funcionario> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Funcionario WHERE Enabled = 'true'";

        return executarConsulta(sql);
    }

    public static Funcionario retornarFuncionario(int id) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Funcionario "
                + " WHERE Funcionario.ID = ?";
        Funcionario funcionario = new Funcionario();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setInt(1, id);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            funcionario.setId(result.getInt("ID"));
            funcionario.setNome(result.getString("Nome"));
            funcionario.setLogin(result.getString("Login"));
            funcionario.setSenha(result.getString("Senha"));
            funcionario.setCargo(result.getString("Cargo"));
            funcionario.setAdmissao(result.getDate("Admissao"));
            funcionario.setUnidade("Unidade");
            funcionario.setSexo(result.getString("Sexo"));
            funcionario.setEnabled(result.getString("enabled"));
            connection.close();
            return funcionario;
        }

        return null;
    }

}


