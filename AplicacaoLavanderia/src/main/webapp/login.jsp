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
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/login.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/login.js"></script>
        <title>Login</title>
    </head>
    <body>
        <div id="principal">
            <h1 class="form-signin-heading">Login</h1>  

            <form class="form-horizontal" action= "./Login" method="post">

                <c:choose>
                    <c:when test="${erroLogin}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-user fa-fw"></span></span>
                            <input id="campologin" type="text" value="${login}" name="login" class="form-control erro" placeholder="Usuario">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-user fa-fw"></span></span>
                            <input id="campologin" type="text" value="${login}" name="login" class="form-control" placeholder="Usuario">
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <c:choose>
                    <c:when test="${erroSenha}">  
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-id-card fa-fw"></span></span>
                            <input id="camposenha" value="${senha}" type="password" name="senha"  class="form-control erro" placeholder="Senha">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-id-card fa-fw"></span></span>
                            <input id="camposenha" value="${senha}" type="password" name="senha" class="form-control" placeholder="Senha">
                        </div>
                    </c:otherwise>
                </c:choose>
               
                <div id="buttons">
                    <button id="logar" type="submit" class="btn btn-success">Logar</button>
                </div>

            </form>
        </div>
    </body>
</html>
