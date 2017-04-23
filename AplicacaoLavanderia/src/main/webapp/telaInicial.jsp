<%-- 
    Document   : telaInicial
    Created on : 23/04/2017, 14:33:39
    Author     : Thalles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme-min.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css">

        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/telaInicial.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/telaInicial.js">
        </script>
        
        <title>Home</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id = "menu">
            <button id="GerenciarFuncionario" type="submit">Gerenciar Funcionario</button>
            <button id="GerenciarCliente" type="submit">Gerenciar Cliente</button>
            <button id="GerenciarServicos" type="submit">Gerenciar Serviços</button>
            <button id="relatorioVendas" type="submit">Relatório de Vendas</button>
            <button id="vendas" type="submit">Vender</button>
        </div>
        
    </body>
</html>
