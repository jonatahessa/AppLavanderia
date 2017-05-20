<%-- 
    Document   : cadastroCliente
    Created on : 17/04/2017, 19:39:50
    Author     : jonata.hmoliveira
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <%@ include file = "header.jsp" %>
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarCliente.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/cadastrarCliente.js"></script>
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Cadastro de Cliente</h1>  

            <form class="form-horizontal" action= "./CadastrarCliente" method="post">

                <c:choose>
                    <c:when test="${erroNome}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-user fa-fw"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control erro" placeholder="Nome">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-user fa-fw"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control" placeholder="Nome">
                            <c:if test="${trueNome}">
                            <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>            
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <c:choose>
                    <c:when test="${erroCpf}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-id-card fa-fw"></span></span>
                            <input id="campocpf" maxlength="14" value="${cpf}" type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" class="form-control erro" placeholder="CPF">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-id-card fa-fw"></span></span>
                            <input id="campocpf" maxlength="14" value="${cpf}" type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" class="form-control" placeholder="CPF">
                            <c:if test="${trueCpf}">
                            <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>
                        </div>
                    </c:otherwise>
                </c:choose>
                
               <c:choose>
                    <c:when test="${erroEmail}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-envelope fa-fw"></span></span>
                            <input id="campoemail" type="text" value="${email}" name="email" class="form-control erro" placeholder="E-mail">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-envelope fa-fw"></span></span>
                            <input id="campoemail" type="text" value="${email}" name="email" class="form-control" placeholder="E-mail">
                            <c:if test="${trueEmail}">
                            <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>
                        </div>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${erroTelefone}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-phone fa-fw"></span></span>
                            <input id="campotelefone" value="${telefone}" maxlength="12" type="text" name="telefone" class="form-control erro" onkeypress="mascara(this, '## ####-####');" placeholder="Telefone">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-phone fa-fw"></span></span>
                            <input id="campotelefone" value="${telefone}" maxlength="12" type="text" name="telefone" class="form-control" onkeypress="mascara(this, '## ####-####');" placeholder="Telefone">
                            <c:if test="${trueTelefone}">
                            <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>
                        </div>
                    </c:otherwise>
                </c:choose>
                               
                <div class="input-group">
                    <span class="input-group-addon"><span class="fa fa-venus-mars fa-fw"></span></span>
                    <select id="camposexo" class="selectpicker form-control" data-live-search="true" name="sexo" title="Sexo">
                        <c:choose>
                            <c:when test="${sex eq 'Feminino'}">            
                                <option name="Feminino">Feminino</option>
                                <option name="Masculino">Masculino</option>
                            </c:when>
                            <c:otherwise>
                                <option name="Masculino">Masculino</option>
                                <option name="Feminino">Feminino</option>
                            </c:otherwise>
                        </c:choose>
                    </select>            
                </div>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>

            </form>
        </div>
    </body>
</html>
