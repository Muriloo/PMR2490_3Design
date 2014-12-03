<%-- 
    Document   : novoupload
    Created on : 20/11/2014, 14:51:25
    Author     : PFA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
    <title>Upload Projeto</title>
<link rel="stylesheet" type="text/css" href="../index.css" media="all">
</head>
    
<body>
    <%@include file="../WEB-INF/header.jsp" %>
    <%if(customerId == null){
    %>
        <h2>Faça login antes de subir um projeto.</h2>
    <%
    }else{
    %>
        
	<div id="form_container">
            <%String error = request.getParameter("error");
            if(error != null){
                if(error.equals("wrongfields")){
                    %><font color=red>Favor preencher os campos corretamente.</font><%
                } else if (error.equals("erroruploading")){
                    %><font color=red>Erro ao subir projeto.</font><%
                } else if (error.equals("nofile")){
                    %><font color=red>Favor escolher um arquivo.</font><%
                } 
            }
            %>
            <form action="../UploadServlet" method="post" enctype="multipart/form-data">
		<div class="form_description">
                    <h2>Upload de novo projeto</h2>
                    <p>Escolha um arquivo em formato adequado e faça o upload do mesmo nesta página.</p>
                </div>
                <div>
                 <table width="600px">	
                    <tr id="li_1">
                        <td>
                           Nome:
                        </td>
                        <td>
                                <input id="name" name="name" class="element text medium" type="text" maxlength="400" value="" style="height:20px;width:400px"> 
                        </td> 
                    </tr>		
                    <tr id="li_2">
                        <td>Descri&ccedil;&atilde;o: </td>
                        <td>
                           <input id="description" name="description" class="element text large" type="text" maxlength="400" value="" style="height:20px;width:400px"> 
                        </td> 
                    </tr>
                    <tr id="li_3">
                        <td>Coment&aacute;rios: </td>
                        <td>
                         <textarea id="comments" name="comments" class="element textarea large"  value=""
                                   style="height:100px;width:400px "></textarea>
                        </td>
                    </tr>
                   
                    </table>
                    <br><hr width="600px" align="left">
                    <table >
                    <tr>
                        <td>Escolha um arquivo de até 50Mb para fazer upload. Os formatos aceitos X3D</td>
                    </tr> 
                    
                    <tr style="border-top:1px solid">
                            <td ><input id="projectFile" name="projectFile" class="element file" type="file"> </td>
                    </tr> 
                    </table>
                    <br><hr width="600px" align="left">
                    <table>
                    <tr>
                        <td>Escolha at&eacute; 3 imagens para seu projeto </td> 
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
                     </table>
                    <hr width="600px" align="left">
                    <table>
                        <tr>
                        <td><p class="guidelines" id="guide_6">Escolha o valor que você deseja receber por cada unidade vendida do seu projeto.</p></td>
                    </tr>
                    <tr id="li_6">
                    <td>Pre&ccedil;o: <input id="price" name="price" class="element text currency" size="10" value="" type="text"> Reais
                    </td>
                    </tr>
                    <tr><td>&nbsp;</td></tr>
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
