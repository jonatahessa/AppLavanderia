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
    
    public boolean verificarDeData(String DeData) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        if (DeData.length() > 10) {
            return false;
        }
        
        try {
            Date dataValida = sdf.parse(DeData);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }
    
    public boolean verificarAteData(String AteData) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        if (AteData.length() > 10) {
            return false;
        }
        
        try {
            Date dataValida = sdf.parse(AteData);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }
    
    public List<Venda> ListarVenda() throws Exception {
        return Daos.DaoRelatorio.listar();
    }
    
}
