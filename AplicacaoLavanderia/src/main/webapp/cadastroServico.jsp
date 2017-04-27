<%-- 
    Document   : cadastrarServico
    Created on : 24/04/2017, 19:54:46
    Author     : eloisa.asilva2
--%>

<!doctype html>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<html>

    <head>
        <!-- Bootstrap -->
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme-min.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css">

        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarServico.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarServico.js"></script>
        <title>Cadastro de Serviço</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>

        
        <section id="principal">
        <form class="form-horizontal" action= "./CadastrarServico" method="post">
            <h1 class="form-signin-heading">Cadastro de Serviço</h1>  
            <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="camponome" type="text" name="nome" class="form-control" placeholder="Nome">
            </div>

            <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                    <input id="campopreco" type="text" name="preco" class="form-control" placeholder="preco">
            </div>
            <div id="buttons">
                <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
            </div>
        </form>
        </section>    
    <body>
</html>
