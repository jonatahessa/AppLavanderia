<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/alterarCliente.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/alterarCliente.js"></script>
        <title>Alterar Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Alteração de Cliente</h1>  

            <form class="form-horizontal" action= "./AlterarCliente" method="post">
                <input type="text" value="${id}" name="idCliente" id="id">
                <c:choose>
                    <c:when test="${erroNome}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control erro" placeholder="Nome">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control" placeholder="Nome">
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <c:choose>
                    <c:when test="${erroCpf}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class=" glyphicon glyphicon-user"></span></span>
                            <input id="campocpf" maxlength="14" value="${cpf}" type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" class="form-control erro" placeholder="CPF">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class=" glyphicon glyphicon-user"></span></span>
                            <input id="campocpf" maxlength="14" value="${cpf}" type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" class="form-control" placeholder="CPF">
                        </div>
                    </c:otherwise>
                </c:choose>
                
               <c:choose>
                    <c:when test="${erroEmail}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class=" glyphicon glyphicon-envelope"></span></span>
                            <input id="campoemail" type="text" value="${email}" name="email" class="form-control erro" placeholder="E-mail">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class=" glyphicon glyphicon-envelope"></span></span>
                            <input id="campoemail" type="text" value="${email}" name="email" class="form-control" placeholder="E-mail">
                        </div>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${erroTelefone}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class=" glyphicon glyphicon-earphone"></span></span>
                            <input id="campotelefone" value="${telefone}" maxlength="13" type="text" name="telefone" class="form-control erro" onkeypress="mascara(this, '## ####-####');" placeholder="Telefone">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class=" glyphicon glyphicon-earphone"></span></span>
                            <input id="campotelefone" value="${telefone}" maxlength="13" type="text" name="telefone" class="form-control" onkeypress="mascara(this, '## ####-####');" placeholder="Telefone">
                        </div>
                    </c:otherwise>
                </c:choose>
                               
                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-star"></span></span>
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
