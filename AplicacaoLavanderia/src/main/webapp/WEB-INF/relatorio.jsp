<%@page import="CRUDCliente.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="dao" class="Daos.DaoCliente"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/relatorio.css">
        <script type="text/javascript" src="./resources/JavaScript/relatorio.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- lib box de confirmação -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>
        <!-- lib salvar para excel -->
        <link rel="stylesheet" type="text/css" href="https://www.shieldui.com/shared/components/latest/css/light/all.min.css" />
        <script type="text/javascript" src="https://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
        <script type="text/javascript" src="https://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>


        <title>Consulta Cliente</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./relatorio" method="post">
                <fieldset>
                    <h1>Relatório</h1>
                    <article>
                        <section class="color-pattern-1">
                            <div class="campoTotal">
                                <div class="filho">
                                    <label>De:</label>
                                    <input type="text" name="palavra" maxlength="10" onkeypress="mascara(this, '##/##/####');" value="${palavra}"/>
                                </div>      
                                <div class="filho">
                                    <label>Até:</label>
                                    <input type="text" name="palavra" maxlength="10" onkeypress="mascara(this, '##/##/####');" value="${palavra}"/>
                                </div>   
                                <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-search fa-la"></span> Pesquisar</button>
                                <input type="button" class="btn button button-1 button-2a button_add" value=" Salvar" onclick="exportToExcel('exTable')" /></span>
                        </section>
                    </article> 
                </fieldset>
            </form>
            <table id="exTable" class="table table-bordered" align="center" border="1">
                <thead class="lockedRecordsBg">
                    <tr>
                        <th>Nome</th>
                        <th>Sexo</th>
                        <th>Cargo</th>
                        <th>Unidade</th>
                        <th>Alterar Cliente</th>
                        <th>Remover Cliente</th>
                </thead>
                <tbody>
                    
                <c:forEach var="funcionarios" items="${resultado}">
                    <tr>

                        <td>${funcionarios.nome}</td>
                        <td>${funcionarios.sexo}</td>
                        <td>${funcionarios.cargo}</td>
                        <td>${funcionarios.nomeUnidade}</td>
                        <td><a href="./AlterarFuncionario?id=${funcionarios.id}" >Alterar</a></td>
                        <td><form action="DeletarFuncionario" method="post" id="frm${funcionarios.id}">
                                <input type="hidden" name="id" value="${funcionarios.id}">
                                <a href="#" onclick="document.getElementById('frm${funcionarios.id}').submit()">Remover</a>
                            </form></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table> 

        </div>

    </body>
</html>
