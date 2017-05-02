<%-- 
    Document   : 
    Created on : 17/04/2017, 19:39:50
    Author     : jonata.hmoliveira
--%>

<%@page import="CRUDCliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoCliente"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
        <form action="consultaCliente.jsp" method="GET">
            <fieldset>
                <legend>Pesquisar</legend>
                <input type="text" name="palavra" value="${param.palavra}"/>
                <input type="submit" value="Pesquisar"/>
            </fieldset>
        </form>
        
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
                    <td>${clientes.nome}</td>
                    <td>${clientes.cpf}</td>
                    <td>${clientes.email}</td>
                    <td>${clientes.telefone}</td>
                    <td>${clientes.sexo}</td>
                    <td><a class="btn btn-primary" href="">Alterar</a></td>
                    <td><a class="btn btn-danger" href="">Remover</a></td>
                </tr>
                </c:forEach>
            </table>
        
        </div>
    </body>
</html>
