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
<h2>Lista de usuários</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        
        
<%@ page import="java.util.Vector" %>
<%@ page import="transaction.pendingProject" %>
<%@ page import="project.versionDO" %>
<%@ page import="transaction.UserTransactions" %>
<%@ page import="data.ContatoDO" %>

<!------------------------------------------------------------------->
<!--   sempre mostrar o formulario de busca, ateh acao ser "voltar" -->

<%     if ( null != request.getParameter("voltar")) {
%>        <jsp:forward page="./index.jsp" />
<%        return;
       }
%>

         <form action="./user-list.jsp" method="post">
             
             
          
         <input type="submit" name="pesquisar" value="Pesquisar" />
         <input type="submit" name="voltar" value="Voltar" />
         </form>

<! ------------------------------------------------------------------->

        
        <%   if ( null != request.getParameter("pesquisar")) {  
       transaction.UserTransactions tn = new transaction.UserTransactions();
       Vector users = tn.getAllUsers();
       session.setAttribute("vector",users);
       if ( (users == null) || (users.size() == 0)) {
         // avisar usuario que nao ha' contatos com este nome
%>
          Nenhum usuário pendente encontrado!
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                 <td>Username</td>
                <td>Email</td>
             </tr>
<%           for(int i = 0; i < users.size(); i++) {
                ContatoDO user = (ContatoDO)users.elementAt(i);
%>              <tr>
                   <td><a href="./user/<%= user.getUsername() %>.jsp"><%= user.getUsername() %></a></td>
                   <td><%= user.getEmail() %></td>
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
