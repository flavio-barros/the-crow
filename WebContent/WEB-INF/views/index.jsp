<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css" />">
<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css" />">
<style type="text/css">
	body{
		padding-top: 60px;
	}
</style>
<title>The Crow</title>
</head>
<body>

	<c:import url="cabecalho.jsp"></c:import>
	
	<div class="container">
	
		<c:forEach var="s" items="${secoes}">
		
			<legend>${s.tituloSecao}</legend>
		
			<c:forEach var="n" items="${s.noticias}">
			
				<div class="span5">
				
					<h3>${n.tituloNoticia}</h3>
					<p>${n.subtituloNoticia}</p>
					<p><a class="btn" href="visualizarNoticia?idNoticia=${n.idNoticia}">Ver mais</a></p>
					<c:forEach var="funcao" items="${logado.listaFuncao}">
						<c:if test="${funcao.tituloFuncao == 'Editor' }">
   							<p><a class="btn btn-inverse" href="apagarNoticiaPI?idNoticia=${n.idNoticia}&idSecao=${secao.idSecao}">Apagar</a></p>
   						</c:if>
   						<c:if test="${funcao.tituloFuncao == 'Jornalista' && n.autor.idUsuario == logado.idUsuario}">
   							<p><a class="btn btn-inverse" href="apagarNoticiaPI?idNoticia=${n.idNoticia}&idSecao=${secao.idSecao}">Apagar</a></p>
   						</c:if>
					</c:forEach>
				</div>
			
			</c:forEach>
		
		</c:forEach>
	
	</div>

</body>
</html>