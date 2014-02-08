<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@page import="br.com.caelum.jdbc.dao.DAOException"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://displaytag.sf.net" prefix="display" %>
    <c:import url="cabecalho.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista Contatos Elegante</title>
</head>
<body>

<!-- cria a DAO -->
<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao"></jsp:useBean>

<table>
<tr>
 <td>Nome</td>
 <td>Email</td>
 <td>Endereço</td>
 <td>Data Nascimento</td>
 </tr>
<!-- percorre contatos montando as linhas da table -->
<c:forEach var="contato" items="${dao.lista }">
<tr>
  <td>${contato.nome }</td>
  <c:choose>
  <c:when test="${not empty contato.email }">
  <td><a href="malito:${contato.email}">${contato.email }</a></td>
  </c:when>
  <c:otherwise>
  <td>	Email não informado!</td>
  </c:otherwise>
  </c:choose>
  <td>${contato.endereco }</td>
  <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
</tr>
 </c:forEach>
 <tr>
</tr>
</table>

<c:import url="rodape.jsp"></c:import>
</body>
</html>