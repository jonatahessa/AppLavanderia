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
        <script type="text/javascript" src="./resources/JavaScript/cadastroServico.js"></script>
        <title>Cadastro de Serviço</title>
    </head>

    <body>
        <div id ="logo"></div>
        <div id = "menu">
            <form method="get" action="funcionarios.jsp"><button class="botaomenu" type="submit">Funcionários</button></form>
            <form method="get" action="clientes.jsp"><button class="botaomenu" type="submit">Clientes</button></form>
            <form method="get" action="servicos.jsp"><button class="botaomenu" type="submit">Serviços</button></form>
            <form method="get" action="relatorios.jsp"><button class="botaomenu" type="submit">Relatórios</button></form>
            <form method="get" action="vender.jsp"><button class="botaomenu" type="submit">Vender</button></form>
        </div>


        <h1 class="form-signin-heading">Cadastro de Serviço</h1>  

        <form class="form-horizontal" action= "./CadastrarServico" method="post">

            <div class="input-group">
                <span class="campos input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                <input id="campoNomeServico" type="text" name="nomeServico" class="campos form-control" placeholder="Nome do Serviço">
            </div>

            <div class="input-group">
                <span class="campos input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                <input id="campoPrecoPeca" type="text" name="precoPeca" class="campos form-control" placeholder="Preço por peça">
            </div>
            <button type="submit">Cancelar</button>
            <button type="submit">Cadastrar</button>
        </form>
    <body>
</html>
