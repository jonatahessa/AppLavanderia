<%-- 
    Document   : cadastroFuncionario
    Created on : 18/04/2017, 20:52:19
    Author     : livia.cgsantos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="estilo.css">
        <script type="text/javascript" src="cliente.js">
        </script>
        <title>Cadastro Funcionario</title>
    </head>
    <body>
        <h1>Cadastro de Funcionario</h1>
        <section id="principal">
            <form method="post">
                <input id="camponome" class="campos" type="text" name="nome" placeholder="Nome" />
                <input id="campocpf" class="campos" type="text" name="cpf" placeholder="CPF" />
                 <input type="date" id="campoidade"  name="data_Nascimento" placeholder="Data de Nascimento"/>
                
                 <select id="camposexo" name="sexo">
                    <option value="sexo">Feminino</option>
                    <option value="sexo">Masculino</option>
                </select>
                
                 <input id="campoendereco" class="campos" type="text" name="endereco" placeholder="Endereço" />
                <input id="campocep" class="campos" type="text" name="cep" placeholder="CEP" />
                <input id="campocidade" class="campos" type="text" name="cidade" placeholder="Cidade" />
                <input id="campoestado" class="campos" type="text" name="estado" placeholder="Estado" />
                
                <input id="campoemail" class="campos" type="text" name="email" placeholder="E-mail" />
                <input id="campotelefone" class="campos" type="text" name="telefone" placeholder="Telefone" />
                <input id="campoctps" class="campos" type="text" name="ctps" placeholder="CTPS" />
                <input type="date" id="campoadmissao"  name="data_Admissao" placeholder="Data de Nascimento"/>
                
                <select id="campocargo" name="cargo">
                    <option value="">Gerente T.I</option>
                    <option value="funcionario">Funcionario T.I</option>
                    <option value="funcionario">Gerente Vendas</option>
                    <option value="funcionario">Funcionario Vendas</option>
                    <option value="funcionario">Gerente Retaguarda</option>
                    <option value="funcionario">Retaguarda</option>
                </select> 
                
                <select id="campofiliais" name="filiais">
                    <option value="filiais">Filial1</option>
                    <option value="filiais">Filial2</option>
                </select>
                <div id="buttons">
                    <button id="salvar" type="button">Salvar</button>
                    <button id="cancelar" type="button">Cancelar</button>
                </div>

            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>
