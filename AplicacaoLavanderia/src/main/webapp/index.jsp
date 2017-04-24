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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/index.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/index.js">
        </script>
        
        <title>Home</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id = "menu">
            <form method="get" action="funcionarios.jsp"><button type="submit">Funcionários</button></form>
            <form method="get" action="clientes.jsp"><button type="submit">Clientes</button></form>
            <form method="get" action="servicos.jsp"><button type="submit">Serviços</button></form>
            <form method="get" action="relatorios.jsp"><button type="submit">Relatórios</button></form>
            <form method="get" action="vender.jsp"><button type="submit">Vender</button></form>
        </div>
        
    </body>
</html>
