<%-- 
    Document   : index
    Created on : 24-nov-2009, 11:28:37
    Author     : sanpedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>  <!importando libraria SQL do JAVA>

<html>
    <head>
        
        <link rel="stylesheet" type="text/css" href="view.css" media="all">
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
        <script type="text/javascript" src="view.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>HomePage</title>

    </head>

    <body>
        <!conteudo HTML para gerar o formulário. gerado automaticamente no site http://www.phpform.org>
        <%@include file="WEB-INF/header.jsp" %>
        
    
        <div id="page">
            <div id="nav">
                Coisa 3D<br>
                Mais uma coisa 3D<br>
                Such 3D!<br> 
                
                <% 
                if (user_permission_id != null) {
                    if(user_permission_id.equals("2")) { %>
                    <a href="./paginadomoderador.jsp">Pagina do Moderador</a><br>               
                    <a href="./projects.jsp">Lista de Todos Projetos</a><br>               
                    <a href="./user-list.jsp">Listar usuários</a><br>
                    <a href="./PaginaDoDesenvolvedor/uploadprojeto.jsp">Subir Projeto</a>
                     
                     <%    }
                    else { %>             
                     
                    <a href="./projects.jsp">Lista de Todos Projetos</a><br>               
                    <a href="./user-list.jsp">Listar usuários</a><br>
                    <a href="./PaginaDoDesenvolvedor/uploadprojeto.jsp">Subir Projeto</a>
                     <% } 
                }%>   
            </div>
               
            <div id="section">
                <h2>Olha qu&atilde;o 3D est&aacute; isso!</h2>
                <p>
                    Sim, estamos 3D, esse texto fala sobre 3D por que queremos somentes coisas 3D,
                    uma vez que estudos mostram que coisas 2D nao sao legais.
                </p>
                <p>
                    Entao vamos agora falar sobre mais coisas 3D por que ali em cima n&atilde;o falamos o suficiente,
                    e se voce ler direito, da pra ver que as letras est&atilde;o 3D tamb&eacute;m.
                    Se voce for ainda mais inteligente vai perceber que a ultima frase &eacute; zuera
                </p>
            </div>                
        </div>
            
         <%@include file="WEB-INF/footer.jsp" %>
    </body>
    
</html>
