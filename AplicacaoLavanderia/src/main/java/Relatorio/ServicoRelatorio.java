/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorio;

import CRUDVenda.Venda;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vinicius.vsilva8
 */
public class ServicoRelatorio {

    public int verificarDeData(String deData) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        if (deData == null || deData.equalsIgnoreCase("")) {
            return 1;
        }
        try {
            Date dataValida = sdf.parse(deData);
            return 2;
        } catch (ParseException e) {
            return 0;
        }

    }

    public int verificarAteData(String ateData) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        if (ateData == null || ateData.equalsIgnoreCase("")) {
            return 1;
        }
        try {
            Date dataValida = sdf.parse(ateData);
            return 2;
        } catch (ParseException e) {
            return 0;
        }
    }

    public List<Relatorio> listarRelatorioSemDataAdmin() throws Exception {
        return Daos.DaoRelatorio.listarSemDataAdmin();
    }

    public List<Relatorio> listarRelatorioDeDataAdmin(String data) throws Exception {
        return Daos.DaoRelatorio.ListaComDeDataAdmin(data);
    }

    public List<Relatorio> listarRelatorioDeDataAteDataAdmin(String deData, String ateData) throws Exception {
        return Daos.DaoRelatorio.ListaComDeDataAteDataAdmin(deData, ateData);
    }

    public List<Relatorio> listarRelatorioAteDataAdmin(String ateData) throws Exception {
        return Daos.DaoRelatorio.ListaComAteDataAdmin(ateData);
    }
    
    public List<Relatorio> listarRelatorioSemDataVendedor(int idUnidade) throws Exception {
        return Daos.DaoRelatorio.ListaSemDataVendedor(idUnidade);
    }
    
    public List<Relatorio> listarRelatorioDeDataVendedor(String data, int idUnidade) throws Exception {
        return Daos.DaoRelatorio.ListaComDeDataVendedor(data, idUnidade);
    }
    
    public List<Relatorio> listarRelatorioAteDataVendedor(String data, int idUnidade) throws Exception {
        return Daos.DaoRelatorio.ListaComAteDataVendedor(data, idUnidade);
    }
    
    public List<Relatorio> listarRelatorioDeDataAteDataVendedor(String deData, String ateData, int idUnidade) throws Exception {
        return Daos.DaoRelatorio.ListaComDeDataAteDataVendedor(deData, ateData, idUnidade);
    }
}
