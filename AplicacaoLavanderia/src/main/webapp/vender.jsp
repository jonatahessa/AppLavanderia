
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="Daos.DaoServico"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/vender.css">
        <script type="text/javascript" src="./resources/JavaScript/vender.js">
        </script>
        <title>Cadastro Funcionario</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>

        <section id="principal">
            <form method="post" action= "./Vender" method="post">
                <h1>Vender</h1>
                <div>                    
                    <select id="camposervico" class="campos" name="servico">
                        <c:forEach var="servico" items="${dao.listar()}"> 
                        <option name="${servico.nomeServico}">${servico.nomeServico}</option>
                        </c:forEach>
                    </select>
                    <%-- <c:forEach var="servico" items="${dao.retornarPreco()}"> 
                        <h2> ${servico.precoPorPeca}</h2>
                    </c:forEach> --%>
                </div>
                
                <div>
                    
                </div>

                <div id="buttons">
                    <button id="salvar" type="submit">Salvar</button>
                    <button id="cancelar" type="button">Cancelar</button>
                </div>

            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>
