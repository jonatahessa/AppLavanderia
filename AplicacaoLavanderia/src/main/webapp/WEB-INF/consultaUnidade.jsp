<%@page import="CRUDUnidade.Unidade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoUnidade"/>
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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaUnidade.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Consulta Unidade</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./PesquisarUnidade" method="post">
                <fieldset>
                    <h1>Pesquisar Unidade</h1>
                    <article>
                        <section class="color-pattern-1">
                            <input type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                            <button class="btn btn-info button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                        </section>
                    </article> 
                </fieldset>
            </form>
            <form method="POST" action="Redirecionar"><button class="btn btn-success" name="tela" value="/WEB-INF/cadastroUnidade.jsp" type="submit">Cadastrar</button></form>        
            <table id="tableID" class="table table-bordered" align="center">
                <tr>

                    <th>Nome da Unidade</th>
                    <th>CNPJ</th>
                    <th>Alterar Unidade</th>
                    <th>Remover Unidade</th>
                </tr>

                <c:forEach var="unidades" items="${resultado}">
                    <tr>

                        <td>${unidades.nome}</td>
                        <td>${unidades.cnpj}</td>
                        <td><a href="./AlterarUnidade?id=${unidades.id}" >Alterar</a></td>
                        <td><form action="DeletarUnidade" method="post" id="frm${unidades.id}">
                                <input type="hidden" name="id" value="${unidades.id}">
                                <a href="#" onclick="document.getElementById('frm${unidades.id}').submit()">Remover</a>
                            </form></td>
                    </tr>
                </c:forEach>
            </table>        
        </div>
    </body>
</html>
