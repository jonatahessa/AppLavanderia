
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarFilial.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarFilial.js"></script>
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Cadastro de Filial</h1>  

            <form class="form-horizontal" action= "./CadastrarFilial" method="post">

                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="campoendereco" type="text" name="endereco" class="form-control" placeholder="endereço">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="camponumero" type="text" name="numero" class="form-control" placeholder="numero">
                </div>
                
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="campocep" type="text" name="cep" class="form-control" placeholder="cep">
                </div>
                
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="campocidade" type="text" name="cidade" class="form-control" placeholder="cidade">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="campoestado" type="text" name="estado" class="form-control" placeholder="estado">
                </div>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>

            </form>
        </div>
    </body>
</html>