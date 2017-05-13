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
                    
                <c:choose>
                    <c:when test="${erroNome}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control erro" placeholder="Nome">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control" placeholder="Nome">
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
                
                
                <c:choose>
                    <c:when test="${erroAdmissao}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-list-alt"></span></span>
                            <input id="camponome" type="text" value="${admissao}" name="nome" class="form-control erro" placeholder="Admissao">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-list-alt"></span></span>
                            <input id="camponome" type="text" value="${admissao}" name="nome" class="form-control" placeholder="Admissao">
                        </div>
                    </c:otherwise>
                </c:choose>
                
                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-briefcase"></span></span>
                    <select id="campocargo" class="selectpicker form-control" data-live-search="true" name="cargo" title="Sexo">
                        <c:choose>
                            <c:when test="${cargo eq 'Gerente T.I'}">         
                                <option name="Gerente T.I">Gerente T.I</option> 
                                <option name="Funcionario T.I">Funcionário T.I</option>  
                                <option name="Gerente Vendas">Gerente Vendas</option>
                                <option name="Funcionario Vendas">Funcionário Vendas</option>
                                <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                                <option name="Funcionario Retaguarda">Funcionario Retaguarda</option> 
                            </c:when>
                            <c:when test="${cargo eq 'Funcionário T.I'}">   
                                <option name="Funcionario T.I">Funcionário T.I</option>  
                                <option name="Gerente T.I">Gerente T.I</option> 
                                <option name="Gerente Vendas">Gerente Vendas</option>
                                <option name="Funcionario Vendas">Funcionário Vendas</option>
                                <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                                <option name="Funcionario Retaguarda">Funcionario Retaguarda</option>  
                            </c:when>
                            <c:when test="${cargo eq 'Gerente Vendas'}">   
                                <option name="Gerente Vendas">Gerente Vendas</option>
                                <option name="Gerente T.I">Gerente T.I</option> 
                                <option name="Funcionario T.I">Funcionário T.I</option>  
                                <option name="Funcionario Vendas">Funcionário Vendas</option>
                                <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                                <option name="Funcionario Retaguarda">Funcionario Retaguarda</option>  
                            </c:when>
                            <c:when test="${cargo eq 'Funcionário Vendas'}"> 
                                <option name="Funcionario Vendas">Funcionário Vendas</option>
                                <option name="Gerente T.I">Gerente T.I</option> 
                                <option name="Funcionario T.I">Funcionário T.I</option>  
                                <option name="Gerente Vendas">Gerente Vendas</option>
                                <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                                <option name="Funcionario Retaguarda">Funcionario Retaguarda</option> 
                            </c:when>
                            <c:when test="${cargo eq 'Gerente Retaguarda'}"> 
                                <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                                <option name="Gerente T.I">Gerente T.I</option> 
                                <option name="Funcionario T.I">Funcionário T.I</option>  
                                <option name="Gerente Vendas">Gerente Vendas</option>
                                <option name="Funcionario Vendas">Funcionário Vendas</option>
                                <option name="Funcionario Retaguarda">Funcionario Retaguarda</option> 
                            </c:when>
                            <c:otherwise>
                                <option name="Funcionario Retaguarda">Funcionario Retaguarda</option> 
                                <option name="Gerente T.I">Gerente T.I</option> 
                                <option name="Funcionario T.I">Funcionário T.I</option>  
                                <option name="Gerente Vendas">Gerente Vendas</option>
                                <option name="Funcionario Vendas">Funcionário Vendas</option>
                                <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                            </c:otherwise>
                        </c:choose>
                    </select>            
                </div>       
   
                <div class="input-group">
                    <span class="input-group-addon"><span class=" glyphicon glyphicon-home"></span></span>
                    <select id="campoempresa" class="selectpicker form-control" data-live-search="true" name="unidade" title="Unidadw">
 
                        <c:forEach var="unidade" items="${dao.listar()}"> 
                            <option nome="${unidade.nome}">${unidade.nome}</option>
                        </c:forEach>
                    </select>
                </div>
 
                <c:choose>
                    <c:when test="${erroLogin}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input id="campologin" type="text" value="${login}" name="login" class="form-control erro" placeholder="Login">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input id="campologin" type="text" value="${login}" name="login" class="form-control" placeholder="Login">
                        </div>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${erroSenha}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input id="campologin" type="password" value="${senha}" name="senha" class="form-control erro" placeholder="Senha">
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input id="campologin" type="password" value="${senha}" name="senha" class="form-control" placeholder="Senha">
                        </div>
                    </c:otherwise>
                </c:choose>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>

            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>
