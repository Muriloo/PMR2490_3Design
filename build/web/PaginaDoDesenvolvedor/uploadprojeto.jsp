<%-- 
    Document   : novoupload
    Created on : 20/11/2014, 14:51:25
    Author     : PFA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
<link rel="stylesheet" type="text/css" href="../index.css" media="all">
</head>
    
<body>
    <%@include file="../WEB-INF/header.jsp" %>
    <%if(customerId != null){
    %>
        <h2>Faça login antes de subir um projeto.</h2>
    <%
    }else{
    %>
        
	<div id="form_container">
	
            <form action="../UploadServlet" method="post" enctype="multipart/form-data">
		<div class="form_description">
                    <h2>Upload de novo projeto</h2>
                    <p>Escolha um arquivo em formato adequado e faça o upload do mesmo nesta página.</p>
                </div>
                <div>
                 <table width="600px">	
                    <tr id="li_1">
                        <td>
                            <label class="description" for="element_1">Nome: </label>
                        </td>
                        <td>
                                <input id="name" name="name" class="element text medium" type="text" maxlength="255" value=""> 
                        </td> 
                    </tr>		
                    <tr id="li_2">
                        <td><label class="description" for="element_2">Descri&ccedil;&atilde;o: </label></td>
                        <td>
                           <input id="description" name="description" class="element text large" type="text" maxlength="255" value=""> 
                        </td><p class="guidelines" id="guide_2"><small>Insira uma breve descri&ccedil;&atilde;o sobre o projeto</small></p> 
                    </tr>				
                    <tr id="li_3">
                        <td><label class="comments" for="element_3">Coment&aacute;rios: </label></td>
                        <td>
                         <textarea id="comments" name="comments" class="element textarea large"  value=""
                                   style="height:80px;width:400px "></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        <p class="guidelines" id="guide_3"><small>Coloque todas as observa&ccedil;&otilde;es desejadas.</small></p> 
                    </td>    
                    </tr>		
                    <tr id="li_4">
                    <td><label class="description" for="element_4">Escolher Arquivo </label></td>
                    <tr>
                            <td colspan="2"><input id="projectFile" name="projectFile" class="element file" type="file"> </td>
                    </tr> 
                    <tr>
                        <td colspan="2"><p class="guidelines" id="guide_4"><small>Escolha um arquivo de até 50Mb para fazer upload. Os formatos aceitos são bla,bla,bla,bla,bla,bla,bla</small></p></td>
                    </tr> 
                    
                    
                    <tr id="li_5">
                        <td><input id="image1" name="image" class="element file" type="file"></td>
                    </tr>    
                    <tr id="li_5_1">
                        <td><input id="image2" name="image" class="element file" type="file"></td>
                    </tr>
                    <tr id="li_5_2">
                        <td><input id="image3" name="image" class="element file" type="file"></td>
                    </tr>                        
                    <tr>
                        <td><label class="description" for="element_5">Escolha at&eacute; 3 imagens para seu projeto </label></td> 
                    </tr>    
                    <tr>
                        <td><p class="guidelines" id="guide_5"><small>Imagens de até 500Kb.</small></p> </td>
                    </tr>	
                    
                    <tr id="li_6">
                    <td><label class="price" for="element_6">Pre&ccedil;o </label></td>
                    <td><span class="symbol">R$</span>
                    <span>
                            <input id="price" name="price" class="element text currency" size="10" value="" type="text"> .		
                            <label for="element_6_1">Reais</label>
                    </span></td>
                    
                    </tr>
                    <tr>
                        <td><p class="guidelines" id="guide_6"><small>Escolha o valor que você deseja receber por cada unidade vendida do seu projeto.</small></p></td>
                    </tr>
                    
                    
                    <br><br>
                    <tr class="buttons"><td>
                        <input type="hidden" name="upload" value="upload" />
                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Enviar" />
                    </td></tr>
                </table>
                </div>
            </form>
        </div>
        
 <%}%>  
<%@include file="../WEB-INF/footer.jsp" %>       
    
</body>
</html>
