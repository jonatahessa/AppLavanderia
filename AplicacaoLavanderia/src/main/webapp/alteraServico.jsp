<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/alterarServico.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/alterarServico.js"></script>
        <title>Alterar Servico</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>  
        <section id="principal">
            <form class="form-horizontal" action= "./AlterarServico" method="post">
                <input type="text" value="${id}" name="id" id="id">
                <h1 class="form-signin-heading">Alterar Serviço</h1>  
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
                    <c:when test="${erroPreco}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-usd"></span></span>
                            <input id="campopreco" type="text" value="${preco}" name="preco" class="form-control erro" placeholder="preco">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-usd"></span></span>
                            <input id="campopreco" type="text" value="${preco}" name="preco" class="form-control" placeholder="preco">
                            <c:if test="${truePreco}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if> 
                        </div>
                    </c:otherwise>
                </c:choose>
 
                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>
            </form>
        </section> 
    </body>
</html>
