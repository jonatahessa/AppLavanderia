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
           
        String sql = "INSERT INTO Funcionario (admissao, cargo, ctps, unidade, login, senha, sexo, enabled) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setDate(12, funcionario.getAdmissao());
            statement.setString(1, funcionario.getNome());
            statement.setString(3, funcionario.getCtps());
            statement.setString(4, funcionario.getNascimento());
            statement.setString(5, funcionario.getSexo());
            statement.setString(6, funcionario.getTelefone());
            statement.setString(7, funcionario.getEmail());
            statement.setString(8, funcionario.getEndereco());
            statement.setString(9, funcionario.getCep());
            statement.setString(10, funcionario.getCidade());
            statement.setString(11, funcionario.getEstado());
            
            statement.setString(13, funcionario.getCargo());
            statement.setString(14, funcionario.getEmpresa());
            statement.setString(15, "true");
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

    public static void deletar(String cpf)
            throws SQLException, Exception {
        String sql = "UPDATE cliente SET enabled = ?"
                + " WHERE cpf = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, "false");
            statement.setString(2, cpf);

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

    public static void alterar(Funcionario funcionario, String cpf)
            throws SQLException, Exception {
        String sql = "UPDATE cliente "
                + "SET nome = ?, "
                + "telefone = ?, "
                + "email = ?, "
                + "WHERE cpf = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getEmail());
            statement.setString(10, cpf);
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

        String sql = "SELECT * FROM cliente "
                + " WHERE cliente.enabled = 'true';";

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
                statement.setString(2, funcionario.getCpf());
                statement.setString(3, funcionario.getTelefone());
                statement.setString(4, funcionario.getEmail());
                statement.setString(5, funcionario.getEnabled());
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
        String sql = "SELECT * FROM cliente WHERE cpf = ? AND "
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
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setEnabled(result.getString("enabled"));
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
        String sql = "SELECT * FROM cliente WHERE enabled = 'true'";

        return executarConsulta(sql);
    }

    public static Funcionario retornarCliente(String cpf) throws
            SQLException, Exception {
        String sql = "SELECT * FROM cliente "
                + " WHERE cliente.cpf = ?";
        Funcionario funcionario = new Funcionario();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cpf);

        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            funcionario.setCpf(result.getString("cpf"));
            funcionario.setNome(result.getString("nome"));
            funcionario.setTelefone(result.getString("telefone"));
            funcionario.setEmail(result.getString("email"));
            funcionario.setEnabled(result.getString("enabled"));
            connection.close();
            return funcionario;
        }

        return null;
    }

}


