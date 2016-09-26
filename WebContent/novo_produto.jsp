<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<script type="text/javascript" src="js/scripts.js"></script>
<link type="text/css" href="css/styles.css" rel="stylesheet" />

<title>Novo Produto</title>
</head>
<body>
<center>
	<!-- Validando o Campo nome para n�o permitir caracteres numericos -->
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


	<form action="IncluirProduto" name="form1">
		<table width="700" border="0">
			<tr>
				<td width="100"></td>
				<td width="400"></td>
			</tr>
			<tr>
				<td align="right">Categoria:</td>
				<td>
					<select name="categoria" >
						<option value="0">Inform�tica</option>
						<option value="1">Eletr�nica</option>
						<option value="2">Im�vel</option>
						<option value="3" selected="selected">Outros</option>
					</select>
				</td>
			</tr>
			
			
			<tr>
				<td align="right">Nome:</td>
				<td><input type="text" name="nome" onkeyup="conta(this.value)" onkeyup="validar(this,'text');"maxlength="50" type=text required name=nome
						id="nome" title="Campo Nome � de Preenchimento Obrigat�rio."><span id="cont">50</span> Restantes</td>
				
			<tr>
				<td align="right">Descri��o:</td>
				<td><input type="text" data-ls-module="charCounter" onkeyup="limite_textarea(this.value)" maxlength="100"name="descricao" maxlength="100" width="100"	
			     required name=descricao id="descricao" title="Campo Descri��o � de Preenchimento Obrigat�rio."><span id="contador">100</span> Restantes</center></td>
				
				
			</tr>
			<tr>
				<td></td>
				<td align="left">
					<input type="submit" value="Salvar" >
					<a href="listar_produto.jsp"><input type="button" value="Cancelar"></a>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>