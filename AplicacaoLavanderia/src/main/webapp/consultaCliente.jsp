<%-- 
    Document   : 
    Created on : 17/04/2017, 19:39:50
    Author     : jonata.hmoliveira
--%>

<%@page import="CRUDCliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Daos.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/consultaCliente.js"></script>
        <title>Consulta Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id = "menu"></div>
        <h1>Consulta de Cliente</h1>
        <div id="table">
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Sexo</th>
                    <th>Alterar Cliente</th>
                    <th>Remover Cliente</th>
                </tr>
                
                <c:forEach var="clientes" items="${dao.listar()}">
                <tr>
                    <th>${clientes.nome}</th>
                    <th>${clientes.cpf}</th>
                    <th>${clientes.email}</th>
                    <th>${clientes.telefone}</th>
                    <th>${clientes.sexo}</th>
                    <th><a class="btn btn-primary" href="">Alterar</a></th>
                    <th><a class="btn btn-danger" href="">Remover</a></th>
                </tr>
        </div>
    </body>
</html>
