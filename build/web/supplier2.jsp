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
<%@ page import="project.*" %>

<!------------------------------------------------------------------->
<!--   sempre mostrar o formulario de busca, ateh acao ser "voltar" -->

<%     if ( null != request.getParameter("voltarS")) {
%>        <jsp:forward page="./supplierPage.jsp" />
<%        return;
       }
     if ( null != request.getParameter("voltarsup")) {
%>        <jsp:forward page="./supplierPage.jsp" />
<%        return;
       }
     if ( null != request.getParameter("inserir")) {
%>        <jsp:forward page="./supplierInsert.jsp" />
<%        
   return;
       }
%>

         <form action="./supplier2.jsp" method="post">
              <input type="submit" name="inserir" value="Inserir" />
              <input type="submit" name="voltarS" value="Voltar" />
         </form>

<! ------------------------------------------------------------------->

        
        <% 
       if (null != request.getParameter ("excluir")) {
        System.out.println("vai excluir");
        transaction.supplier tn = new transaction.supplier();
        supplierDO supplier = (supplierDO) session.getAttribute("supplier");
        if (supplier == null){
            System.out.println("fornecedor nulo");
        }
        if (tn.delete(supplier)){
%>        

<h2>Fornecedor Excluido!</h2>
    

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
    System.out.println("fornecedor "+a);
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("suppliers");
    int i = Integer.parseInt(request.getParameter("indice"));
    System.out.println("INDICE="+i);
    supplier = (supplierDO)vector.elementAt(i);
    session.setAttribute("supplier",supplier);
    System.out.println("supplier");
    if (supplier == null){
        System.out.println("fornecedor nulo");
    }
    
%>        

<! --------------------------abre geral-------------------------------------->
<h2>Ver Fornecedor</h2>
<%
        if(request.getParameter("ok") != null) {
            %>
          Fornecedor inserido com sucesso!
            
            <%
        }

%>

<table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                
            </tr>
<%        
           
%>              <tr>
                   <td><%= supplier.getName() %></td>
                   <td><%= supplier.getEval() %></td>
                   <td><%= supplier.getComment() %></td>
                   <td><%= supplier.getDescription() %></td>
                   
                </tr>        
        </table> 
                
<! --------------------------fecha geral-------------------------------------->
<! --------------------------abre contatos------------------------------------>
Tabela de Contatos
<table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Cargo</td>
                <td>Email</td>
                <td>Telefone</td>
                
           
            </tr>
<%        

            Vector contacts = new Vector();
            contacts = supplier.getContactInfo();
            
            for(int j = 0; j < contacts.size(); j++) {
                contactInfoDO contact = (contactInfoDO) contacts.elementAt(j);
%>              <tr>
                   <td><%= contact.getName() %></td>
                   <td><%= contact.getPosition() %></td>
                   <td><%= contact.getEmail() %></td>
                   <td><%= contact.getPhone() %></td>
               
                </tr>        
<%           } // for j - contatos      
%>        </table>            
                
<! --------------------------fecha contatos----------------------------------->
<! --------------------------abre bancos-------------------------------------->
Tabela de Dados Bancários
<table BORDER="1">
             <tr>
                 <td>N&uacutemero do Banco</td>
                 <td>Ag&ecircncia</td>
                <td>Conta</td>
                <td>CNPJ/CPF</td>
               
            </tr>
<%        
       
            Vector banks = new Vector();
            banks = supplier.getBankInfo();
            for(int k = 0; k < banks.size(); k++) {
                BankInfoDO bank = (BankInfoDO) banks.elementAt(k);
%>              <tr>
                   <td><%= bank.getBankNumber() %></td>
                   <td><%= bank.getAgency() %></td>
                   <td><%= bank.getAccount() %></td>
                   <td><%= bank.getCnpjCpf() %></td>
                   <td>
                  
                </tr>        
<%           } // for k - bancos      
%>        </table> 
                

<! --------------------------fecha bancos------------------------------------->
<! --------------------------abre endereços----------------------------------->
Tabela de Endere&ccedilos
<table BORDER="1">
             <tr>
                <td>Pa&iacutes</td>
                <td>Estado</td>
                <td>Cidade</td>
                <td>Logradouro</td>
                <td>Complemento</td>
                <td>CEP</td>
       
            </tr>
<%        
       
            Vector addresses = new Vector();
            addresses = supplier.getAddress();
            for(int u = 0; u < addresses.size(); u++) {
                supplierAddressDO address = (supplierAddressDO) addresses.elementAt(u);
%>              <tr>
                   <td><%= address.getCountry() %></td>
                   <td><%= address.getState() %></td>
                   <td><%= address.getCity() %></td>
                   <td><%= address.getStreet() %></td>
                   <td><%= address.getComplement() %></td>
                   <td><%= address.getPostalcode() %></td>
         
                 
                </tr>        
<%           } // for u - endereços      
%>        </table>            
                
<! --------------------------fecha endereços---------------------------------->
<! --------------------------abre materiais----------------------------------->
Tabela de Materiais
<table BORDER="1">
             <tr>
                <td>Nome do Material</td>
            
             </tr>
<%        
            Object[] materials = supplier.getMaterials();
            for(int v = 0; v < materials.length; v++) {
                
%>              <tr>
                   <td><%=(String) materials[v] %></td>
                   
                </tr>        
<%           } // for v - materiais     
%>        </table>            

                <form action="./supplier2.jsp" method="post">
                    <!input type="hidden" name="editar2" value="Editar" />
                    <input type="submit" name="excluir" value="Excluir" />
                    
                </form>
<! --------------------------fecha materiais---------------------------------->



<%

}//ver fornecedor
       
           else if ( null != request.getParameter("pesquisar")) {  
       transaction.supplier tn = new transaction.supplier();
       Vector suppliers = tn.getSuppliers();
       session.setAttribute("vector",suppliers);
       
       if ( (suppliers == null) || (suppliers.size() == 0)) {
         
%>
          Nenhuma versão pendente encontrada!
         
<%     } else {
%>
          
          <table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
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


