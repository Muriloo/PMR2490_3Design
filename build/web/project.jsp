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
<h2>Projeto</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        
        
<%@ page import="java.util.Vector" %>
<%@ page import="utils.MetodosUteis" %>
<%@ page import="transaction.ProjectTransactions" %>
<%@ page import="project.projectDO" %>
<%@ page import="transaction.CommentTransactions" %>
<%@ page import="comment.CommentDO" %>
<%@ page import="transaction.UserTransactions" %>
<%@ page import="data.ContatoDO" %>


<!------------Adicionado o comentário postado---------------------------------->

<%     if ( null != request.getParameter("comentar")) {
    String comment = request.getParameter("comment");
    String customerIdStr = request.getParameter("customerId");
    String commentProjectId = request.getParameter("commentProjectId");
    System.out.println("Comentando");
    transaction.CommentTransactions commentTransaction = new transaction.CommentTransactions();
    CommentDO comentario = new CommentDO();
    comentario.setComment(comment);
    comentario.setCustomerId(Integer.parseInt(customerIdStr));
    comentario.setProjectId(Integer.parseInt(commentProjectId));
    
    if (commentTransaction.addComment(comentario)){
%>        
<h3>Comentário feito!</h3>

<%
    }//se rejeitada com sucesso
    else {
        %>
        
<h3>Comentário perdido! Tente denovo por favor.</h3>
        
        <%
    }//Erro na rejeição
} %>  

<!------------pega o projeto do BD--------------------------------------------->
        <%  String projectIdStr = request.getParameter("projectId");        
        int show=10;
        if (null != projectIdStr) { 
        String showStr = request.getParameter("show");
        if(null != showStr){
            show = Integer.parseInt(showStr);
        }
        int ok;
        try{//checa se o valor de projectId é um número  
            int projectId = Integer.parseInt(projectIdStr);
            ok = 1;
        }catch(NumberFormatException nfe){  
            %>Parâmetros de projeto incorretos<%
            ok = 0;
        }
        if ( ok == 1 ) {           
             transaction.CommentTransactions commentTransaction = new transaction.CommentTransactions();
             Vector comments = commentTransaction.getComments(projectIdStr);
             session.setAttribute("vector",comments);
             transaction.UserTransactions userTransaction = new transaction.UserTransactions();
             Vector users = userTransaction.getUsers(comments);
             session.setAttribute("vector",users);
 %>       
 Projeto: <%=projectIdStr%><br>
         Agora ao que importa, os comentários!
         <hr style="border-color: #6ED4B8">
         <%for(int i = 0; i < comments.size() && i < show; i++){
             CommentDO comment = (CommentDO)comments.elementAt(i);
             ContatoDO user = (ContatoDO)users.elementAt(i);%>
             <a href="./user.jsp?username=<%= user.getUsername() %>" style="font-size: 11pt; color: #3EA498;"><%=user.getUsername()%></a>         <span style="font-size: 8pt;color: #C0C0C0"><%=MetodosUteis.dateToDate(comment.getCreatedAt())%></span><br>
             <span style="font-size: 10pt; padding-left: 10px">    <%=comment.getComment()%></span><br>
             
             <hr style="border-color: #6ED4B8">

         <%} // returned versions
         if(comments.size() == 0){
             %>Este produto ainda não foi comentado<%
         }else if(comments.size() > show){%>
             <a href="./project.jsp?projectId=<%=projectIdStr%>&show=<%=show+20%>" style="font-size: 14pt; color: #3EA498;">Mostrar mais comentários</a><%
         }
         if(customerId != null){%>
            <form action="./project.jsp?projectId=<%=projectIdStr%>&show=10" method="post">  
            <textarea name="comment" cols="50" rows="2" maxlength="500" placeholder="Commente aqui" style="resize: none" required></textarea>
            <input type="hidden" name="customerId" value="<%=customerId%>"  />      
            <input type="hidden" name="commentProjectId" value="<%=projectIdStr%>"  />             
            <input type="submit" name="comentar" value="Comentar" style="height:30px;font-size:12pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -7px"/>
            </form><%
         }else{%>
            <form action="./project.jsp?projectId=<%=projectIdStr%>&show=10" method="post">  
            <textarea name="comment" cols="50" rows="2" maxlength="500" disabled style="resize: none">Necessário estar logado para comentar</textarea>          
            <input type="submit" name="comentar" value="Comentar" disabled style="height:30px;font-size:12pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -7px"/>
            </form><%             
         }
         }else{
           %>Faltam parâmetros do projeto<%
         }
}
%>

<!--------------------------Footer--------------------------------------------->

</div>
</div>

<%@include file="WEB-INF/footer.jsp" %>    
<!-------------------Fim do Footer--------------------------------------------->

</body>

</html>
