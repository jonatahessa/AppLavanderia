<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="Daos.DaoCliente"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <!-- Bootstrap -->
        <%@ include file = "bootstrap.html" %>
        <!-- Interface e Dinâmica -->
        <link rel="StyleSheet" type="text/css" href="./resources/CSS/alterarCliente.css" media="screen" >
        <script type="text/javascript" src="./resources/JavaScript/alterarCliente.js"></script>
        <title>Alterar Cliente</title>
    </head>
    <body>
        <div id ="logo"></div>
        <%@ include file = "menu.jsp" %>   
        <div id="principal">
            <h1 class="form-signin-heading">Alteração de Cliente</h1>  

            <form class="form-horizontal" action= "./CadastrarCliente" method="post">

                <c:forEach var="cliente" items="${dao.obter('${cpf}')}">  
                
                    <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
                        <input id="camponome" type="text" name="nome" class="form-control erro" placeholder="${cliente.nome}">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><span class=" glyphicon glyphicon-user"></span></span>
                        <input id="campocpf" maxlength="14" type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" class="form-control erro" placeholder="${cliente.cpf}">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><span class=" glyphicon glyphicon-envelope"></span></span>
                        <input id="campoemail" type="text" name="email" class="form-control erro" placeholder="${cliente.email}">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><span class=" glyphicon glyphicon-earphone"></span></span>
                         <input id="campotelefone" maxlength="13" type="text" name="telefone" class="form-control erro" onkeypress="mascara(this, '## ####-####');" placeholder="${cliente.telefone}">
                    </div>
    
                    <div class="input-group">
                        <span class="input-group-addon"><span class=" glyphicon glyphicon-star"></span></span>
                        <select id="camposexo" class="selectpicker form-control" data-live-search="true" name="sexo" title="Sexo">
                            <option name="Feminino">Feminino</option>
                            <option name="Masculino">Masculino</option>
                        </select>
                    </div>
                </c:forEach>
                        
                            
                <div id="buttons">
                    <button id="salvar" type="submit" class="btn btn-success">Salvar</button>
                    <button id="cancelar" type="button" class="btn btn-danger">Cancelar</button>
                </div>

            </form>
        </div>
    </body>
</html>
