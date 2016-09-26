<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Entidades.Usuario"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />

<title>Atami</title>
<center>
<script type="text/javascript">
	function validaCadastro() {
		//Acesso ao formulario
		id = document.getElementById("txtid");
		nome = document.getElementById("txtnome");
		usuario = document.getElementById("txtusuario");
		senha = document.getElementById("txtsenha");

		if (nome.value == "") {
			window.alert("Campo Nome é de Preenchimento Obrigatório.");
			nome.focus();
			return false;
		}
		if (usuario.value == "") {
			window.alert("Campo Usuário é de Preenchimento Obrigatório.");
			usuario.focus();
			return false;
		}
		if ((id.value == "" || id.value == "0") && senha.value == "") {
			window.alert("Campo Senha é de Preenchimento Obrigatório.");
			senha.focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>

	<%
		Usuario ususalvar = (Usuario) request.getAttribute("ususalvar");
	%>
	<%@include file="includes/menu.jsp"%>

	<form name="frmcadusuario" onsubmit="return validaCadastro()"
		method="post" action="usucontroller.do">

		<fieldset>
			<legend>Cadastro de Usuários</legend>
				<table>
				<input id="txtid" type="hidden" name="txtid"
				value="<%=ususalvar.getId()%>" readonly="readonly"> <br>
				 <tr>
				   <td>Nome:</td>
				   <td><input id="txtnome" type="text" name="txtnome"
				value="<%=ususalvar.getNome()%>" size="20"> </br></td>
				 </tr>
				 <tr>
				   <td>Login:</td>
				   <td><input id="txtusuario" type="text" name="txtusuario"
				value="<%=ususalvar.getUsuario()%>" size="20"> <br /></td>
				 </tr>
				 <tr>
				   <td>Senha:</td>
				   <td><input type="password" name="txtsenha" id="txtsenha"
				value="" size="20"> <br /></td>
				 </tr>
				</table>
		<input type="submit" name="btsalvar" value="Salvar">

		</fieldset>


	</form>
</center>
</body>
</html>