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
<title>${classificado.tituloClassificado}</title>
</head>
<body>
	<c:import url="../cabecalho.jsp"></c:import>
	
	<div class="container">
	
		<div class="page-header">
			<h1>${classificado.tituloClassificado}</h1>
		</div>
		<p>${classificado.textoClassificado}</p>
		<p><b>Preço Inicial: </b>R$ ${classificado.precoInicial}</p>
		<p><b>Telefone: </b>${classificado.telefone}</p>
		
		<div class="hero-unit">
			<c:choose>
				<c:when test="${not empty melhorOferta}">
					<p><b>Melhor Oferta:</b> R$ ${melhorOferta.valor}</p>
					<p>Por: ${melhorOferta.usuario.nome}</p>
				</c:when>
				<c:otherwise>
					<p>Ainda não foram realizadas ofertas</p>
				</c:otherwise>
			</c:choose>
		</div>
		<form action="cadastroOferta" method="post">
			<input type="hidden" name="usuario.idUsuario" value="${logado.idUsuario}">
			<input type="hidden" name="classificado.idClassificado" value="${classificado.idClassificado}">
			<div class="input-append">
				<input class="span2" id="appendedInputButton" type="text" name="valor">
				<button class="btn" type="submit">Fazer oferta</button>
			</div>
		</form>
	</div>
</body>
</html>