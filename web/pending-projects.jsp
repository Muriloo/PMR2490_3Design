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
<h2>Gerenciamento de Versões Pendentes</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        
        
<%@ page import="java.util.Vector" %>
<%@ page import="transaction.pendingProject" %>
<%@ page import="project.versionDO" %>

<!------------------------------------------------------------------->
<!--   sempre mostrar o formulario de busca, ateh acao ser "voltar" -->

<%     if ( null != request.getParameter("voltar")) {
%>        <jsp:forward page="./index.jsp" />
<%        return;
       }
%>

         <form action="./pending-projects.jsp" method="post">
             
             
          
         <input type="submit" name="pesquisar" value="Pesquisar" />
         <input type="submit" name="voltar" value="Voltar" />
         </form>

<! ------------------------------------------------------------------->

        
        <%   if ( null != request.getParameter("pesquisar")) {  
       transaction.pendingProject tn = new transaction.pendingProject();
       Vector versions = tn.getPending();
       session.setAttribute("vector",versions);
       request.setAttribute("vector",versions);
       if ( (versions == null) || (versions.size() == 0)) {
         
%>
          Nenhuma versão pendente encontrada!
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                <td>ID do Projeto</td>
                <td>Nome da Versão</td>
                <td>Visibilidade</td>
                <td>Status</td>
                <td>Arquivo</td>
                <td>Aprovar</td>
                <td>Rejeitar</td>
            </tr>
<%           for(int i = 0; i < versions.size(); i++) {
                versionDO version = (versionDO)versions.elementAt(i);
                String file = version.getFilepath();
%>              <tr>
                   <td><%= version.getProjectId() %></td>
                   <td><%= version.getName() %></td>
                   <td><%= version.getVisibility() %></td>
                   <td><%= version.getStatusId() %></td>
                   <td>
                       <form action="Files/<%=file%>" method="post">
                <input type="submit" name="download" value="Download" />
                       </form> 
                   </td>

                   
                   <td><form action="./approval-confirmation.jsp" method="post">
             
         <input type="hidden" name="indice" value="<%=i%>"  />             
         <input type="submit" name="aprovar" value="Aprovar" />
      
         </form></td>
                <td><form action="./approval-confirmation.jsp" method="post">
             
         <input type="hidden" name="indice" value="<%=i%>"  />               
         <input type="submit" name="rejeitar" value="Rejeitar" />
      
         </form></td>
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
