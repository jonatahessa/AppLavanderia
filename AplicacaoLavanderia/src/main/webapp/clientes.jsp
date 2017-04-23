<%-- 
    Document   : cadastroCliente
    Created on : 17/04/2017, 19:39:50
    Author     : jonata.hmoliveira
--%>

<%@page import="CRUDCliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Daos.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    DaoCliente dao = new DaoCliente();

    List<Cliente> lista;

    lista = dao.listar();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarCliente.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarCliente.js">
        </script>
        <title>Consulta Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id = "menu"></div>
        <h1>Consulta de Cliente</h1>
        <div id="table">
            <table align="center">
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Sexo</th>
                </tr>
                <!-- inicia for -->
                <%
                    for (Cliente registro : lista) {

                %>
                <tr>
                    <th><%=registro.getNome()%></th>
                    <th><%=registro.getCpf()%></th>
                    <th><%=registro.getEmail()%></th>
                    <th><%=registro.getTelefone()%></th>
                    <th><%=registro.getSexo()%></th>
                </tr>
                <!-- encerra for -->
                <%
                    }
                %>
        </div>
    </body>
</html>
