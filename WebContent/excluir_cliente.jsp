<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />
<title>Excluir Cliente</title>
</head>
<body>
<center>
	<form action="ExcluirCliente">
		<table width="550" border="0">
			<tr>
				<td width="150"></td>
				<td width="400"></td>
			</tr>
			<tr>
				<td align="right">C�digo:</td>
				<td><input type="text" name="codigo" value="<%=request.getParameter("codigo") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">Categoria:</td>
				<td><input type="text" name="categoria" value="<%=request.getParameter("categoria") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">Nome:</td>
				<td><input type="text" name="nome" value="<%=request.getParameter("nome") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">Telefone:</td>
				<td><input type="text" name="telefone" value="<%=request.getParameter("telefone") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" value="Salvar">
					<a href="listar_cliente.jsp"><input type="button" value="Cancelar"></a>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>