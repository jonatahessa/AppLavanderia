<%-- 
    Document   : consultarFuncionarios
    Created on : 02/05/2017, 20:32:56
    Author     : livia.cgsantos
--%>

<%@page import="CRUDFuncionario.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoFuncionario"/>
<jsp:useBean id="dao1" class="Daos.DaoUnidade"/>
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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaFuncionario.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaFuncionario.js"></script>
        <title>Consulta Funcionario</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        
        <div id="table">
        <form action="consultaFuncionario.jsp" method="GET">
            <fieldset>
                <h1>Pesquisar Funcionario</h1>
                <input type="text" name="palavra" value="${param.palavra}"/>
                <input type="submit" value="Pesquisar"/>
            </fieldset>
        </form>
        
        
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>Cargo</th>
                    <th>Unidade</th>
                    <th>Alterar Cliente</th>
                    <th>Remover Cliente</th>
                </tr>
                
                <c:forEach var="funcionarios" items="${dao.listar()}">
                    <tr>
                    <td>${funcionarios.nome}</td>
                    <td>${funcionarios.sexo}</td>
                    <td>${funcionarios.cargo}</td>
                    <td>${funcionarios.idUnidade}</td>
                    <td><a class="btn btn-primary" href="">Alterar</a></td>
                    <td><a class="btn btn-danger" href="">Remover</a></td>
                </tr>
                </c:forEach>
            </table>
        
        </div>
    </body>
</html>
