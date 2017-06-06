package br.senac.tads3.Daos;

import br.senac.tads3.CRUDCliente.Cliente;
import br.senac.tads3.ConnectionBD.ConnectionUtils;
import br.senac.tads3.Exceptions.ClienteException;
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
public class DaoCliente {

    public static void inserir(Cliente cliente)
            throws SQLException, Exception {

        String sql = "INSERT INTO Cliente (NomeCliente, cpf, telefone, email, enabled, sexo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, "true");
            statement.setString(6, cliente.getSexo());
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

    //Deleta um cliente na tabela "cliente" do banco de dados
    public static void deletar(String cpf)
            throws SQLException, Exception {
        //Monta a string de remoção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Cliente SET enabled = ?"
                + "WHERE cpf = ?; ";

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
            statement.setString(2, "" + cpf);

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

    public static void alterar(Cliente cliente, String id)
            throws SQLException, Exception {
        String sql = "UPDATE Cliente SET NomeCliente = ?, cpf = ?,telefone = ?, email = ?, sexo = ? "
                + "WHERE ID = ?;";

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getSexo());
            int idtrue = Integer.parseInt(id);
            statement.setInt(6, idtrue);
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

    public static Cliente obter(String cpf)
            throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE CPF = ?;";

        PreparedStatement statement = null;
        Connection connection = null;
        Cliente cliente = new Cliente();
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {

            cliente.setCpf(result.getString("cpf"));
            cliente.setNome(result.getString("NomeCliente"));
            cliente.setTelefone(result.getString("telefone"));
            cliente.setEmail(result.getString("email"));
            cliente.setSexo(result.getString("sexo"));
            cliente.setEnabled(result.getString("enabled"));
            cliente.setId(result.getInt("ID"));
        }

        return cliente;
    }

    public static List<Cliente> executarConsulta(String sql) throws
            ClienteException, SQLException, Exception {
        List<Cliente> listaClientes = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setCpf(result.getString("cpf"));
                cliente.setNome(result.getString("NomeCliente"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEmail(result.getString("email"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setEnabled(result.getString("enabled"));
                listaClientes.add(cliente);
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
        return listaClientes;
    }

    public static List<Cliente> listar()
            throws SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE enabled = 'true'";

        return executarConsulta(sql);
    }

    public static Cliente retornarCliente(String cpf) throws
            SQLException, Exception {
        String sql = "SELECT * FROM cliente "
                + " WHERE cliente.cpf = ?";
        Cliente cliente = new Cliente();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cpf);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            cliente.setCpf(result.getString("cpf"));
            cliente.setNome(result.getString("NomeCliente"));
            cliente.setTelefone(result.getString("telefone"));
            cliente.setEmail(result.getString("email"));
            cliente.setEnabled(result.getString("enabled"));
            connection.close();
            return cliente;
        }

        return null;
    }
    
    public static Cliente retornarClienteId(int id) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Cliente "
                + " WHERE ID = ?";
        Cliente cliente = new Cliente();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            cliente.setCpf(result.getString("cpf"));
            cliente.setNome(result.getString("NomeCliente"));
            cliente.setTelefone(result.getString("telefone"));
            cliente.setEmail(result.getString("email"));
            cliente.setEnabled(result.getString("enabled"));
            connection.close();
            return cliente;
        }

        return null;
    }


    public static List<Cliente> pesquisarCliente(String nome) throws
        ClienteException, SQLException, Exception {
        String sql = "SELECT * FROM Cliente WHERE NomeCliente LIKE ? AND Enabled = 'true'";
        
        List<Cliente> listaClientes = null;
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
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setCpf(result.getString("cpf"));
                cliente.setNome(result.getString("NomeCliente"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEmail(result.getString("email"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setEnabled(result.getString("enabled"));
                listaClientes.add(cliente);
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
        return listaClientes;
    }
    
    public static boolean verificarDuplicada(String cpf) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Cliente "
                + " WHERE Cliente.cpf = ?";
        Cliente cliente = new Cliente();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cpf);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            cliente.setCpf(result.getString("cpf"));
            cliente.setNome(result.getString("NomeCliente"));
            cliente.setTelefone(result.getString("telefone"));
            cliente.setEmail(result.getString("email"));
            cliente.setEnabled(result.getString("enabled"));
            connection.close();
            return true;
        }

        return false;
    }
    
    public static boolean verificarDuplicadaAlterar(String cpf, int id) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Cliente "
                + " WHERE Cliente.cpf = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cpf);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();
        Cliente cliente = retornarClienteId(id);
        if(cliente.getCpf().equalsIgnoreCase(cpf)){
            return false;
        }
        while (result.next()) {
            return true;
        }
        return false;
    }
    
    public static boolean verificarCliente(String cpf) throws
            SQLException, Exception {
        String sql = "SELECT * FROM Cliente "
                + " WHERE Cliente.cpf = ? AND Enabled = 'true'";
        Connection connection = null;
        PreparedStatement statement = null;

        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);

        statement.setString(1, cpf);
        System.out.println(statement.toString());
        System.out.println("Executando CONSULTA SQL: " + sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            return true;
        }

        return false;
    }

}
