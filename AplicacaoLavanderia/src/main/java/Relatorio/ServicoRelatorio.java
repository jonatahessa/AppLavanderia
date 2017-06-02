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
    
    public List<Relatorio> ListarRelatorioSemDataAdmin() throws Exception {
        return Daos.DaoRelatorio.listarSemDataAdmin();
    }
    
    public List<Relatorio> ListarRelatorioDeDataAdmin(String data) throws Exception {
        return Daos.DaoRelatorio.ListaComDeDataAdmin(data);
    }
    
}
