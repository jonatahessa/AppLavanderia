
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="Daos.DaoServico"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/vender.css">
        <script type="text/javascript" src="./resources/JavaScript/vender.js">
        </script>
        <title>Vender</title>
    </head>
    <%-- https://pt.stackoverflow.com/questions/26421/pegar-valor-de-um-atributo-na-td  --%>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>

        <section id="principal">
            <form name="formVendas" method="get" action= "" method="get">
                <h1>Vender</h1>

                <%-- <select id="camposervico" class="campos" name="servico">
                    <c:forEach var="servico" items="${dao.listar()}"> 
                    <option name="${servico.nomeServico}">${servico.nomeServico}</option>
                    </c:forEach>
                </select>
                
                <%-- <c:forEach var="servico" items="${dao.retornarPreco()}"> 
                    <h2> ${servico.precoPorPeca}</h2>
                </c:forEach> --%>

                <p><label>Nome do serviço:<select id="camposervico" class="tempNome" name="servico">
                            <c:forEach var="servico" items="${dao.listar()}">
                                <option name="${servico.nomeServico}">${servico.nomeServico}</option>
                            </c:forEach>
                        </select></label>
                    <label>Quantidade:<input type="text" class="tempQuantidade" name="quantidade"></label>
                    <label>Preço Unitário:<input type="text" class="tempPrecoUnitario" name="precounitario" ></label>
                    <label>Valor total:<input type="text" class="tempInsert"  value="" name="valortotal"></label>
                    <button type="button" id="tempBtn" onclick="calcularTotal()">Adicionar</button>
                </p>

                <table width="100%">
                    <thead>
                        <tr>
                            <th>Serviço</th>
                            <th>Preço Unitário</th>
                            <th>Quantidade</th>
                            <th>Valor Total</th>
                            <th>Remover</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>



            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>
