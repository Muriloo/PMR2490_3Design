<%-- 
    Document   : novoupload
    Created on : 20/11/2014, 14:51:25
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
	
		<form id="form_930200" class="appnitro" enctype="multipart/form-data" method="post" action="">
					<div class="form_description">
			<h2>Upload de novo projeto</h2>
			<p>Escolha um arquivo em formato adequado e faça o upload do mesmo nesta página.</p>
		</div>						
			<ul >
			
					<li id="li_1" >
		<label class="description" for="element_1">Faça o upload de um arquivo de seu computador </label>
		<div>
			<input id="element_1" name="element_1" class="element file" type="file"/> 
		</div> 
		</li>
			<br><br>
					<li class="buttons">
			    <input type="hidden" name="form_id" value="930200" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Enviar" />
		</li>
			</ul>
		</form>
        </div>
    
<%@include file="../WEB-INF/footer.jsp" %>       
    
</body>
</html>
