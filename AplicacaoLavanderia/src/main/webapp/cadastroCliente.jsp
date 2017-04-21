<%-- 
    Document   : cadastroCliente
    Created on : 17/04/2017, 19:39:50
    Author     : jonata.hmoliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarCliente.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarCliente.js">
        </script>
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id = "menu"></div>
        <h1>Cadastro de Cliente</h1>
        <div id="principal">
            <form action= "./CadastrarCliente" method="post">

                <input id="camponome" class="campos" type="text" name="nome" placeholder="Nome" />

                <input id="campocpf" class="campos" type="text" name="cpf" placeholder="CPF" />

                <input id="campoemail" class="campos" type="text" name="email" placeholder="E-mail" />

                <input id="campotelefone" class="campos" type="text" name="telefone" placeholder="Telefone" />
                
                <select id="camposexo" name="sexo">
                    <option name="Feminino">Feminino</option>
                    <option name="Masculino">Masculino</option>
                </select>

                <div id="buttons">
                    <button id="salvar" type="submit">Salvar</button>
                    <button id="cancelar" type="button">Cancelar</button>
                </div>

            </form>
        </div>
    </body>
</html>
