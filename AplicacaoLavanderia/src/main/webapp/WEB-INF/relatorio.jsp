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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/relatorio.css">
        <script type="text/javascript" src="./resources/JavaScript/relatorio.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- lib box de confirmação -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>
        <!-- lib salvar para excel -->
        <link rel="stylesheet" type="text/css" href="https://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
        <script type="text/javascript" src="https://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
        <script type="text/javascript" src="https://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>


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
                                    <label>De:</label>
                                    <input type="text" name="palavra" maxlength="10" onkeypress="mascara(this, '##/##/####');" value="${palavra}"/>
                                </div>      
                                <div class="filho">
                                    <label>Até:</label>
                                    <input type="text" name="palavra" maxlength="10" onkeypress="mascara(this, '##/##/####');" value="${palavra}"/>
                                </div>   
                                <button class="btn btn-info button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                                <button id="exportButton" class="btn btn-info button button-1 button-1a" type="submit"><span class="fa fa-file-excel-o fa-lg"></span> Salvar</button>  
                        </section>
                    </article> 
                </fieldset>
            </form>
            <table id="exportTable" class="table table-bordered" align="center">
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
        </div>

    </body>
</html>
