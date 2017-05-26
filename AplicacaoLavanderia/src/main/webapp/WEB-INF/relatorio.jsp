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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaCliente.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaCliente.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Consulta Cliente</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./relatorio" method="post">
                <fieldset>
                    <h1>Relatório</h1>
                    <article>
                        <section class="color-pattern-1">
                            <div class="campoTotal">
                                <div class="filho">
                                    <input type="text" name="palavra" value="${palavra}" placeholder="De"/>
                                    <input type="text" name="palavra" value="${palavra}" placeholder="Até"/>
                                </div>
                            </div>
                            <button class="btn btn-info button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                        </section>
                    </article> 
                </fieldset>
            </form>
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>ID - Venda</th>
                    <th>ID - Funcionário</th>
                    <th>CPF - Cliente</th>
                    <th>Serviço</th>
                    <th>Quantidade</th>
                    <th>Total</th>
                    <th>Data</th>
                </tr>
                <c:forEach var="vendas" items="${resultado}">
                    <tr onclick="main();">
                        <td>${vendas.idvenda}</td>
                        <td>${vendas.idfuncionario}</td>
                        <td>${vendas.cpfcliente}</td>
                        <td>${vendas.servico}</td>
                        <td>${vendas.quantidade}</td>
                        <td>${vendas.total}</td>
                        <td>${vendas.data}</td>
                    </tr>
                </c:forEach>
            </table>
            <button class="btn btn-info button button-1 button-1a" type="submit"><span class="fa fa-file-excel-o"></span> Salvar como...</button>                   
        </div>

    </body>
</html>
