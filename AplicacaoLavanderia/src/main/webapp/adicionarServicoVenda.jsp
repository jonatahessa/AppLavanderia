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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaCliente.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaCliente.js"></script>
        <title>Adicionar Serviço</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="./AdicionarServico" method="post">
                <fieldset>
                    <h1>Adicionar Serviço</h1>
                    <input type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                    <button class="btn btn-info" type="submit">Pesquisar</button>
                </fieldset>
            </form>   
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>ID</th>
                    <th>Nome do serviço</th>
                    <th>Preço por peça</th>
                    <th>Adicionar Serviço</th>
                </tr>

                <c:forEach var="servicos" items="${resultado}">
                    <tr>
                        <td>${servicos.id}</td>
                        <td>${servicos.nomeServico}</td>
                        <td>${servicos.precoServico}</td>
                        <td><a href="./Lavar?id=${servicos.id}" >Adicionar</a></td>
                        </form></td>
                    </tr>
                </c:forEach>
            </table>        
        </div>
    </body>
</html>