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
<%@ page import="transaction.ProjectTransactions" %>
<%@ page import="project.projectDO" %>
<%@ page import="transaction.CommentTransactions" %>
<%@ page import="comment.CommentDO" %>


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
       if (null != projectIdStr) { 
        String showStr = request.getParameter("show");
        int show;
        if(null != showStr){
            show = Integer.parseInt(showStr);
        }else{
            show = 10;
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
 %>       
 Projeto: <%=projectIdStr%><br>
         Agora ao que importa, os comentários!
         <hr style="border-color: #6ED4B8">
         <%for(int i = 0; i < comments.size() && i < show; i++){
             CommentDO comment = (CommentDO)comments.elementAt(i);%>
             Id do usuário:<%=comment.getCustomerId()%><br>
             Commentário:<%=comment.getComment()%><br>
             Data:<%=comment.getCreatedAt()%><br>
             <hr style="border-color: #6ED4B8">

         <%} // returned versions
         if(comments.size() == 0){
             %>Este produto ainda não foi comentado<%
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
