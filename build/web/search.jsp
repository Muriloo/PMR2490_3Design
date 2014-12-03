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
        <title>JSP Page</title>
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
</div>

<div id="section">
       
<!-------------Fim do Header--------------------------------------------------->
        



                <%@ page import="java.util.Vector" %>
                <%@ page import="search.searchProject" %>
                <%@ page import="project.projectDO" %>

                <%            String keyword = request.getParameter("keyword");
                    keyword = keyword.toUpperCase();
                %>

                <h3>Resultados encontrados para o termo: "<%=keyword%>"</h3>     

                <%
                    search.searchProject tn = new search.searchProject();
                    Vector searchResults = tn.getResults(keyword);
                    session.setAttribute("vector", searchResults);
                    if ((searchResults == null) || (searchResults.size() == 0)) {
                        // avisar usuario que nao ha' contatos com este nome
                %>
                <h2>Nenhum resultado encontrado</h2>

                <%
                } //if nenhum resultado 
                else {
                %>    
                <table BORDER="1">
                    <tr>
                        <td>Nome do projeto</td>
                        <td>preço</td>
                        <td>Descrição</td>
                        <td>Desenvolvedor</td>
                    </tr>
                    <%          for (int i = 0; i < searchResults.size(); i++) {
                            projectDO searchResult = (projectDO) searchResults.elementAt(i);
                    %>              <tr>
                        <td><%= searchResult.getName()%></td>
                        <td><%= searchResult.getPrice()%></td>
                        <td><%= searchResult.getDescription()%></td>
                        <td><form action="./pageProject.jsp" method="post">
             
         <input type="submit" name="1" value="teste"  />               
      
         </form></td>
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
