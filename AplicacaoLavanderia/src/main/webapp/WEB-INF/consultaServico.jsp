
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

        <title>Consulta Serviço</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action="./PesquisarServico" method="post">
                <fieldset>
                    <h1>Pesquisar Serviço</h1>
                    <article>
                        <section class="color-pattern-1 form-inline">
                            <input class="form-control" type="text" name="palavra" value="${palavra}" placeholder="Pesquisa por nome"/>
                            <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-search"></span> Pesquisar</button>
                        </section>
                    </article> 
                </fieldset>
            </form>

            <form method="POST" action="Redirecionar">
                <button class="btn button button-1 button-1a" name="tela" value="/WEB-INF/cadastroServico.jsp" type="submit"><span class="fa fa-plus"></span> Cadastrar</button>
            </form>

            <div class="scroll">
                <table id="tableID" class="table table-bordered" align="center">
                    <tr>

                        <th>Nome do serviço</th>
                        <th>Preço por peça</th>
                        <th WIDTH=140>Alterar Serviço</th>
                        <th WIDTH=140>Remover Serviço</th>
                    </tr>

                    <c:forEach var="servicos" items="${resultado}">
                        <tr>

                            <td>${servicos.nomeServico}</td>
                            <td>${servicos.precoServico}</td>
                            <td WIDTH=140><a href="./AlterarServico?id=${servicos.id}" ><button class="btn button button-1 button-1a" type="submit"><span class="fa fa-pencil"></span> Alterar</button></a></td>
                            <td WIDTH=140><form action="DeletarServico" method="post" id="frm${servicos.id}" onsubmit="return apagar(this);">
                                    <input type="hidden" name="id" value="${servicos.id}">
                                    <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-trash"></span> Remover</button>
                                </form></td>
                        </tr>
                    </c:forEach>
                </table>        
            </div>
                            
            <div class="alerta">
                <div class="barra"><span class="fa fa-exclamation-triangle"></span> Aviso</div>
                <br/>
                <p>Deseja remover o serviço?</p>
                <button class="btn button button-1 button-1a" onclick="confirmar();"><span class="fa fa-thumbs-up"></span> Sim</button>
                <button class="btn button button-1 button-1a" onclick="cancelar();"><span class="fa fa-thumbs-down"></span> Não</button>
            </div>

            <div class="nevoa">

            </div>
    </body>
</html>