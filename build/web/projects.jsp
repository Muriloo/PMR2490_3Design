<%-- 
    Document   : pending-projects
    Created on : 18/11/2014, 15:48:09
    Author     : Arthur
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
<h2>Projetos</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        
        
<%@ page import="java.util.Vector" %>
<%@ page import="transaction.ProjectTransactions" %>
<%@ page import="project.projectDO" %>


<! ------------------------------------------------------------------->

        
        <%   if (true) {  
       transaction.ProjectTransactions tn = new transaction.ProjectTransactions();
       Vector projects = tn.getAllProjects();
       session.setAttribute("vector",projects);
       if ( (projects == null) || (projects.size() == 0)) {
         // avisar usuario que nao ha' contatos com este nome
%>
          Não existe nenhum projeto
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                 <td>Produto</td>
                <td>Preco</td>
                <td>Adicionar ao Carrinho</td>
             </tr>
<%           for(int i = 0; i < projects.size(); i++) {
                projectDO project = (projectDO)projects.elementAt(i);
%>              <tr>
                    <td><a href="./project.jsp?projectId=<%=project.getId()%>"><%= project.getName()%></a></td>
                    <td><%= project.getPrice() %></td>
                    <td><%if(customerId != null){%>
                       <form action="./carrinho.jsp" method="post">  
                        <input type="number" name="quantity" min="1" max="10000" value="1"  /> 
                        <input type="hidden" name="projectId" value="<%=project.getId()%>"  />             
                        <input type="submit" name="adicionar" value="+" />

                        </form><%}else{%>Necessário Logar!<%}%></td>
                </tr>        
<%           } // for i      
%>        </table>            
<%     } // returned versions
     } // pesquisar
%>

<!--------------------------Footer--------------------------------------------->

</div>
</div>

<%@include file="WEB-INF/footer.jsp" %>    
<!-------------------Fim do Footer--------------------------------------------->

</body>

</html>
