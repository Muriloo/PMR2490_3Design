<%-- 
    Document   : uploadnovaversao
    Created on : 20/11/2014, 14:52:40
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
	
		
					<div class="form_description">
			<h2>Opções de projeto</h2>
			<p>Faça o upload de uma nova versão do projeto, edite sua descrição ou exclua este projeto.</p>
		</div>						
			<ul >
			
					<li id="li_1" >
		<label class="description" for="element_1">Faça o upload de uma nova versão </label>
		<div>
			<input id="element_1" name="element_1" class="element file" type="file"/> 
		</div> 
		</li>
                
                <li class="buttons">
			    <input type="hidden" name="form_id" value="930200" />
			    
				<input id="enviar" class="button_text" type="submit" name="enviar" value="Enviar" />
		</li>
                <br><br>
                <li class="buttons">
                    <form method="post" action="/3Design/PáginaDoDesenvolvedor/editarprojeto.jsp">
			    
				<input id="editar" class="button_text" type="submit" name="editar" value="Editar descrição" >
                    </form>
		</li>
                <br><br>
                <li class="buttons">
                    <form method="post" action="/3Design/PáginaDoDesenvolvedor/remocaoprojeto.jsp">
			    
				<input id="excluir" class="button_text" type="submit" name="excluir" value="Excluir projeto" />
                    </form>
		</li>
			</ul>
		
        </div>
 <%@include file="../WEB-INF/footer.jsp" %>    
</body>
</html>
