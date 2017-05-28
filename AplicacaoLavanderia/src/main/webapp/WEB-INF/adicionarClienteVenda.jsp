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

        <title>Adicionar Cliente</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./AdicionarClienteVenda" method="post">
                <fieldset>
                    <h1>Adicionar Cliente</h1>
                    <article>
                        <section class="color-pattern-1 form-inline">
                            <input class="form-control" type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                            <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                            <button id="exportButton" class="btn button button-1 button-1a" type="submit"><span class="fa fa-file-excel-o fa-lg"></span> Salvar</button>  
                        </section>
                    </article> 
                </fieldset>
            </form>

            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Sexo</th>
                    <th>Adicionar Cliente</th>
                </tr>
                <c:forEach var="clientes" items="${resultado}">
                    <tr onclick="main();">
                        <td>${clientes.nome}</td>
                        <td name="cpf">${clientes.cpf}</td>
                        <td>${clientes.email}</td>
                        <td>${clientes.telefone}</td>
                        <td>${clientes.sexo}</td>
                        <td><a href="./ObterCliente?cpf=${clientes.cpf}" >Adicionar</a></td>
                    </tr>
                </c:forEach>
            </table>

        </div>

    </body>
</html>
