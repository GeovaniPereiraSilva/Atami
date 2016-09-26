<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />
<title>Alterar Produto</title>
</head>
<body>
<center>
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
    quant = 100;
    total = valor.length;
    if(total <= quant) {
        resto = quant - total;
        document.getElementById('contador').innerHTML = resto;
    } else {
        document.getElementById('texto').value = valor.substr(0,quant);
    }
}
</script>

<script>
function conta(valr) {
    sobra = 50;
    total = valr.length;
    if(total <= sobra) {
        resto = sobra - total;
        document.getElementById('cont').innerHTML = resto;
    } else {
        document.getElementById('texto').value = valr.substr(0,sobra);
    }
}
</script>


	<form action="AlterarProduto">
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
				<td align="right">Categoria:</td>
				<td><input type="text" name="categoria" value="<%=request.getParameter("categoria") %>" readonly="readonly">
				<input type="hidden" name="idCategoria" value="<%=request.getParameter("idCategoria") %>">
				</td>
			</tr>
			<tr>
				<td align="right">Nome:</td>
				<td><input maxlength="50" type="text" name="nome" onkeyup="conta(this.value)" onkeyup="validar(this,'text');" value="<%=request.getParameter("nome") %>"
						required name=nome id="nome" title="Campo Nome é de Preenchimento Obrigatório.">
						<span id="cont">50</span> Restantes<br></td>
				
			</tr>
			<tr>
				<td align="right">Descrição:</td>
				<td><input maxlength="100" type="text" onkeyup="limite_textarea(this.value)" name="descricao" value="<%=request.getParameter("descricao") %>"
						required name=descricao id="descricao" title="Descrição do Produto é de Preenchimento Obrigatório.">
							<span id="contador">100</span> Restantes<br></td>
	
				</tr>
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" value="Salvar">
					<a href="listar_produto.jsp"><input type="button" value="Cancelar"></a>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>