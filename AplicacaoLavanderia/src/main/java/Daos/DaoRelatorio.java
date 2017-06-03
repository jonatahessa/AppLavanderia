/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import ConnectionBD.ConnectionUtils;
import Exeptions.RelatorioException;
import Relatorio.Relatorio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius.vsilva8
 */
public class DaoRelatorio {

    public static List<Relatorio> listarSemDataAdmin()
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " ORDER BY Venda.Data DESC;";

        return executarConsulta(sql);
    }

    public static List<Relatorio> executarConsulta(String sql) throws
            RelatorioException, SQLException, Exception {
        List<Relatorio> listaRelatorio = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            statement = connection.createStatement();
            System.out.println("Executando CONSULTA SQL: " + sql);
            result = statement.executeQuery(sql);
            while (result.next()) {
                if (listaRelatorio == null) {
                    listaRelatorio = new ArrayList<Relatorio>();
                }
                Relatorio relatorio = new Relatorio();
                relatorio.setUnidade(result.getString("NomeUnidade"));
                relatorio.setFuncionario(result.getString("NomeFuncionario"));
                relatorio.setCliente(result.getString("NomeCliente"));
                relatorio.setData(result.getDate("Data"));
                relatorio.setTotal(result.getDouble("Total"));
                listaRelatorio.add(relatorio);
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
        return listaRelatorio;
    }

    public static List<Relatorio> ListaComDeDataAdmin(String data)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Venda.Data >= ? AND Venda.Data <= NOW() ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date convert = new Date(fmt.parse(data).getTime());
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setDate(1, convert);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }
    
    public static List<Relatorio> ListaComDeDataAteDataAdmin(String deData, String ateData)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Venda.Data >= ? AND Venda.Data <= ? ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date convertDeData = new Date(fmt.parse(deData).getTime());
        Date convertAteDate = new Date(fmt.parse(ateData).getTime());
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setDate(1, convertDeData);
        statement.setDate(2, convertAteDate);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }
    
    public static List<Relatorio> ListaComAteDataAdmin(String data)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Venda.Data <= ? ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date convert = new Date(fmt.parse(data).getTime());
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setDate(1, convert);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }
    
    public static List<Relatorio> ListaSemDataVendedor(int id)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Unidade.ID = ? ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }
    
    public static List<Relatorio> ListaComDeDataVendedor(String data, int idUnidade)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Venda.Data >= ? AND Venda.Data <= NOW()"
                + " AND Funcionario.ID_Unidade = ? ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date convert = new Date(fmt.parse(data).getTime());
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setDate(1, convert);
        statement.setInt(2, idUnidade);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }
    
    public static List<Relatorio> ListaComAteDataVendedor(String data, int idUnidade)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Venda.Data <= ? AND Funcionario.ID_Unidade = ?"
                + " ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date convert = new Date(fmt.parse(data).getTime());
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setDate(1, convert);
        statement.setInt(2, idUnidade);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }
    
    public static List<Relatorio> ListaComDeDataAteDataVendedor(String deData, String ateData, int idUnidade)
            throws SQLException, Exception {
        String sql = "SELECT Unidade.NomeUnidade, Funcionario.NomeFuncionario,"
                + " Cliente.NomeCliente, Venda.Data, Venda.Total FROM Unidade"
                + " INNER JOIN Funcionario ON Unidade.ID = Funcionario.ID_Unidade"
                + " INNER JOIN Venda ON Funcionario.ID = Venda.ID_Funcionario"
                + " INNER JOIN Cliente ON Cliente.ID = Venda.ID_Cliente"
                + " WHERE Venda.Data >= ? AND Venda.Data <= ?"
                + "AND Funcionario.ID_Unidade = ? ORDER BY Venda.Data DESC;";

        List<Relatorio> listaRelatorio = null;
        PreparedStatement statement = null;
        Connection connection = null;
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date convertDeData = new Date(fmt.parse(deData).getTime());
        Date convertAteDate = new Date(fmt.parse(ateData).getTime());
        connection = ConnectionUtils.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setDate(1, convertDeData);
        statement.setDate(2, convertAteDate);
        statement.setInt(3, idUnidade);
        System.out.println(statement.toString());
        ResultSet result = null;
        result = statement.executeQuery();

        while (result.next()) {
            if (listaRelatorio == null) {
                listaRelatorio = new ArrayList<Relatorio>();
            }
            Relatorio relatorio = new Relatorio();
            relatorio.setUnidade(result.getString("NomeUnidade"));
            relatorio.setFuncionario(result.getString("NomeFuncionario"));
            relatorio.setCliente(result.getString("NomeCliente"));
            relatorio.setData(result.getDate("Data"));
            relatorio.setTotal(result.getDouble("Total"));
            listaRelatorio.add(relatorio);
        }

        return listaRelatorio;
    }

}
