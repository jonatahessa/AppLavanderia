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
        <title>Consulta Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="./PesquisarServico" method="post">
                <fieldset>
                    <h1>Pesquisar Serviço</h1>
                    <input type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                    <button class="btn btn-info" type="submit">Pesquisar</button>
                </fieldset>
            </form>
            <form method="POST" action="cadastroServico.jsp"><button class="btn btn-success" type="submit">Cadastrar</button></form>        
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome do serviço</th>
                    <th>Preço por peça</th>
                    <th>Alterar Cliente</th>
                    <th>Remover Cliente</th>
                </tr>

                <c:forEach var="servicos" items="${resultado}">
                    <tr>
                        <td>${servicos.nomeServico}</td>
                        <td>${servicos.precoPorPeca}</td>
                        <td><a href="./AlterarServico?id=${servicos.id}" >Alterar</a></td>
                        <td><form action="DeletarServico" method="post" id="frm${servicos.id}">
                            <input type="hidden" name="id" value="${servicos.id}">
                            <a href="#" onclick="document.getElementById('frm${servicos.id}').submit()">Remover</a>
                        </form></td>
                    </tr>
                </c:forEach>
            </table>        
        </div>
    </body>
</html>