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
            <form method="POST" action="Redirecionar">
                <button class="btn btn-success" name="tela" value="/WEB-INF/adicionarServicoVenda.jsp" type="submit">Adicionar Serviço</button>
                <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                <button id="cancelar" type="button" class="btn btn-info">Finalizar</button>
            </form>
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Quantidade</th>
                    <th>Remover</th>
                </tr>
                
                    <c:forEach var="servicos" items="${resultado}">
                    <tr>
                        <td>${servicos.idServico}<input type="hidden" name="id" value="${servicos.idServico}"/></td>
                        <td>${servicos.quantidade}<input type="hidden" name="id" value="${servicos.quantidade}"/></td>
                        
                        <td><button type="submit" class="btn btn-danger">Remover</button></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
