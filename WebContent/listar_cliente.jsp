<%@ page import="java.util.List"%>
<%@ page import="Dao.DAOClienteImpl"%>
<%@ page import="Entidades.Cliente"%>
<%@ page import="Dao.DAOCliente"%>
<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />
<title>Lista de Clientes</title>
</head>
<body>
<center>
	<table width="550" cellspacing="0" id="mytable" class="CSSTableGenerator">
	
     	<tr>
            <td><b>Código</b></td>
            <td><b>Tipo</b></td>
            <td><b>Nome</b></td>
            <td><b>Telefone</b></td>
            <td></td>
            <td></td>
        </tr>
        <%
        	String dtString = null;
                        	DAOCliente dao = new DAOCliente();
                            List<Cliente> lista = dao.listarClientes();
                            for(Cliente cliente : lista){
        %>
        <tr>
            <td><%= cliente.getCodigo() %></td>
            <td><%= cliente.getCategoriaFormatada() %></td>
            <td><%= cliente.getNome() %></td>
            <td><%= cliente.getTelefone() %></td>
            <td><% out.print("<a href='alterar_cliente.jsp?codigo=" + cliente.getCodigo()+ "&categoria="+cliente.getCategoriaFormatada()+ "&idCategoria="+cliente.getCategoria() + "&nome="+cliente.getNome()+"&telefone="+cliente.getTelefone()+"'>Alterar</a>"); %></td>
            <td><% out.print("<a href='excluir_cliente.jsp?codigo=" + cliente.getCodigo()+ "&categoria="+cliente.getCategoriaFormatada()+ "&idCategoria="+cliente.getCategoria() + "&nome="+cliente.getNome()+"&telefone="+cliente.getTelefone()+"'>Excluir</a>"); %></td>
        </tr>
        <%
          }
        %>
	</table>	
	<table width="700" border="0">
		<tr>
			<td align="center">
				<a href="index.jsp"><input type="button" value="Inicial" class="button"></a>
				<a href="novo_cliente.jsp"><input type="button" value="Novo" class="button"></a>
			</td>
		</tr>
	</table>	
	</center>
</body>
</html>