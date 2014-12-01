<%-- 
    Document   : approval-confirmation
    Created on : 19/11/2014, 11:28:21
    Author     : Arthur
--%>

<%@ page import="java.util.Vector" %>
<%@ page import="transaction.pendingProject" %>
<%@ page import="project.versionDO" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
    </head>
    <body>
        
<!--------------------Header--------------------------------------------------->
<%@include file="/WEB-INF/header.jsp" %>

<div id="page">
<div id="nav">
Coisa 3D<br>
Mais uma coisa 3D<br>
Such 3D!<br>
</div>

<div id="section">
<h2>Gerenciamento de Versões Pendentes</h2>
        
<!-------------Fim do Header--------------------------------------------------->

<%     if ( null != request.getParameter("voltarAC")) {
%>        <jsp:forward page="./pending-projects.jsp" />
<%        return;
       }
%>

<%     if ( null != request.getParameter("aprovarC")) {
    String a = request.getParameter("indiceC");
    System.out.println("aprovarC "+a);
    transaction.pendingProject pp = new transaction.pendingProject();
    versionDO version = new versionDO();
    Vector vector = new Vector();
    vector = (Vector)session.getAttribute("vector");
    int i = Integer.parseInt(request.getParameter("indiceC"));
    System.out.println("INDICE="+i);
    version = (versionDO)vector.elementAt(i);
    if (version == null){
        System.out.println("versão nula");
    }
    if (pp.approve(version)){
%>        

<h2>Versão Aprovada!</h2>
<form action="./pending-projects.jsp" method="post">
                <input type="submit" name="voltarAC" value="Voltar" />
</form>       

<%
    }//se aprovada com sucesso
    else {
        %>
        
<h2>Erro na aprovação!</h2>
<form action="./pending-projects.jsp" method="post">
                <input type="submit" name="voltarAC" value="Voltar" />
</form>       
        
        <%
    }//Erro na aprovação

}//aprovarC
else if ( null != request.getParameter("rejeitarC")) {
    System.out.println("vai rejeitar");
    String a = request.getParameter("indiceC");
    System.out.println("rejeitarC "+a);
    transaction.pendingProject pp = new transaction.pendingProject();
    versionDO version = new versionDO();
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("vector");
    int i = Integer.parseInt(request.getParameter("indiceC"));
    System.out.println("INDICE="+i);
    version = (versionDO)vector.elementAt(i);
    if (version == null){
        System.out.println("versão nula");
    }
    if (pp.reprove(version)){
%>        

<h2>Versão Rejeitada!</h2>
<form action="./pending-projects.jsp" method="post">
                <input type="submit" name="voltarAC" value="Voltar" />
</form>       

<%
    }//se rejeitada com sucesso
    else {
        %>
        
<h2>Erro na rejeição!</h2>
<form action="./pending-projects.jsp" method="post">
                <input type="submit" name="voltarAC" value="Voltar" />
</form>        
        
        <%
    }//Erro na rejeição

}//rejeitarC
else{
    System.out.println("else");
    String aprovar_rejeitar;
    int i = Integer.parseInt(request.getParameter("indice"));
    if( null != request.getParameter("aprovar") ){
         System.out.println("aprovar "+i);
        %>
         <h2>Você tem certeza que deseja aprovar essa versão?</h2>
         <form action="./approval-confirmation.jsp" method="post">
                <input type="hidden" name="indiceC" value="<%=i%>"  />
                <input type="submit" name="aprovarC" value="Aprovar" />
                <input type="submit" name="voltarAC" value="Voltar" />
            </form>       
            
            <%
    }
        else if( null != request.getParameter("rejeitar") ){
            System.out.println("rejeitar "+i);
            %>
            <h2>Você tem certeza que deseja rejeitar essa versão?</h2>

            <form action="./approval-confirmation.jsp" method="get">
                <input type="hidden" name="indiceC" value="<%=i%>"  />

                <input type="submit" name="rejeitarC" value="Rejeitar" />
                <input type="submit" name="voltarAC" value="Voltar" />
            </form>        
            
            <%
           
        }
        else{
            aprovar_rejeitar = "MERDA";
            System.out.println("merda");
        }
    
    
    

%>




<%
}//else (primeira entrada na página)

%>                     
                     
<!--------------------------Footer--------------------------------------------->

</div>
</div>

   <%@include file="/WEB-INF/footer.jsp" %>    
    
<!-------------------Fim do Footer--------------------------------------------->

</body>

</html>
