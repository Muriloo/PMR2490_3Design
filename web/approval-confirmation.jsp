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
        
        <div style="height:90px;margin:0px;background-color: #6ED4B8">
<div id="header" style="vertical-align: top;height:80px">
    <a href="index.html">
        <img src="images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
    </a>
    <div style="float:right;">
    <a class="header" href="teste.jsp">Sign Up</a>
    <span style="letter-spacing:14px;"> |</span>
    <a class="header" href="index.html">Log In </a>
    <span style="letter-spacing:14px;"> |</span>
    <a href="index.html">
        <img src="images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:12px">
    </a>
    </div>
    <div style="display:inline;text-align: center">
    <br>
    <form>
        <input type="search" name="firstname" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
        <input type="submit" value="" style="background:url(images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
    </form>
    </div>
</div>
</div>

<div id="page">
<div id="nav">
Coisa 3D<br>
Mais uma coisa 3D<br>
Such 3D!<br>
</div>

<div id="section">
<h2>Gerenciamento de Versões Pendentes</h2>
        
<!-------------Fim do Header--------------------------------------------------->

<%     if ( null != request.getParameter("voltar")) {
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
<form action="./pending-projects.jsp" method="post"
                <input type="submit" name="voltarAC" value="Voltar" />
</form>       

<%
    }//se aprovada com sucesso
    else {
        %>
        
<h2>Erro na aprovação!</h2>
<form action="./pending-projects.jsp" method="post"
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
    vector = (Vector)session.getAttribute("vector");
    int i = Integer.parseInt(request.getParameter("indiceC"));
    System.out.println("INDICE="+i);
    version = (versionDO)vector.elementAt(i);
    if (version == null){
        System.out.println("versão nula");
    }
    if (pp.reprove(version)){
%>        

<h2>Versão Rejeitada!</h2>
<form action="./pending-projects.jsp" method="post"
                <input type="submit" name="voltarAC" value="Voltar" />
</form>       

<%
    }//se rejeitada com sucesso
    else {
        %>
        
<h2>Erro na rejeição!</h2>
<form action="./pending-projects.jsp" method="post"
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
         <form action="./approval-confirmation.jsp" method="post"
                <!input type="text" name="teste" value="testee">
                <input type="hidden" name="indice" value="<%=i%>"  />
                <input type="submit" name="aprovarC" value="Aprovar" />
                <input type="submit" name="voltar" value="Voltar" />
            </form>       
            
            <%
    }
        else if( null != request.getParameter("rejeitar") ){
            System.out.println("rejeitar "+i);
            %>
            <h2>Você tem certeza que deseja rejeitar essa versão?</h2>
            <form action="./approval-confirmation.jsp" method="post"
                <!input type="text" name="teste" value="testee">
                <input type="hidden" name="indice" value="<%=i%>"  />
                <input type="submit" name="rejeitarC" value="Rejeitar" />
                <input type="submit" name="voltar" value="Voltar" />
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
    
<div style="height:160px;margin: 0px auto;display: block;background-color:#6ED4B8;clear:both;">
<div id="footer">
    <table id="bottomlinks">
        <tbody>
            <tr>
                <td style="vertical-align: top;width:800px">
                    <h3>Modo de Pagamento</h3>
                    <a href="https://pagseguro.uol.com.br/" target="_blank">
                        <img src="images/pagseguro.bmp" alt="pagseguro" style="width:100px;height:30px">
                    </a>
                </td>
                <td style="vertical-align: top">
                    <h3>Contato</h3>
                    <h5>Email: contato@3design.com</h5>
                    <h5>Telefone: +55 11 99975-6644</h5>
                    
                </td>
            </tr>
        </tbody>
    </table>
</div>
</div>    
    
<!-------------------Fim do Footer--------------------------------------------->

</body>

</html>
