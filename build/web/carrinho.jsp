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
<h2>Carrinho</h2>
        
<!-------------Fim do Header--------------------------------------------------->
        
        
<%@ page import="java.util.Vector" %>
<%@ page import="transaction.CartTransactions" %>
<%@ page import="cart.cartDO" %>
<%@ page import="transaction.ProjectTransactions" %>
<%@ page import="project.projectDO" %>


<!-------checa se tem algum item a ser adicionado------------------------------>
<%     if ( null != request.getParameter("adicionar")) {
    String projectId = request.getParameter("projectId");
    String quantity = request.getParameter("quantity");
    System.out.println(projectId);
    transaction.CartTransactions add = new transaction.CartTransactions();
    cartDO itemNovo = new cartDO();
    itemNovo.setCustomerId(Integer.parseInt(customerId));
    itemNovo.setProjectId(Integer.parseInt(projectId));
    itemNovo.setQuantity(Integer.parseInt(quantity));
    
    if (add.addItem(itemNovo)){
%>        
<h3>Item adicionado!</h3>

<%
    }//se rejeitada com sucesso
    else {
        %>
        
<h3>Erro na adição do item!</h3>
        
        <%
    }//Erro na rejeição
} %>   


<!-------checa se tem algum item a ser atualizado------------------------------>
<%     if ( null != request.getParameter("atualizar")) {
    String itemId = request.getParameter("itemId");
    String quantity = request.getParameter("quantity");
    transaction.CartTransactions upd = new transaction.CartTransactions();
    cartDO itemUpd = new cartDO();
    itemUpd.setId(Integer.parseInt(itemId));
    itemUpd.setQuantity(Integer.parseInt(quantity));
    itemUpd.setCustomerId(Integer.parseInt(customerId));
    
    if (upd.updateItem(itemUpd)){
%>        
<h3>Item atualizado!</h3>

<%
    }//se rejeitada com sucesso
    else {
        %>
        
<h3>Erro na atualização!</h3>
        
        <%
    }//Erro na rejeição
} %>   


<!-------checa se tem algum item a ser deletado-------------------------------->
<%     if ( null != request.getParameter("deletar")) {
    String itemCartId = request.getParameter("itemCartId");
    System.out.println(itemCartId);
    transaction.CartTransactions del = new transaction.CartTransactions();
    cartDO itemDelete = new cartDO();
    itemDelete.setId(Integer.parseInt(itemCartId));
    
    if (del.removeItem(itemDelete)){
%>        
<h3>Item deletado!</h3>

<%
    }//se rejeitada com sucesso
    else {
        %>
        
<h3>Erro em deletar o item!</h3>
        
        <%
    }//Erro na rejeição
} %>   


<!-------pega todos os itens deste usuario e mostra---------------------------->
        <%   if (true) {  
       transaction.CartTransactions itemTransaction = new transaction.CartTransactions();
       Vector items = itemTransaction.getItems(customerId);
       session.setAttribute("vector",items);
       transaction.ProjectTransactions projectTransaction = new transaction.ProjectTransactions();
       Vector projects = projectTransaction.getCartProjects(items);
       session.setAttribute("vector",projects);
       if ( (items == null) || (items.size() == 0)) {
         // avisar usuario que nao ha' contatos com este nome
%>
Seu carrinho está vazio. Volte para a <a href="index.jsp"> página inicial</a> ou <a href="projects.jsp">escolha produtos</a>.
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                <td>Thumbnail</td>
                <td>Produto</td>
                <td>Quantidade</td>
                <td>Preço Unitário</td>
                <td>Preço Total</td>
                <td>Deletar Produto</td>
             </tr>
<%          float soma = 0; 
            for(int i = 0; i < items.size(); i++) {
                cartDO item = (cartDO)items.elementAt(i);
                projectDO project = (projectDO)projects.elementAt(i);
%>              <tr>
                    <td>Pegar Foto</td>
                    <td><%= project.getName() %></td>
                    <td><form action="./carrinho.jsp" method="get">  
                        <input type="number" name="quantity" min="1" max="10000" value="<%= item.getQuantity() %>"  /> 
                        <input type="hidden" name="itemId" value="<%=item.getId()%>"  />             
                        <input type="submit" name="atualizar" value=" " style="background:url(images/refresh.png) no-repeat;width: 25px;height: 25px;position:relative;" /></form>
                    </td>
                    <td><%= project.getPrice() %></td>
                    <td><%= project.getPrice()*item.getQuantity() %></td>
                    <td><form action="./carrinho.jsp" method="get"> 
                       <input type="hidden" name="itemCartId" value="<%=item.getId()%>"  />             
                       <input type="submit" name="deletar" value="-" /></form></td>
                </tr>        
<%              soma += project.getPrice()*item.getQuantity();
                } // for i %> 
             <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><%= soma %></td>
                <td></td>
             </tr>
        </table>            
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
