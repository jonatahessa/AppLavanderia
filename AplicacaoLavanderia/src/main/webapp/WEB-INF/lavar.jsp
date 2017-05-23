<%@page import="CRUDServico.Servico"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Lavar</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./PesquisarServico" method="post">
                <fieldset>
                    <h1>Lavar</h1>
                </fieldset>
            </form>
            <form method="POST" action="Redirecionar"><button class="btn btn-success" name="tela" value="/WEB-INF/adicionarServicoVenda.jsp" type="submit">Adicionar Serviço</button></form>
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Remover</th>
                </tr>
                <c:forEach var="servicos" items="${resultado}">
                    <tr onclick="main();">
                        <td>${servicos.id}</td>
                        <td>${servicos.nome}</td>
                        <td>${servicos.preco}</td>
                        <td>${servicos.quantidade}</td>
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
