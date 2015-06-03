<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap.css" />">
		<link rel="stylesheet" type="text/css" href="<c:url value="/bootstrap/css/bootstrap-responsive.css" />">

		<title></title>
		
	</head>
	
<body>
	 <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="paginaInicial">The Crow</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li><a href="paginaInicial">Página inicial</a></li>
              <li><a href="visualizarClassificados">Classificados</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" >Categorias<b class="caret"></b></a>
                <ul class="dropdown-menu">
                <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
     					url="jdbc:mysql://localhost/the_moon"
     					user="root"  password=""/>
                	<sql:query var="secoes" dataSource="${ds}">
    					SELECT * FROM secao
					</sql:query>
                	<c:forEach var="c" items="${secoes.rows}">
                		<li><a href="noticiasCategoria?idSecao=${c.id_secao}">${c.titulo_secao}</a></li>
                	</c:forEach>
                	
                </ul>
              </li>
            </ul>
            
           <div class="pull-right">
           <c:choose>
			<c:when test="${not empty logado}">
				<ul class="nav">
				<li class="dropdown">
       			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
            		Bem vindo, ${logado.nome}
            		<c:forEach var="funcao" items="${logado.listaFuncao}">
   						[${funcao.tituloFuncao}]
					</c:forEach>
					<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
					
						<c:forEach var="funcao" items="${logado.listaFuncao}">
						
   							<c:if test="${funcao.tituloFuncao == 'Editor' }">
   								<li class="nav-header">Editor</li>
								<li><a href="cadastroJornalistaForm">Cadastrar Jornalista</a></li>
								<li><a href="cadastroClassificadoForm">Cadastrar Classificado</a></li>
								<li><a href="cadastroCategoriaForm">Cadastrar Categoria</a></li>
								<li class="divider"></li>
   							</c:if>
   							
   							<c:if test="${funcao.tituloFuncao == 'Jornalista' }">
   								<li class="nav-header">Jornalista</li>
								<li><a href="cadastroNoticiasForm">Cadastrar Noticia</a></li>
								<li class="divider"></li>
   							</c:if>
   							
						</c:forEach>
		
					</ul>
					
				
				</li>
				</ul>
					<div class="pull-right">
            			<ul class="nav">
           					<li><a href="logout">Sair</a></li>
           				</ul>
            		</div>
            </c:when>
            <c:otherwise>
            	
            	<form class="navbar-form pull-right" action="efetuarLogin" method="post"><!-- Formulário de login -->
					<input class="span2" type="text" name="login" placeholder="login">
					<input class="span2" type="password" name="senha" placeholder="Senha">
             		<button type="submit" class="btn" >Entrar</button>
            	</form>
            	
            	<div class="pull-right">
            		<ul class="nav">
            			<li><a href="cadastroLeitorForm">Cadastre-se</a></li>
            		</ul>
            	</div>
            	
            </c:otherwise>
            </c:choose>
            </div>
             
            
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
    
    <script type="text/javascript" src="<c:url value="/bootstrap/js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/bootstrap/js/bootstrap.js" />"></script>
    
</body>
</html>