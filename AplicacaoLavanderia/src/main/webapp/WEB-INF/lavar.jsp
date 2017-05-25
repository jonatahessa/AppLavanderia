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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

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
            <form method="POST" action="Redirecionar">
                <button class="btn btn-success" name="tela" value="/WEB-INF/adicionarServicoVenda.jsp" type="submit">Adicionar Serviço</button>
            </form>
            <form>
                <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
            </form>
            <form method="post" action="FinalizarVenda">
                <button id="cancelar" type="submit" class="btn btn-info">Finalizar</button>
            </form>
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th>Remover</th>
                </tr>

                <c:forEach var="itens" items="${resultado}">
                    <tr>
                        <td>${itens.id}<input type="hidden" name="id" value="${itens.id}"/></td>
                        <td>${itens.nomeServico}<input type="hidden" name="nome" value="${itens.nomeServico}"/></td>
                        <td>${itens.quantidade}<input type="hidden" name="qtde" value="${itens.quantidade}"/></td>
                        <td>${itens.precoServico}<input type="hidden" name="preco" value="${itens.precoServico}"/></td>
                        <td><form action="DeletarItemVenda" method="post" id="frm${itens.id}">
                                <input type="hidden" name="id" value="${itens.id}">
                                <a href="#" onclick="document.getElementById('frm${itens.id}').submit()">Remover</a>
                            </form></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
