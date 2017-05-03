<%-- 
    Document   : servicos
    Created on : 24/04/2017, 21:50:50
    Author     : eloisa.asilva2
--%>

<jsp:useBean id="dao" class="Daos.DaoServico"/>
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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaServico.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaServico.js"></script>
        <title>Consulta Serviço</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="consultaServico.jsp" method="GET">
                <fieldset>
                    <h1>Pesquisar Serviço</h1>
                    <input type="text" name="palavra" value="${param.palavra}"/>
                    <input type="submit" value="Pesquisar"/>
                </fieldset>
            </form>
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome do serviço</th>
                    <th>Preço por peça</th>
                    <th>Alterar Cliente</th>
                    <th>Remover Cliente</th>
                </tr>

                <c:forEach var="servicos" items="${dao.listar()}">
                    <tr>
                        <td>${servicos.nomeServico}</td>
                        <td>${servicos.precoPorPeca}</td>
                        <td><a class="btn btn-primary" href="">Alterar</a></td>
                        <td><a class="btn btn-danger" href="">Remover</a></td>
                    </tr>
                </c:forEach>
            </table>        
        </div>
    </body>
</html>