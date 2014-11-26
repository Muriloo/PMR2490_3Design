<%-- 
    Document   : remocaoprojeto
    Created on : 20/11/2014, 15:43:01
    Author     : PFA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
<link rel="stylesheet" type="text/css" href="index.css" media="all">
</head>
    
<body>
    
<%@include file="../WEB-INF/header.jsp" %>    
    
    
    
    
    <div id="form_container">
	
		<h1><a>Página de exclusão de projeto</a></h1>
		
					<div class="form_description">
			
			<p>Você deseja realmente excluir este projeto?</p>
		</div>	
                    <ul >
			
					<li class="buttons">
			    <input type="hidden" name="form_id" value="933363" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Confirmar" />
		</li>
                <br><br>
                <li class="buttons">
                    <form method="post" action="/3Design/PaginaDoDesenvolvedor/uploadnovaversao.jsp">
			    
				<input id="cancelar" class="button_text" type="submit" name="cancelar" value="Cancelar" />
                    </form>
		</li>
			</ul>

<%@include file="../WEB-INF/footer.jsp" %>    
        
    
</body>
</html>
