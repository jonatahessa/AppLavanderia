<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="br.senac.tads3.Daos.DaoUnidade"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/alteraFuncionario.css">
        <script type="text/javascript" src="./resources/JavaScript/cadastrarFuncionario.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Alteração de Funcionario</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <section id="principal">
            <form method="post" action= "./AlterarFuncionario" method="post">
                <h1>Alterar Funcionário</h1>
                <input type="text" value="${idAlterar}" name="idFuncionario" id="id">
                <c:choose>
                    <c:when test="${erroNome}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-id-badge fa-fw"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control erro" placeholder="Nome">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-id-badge fa-fw"></span></span>
                            <input id="camponome" type="text" value="${nome}" name="nome" class="form-control" placeholder="Nome">
                            <c:if test="${trueNome}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>  
                        </div>
                    </c:otherwise>
                </c:choose>


                <div class="input-group">
                    <span class="input-group-addon"><span class="fa fa-venus-mars fa-fw"></span></span>
                    <select id="camposexo" class="selectpicker form-control" data-live-search="true" name="sexo" title="Sexo">
                        <c:choose>
                            <c:when test="${sexo eq 'Feminino'}">
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
                            <span class="input-group-addon"><span class="fa fa-calendar-check-o fa-fw"></span></span>
                            <input id="camponome" type="text" value="${admissao}" name="admissao" maxlength="10" onkeypress="mascara(this, '##/##/####');" class="form-control erro" placeholder="Admissão">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-calendar-check-o fa-fw"></span></span>
                            <input id="camponome" type="text" value="${admissao}" name="admissao" maxlength="10" onkeypress="mascara(this, '##/##/####');" class="form-control" placeholder="Admissão">
                            <c:if test="${trueAdmissao}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>  
                        </div>
                    </c:otherwise>
                </c:choose>

                <div class="input-group">
                    <span class="input-group-addon"><span class="fa fa-briefcase fa-fw"></span></span>
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
                    <span class="input-group-addon"><span class="fa fa-building fa-fw"></span></span>
                    <select id="campoempresa" class="selectpicker form-control" data-live-search="true" name="unidade" title="Unidadw">   
                        <c:forEach var="unidade" items="${dao.listar()}">
                            <c:if test="${unidade.nome eq unidadeFuncionario}">
                                <option nome="${unidade.nome}">${unidade.nome}</option>
                            </c:if>
                        </c:forEach>
                        <c:forEach var="unidade" items="${dao.listar()}">
                            <c:if test="${unidade.nome ne unidadeFuncionario}">
                                <option nome="${unidade.nome}">${unidade.nome}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>

                <c:choose>
                    <c:when test="${erroLogin}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-user-circle fa-fw"></span></span>
                            <input id="campologin" type="text" value="${login}" name="login" class="form-control erro" placeholder="Login">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-user-circle fa-fw"></span></span>
                            <input id="campologin" type="text" value="${login}" name="login" class="form-control" placeholder="Login">
                            <c:if test="${trueLogin}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>  
                        </div>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${erroSenha}"> 
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-key fa-fw"></span></span>
                            <input id="campologin" type="password" value="${senha}" name="senha" class="form-control erro" placeholder="Senha">
                            <span class="glyphicon remove glyphicon-remove form-control-feedback"></span>
                        </div>
                    </c:when>    
                    <c:otherwise>
                        <div class="input-group">
                            <span class="input-group-addon"><span class="fa fa-key fa-fw"></span></span>
                            <input id="campologin" type="password" value="${senha}" name="senha" class="form-control" placeholder="Senha">
                            <c:if test="${trueSenha}">
                                <span class="glyphicon ok glyphicon-ok form-control-feedback"></span>
                            </c:if>  
                        </div>
                    </c:otherwise>
                </c:choose>

                <div id="buttons">
                    <button id="salvar" type="submit" class="btn button button-1 button-1a">Salvar</button>
                </div>

            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>