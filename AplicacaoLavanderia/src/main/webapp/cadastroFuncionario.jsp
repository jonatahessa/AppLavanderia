<%-- 
    Document   : cadastroFuncionario
    Created on : 18/04/2017, 20:52:19
    Author     : livia.cgsantos
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="Daos.DaoUnidade"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/cadastrarFuncionario.css">
        <script type="text/javascript" src="./resources/JavaScript/cadastrarFuncionario.js">
        </script>
        <title>Cadastro Funcionario</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>

        <section id="principal">
            <form method="post" action= "./CadastrarFuncionario" method="post">
                <h1>Cadastro de Funcionario</h1>
                <div id="pessoais">
                    
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
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control erro" placeholder="Nome">
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
                
                </div>

                <div id="profissional">
                    <input type="text" id="campoadmissao" class="campos"  name="admissao" placeholder="Admissão"/>
                    <select id="campocargo" name="cargo">
                        <option name="Gerente T.I">Gerente T.I</option>
                        <option name="Funcionario T.I">Funcionário T.I</option>
                        <option name="Gerente Vendas">Gerente Vendas</option>
                        <option name="Funcionario Vendas">Funcionário Vendas</option>
                        <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                        <option name="Funcionario Retaguarda">Funcionário Retaguarda</option>
                    </select>   
                    <select id="campoempresa" class="campos" name="unidade">
                        <c:forEach var="unidade" items="${dao.listar()}"> 
                            <option nome="${unidade.nome}">${unidade.nome}</option>
                        </c:forEach>
                    </select>
                    <input type="text" name="login" id="Login" placeholder="Login">
                    <input type="password" name="senha" id="usuario" placeholder="Senha">
                </div>

                <div id="buttons">
                    <button action id="salvar" type="submit">Salvar</button>

                    <button id="cancelar" type="button">Cancelar</button>
                </div>

            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>
