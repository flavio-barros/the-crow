<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{
		padding-top: 60px;
	}
</style>
<title>${noticia.tituloNoticia}</title>
</head>
<body>
	
	<c:import url="../cabecalho.jsp"></c:import>
	
	<div class="container">
		<div class="span8">
			<h1>${noticia.tituloNoticia}</h1>
			<h5>${noticia.subtituloNoticia}</h5>
			<p>${noticia.textoNoticia}</p>
			<p>Escrito por: ${noticia.autor.nome}</p>
		</div>
	</div>
</body>
</html>