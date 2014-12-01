<%-- 
    Document   : supplierPage
    Created on : 24/11/2014, 10:31:00
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

<%     if ( null != request.getParameter("voltar")) {
%>        <jsp:forward page="./index.jsp" />
<%        return;
       }
        else if ( null != request.getParameter("inserir")) {
%>        <jsp:forward page="./supplierInsert.jsp" />
<%     return;
       }
       else if ( null == request.getParameter("excluir")){
%>

         <form action="./supplierPage.jsp" method="post">
              <input type="submit" name="pesquisar" value="Pesquisar" />
              <input type="submit" name="inserir" value="Inserir" />
              <input type="submit" name="voltar" value="Voltar" />
         </form>
      <%}//if excluir == null%>
<! ------------------------------------------------------------------->

        
        <% 
       if ( null != request.getParameter("pesquisar")) {  
       transaction.supplier tn = new transaction.supplier();
       Vector suppliers = tn.getSuppliers();
       session.setAttribute("suppliers",suppliers);
       if ( (suppliers == null) || (suppliers.size() == 0)) {
         
%>
          Nenhum fornecedor encontrado!
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                <td>Ver</td>
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
                <input type="submit" name="ver" value="Ver" />
                       </form> 
                   </td>               
                   <td>
                       <form action="./supplierPage.jsp" method="post">
                <input type="hidden" name="indice" value="<%=i%>"  />               
                <input type="submit" name="excluir" value="Excluir" />
                       </form></td>
                </tr>        
<%           } // for i      
%>        </table>            
<%     } // returned versions
     } // pesquisar
       else if (null != request.getParameter ("excluir")){
            int i = Integer.parseInt(request.getParameter("indice"));
            transaction.supplier tn = new transaction.supplier();
            supplierDO supplier = new supplierDO();
            Vector vector = new Vector();
            vector = (Vector) session.getAttribute("suppliers");
            supplier = (supplierDO)vector.elementAt(i);
            session.setAttribute("remove",supplier);
            
        %>
         <h2>Você tem certeza que deseja excluir este fornecedor?</h2>
             
         <table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>                
            </tr>
            <tr>
                   <td><%= supplier.getName() %></td>
                   <td><%= supplier.getEval() %></td>
                   <td><%= supplier.getCapacityId() %></td>
                   <td><%= supplier.getComment() %></td>
                   <td><%= supplier.getDescription() %></td>
                </tr>        
<%    
%>        </table>   
          <form action="./supplier2.jsp" method="POST">        
                            <input type="hidden" name="indice" value="<%=i%>"  />       
                            <input type="submit" name="ver" value="Ver" />
                            <input type="submit" name="excluir" value="Excluir" />
                            <input type="submit" name="voltarsup" value="Voltar" />
          </form> 

            
            <%
    
           
       
    
    


       }//excluir
%>

<!--------------------------Footer--------------------------------------------->

</div>
</div>

<%@include file="WEB-INF/footer.jsp" %>    
<!-------------------Fim do Footer--------------------------------------------->

</body>

</html>

