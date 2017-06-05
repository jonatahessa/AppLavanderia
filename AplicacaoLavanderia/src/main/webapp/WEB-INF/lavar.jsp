
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/lavar.css">
        <script type="text/javascript" src="./resources/JavaScript/cadastrarCliente.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <!-- bootbox code -->
        <script src="./resources/JavaScript/bootbox.min.js"></script>

        <title>Lavar</title>
    </head>

    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>
        <div id="table">
            <form action= "./PesquisarServico" method="post">
                <fieldset>
                    <h1>Lavar</h1>
                </fieldset>
            </form>
            
            <form method="POST" action="RedirecionarVenda">
                <button class="btn button button-1 button-1a" id="selecionarServico" name="tela" value="/WEB-INF/adicionarServicoVenda.jsp" type="submit"><span class="fa fa-plus"></span> Selecionar Serviço</button>
            </form>
            
            <form id="cancelar" method="POST" action="Redirecionar">
                <button id="cancelar" class="btn button button-1 button-1a" name="tela" value="/CancelarVenda" type="submit"> Cancelar</button>
            </form>
            
            <table id="tableID" class="table table-bordered" align="center">
                <tr>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Valor Unitário</th>
                    <th>Valor</th>
                    <th>Remover</th>
                </tr>

                <c:forEach var="itens" items="${listaItensVenda}">
                    <tr>
                        <input type="hidden" name="iditem" value="${itens.id}"/>
                        <td>${itens.nomeServico}<input type="hidden" name="nome" value="${itens.nomeServico}"/></td>
                        <td>${itens.quantidade}<input type="hidden" name="qtde" value="${itens.quantidade}"/></td>
                        <td>${itens.precoUnitario}<input type="hidden" name="precounitario" value="${itens.precoUnitario}"/></td>
                        <td>${itens.precoServico}<input type="hidden" name="preco" value="${itens.precoServico}"/></td>
                        <td><form action="DeletarItemVenda" method="post" id="frm${itens.id}">
                                <input type="hidden" name="iditem" value="${itens.id}">
                                <button class="btn button button-1 button-1a" type="submit"><span class="fa fa-minus"></span> Remover</button>
                            </form></td>
                    </tr>
                </c:forEach>
            </table>
            
            <p name="total">${total}</p>
            <form method="POST" action="RedirecionarVenda">
                <c:choose>
                    <c:when test="${erroCpf}">
                        <input type="text" name="cpf" class="erro" placeholder="CPF do Cliente" value="${cpf}" maxlength="14" onkeypress="mascara(this, '###.###.###-##');"/> 
                     </c:when>
                    <c:otherwise>  
                        <input type="text" name="cpf" placeholder="CPF do Cliente" value="${cpf}" maxlength="14" onkeypress="mascara(this, '###.###.###-##');"/> 
                    </c:otherwise>
                </c:choose>
            <button id="cancelar" class="btn button button-1 button-1a" name="tela" value="/FinalizarVenda" type="submit"><span class="fa fa-usd"></span> Finalizar</button>
            </form>
            <form method="POST" action="RedirecionarVenda">
                <button class="btn button button-1 button-1a" name="tela" value="/WEB-INF/adicionarClienteVenda.jsp" type="submit"><span class="fa fa-plus"></span> Buscar Cliente</button>
            </form>
            
        </div>
    </body>
</html>
