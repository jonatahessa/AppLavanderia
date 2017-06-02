package Relatorio;

import CRUDVenda.ItemVenda;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Relatorio {

    private String cliente;
    private String funcionario;
    private String unidade;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

}
