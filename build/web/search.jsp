<%-- 
    Document   : searchProject
    Created on : 26/11/2014, 11:03:07
    Author     : Marcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Resultados</title>
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
    </head>

    <body>
        
<!--------------------Header--------------------------------------------------->
<%@include file="WEB-INF/header.jsp" %>
<div id="page">
<div id="nav">
Coisa 3D<br>
Mais uma coisa 3D<br>
Such 3D!<br> 
<a href="./pending-projects.jsp">Projetos Pendentes</a><br> 
<a href="./projects.jsp">Lista de Todos Projetos</a><br>               
<a href="./user-list.jsp">Listar usuários</a><br>
<a href="./PaginaDoDesenvolvedor/uploadprojeto.jsp">Subir Projeto</a>
</div>
<div id="section">
       
<!-------------Fim do Header--------------------------------------------------->
        

                <%@ page import="java.util.Vector" %>
                <%@ page import="search.searchProject" %>
                <%@ page import="project.projectInfoDO" %>
                <%@ page import="project.userInfoDO" %>
                <%@ page import="search.searchUser" %>

                <%            String keyword = request.getParameter("keyword");
                    keyword = keyword.toUpperCase();
                %>

                <h4>Resultados encontrados para o termo: "<%=keyword%>"</h4>     

<!--------------------------------Search Projects------------------------------------------------>
                <%
                    search.searchProject tn = new search.searchProject();
                    Vector searchResults = tn.getResults(keyword);
                    session.setAttribute("vector", searchResults);
                    
                    if ((searchResults == null)|| (searchResults.size() == 0)) {
                        // avisar usuario que nao ha' contatos com este nome
                %>
                <h3>Projetos encontrados: Nenhum.</h3>

                <%
                } //if nenhum resultado 
                else {
                %> 
               <h3>Projetos encontrados:</h3>
                <table BORDER="1">
                    <tr>
                        <td>Nome do projeto</td>
                        <td>preço</td>
                        <td>Descrição</td>
                        <td>Desenvolvedor</td>
                    </tr>
                    <%          for (int i = 0; i < searchResults.size(); i++) {
                            projectInfoDO searchResult = (projectInfoDO) searchResults.elementAt(i);
                    %>              
                    <tr>
                        <td><a href="./project.jsp?projectId=<%=searchResult.getId()%>"><%= searchResult.getName()%></a></td>
                        <td><%= searchResult.getPrice()%></td>
                        <td><%= searchResult.getDescription()%></td>
                        <td><a href="./verperfil.jsp?id=<%=searchResult.getCustomerId()%>">Ver</a></td>
                    </tr>        
                    <%           } // for i      
                    %>        </table>

                    <%
                } //searchproject
                %>   
                
<!--------------------------------Search User------------------------------------------------>    
                <%
                    search.searchUser tn2 = new search.searchUser();
                    Vector searchResults2 = tn2.getResults(keyword);
                    session.setAttribute("vector", searchResults2);
                    
                    if ((searchResults2 == null)|| (searchResults2.size() == 0)) {
                        // avisar usuario que nao ha' contatos com este nome
                %>

                <h3>Usuários encontrados: Nenhum.</h3>

                <%
                } //if nenhum resultado 
                else {
                %>                     
                <h3>Usuários encontrados:</h3>
<table BORDER="1">
                    <tr>
                        <td>Username</td>
                        <td>E-mail</td>
                        <td>Country</td>
                    </tr>
                    <%for (int i = 0; i < searchResults2.size(); i++) {
                            userInfoDO searchResult2 = (userInfoDO) searchResults2.elementAt(i);
                    %>              
                    <tr>
                        <td><a href="./verperfil.jsp?id=<%=searchResult2.getId()%>"><%= searchResult2.getUsername()%></a></td>
                        <td><%= searchResult2.getEmail()%></td>
                        <td><%= searchResult2.getCountry()%></td>
                    </tr>        
                    <%           } // for i      
                    %>        </table>

                <%
                    } // returned versions
%>

                <!--------------------------Footer--------------------------------------------->

            </div>
        </div>

        <%@include file="WEB-INF/footer.jsp" %>    
        <!-------------------Fim do Footer--------------------------------------------->

    </body>
</html>
