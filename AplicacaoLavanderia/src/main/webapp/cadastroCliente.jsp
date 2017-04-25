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
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarCliente.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarCliente.js"></script>
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Cadastro de Cliente</h1>  

            <form class="form-horizontal" action= "./CadastrarCliente" method="post">

                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="camponome" type="text" name="nome" class="form-control" placeholder="Nome">
                </div>

                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-user"></span></span>
                    <input id="campocpf" type="text" name="cpf" class="form-control" placeholder="CPF">
                </div>

                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-envelope"></span></span>
                    <input id="campoemail" type="text" name="email" class="form-control" placeholder="E-mail">
                </div>

                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-earphone"></span></span>
                    <input id="campotelefone" type="text" name="telefone" class="form-control" placeholder="Telefone">
                </div>

                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-star"></span></span>
                    <select id="camposexo" class="selectpicker form-control" data-live-search="true" name="sexo" title="Sexo">
                        <option name="Feminino">Feminino</option>
                        <option name="Masculino">Masculino</option>
                    </select>
                </div>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>

            </form>
        </div>
    </body>
</html>
