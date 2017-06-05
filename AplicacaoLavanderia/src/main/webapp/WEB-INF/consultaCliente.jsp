
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/consultaCliente.css">
        <script type="text/javascript" src="./resources/JavaScript/consultaCliente.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Consulta Cliente</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./PesquisarCliente" method="post">
                <fieldset>
                    <h1>Pesquisar Cliente</h1>
                    <article>
                        <section class="color-pattern-1 form-inline">
                            <input class="form-control" type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                            <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>                         
                        </section>
                    </article> 
                </fieldset>
            </form>

            <form method="POST" action="Redirecionar">
                <button class="btn button button-1 button-1a" name="tela" value="/WEB-INF/cadastroCliente.jsp" type="submit"><span class="fa fa-plus"></span> Cadastrar</button>
            </form>

            <div class="scroll">
                <table id="tableID" class="table table-bordered" align="center">
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>E-mail</th>
                        <th>Telefone</th>
                        <th>Sexo</th>
                        <th WIDTH=130>Alterar Cliente</th>
                        <th WIDTH=130>Remover Cliente</th>
                    </tr>
                    <c:forEach var="clientes" items="${resultado}">
                        <tr onclick="main();">
                            <td>${clientes.nome}</td>
                            <td>${clientes.cpf}</td>
                            <td>${clientes.email}</td>
                            <td>${clientes.telefone}</td>
                            <td>${clientes.sexo}</td>
                            <td WIDTH=130><a href="./AlterarCliente?cpf=${clientes.cpf}" ><button class="btn button button-1 button-1a" type="submit"><span class="fa fa-pencil"></span> Alterar</button></a></td>
                            <td WIDTH=130><form action="DeletarCliente" method="post" id="frm${clientes.cpf}" onsubmit="return apagar(this);">
                                    <input type="hidden" name="cpf" value="${clientes.cpf}">
                                    <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-trash"></span> Remover</button>
                                </form></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
                            
            <div class="alerta">
                <div class="barra"><span class="fa fa-exclamation-triangle"></span> Aviso</div>
                <br/>
                <p>Deseja remover o cliente?</p>
                <button class="btn button button-1 button-1a" onclick="confirmar();"><span class="fa fa-thumbs-up"></span> Sim</button>
                <button class="btn button button-1 button-1a" onclick="cancelar();"><span class="fa fa-thumbs-down"></span> Não</button>
            </div>

            <div class="nevoa">

            </div>
    </body>
</html>
