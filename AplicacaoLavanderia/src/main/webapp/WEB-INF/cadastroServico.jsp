<%-- 
    Document   : cadastrarServico
    Created on : 24/04/2017, 19:54:46
    Author     : eloisa.asilva2
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>

    <head>
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e DinÃ¢mica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarServico.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarServico.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Cadastro de Serviço</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>


        <section id="principal">
            <form class="form-horizontal" action= "./CadastrarServico" method="post">
                <h1 class="form-signin-heading">Cadastro de Serviço</h1>  
                <c:choose>
                    <c:when test="${erroNome}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-shower fa-fw"></span></span>
                            <input id="camponome" type="text" name="nome" value="${nome}" class="form-control erro" placeholder="Nome">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-shower fa-fw"></span></span>
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
                            <span class="input-group-addon"><span class="fa fa-usd fa-fw"></span></span>
                            <input id="campopreco" type="text" value="${preco}" name="preco" class="form-control erro" placeholder="Preço">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-usd fa-fw"></span></span>
                            <input id="campopreco" type="text" value="${preco}" name="preco" class="form-control" placeholder="Preço">
                            <c:if test="${truePreco}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if> 
                        </div>
                    </c:otherwise>
                </c:choose>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                </div>
            </form>
        </section>    
    <body>
</html>
