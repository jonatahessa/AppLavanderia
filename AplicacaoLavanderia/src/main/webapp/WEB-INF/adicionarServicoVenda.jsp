
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaServico.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaServico.js"></script>
        <title>Adicionar Serviço</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="./AdicionarServicoVenda" method="post">
                <fieldset>
                    <h1>Adicionar Serviço</h1>
                    <section class="color-pattern-1 form-inline">
                            <input class="form-control" type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                            <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                            <button id="cancelar" class="btn button button-1 button-1a" type="button"><span class="fa fa-times"></span> Cancelar</button>
                        </section>
                </fieldset>
            </form>   
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>ID</th>
                    <th>Nome do serviço</th>
                    <th>Preço por peça</th>
                    <th>Quantidade</th>
                    <th>Selecionar Serviço</th>
                </tr>

                <c:forEach var="servicos" items="${resultado}">
                    <tr>
                    <form method="post" action="./Lavar">
                        <td>${servicos.id}<input type="hidden" name="id" value="${servicos.id}"/></td>
                        <td>${servicos.nomeServico}</td>
                        <td>${servicos.precoServico}</td>
                        <td><input class="qtde" type="number" name="qtde" min="1" value="${param.qtde ? param.qtde : 1}" max="999"></td>
                        <td><button class="btn button button-1 button-1a" type="submit"><span class="fa fa-plus"></span> Selecionar</button></td>
                        </form>
                    </tr>
                </c:forEach>
            </table>        
        </div>
    </body>
</html>