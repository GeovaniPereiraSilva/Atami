<%@page import="Entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/styles.css" rel="stylesheet" />

<title>Login</title>
</head>
<body>
<%@include file="includes/menu.jsp" %>

<% Usuario usu=  (Usuario) request.getAttribute("usu"); 
	if(usu.getId()!=null && usu.getId()>0) {
%>
<h1>Alterado com sucesso!</h1>

<% } else { %>
<h1>Cadastrado com sucesso</h1>
	
<%} %>

</body>
</html>