<%-- 
    Document   : pageProject
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
<h2>Gerenciamento de Versões Pendentes</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        



                <%@ page import="java.util.Vector" %>
                <%@ page import="search.searchProject" %>
                <%@ page import="project.projectDO" %>

                <%  
                    String project_Id = request.getParameter("project_id");
                %>

                <h3>Resultados encontrados para o termo: "<%=project_Id%>"</h3>     

                <%
                    search.searchProject tn = new search.searchProject();
                    Vector project = tn.getResults(project_Id);
                    session.setAttribute("vector", project);
                    if ((project == null) || (project.size() == 0)) {
                        // avisar usuario que nao ha' contatos com este nome
                %>
                <h2>Desculpe o transtorno. O projeto está indisponível no momento</h2>

                <%
                } //if nenhum resultado 
                else {
                        projectDO projectDO = (projectDO) project.elementAt(0);
                %>    
                <h1><%=projectDO.getName()%></h1>
                <h3> image </h3>    
                <h2>Preço: <%=projectDO.getPrice()%></h2>
                <h2>Descrição</h2>
                <h3><%=projectDO.getDescription()%></h3>
                <h2>Detalhes</h2>
                <h3><%=projectDO.getDetail()%></h3>


                <%
                    } // else mostra projeto
%>

                <!--------------------------Footer--------------------------------------------->

            </div>
        </div>

        <%@include file="WEB-INF/footer.jsp" %>    
        <!-------------------Fim do Footer--------------------------------------------->

    </body>
</html>
