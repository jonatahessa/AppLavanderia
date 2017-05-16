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
        <%@ include file = "header.jsp" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaCliente.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaCliente.js"></script>
        <title>Consulta Cliente</title>
    </head>
  
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="consultaCliente.jsp" method="POST">
                <fieldset>
                    <h1>Pesquisar Cliente</h1>
                    <input type="text" name="palavra" />
                    <input type="submit" value="Pesquisar" href="./AlterarCliente?cpf=${clientes.cpf}"/>
                </fieldset>
            </form>
            <form method="POST" action="cadastroCliente.jsp"><button class="btn btn-success" type="submit">Cadastrar</button></form>
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
                    <tr onclick="main();">
                        <td>${clientes.nome}</td>
                        <td>${clientes.cpf}</td>
                        <td>${clientes.email}</td>
                        <td>${clientes.telefone}</td>
                        <td>${clientes.sexo}</td>
                        <td><a href="./AlterarCliente?cpf=${clientes.cpf}" >Alterar</a></td>
                        <td><form action="DeletarCliente" method="post" id="frm${clientes.cpf}">
                            <input type="hidden" name="cpf" value="${clientes.cpf}">
                            <a href="#" onclick="document.getElementById('frm${clientes.cpf}').submit()">Remover</a>
                        </form></td>
                    </tr>
                </c:forEach>
            </table>
            
        </div>
                  
    </body>
</html>
