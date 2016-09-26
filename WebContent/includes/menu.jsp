<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Entidades.Usuario"%>
<%@page import="java.util.List"%><html>
<head>
<title>Atami</title>
<style type="text/css">
.rodape {
   position:absolute;
   bottom:0;
   width:100%;
   height:30px;
   background:black;
}
</style>
</head>
<body>
	<div id="tudo">
	<div id="tudo">
	<div id="cabecalho">
<img src="http://atami.com.br/images/logo.jpg" align="middle">
	</div>
		</div> 
			</div>
				<div id="conteudo">
					
					<b>Seja Bem vindo 
					
					<% 
						Usuario usuAutenticado =  (Usuario)session.getAttribute("usuAutenticado");
						out.print(usuAutenticado.getNome());
					%>
					
					!</b>	
				</div>
	
	<link type="text/css" href="css/menu.css" rel="stylesheet"/>
	<div id="menu">
	<ul>
    <li><a href="index.jsp">Inicio</a></li>| 
	<li><a href="usucontroller.do?acao=lis">Usuários</a></li> |
	<li><a href="prodcontroller.do?acao=lis">Produtos</a></li> | 
	<li><a href="cliecontroller.do?acao=lis">Clientes</a></li> | 
	<li><a href="autenticador.do">Sair</a></li>
	</ul>

<div class="rodape">Copyright 2015 - Atami Forros e Divissórias.</div>
      	</div>
</body>
</html>