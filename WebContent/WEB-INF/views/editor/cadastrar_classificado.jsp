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
<title>Cadastrar Classificado</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>
	
	<div class="container">
		
	<form action="cadastroClassificado" method="post">
		<fieldset>
		    <legend>Cadastrar Classificado</legend>
		    
		    <label>Nome</label>
		    <input type="text" class="input-xxlarge" name="tituloClassificado" placeholder="Titulo do Classificado">
		    
		    <label>Email</label>
		    <textarea rows="3" name="textoClassificado" placeholder="Descrição do Classificado" class="input-xxlarge"></textarea>
		    
		    <label>Valor</label>
		    <input type="text" name="precoInicial" placeholder="Preço inicial">
		    
		    <label>Telefone de contato</label>
		    <input type="text" name="telefone" placeholder="Telefone de contato"> 
		    
		    <label></label>
		    <button type="submit" class="btn">Cadastrar</button>
		</fieldset>
	</form>
		
	</div>

</body>
</html>