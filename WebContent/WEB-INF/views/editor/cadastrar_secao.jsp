<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
		body {
        	padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      	}
</style>

<title>Cadastrar Categoria</title>
</head>
<body>
	<c:import url="../cabecalho.jsp"></c:import>
	
	<div class="container">
		
	<form action="cadastroCategoria" method="post">
		<fieldset>
		    <legend>Cadastrar Categoria</legend>
		    
		    <label>Login</label>
		    <input type="text" name="tituloSecao" placeholder="Titulo da Categoria">
		    
		    <label>Senha</label>
		   	<textarea rows="3" name="descricaoSecao" placeholder="Descrição da Categoria" class="input-xxlarge"></textarea>
		    
		    <label></label>
		    <button type="submit" class="btn">Cadastrar</button>
		</fieldset>
	</form>
	
	<legend>Categorias Cadastradas</legend>
	
	<table class="table table-striped">
		
		<thead>
			
			<tr>
				<th class="span3">Titulo</th>
				<th class="span9">Descrição</th>
			</tr>
		
		</thead>
		<tbody>
			
			
				<c:forEach var="s" items="${secoes}">
					<tr>
						<td>${s.tituloSecao}</td>
						<td>${s.descricaoSecao}</td>
					</tr>
				</c:forEach>
				
		</tbody>
	
	
	</table>
		
	</div>

</body>
</html>