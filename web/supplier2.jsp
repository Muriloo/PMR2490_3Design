<%-- 
    Document   : supplier2
    Created on : 24/11/2014, 10:52:51
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
<h2>Gerenciamento de Fornecedores</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        
        
<%@ page import="java.util.Vector" %>
<%@ page import="transaction.supplier" %>
<%@ page import="project.supplierDO" %>

<!------------------------------------------------------------------->
<!--   sempre mostrar o formulario de busca, ateh acao ser "voltar" -->

<%     if ( null != request.getParameter("voltarS")) {
%>        <jsp:forward page="./supplierPage.jsp" />
<%        return;
       }
%>

         <form action="./supplier2.jsp" method="post">
              <input type="submit" name="incluir" value="Incluir" />
              <input type="submit" name="voltarS" value="Voltar" />
         </form>

<! ------------------------------------------------------------------->

        
        <% 
       if (null != request.getParameter ("excluir")) {
        System.out.println("vai excluir");
    String a = request.getParameter("indice");
    System.out.println("excluir "+a);
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("vector");
    int i = Integer.parseInt(request.getParameter("indice"));
    System.out.println("INDICE="+i);
    supplier = (supplierDO)vector.elementAt(i);
    if (supplier == null){
        System.out.println("fornecedor nulo");
    }
    if (tn.delete(supplier)){
%>        

<h2>Fornecedor Excluido!</h2>
<form action="./supplierPage.jsp" method="post">
                <input type="submit" name="voltarS" value="Voltar" />
</form>       

<%
    }//se rejeitada com sucesso
    else {
        %>
        
        <h2>Erro na exclus&atildeo!</h2>
<form action="./supplierPage.jsp" method="post">
                <input type="submit" name="voltarS" value="Voltar" />
</form>        
        
        <%
    }//Erro na esclusão

}//excluir
       else if (null != request.getParameter ("ver")) {
        System.out.println("ver fornecedor");
    String a = request.getParameter("indice");
    System.out.println("contatos "+a);
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("vector");
    int i = Integer.parseInt(request.getParameter("indice"));
    System.out.println("INDICE="+i);
    supplier = (supplierDO)vector.elementAt(i);
    if (supplier == null){
        System.out.println("fornecedor nulo");
    }
    
%>        

<h2>Ver Fornecedor</h2>
<table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                <td>Excluir</td>
            </tr>
<%        
           
%>              <tr>
                   <td><%= supplier.getName() %></td>
                   <td><%= supplier.getEval() %></td>
                   <td><%= supplier.getCapacityId() %></td>
                   <td><%= supplier.getComment() %></td>
                   <td><%= supplier.getDescription() %></td>
                   <td>
                       <form action="./supplier2.jsp" method="post">
                <input type="hidden" name="indice" value="<%=i%>"  />               
                <input type="submit" name="excluir" value="Excluir" />
                       </form></td>
                </tr>        
<%           } // for i      
%>        </table> 

Tabela de Contatos
<table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                <td>Contatos</td>
                <td>Dados Bancários</td>
                <td>Excluir</td>
            </tr>
<%        
       //RESOLVER PEPINO-> COMO PEGAR OS CONTATOS E DADOS BANCÁRIOS DO supplierDO
           for(int i = 0; i < supplier.contact.size(); i++) {
                supplierDO supplier = (supplierDO)suppliers.elementAt(i);
%>              <tr>
                   <td><%= supplier.getName() %></td>
                   <td><%= supplier.getEval() %></td>
                   <td><%= supplier.getCapacityId() %></td>
                   <td><%= supplier.getComment() %></td>
                   <td><%= supplier.getDescription() %></td>
                   <td>
                       <form action="./supplier2.jsp" method="POST">        
                <input type="hidden" name="indice" value="<%=i%>"  />       
                <input type="submit" name="contacts" value="Contatos" />
                       </form> 
                   </td>               
                   <td>
                       <form action="./supplier2.jsp" method="POST">
                <input type="hidden" name="indice" value="<%=i%>"  />             
                <input type="submit" name="bank" value="Dados Bancarios" />
                       </form>
                   </td>
                   <td>
                       <form action="./supplier2.jsp" method="post">
                <input type="hidden" name="indice" value="<%=i%>"  />               
                <input type="submit" name="excluir" value="Excluir" />
                       </form></td>
                </tr>        
<%           } // for i      
%>        </table>            

<form action="./supplierPage.jsp" method="post">
                <input type="submit" name="voltarS" value="Voltar" />
</form>     

<%

}//ver fornecedor
       
           else if ( null != request.getParameter("pesquisar")) {  
       transaction.supplier tn = new transaction.supplier();
       Vector suppliers = tn.getSuppliers();
       session.setAttribute("vector",suppliers);
       request.setAttribute("vector",suppliers);
       if ( (suppliers == null) || (suppliers.size() == 0)) {
         
%>
          Nenhuma versão pendente encontrada!
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                <td>Contatos</td>
                <td>Dados Bancários</td>
                <td>Excluir</td>
            </tr>
<%        
           for(int i = 0; i < suppliers.size(); i++) {
                supplierDO supplier = (supplierDO)suppliers.elementAt(i);
%>              <tr>
                   <td><%= supplier.getName() %></td>
                   <td><%= supplier.getEval() %></td>
                   <td><%= supplier.getCapacityId() %></td>
                   <td><%= supplier.getComment() %></td>
                   <td><%= supplier.getDescription() %></td>
                   <td>
                       <form action="./supplier2.jsp" method="POST">        
                <input type="hidden" name="indice" value="<%=i%>"  />       
                <input type="submit" name="contacts" value="Contatos" />
                       </form> 
                   </td>               
                   <td>
                       <form action="./supplier2.jsp" method="POST">
                <input type="hidden" name="indice" value="<%=i%>"  />             
                <input type="submit" name="bank" value="Dados Bancarios" />
                       </form>
                   </td>
                   <td>
                       <form action="./supplier2.jsp" method="post">
                <input type="hidden" name="indice" value="<%=i%>"  />               
                <input type="submit" name="excluir" value="Excluir" />
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


