<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarUnidade.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarUnidade.js"></script>
        <title>Alterar Unidade</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Alteração de Unidade</h1>  

            <form class="form-horizontal" action= "./AlterarUnidade" method="post">
                <input type="text" value="${id}" name="idUnidade" id="id">
                <c:choose>
                    <c:when test="${erroNome}">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="camponome" type="text" name="nome" value="${nome}" class="form-control erro" placeholder="Nome">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="camponome" type="text" name="nome" value="${nome}" class="form-control" placeholder="Nome">
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <c:choose>
                    <c:when test="${erroCnpj}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="campocnpj" type="text" maxlength="18" name="cnpj" value="${cnpj}" class="form-control erro" onkeypress="mascara(this, '##.###.###/####-##')" placeholder="CNPJ">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="campocnpj" type="text" maxlength="18" name="cnpj" value="${cnpj}" class="form-control" onkeypress="mascara(this, '##.###.###/####-##')" placeholder="CNPJ">
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>

            </form>
        </div>
    </body>
</html>