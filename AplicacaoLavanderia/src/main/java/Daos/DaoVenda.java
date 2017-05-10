package br.com.Daos;

import br.com.Classes.Venda;
import br.com.ConexaoBanco.ConnectionUtils;
import br.com.Servicos.ServicoVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DaoVenda {
    
    
    
    //Insere uma venda na tabela "venda" do banco de dados
    public static void inserir(Venda venda)
            throws SQLException, Exception {
        //Monta a string de inserção de uma Venda no BD,
        //utilizando os dados da venda passados como parâmetro
        String sql = "INSERT INTO venda (VendaCliente, VendaCPF, "
                + "VendaValorTotal, VendaData, ItemVendaID) VALUES (?, ?, ?, ?, ?);";

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

            Date data = venda.getDataVenda();
            java.sql.Date dataSql = new java.sql.Date(data.getTime());
            statement.setString(1, venda.getClienteNome());
            statement.setString(2, venda.getCpf());
            statement.setString(3, ""+venda.getValorTotal());
            statement.setDate(4, dataSql);
            statement.setInt(5, venda.getIdItemVenda());
            
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
    
    //Insere um produto na tabela "ItensVenda" do banco de dados
    public static void inserirItensVenda(int itemVendaID,int idProduto, int qnt, String produtoTitulo)
            throws SQLException, Exception {
        //Monta a string de inserção de um ItenVenda no BD,
        //utilizando os dados do produto passados como parâmetro
        String sql = "INSERT INTO ItensVenda (ItemVendaID, produtoId, ProdutoQuantidade, ProdutoTitulo) "
                +  "VALUES (?, ?, ?, ?);";

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

            statement.setInt(1, itemVendaID);
            statement.setInt(2, idProduto);
            statement.setInt(3, qnt);
            statement.setString(4, produtoTitulo );
            
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
    
    //Retorna o maior VendaID da tabela de ItensVenda
    public static int retornarMaiorID()
            throws SQLException, Exception {
        //Monta a string de inserção de um ItenVenda no BD,
        String sql = "SELECT MAX(ItemVendaID) FROM ItensVenda";
        int maiorID = 0;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        Statement statement = null;
   
            //Abre uma conexão com o banco de dados
            connection = ConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.createStatement();
            
            //Exibe no console o que será executado no banco de dados
            System.out.println("Executando COMANDO SQL: " + sql);
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                maiorID = (result.getInt("MAX(ItemVendaID)"));
                connection.close();
                statement.close();
                return maiorID;
            }
            return 1;
    }
}