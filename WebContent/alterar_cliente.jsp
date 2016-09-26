<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery.maskedinput-1.2.2.js"></script>
<link type="text/css" href="css/styles.css" rel="stylesheet" />
<title>Alterar Cliente</title>
</head>
<body>
<center>
<script>
function numero(evtKeyPress)
{
    var nTecla = 0;
    if (document.all) {
        nTecla = evtKeyPress.keyCode;
    } else {
        nTecla = evtKeyPress.which;
    }
    if ((nTecla > 47 && nTecla < 58)
    || nTecla == 8 || nTecla == 127
    || nTecla == 0 || nTecla == 9  // 0 == Tab
    || nTecla == 13) { // 13 == Enter
        return true;
    } else {
    	alert('O campo Telefone deve contêr somente números');

        return false;
    }
}
</script>
	<!-- Validando o Campo nome para não permitir caracteres numericos -->
<script>
function validar(dom,tipo){
	switch(tipo){
		case'num':var regex=/[A-Za-z]/g;break;
		case'text':var regex=/\d/g;break;
	}
	dom.value=dom.value.replace(regex,'');
}	
	</script>
<!-- Contador de Numeros restantes que sao inseridos no campo nome -->
<script>
function limite_textarea(valor) {
    quant = 50;
    total = valor.length;
    if(total <= quant) {
        resto = quant - total;
        document.getElementById('cont').innerHTML = resto;
    } else {
        document.getElementById('texto').value = valor.substr(0,quant);
    }
}
</script>

	<script type="text/javascript">
			</script>
	<form action="AlteraCliente">
		<table width="550" border="0">
			<tr>
				<td width="150"></td>
				<td width="400"></td>
			</tr>
			<tr>
				<td align="right">Código:</td>
				<td><input type="text" name="codigo" value="<%=request.getParameter("codigo") %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td align="right">Tipo:</td>
				<td><input type="text" name="categoria" value="<%=request.getParameter("categoria") %>" readonly="readonly"></td>
					<input type="hidden" name="idCategoria" value="<%=request.getParameter("idCategoria") %>">
			</tr>
			<tr>
				<td align="right">Nome:</td>
				<td><input maxlength="50" type="text" name="nome" onkeyup="limite_textarea(this.value)" id="texto" onkeyup="validar(this,'text');" required name=nome value="<%=request.getParameter("nome") %>"
								id="nome" title="Nome do Cliente Obrigatório."><span id="cont">50</span> Caracteres Restantes <br></td>
			</tr>
			<tr>
				<td align="right">Telefone:</td>
			<td><input type="numbers" onkeypress="return numero(event);"maxlength="15" required name=telefone value="<%=request.getParameter("telefone") %>" id="telefone"
				></td>
		
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