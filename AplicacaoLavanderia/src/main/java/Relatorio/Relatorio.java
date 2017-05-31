package Relatorio;

import CRUDVenda.ItemVenda;
import java.sql.Date;
import java.util.List;

public class Relatorio {
    
    private String cliente;
    private String funcionario;
    private String unidade;
    private List<ItemVenda> carrinho;
    private double total;
    private Date data;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    public List<ItemVenda> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<ItemVenda> carrinho) {
        this.carrinho = carrinho;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
