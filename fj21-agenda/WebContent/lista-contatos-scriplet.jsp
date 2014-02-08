<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contatos</title>
</head>
<body>

<%@page import="java.util.*,
				java.text.*,
				br.com.caelum.jdbc.dao.*, 
				br.com.caelum.jdbc.modelo.*"%>
				
				
<table>
  <%
  ContatoDao contatoDao = new ContatoDao();
  List<Contato> contatos = contatoDao.getLista();
  
  for(Contato contato : contatos){
  %>
  <tr>
  		<td><%=contato.getNome()%></td>
  		<td><%=contato.getEmail() %></td>
  		<td><%=contato.getEndereco() %></td>
  		<td><%=contato.getDataNascimento().getTime() %></td>
  </tr>
  <%
  }
  %>
  		
</table>

</body>
</html>