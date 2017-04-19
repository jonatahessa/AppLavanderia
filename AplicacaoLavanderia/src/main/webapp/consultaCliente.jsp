<%-- 
    Document   : consultaCliente
    Created on : 18/04/2017, 20:39:36
    Author     : viniciuzvieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Cliente</title>
    </head>
<body>
	<div align="center">
		<P>Lista de Clientes</P>
		<table border="1">
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>Data Cadastro</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="aluno" items="${listaCliente}">
				<tr>
					<td>${cliente.cpf}</td>
					<td>${cliente.nome}</td>
                                        <td>${cliente.email}</td>
					<td>${cliente.telefone}</td>
					<td><fmt:formatDate value="${cliente.dataCadastro}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="AlunoServlet?acao=Excluir&cpf=${cliente.cpf}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaCliente) > 0}">
   		Existem ${fn:length(listaCliente)} clientes!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>
 
</body>
</html>
