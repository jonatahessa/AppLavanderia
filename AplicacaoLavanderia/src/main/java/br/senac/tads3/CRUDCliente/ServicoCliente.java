package br.senac.tads3.CRUDCliente;


import java.util.List;

public class ServicoCliente {

    public boolean verificarCpf(String cpf) {
        if (cpf == null || cpf.equals("")) {
            return false;
        }
        if (cpf.length() != 14) {
            return false;
        }
        try {
            int teste = Integer.parseInt(cpf.substring(0,2));
            int teste2 = Integer.parseInt(cpf.substring(4,6));
            int teste3 = Integer.parseInt(cpf.substring(8,10));
            int teste4 = Integer.parseInt(cpf.substring(12,13));
            
        } catch (Exception e){
            return false;
        }
        
        return true;
    }

    public boolean verificarNome(String nome) {
        boolean erro = false;
        if (nome == null || nome.trim().equals("")) {
            return false;
        }
        for(int i = 0; i < nome.length(); i++) {
            try {
                int teste = Integer.parseInt(""+nome.charAt(i));
                erro = true;
            } catch (Exception e){
            }
            if (erro){
                return false;
            }
        }
        if (nome.length() > 100) {
            return false;
        }
        return true;
    }

    public boolean verificarSexo(String sexo) {
        if (sexo == null || sexo.equals("")) {
            return false;
        }
        return true;
    }

    public boolean verificarEmail(String email) {
        int contador = 0;
        if (email == null || email.trim().equals("")) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                contador++;
            }
            if (email.charAt(i) == ',') {
                return false;
            }
        }
        if (!email.contains(".com")) {
            return false;
        }
        if (contador != 1 || email.length() > 100) {
            return false;
        }
        return true;
    }

    public boolean verificarTelefone(String telefone) {

        if (telefone == null || telefone.equals("")) {
            return false;
        }
        if (telefone.length() != 12) {
            return false;
        }
        try {
            int teste = Integer.parseInt(telefone.substring(0,1));
            int teste2 = Integer.parseInt(telefone.substring(3,6));
            int teste3 = Integer.parseInt(telefone.substring(8,12));            
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void inserirCliente(Cliente cliente) throws Exception {
        br.senac.tads3.Daos.DaoCliente.inserir(cliente);
    }

    public void deletarCliente(String cpf) throws Exception {
        br.senac.tads3.Daos.DaoCliente.deletar(cpf);
    }

    public void alterarCliente(Cliente cliente, String id) throws Exception {
        br.senac.tads3.Daos.DaoCliente.alterar(cliente, id);
    }

    public Cliente obterCliente(String cpf) throws Exception {
        return br.senac.tads3.Daos.DaoCliente.obter(cpf);
    }
    
    public List<Cliente> pesquisarCliente(String nome) throws Exception {
        return br.senac.tads3.Daos.DaoCliente.pesquisarCliente(nome);
    }
    
    public List<Cliente> ListarClientes() throws Exception {
        return br.senac.tads3.Daos.DaoCliente.listar();
    }
    
    public boolean verificarDuplicada(String cpf) throws Exception {
        return br.senac.tads3.Daos.DaoCliente.verificarDuplicada(cpf);
    }
    
    public boolean verificarClienteInativo(String cpf) throws Exception {
        return br.senac.tads3.Daos.DaoCliente.verificarClienteInativo(cpf);
    }
    
    public boolean verificarDuplicadaAlterar(String cpf, int id) throws Exception {
        return br.senac.tads3.Daos.DaoCliente.verificarDuplicadaAlterar(cpf, id);
    }
}
