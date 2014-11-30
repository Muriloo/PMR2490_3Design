<%-- 
    Document   : remocaoprojeto
    Created on : 20/11/2014, 15:43:01
    Author     : Yuji
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
	
		<h1><a>Página de exclusão de Usuário</a></h1>
		
					<div class="form_description">
			
			<p>Você deseja realmente excluir este usuário?</p>
		</div>	
                    <ul >
			

			    <input type="hidden" name="form_id" value="933363" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Confirmar" />

                                <br><br>
                    <form method="post" action="/3Design/PáginaDoDesenvolvedor/uploadnovaversao.jsp">
			    
				<input id="cancelar" class="button_text" type="submit" name="cancelar" value="Cancelar" />
                    </form>
			</ul>

<%@include file="../WEB-INF/footer.jsp" %>    
        
    
</body>
</html>