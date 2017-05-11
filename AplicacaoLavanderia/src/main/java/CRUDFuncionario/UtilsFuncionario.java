package CRUDFuncionario;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilsFuncionario {

    public Date converterData(String recebe) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.sql.Date data = new java.sql.Date(format.parse(recebe).getTime());
            return data;
        } catch (ParseException ex) {
            Logger.getLogger(UtilsFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}