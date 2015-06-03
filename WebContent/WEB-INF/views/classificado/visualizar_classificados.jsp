<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{
		padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
	}
</style>
<title>Classificados</title>
</head>
<body>
	<c:import url="../cabecalho.jsp"></c:import>
	
	<div class="container">
	
		<div class="row">
			<c:forEach var="c" items="${classificados}">
			
				<div class="span4">
					<h2>${c.tituloClassificado}</h2>
					<p><b>Preço Inicial: </b>R$ ${c.precoInicial}</p>
					<p><a class="btn" href="detalhesClassificados?idClassificado=${c.idClassificado}">Ver mais</a></p>
				</div>
			
			</c:forEach>
		</div>
	
	</div>
</body>
</html>