<%@page import="CRUDFuncionario.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoFuncionario"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="" media="screen" >
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaFuncionario.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaFuncionario.js"></script>
        <title>Consulta Funcionario</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>

        <div id="table">
            <form action="./PesquisarFuncionario" method="post">
                <fieldset>
                    <h1>Pesquisar Funcionario</h1>
                    <input type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                    <button class="btn btn-info" type="submit">Pesquisar</button>
                </fieldset>
            </form>
            <form method="POST" action="cadastroFuncionario.jsp"><button class="btn btn-success" type="submit">Cadastrar</button></form>

            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                  
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>Cargo</th>
                    <th>Unidade</th>
                    <th>Alterar Cliente</th>
                    <th>Remover Cliente</th>
                </tr>

                <c:forEach var="funcionarios" items="${resultado}">
                    <tr>

                        <td>${funcionarios.nome}</td>
                        <td>${funcionarios.sexo}</td>
                        <td>${funcionarios.cargo}</td>
                        <td>${funcionarios.nomeUnidade}</td>
                        <td><a href="./AlterarFuncionario?id=${funcionarios.id}" >Alterar</a></td>
                        <td><form action="DeletarFuncionario" method="post" id="frm${funcionarios.id}">
                                <input type="hidden" name="id" value="${funcionarios.id}">
                                <a href="#" onclick="document.getElementById('frm${funcionarios.id}').submit()">Remover</a>
                            </form></td>

                    </tr>
                </c:forEach>
            </table>

        </div>
    </body>
</html>
