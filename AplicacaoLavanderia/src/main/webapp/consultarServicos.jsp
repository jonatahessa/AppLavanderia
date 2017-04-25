<%-- 
    Document   : servicos
    Created on : 24/04/2017, 21:50:50
    Author     : eloisa.asilva2
--%>

<%@page import="CRUDServico.Servico"%>
<%@page import="java.util.List"%>
<%@page import="Daos.DaoServico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DaoServico dao = new DaoServico();

    List<Servico> lista;

    lista = dao.listar();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme-min.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap.css">
        <link rel="StyleSheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css">
        
        <link rel="StyleSheet" type="text/css" href="" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/consultaServico.js"></script>
        <title>Consulta Serviço</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id = "menu"></div>
        <h1>Consulta de Serviço</h1>
        <div id="table">
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome do Serviço</th>
                    <th>Preço por peça</th>
                </tr>
                <!-- inicia for -->
                <%
                    for (Servico registro : lista) {

                %>
                <tr>
                    <th><%=registro.getNomeServico()%></th>
                    <th><%=registro.getPrecoPorPeca()%></th>
                    <th><a class="btn btn-primary" href="">Alterar</a></th>
                    <th><a class="btn btn-danger" href="mensagemExclusao.jsp?cpf=<%=registro.getNomeServico()%>">Remover</a></th>
                </tr>
                <!-- encerra for -->
                <%
                    }
                %>
        </div>
    </body>
</html>
