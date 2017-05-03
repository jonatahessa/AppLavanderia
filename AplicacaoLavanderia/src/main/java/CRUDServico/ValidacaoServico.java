package CRUDServico;

public class ValidacaoServico {
    
    public boolean verificarNome(String nome) {
        if (nome == null || nome.equals("")){
            return false;
        }
        return true;
    }
    
    public boolean verificarPreco (String preco) {
        if (preco == null || preco.equals("")){
            return false;
        }
        try {
            double teste = Double.parseDouble(preco);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
