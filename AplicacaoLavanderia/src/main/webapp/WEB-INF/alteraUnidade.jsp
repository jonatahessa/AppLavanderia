<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/alterarUnidade.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/alterarUnidade.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Alterar Unidade</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Alterar Unidade</h1>  

            <form class="form-horizontal" action= "./AlterarUnidade" method="post">
                <input type="text" value="${idAlterar}" name="idUnidade" id="id">
                <c:choose>
                    <c:when test="${erroNome}">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="camponome" type="text" name="nome" value="${nome}" class="form-control erro" placeholder="Nome">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="camponome" type="text" name="nome" value="${nome}" class="form-control" placeholder="Nome">
                            <c:if test="${trueNome}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>
                        </div>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${erroCnpj}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="campocnpj" type="text" maxlength="18" name="cnpj" value="${cnpj}" class="form-control erro" onkeypress="mascara(this, '##.###.###/####-##')" placeholder="CNPJ">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="campocnpj" type="text" value="${cnpj}" maxlength="18" name="cnpj" class="form-control" onkeypress="mascara(this, '##.###.###/####-##')" placeholder="CNPJ">
                            <c:if test="${trueCnpj}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn button button-1 button-1a">Salvar</button>

                </div>

            </form>
        </div>
    </body>
</html>