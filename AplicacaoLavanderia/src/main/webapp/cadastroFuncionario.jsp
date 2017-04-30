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
                    <input id="camponome" class="campos" maxlength="255" type="text" name="nome" placeholder="Nome" />
                    <select id="camposexo" class="campos" name="sexo">
                        <option name="Feminino">Feminino</option>
                        <option name="Masculino">Masculino</option>
                    </select>
                </div>
                
                <div id="profissional">
                    <input type="date" id="campoadmissao" class="campos"  name="admissao" placeholder="Admissão"/>
                    <select id="campocargo" name="cargo">
                        <option name="Gerente T.I">Gerente T.I</option>
                        <option name="Funcionario T.I">Funcionário T.I</option>
                        <option name="Gerente Vendas">Gerente Vendas</option>
                        <option name="Funcionario Vendas">Funcionário Vendas</option>
                        <option name="Gerente Retaguarda">Gerente Retaguarda</option>
                        <option name="Funcionario Retaguarda">Funcionário Retaguarda</option>
                    </select>   
                    <select id="campoempresa" class="campos" name="empresa">
                        <c:forEach var="unidade" items="${dao.listar()}"> 
                        <option nome="${unidade.nome}">${unidade.nome}</option>
                        </c:forEach>
                        <input type="text" name="login" id="Login" placeholder="Login">
                        <input type="password" name="senha" id="usuario" placeholder="Senha">
                    </select>
                </div>

                <div id="buttons">
                    <button id="salvar" type="submit">Salvar</button>
                    <button id="cancelar" type="button">Cancelar</button>
                </div>

            </form>
        </section>
        <script src="./resources/bootstrap/js/bootstrap.min.js"></script> 
    </body>
</html>
