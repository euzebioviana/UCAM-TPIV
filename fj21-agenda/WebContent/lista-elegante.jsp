<%@page import="br.com.caelum.jdbc.dao.ContatoDao"%>
<%@page import="br.com.caelum.jdbc.dao.DAOException"%>
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

<display:table ></display:table>
<display:column></display:column>



<c:import url="rodape.jsp"></c:import>
</body>
</html>