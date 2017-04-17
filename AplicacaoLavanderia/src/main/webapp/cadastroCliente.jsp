<%-- 
    Document   : cadastroCliente
    Created on : 17/04/2017, 19:39:50
    Author     : jonata.hmoliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="StyleSheet" type="text/css" href="estilo.css" media="screen" >
        <script type="text/javascript" src="cliente.js">
        </script>
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <h1>Cadastro de Cliente</h1>
        <section id="principal">
            <form method="post">

                <input id="camponome" class="campos" type="text" name="nome" placeholder="Nome" />

                <input id="campocpf" class="campos" type="text" name="cpf" placeholder="CPF" />

                <input id="campoemail" class="campos" type="text" name="email" placeholder="E-mail" />

                <input id="campotelefone" class="campos" type="text" name="telefone" placeholder="Telefone" />

                <div id="buttons">
                    <button id="salvar" type="button">Salvar</button>
                    <button id="cancelar" type="button">Cancelar</button>
                </div>

            </form>
        </section>
    </body>
</html>
