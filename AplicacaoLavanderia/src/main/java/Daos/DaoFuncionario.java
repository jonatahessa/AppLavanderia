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
            statement.setInt(5, funcionario.getIdUnidade());
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

    //Deleta um funcionario na tabela "funcionario" do banco de dados
      public static void deletar(int id)
            throws SQLException, Exception {
        //Monta a string de remoção de um funcionario no BD,
        //utilizando os dados do funcionario passados como parâmetro
        String sql = "UPDATE Funcionario SET Enabled = ?"
                + "WHERE ID = ?; ";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql);
            statement.setString(1, "false");
            statement.setInt(2, id);
            

            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            //Executa o comando no banco de dados
            statement.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
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
            statement.setInt(6, funcionario.getIdUnidade());
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

        String sql = "SELECT Funcionario.*, Unidade.NomeUnidade FROM Funcionario"
                + " INNER JOIN Unidade on Unidade.ID WHERE funcionario.enabled = 'true';";

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
                statement.setInt(6, funcionario.getIdUnidade());
                statement.setString(7, funcionario.getSexo());
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

    public static Funcionario obter(int id)
            throws SQLException, Exception {
        String sql = "SELECT Funcionario.*, Unidade.NomeUnidade FROM Cliente"
                + " INNER JOIN Unidade ON Unidade.Id WHERE Funcionario.ID = ?;";

        PreparedStatement statement = null;
        Connection connection = null;
        Funcionario funcionario = new Funcionario();
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println(statement.toString());
         ResultSet result = null;
         result = statement.executeQuery();
         
            while (result.next()) {
  
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setLogin(result.getString("login"));
                funcionario.setNomeUnidade(result.getString("NomeUnidade"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setAdmissao(result.getDate("admissao"));
                funcionario.setSexo(result.getString("sexo"));
                funcionario.setEnabled(result.getString("enabled"));
            }
 
        return funcionario;
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
                funcionario.setNomeUnidade(result.getString("NomeUnidade"));
                funcionario.setIdUnidade(result.getInt("ID_Unidade"));
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
        String sql = "SELECT Funcionario.*, Unidade.NomeUnidade FROM Funcionario "
                + " INNER JOIN Unidade ON Unidade.ID WHERE Funcionario.enabled = 'true' GROUP BY Funcionario.ID;";

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
            funcionario.setIdUnidade(result.getInt("ID_Unidade"));
            funcionario.setSexo(result.getString("Sexo"));
            funcionario.setEnabled(result.getString("enabled"));
            connection.close();
            return funcionario;
        }

        return null;
    }

}


