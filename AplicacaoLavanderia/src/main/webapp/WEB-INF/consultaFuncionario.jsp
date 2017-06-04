<%@page import="CRUDFuncionario.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoFuncionario"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaFuncionario.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaFuncionario.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Consulta Funcionario</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="./PesquisarFuncionario" method="post">
                <fieldset>
                    <h1>Pesquisar Funcionario</h1>
                    <article>
                        <section class="color-pattern-1 form-inline">
                            <input class="form-control" type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                            <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                        </section>
                    </article> 
                </fieldset>
            </form>

            <form method="POST" action="Redirecionar">
                <button class="btn button button-1 button-1a" name="tela" value="/WEB-INF/cadastroFuncionario.jsp" type="submit"><span class="fa fa-plus"></span> Cadastrar</button>
            </form>

            <div class="scroll">
                <table id="tableID" class="table table-bordered" align="center">
                    <tr>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Cargo</th>
                        <th>Unidade</th>
                        <th WIDTH=130>Alterar Cliente</th>
                        <th WIDTH=130>Remover Cliente</th>
                    </tr>

                    <c:forEach var="funcionarios" items="${resultado}">
                        <tr>
                            <td>${funcionarios.nome}</td>
                            <td>${funcionarios.sexo}</td>
                            <td>${funcionarios.cargo}</td>
                            <td>${funcionarios.nomeUnidade}</td>
                            <td WIDTH=130><a href="./AlterarFuncionario?id=${funcionarios.id}" ><button class="btn button button-1 button-1a" type="submit"><span class="fa fa-pencil"></span> Alterar</button></a></td>
                            <td WIDTH=130><form action="DeletarFuncionario" method="post" id="frm${funcionarios.id}" onsubmit="return apagar(this);">
                                    <input type="hidden" name="id" value="${funcionarios.id}">
                                    <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-trash"></span> Remover</button>
                                </form></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
                            
            <div class="alerta">
                <div class="barra"><span class="fa fa-exclamation-triangle"></span> Aviso</div>
                <br/>
                <p>Deseja remover o funcionário?</p>
                <button class="btn button button-1 button-1a" onclick="confirmar();"><span class="fa fa-thumbs-up"></span> Sim</button>
                <button class="btn button button-1 button-1a" onclick="cancelar();"><span class="fa fa-thumbs-down"></span> Não</button>
            </div>

            <div class="nevoa">

            </div>

    </body>
</html>
