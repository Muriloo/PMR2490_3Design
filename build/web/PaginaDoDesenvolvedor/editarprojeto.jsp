<%-- 
    Document   : editarprojeto
    Created on : 20/11/2014, 15:14:57
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
    
    <div class="form_description">
			<h2>Edição de projeto</h2>
			<p>Edite aqui as informações básicas do seu projeto!.</p>
		</div>						
			<ul >
			
					<li id="li_1" >
		<label class="description" for="element_1">Nome do projeto </label>
		<div>
			<input id="element_1" name="element_1" class="element text medium" type="text" maxlength="255" value=""/> 
		</div> 
                                        </li>	<br>	<li id="li_2" >
		<label class="description" for="element_2">Versão </label>
		<div>
			<input id="element_2" name="element_2" class="element text small" type="text" maxlength="255" value=""/> 
		</div> 
		</li>	<br>	<li id="li_1" >
		<label class="description" for="element_1">Descrição do produto </label>
		<div>
			<textarea id="element_1" name="element_1" class="element textarea large"></textarea> 
		</div> 
		</li> <br>
		<li id="li_4" >
		<label class="description" for="element_4">Preço </label>
		<div>
			<input id="element_4" name="element_4" class="element text small" type="text" maxlength="255" value=""/> 
		</div> 
		</li>
			<br>
					<li class="buttons">
			    <input type="hidden" name="form_id" value="933363" />
			    
				<input id="saveForm" class="button_text" type="submit" name="submit" value="Enviar" />
		</li>
			</ul>
		</form>	
	</div>

        <%@include file="../WEB-INF/footer.jsp" %>    
    
</body>
</html>
