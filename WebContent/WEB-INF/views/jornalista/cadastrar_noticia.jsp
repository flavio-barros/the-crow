<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body {
		padding-top: 60px;
	}
</style>
<title>Cadastrar Noticia</title>
</head>
<body>

	<div class="container">
	
	<c:import url="../cabecalho.jsp"></c:import>
		
	<form action="cadastroNoticias" method="post">
		<fieldset>
		    <legend>Cadastrar Jornalista</legend>
		    
		    <label>Titulo</label>
		    <input type="text" class="input-xxlarge" name="tituloNoticia" placeholder="Titulo da noticia">
		    
		    <label>Subtitulo</label>
		    <input type="text" class="input-xxlarge" name="subtituloNoticia" placeholder="Subtitulo da noticia">
		    
		    <label>Texto</label>
		   	<textarea rows="10" name="textoNoticia" placeholder="Texto da noticia" class="input-xxlarge"></textarea>
		    
		    <label>Seção</label>
		    <select name="secao.idSecao">
		    	<c:forEach var="sec" items="${secoes}">
		    		<option value="${sec.idSecao}">${sec.tituloSecao}</option>
		    	</c:forEach>
		    </select>
		 	
		 	<input type="hidden" name="autor.idUsuario" value="${logado.idUsuario}">
		 	
		    <button type="submit" class="btn">Cadastrar</button>
		</fieldset>
	</form>
		
	</div>

</body>
</html>