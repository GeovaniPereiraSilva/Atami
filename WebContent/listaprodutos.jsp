<%@ page import="java.util.List"%>
<%@ page import="Dao.DAOProdutoImpl"%>
<%@ page import="Entidades.Produto"%>
<%@ page import="Dao.ProdutoDAO"%>
<%@ page language="java" contentType="text/html;" pageEncoding="iso-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />
<title>Lista de Produtos</title>
</head>
<body>
<center>
	<table width="550" cellspacing="0" id="mytable">
	
     	<tr>
            <td><b>Código</b></td>
            <td><b>Categoria</b></td>
            <td><b>Nome</b></td>
            <td><b>Descrição</b></td>
            <td></td>
            <td></td>
        </tr>
        <%
        	String dtString = null;
                        	ProdutoDAO dao = new DAOProdutoImpl();
                            List<Produto> lista = dao.listarProdutos();
                            for(Produto produto : lista){
        %>
        <tr>
            <td><%= produto.getCodigo() %></td>
            <td><%= produto.getCategoriaFormatada() %></td>
            <td><%= produto.getNome() %></td>
            <td><%= produto.getDescricao() %></td>
            <td><% out.print("<a href='alterar_produto.jsp?codigo=" + produto.getCodigo() + "&categoria="+produto.getCategoriaFormatada() + "&idCategoria="+produto.getCategoria() + "&nome="+produto.getNome() + "&descricao="+produto.getDescricao() +"'>Alterar</a>"); %></td>
            <td><% out.print("<a href='excluir_produto.jsp?codigo=" + produto.getCodigo() + "&categoria="+produto.getCategoriaFormatada() + "&idCategoria="+produto.getCategoria()+"&nome="+produto.getNome() +	"&descricao=" +produto.getDescricao() +"'>Excluir</a>"); %></td>
        </tr>
        <%
            }
        %>
	</table>	
	<table width="701" border="0">
		<tr>
			<td align="center">
				<a href="index.jsp"><input type="button" value="Inicial"></a>
				<a href="novo_produto.jsp"><input type="button" value="Novo"></a>
			</td>
		</tr>
	</table>	
	</center>
</body>
</html>