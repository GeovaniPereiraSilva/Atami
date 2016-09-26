<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Entidades.Usuario"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />

<title>Atami</title>
</head>
<body>
<%@include file="includes/menu.jsp" %>

<h1>
Listagem de Usuários Cadastrados no Sistema.
</h1>
<center>
<table border="1">
	<tr>
		<th>Nome</th>
		<th>Usuário</th>
		<th>Senha</th>
		<th>Opção</th>
	</tr>
	<%
	List<Usuario> lista = (List<Usuario>)request.getAttribute("lista");

	for (Usuario u: lista){
	%>
	
	<tr>
		<td> <%= u.getNome() %> </td>
		<td> <%= u.getUsuario() %> </td>
		<td> <%= u.getSenha() %> </td>
		<td><a href="usucontroller.do?acao=cad">Adicionar</a> | <a href="usucontroller.do?acao=alt&id=<%= u.getId() %>">Alterar</a> | <a href="usucontroller.do?acao=exc&id=<%= u.getId() %>"> Excluir </a>
		</td>
	</tr>
	<%
		}
	%>

</center>
</table>
</body>
</html>