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
        <%if (request.getParameter("upload") != null) {
            
           
            System.out.print("fez a request");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String comments = request.getParameter("comments");
            Part file = request.getPart("file");
            String images = request.getParameter("images");
            String price_str = request.getParameter("price");
            float price = 0;
            boolean result = false;
            
            System.out.print("file:"+file);
            try {
                if (!utils.MetodosUteis.isEmpty(price_str)){
                    price = Float.valueOf(price_str).floatValue();                    
                }
                project.projectDO project = new project.projectDO(name, description, comments, price, "");
                project.versionDO version = new project.versionDO();
                if(file.getSize() > 0){
                    version.setFile(file.getInputStream());
                }
                
                transaction.UploadProject upProject = new transaction.UploadProject();
                try {
                    result = upProject.uploadProject(project, version);
                } catch (Exception e){
                    %>
                    Erro na hora de inserir o projeto favor tentar novamente!;
                    <%
                }
            } catch (NumberFormatException e){
                %>
               <div style="color: red;">Favor inserir valor de preço usando ponto para separar casas decimais.</div>
                <%
            }
            //FileInputStream	inputStream = new FileInputStream(image);
			//convert image
            //byte imageData[] = new byte[(int) image.length()];
            //inputStream.read(imageData);
            //inputStream.close();
        	//System.out.print("\n\n(SimulatingImageAgent) - imagedata:"+imageData.toString());
			//declare test variables
            if (result) {
            %>
            <div style="color:green;">Projeto inserido com sucesso!</div>
             <%
            } else {
            %>
             <div style="color:red;">Projeto não inserido. Favor preencher todos os campos adequadamente.</div>
             <%    
            }
        }
         %>           
        
	<div id="form_container">
	
            <form action="../UploadProjectServlet" method="post" enctype="multipart/form-data">
		<div class="form_description">
                    <h2>Upload de novo projeto</h2>
                    <p>Escolha um arquivo em formato adequado e faça o upload do mesmo nesta página.</p>
                </div>						
                 <ul>	

                    <li id="li_1">
                    <label class="description" for="element_1">Nome: </label>
                    <div>
                            <input id="name" name="name" class="element text medium" type="text" maxlength="255" value=""> 
                    </div> 
                    </li>		
                    <li id="li_2">
                    <label class="description" for="element_2">Descri&ccedil;&atilde;o: </label>
                    <div>
                            <input id="description" name="description" class="element text large" type="text" maxlength="255" value=""> 
                    </div><p class="guidelines" id="guide_2"><small>Insira uma breve descri&ccedil;&atilde;o sobre o projeto</small></p> 
                    </li>		
                    <li id="li_3">
                        <label class="comments" for="element_3">Coment&aacute;rios: </label>
                    <div>
                            <textarea id="comments" name="comments" class="element textarea large"  value=""
                                   style="height:80px;width:400px "></textarea>
                    </div><p class="guidelines" id="guide_3"><small>Coloque todas as observa&ccedil;&otilde;es desejadas.</small></p> 
                    </li>		
                    <li id="li_4">
                    <label class="description" for="element_4">Escolher Arquivo </label>
                    <div>
                            <input id="file" name="file" class="element file" type="file"> 
                    </div> <p class="guidelines" id="guide_4"><small>Escolha um arquivo de até 50Mb para fazer upload. Os formatos aceitos são bla,bla,bla,bla,bla,bla,bla</small></p> 
                    </li>		
                    <li id="li_5">
                    <label class="description" for="element_5">Escolha at&eacute; 3 imagens para seu projeto </label>
                    <div>
                            <input id="images" name="images" class="element file" type="file"> 
                    </div> <p class="guidelines" id="guide_5"><small>Imagens de até 500Kb.</small></p> 
                    </li>		
                    <li id="li_6">
                    <label class="price" for="element_6">Pre&ccedil;o </label>
                    <span class="symbol">R$</span>
                    <span>
                            <input id="price" name="price" class="element text currency" size="10" value="" type="text"> .		
                            <label for="element_6_1">Reais</label>
                    </span>
                    
                    <p class="guidelines" id="guide_6"><small>Escolha o valor que você deseja receber por cada unidade vendida do seu projeto.</small></p> 
                    </li>
                    
                    <br><br>
                    <li class="buttons">
                        <input type="hidden" name="upload" value="upload" />
                        <input id="saveForm" class="button_text" type="submit" name="submit" value="Enviar" />
                    </li>
                </ul>
            </form>
        </div>
        
    
<%@include file="../WEB-INF/footer.jsp" %>       
    
</body>
</html>
