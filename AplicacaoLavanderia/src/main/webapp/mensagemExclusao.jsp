<%-- 
    Document   : mensagemExclusao
    Created on : 21/04/2017, 13:37:22
    Author     : Thalles
--%>

<%@page import="CRUDCliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Daos.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String msg = null;
    if (request.getParameter("cpf") == null) {
        msg = "Erro, verifique e tente novamente";
    } else {
        DaoCliente dao = new DaoCliente();
        Cliente cliente = new Cliente();
        cliente.setCpf(request.getParameter("cpf"));
        boolean ret = dao.deletar(cliente.getCpf());
        if (ret == true) {
            msg = "Cliente removido com sucesso!";
        } else {
            msg = "Não foi possível realizar exclusão, verique e tente novamente";
        }

%>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/mensagens.css" media="screen" >
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <div id="aviso">
            <h1><%=msg%></h1>
        </div>
        <META HTTP-EQUIV="Refresh" CONTENT="1;URL= ./index.jsp">
    </body>
</html>
