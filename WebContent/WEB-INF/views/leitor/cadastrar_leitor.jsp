<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar-se</title>
	<style type="text/css">
		body {
        	padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      	}
	</style>
</head>
<body>
	<c:import url="../cabecalho.jsp"></c:import>
	<div class="container">
		
	<form action="cadastroLeitor" method="post">
		<fieldset>
		    <legend>Cadastre-se</legend>
		    
		    <label>Nome</label>
		    <input type="text" class="input-xxlarge" name="nome" placeholder="Nome">
		    
		    <label>Email</label>
		    <input type="text" class="input-xxlarge" name="email" placeholder="Email">
		    
		    <label>Login</label>
		    <input type="text" name="login" placeholder="Login">
		    
		    <label>Senha</label>
		    <input type="password" name="senha" placeholder="Senha"> 
		    
		    <label></label>
		    <button type="submit" class="btn">Cadastrar</button>
		</fieldset>
	</form>
		
	</div>
</body>
</html>