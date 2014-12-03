<%-- 
    Document   : supplierInsert
    Created on : 30/11/2014, 20:31:57
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
<%@ page import="java.util.ArrayList" %>
<%@ page import="transaction.supplier" %>
<%@ page import="project.*" %>


<!------------------------------------------------------------------->
<!--   sempre mostrar o formulario de busca, ateh acao ser "voltar" -->

<%     if ( null != request.getParameter("voltarSI")) {
%>        <jsp:forward page="./supplierPage.jsp" />
<%        return;
       }
    
     
%>

         <form action="./supplierInsert.jsp" method="post">
              <input type="submit" name="inserir" value="Inserir" />
              <input type="submit" name="voltarSI" value="Voltar" />
         </form>

<! ------------------------------------------------------------------->

        
        <% 
       if (null != request.getParameter ("editar")) {      
        
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    Vector contacts = new Vector();
    Vector banks = new Vector();
    Vector addresses = new Vector();
    ArrayList<String> materials = new ArrayList<String> ();
    boolean erro = false;
    if(null != request.getParameter("indice")){
        // editar fornecedor específico
        
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("suppliers");
    int i = Integer.parseInt(request.getParameter("indice"));
    System.out.println("INDICE="+i);
    supplier = (supplierDO)vector.elementAt(i);
    System.out.println("supplier");
    if (supplier == null){
        System.out.println("fornecedor nulo");
    }
    }else if(null != request.getParameter("editar2")){
    supplier = (supplierDO) session.getAttribute("supplier");
    contacts = supplier.getContactInfo();
    addresses = supplier.getAddress();
    banks = supplier.getBankInfo();
    System.out.println("supplier editar2");
    }else {
    /* inserir novo fornecedor: pegar os parâmetros-------------------------*/
    //gerais
           if(request.getParameter("id") != null && request.getParameter("id").length() !=0)
               supplier.setId(Integer.parseInt(request.getParameter("id")));
               if(request.getParameter("name") != null) supplier.setName(request.getParameter("name"));
               else {
                   %> Nome inválido!<%
                   erro = true;
               }
               System.out.println("supplier name: "+ supplier.getName());
               if(request.getParameter("eval") != null){
                   double eval = Double.parseDouble(request.getParameter("eval"));
                   if(eval>10) eval = 10;
                   else if (eval<0) eval =0;
                   
                   eval = eval*10;
                   int eval2 = (int) eval;
                   eval = eval2/10;
               }
               supplier.setEval( eval );
               supplier.setCapacityId(Integer.parseInt(request.getParameter("capacity")) );
               supplier.setComment(request.getParameter("comment"));
               supplier.setDescription(request.getParameter("description"));
               System.out.println("parametros ok");
           
    //contatos
           
           int p=0;
           String name = request.getParameter("contactName"+p);
           System.out.println("contactName "+name+" size "+name.length());
           
           while(null != request.getParameter("contactName"+p) && request.getParameter("contactName"+p).length() != 0){
               contactInfoDO contact = new contactInfoDO();
               if(null != request.getParameter("contactId"+p) && request.getParameter("contactId"+p).length() != 0)
                    contact.setId(Integer.parseInt(request.getParameter("contactId"+p)));
               System.out.println("entrei no contacts "+request.getParameter("contactName"+p));
               contact.setName(request.getParameter("contactName"+p));
               contact.setPosition(request.getParameter("contactPosition"+p));
               contact.setEmail(request.getParameter("contactEmail"+p));
               contact.setPhone(request.getParameter("contactPhone"+p));
               contacts.add(contact);
               p++;
           }
           if (contacts==null) System.out.println("contacts nulo");
           else{
           supplier.setContactInfo(contacts);
           System.out.println("contacts ok medio");}
    //bancos
           p=0;
           while(null != request.getParameter("bankNumber"+p) && request.getParameter("bankNumber"+p).length() != 0){
               BankInfoDO bank = new BankInfoDO();
               if(null != request.getParameter("bankId"+p) && request.getParameter("bankId"+p).length() != 0)
                    bank.setId(Integer.parseInt(request.getParameter("bankId"+p)));
               bank.setBankNumber(request.getParameter("bankNumber"+p));
               bank.setAgency(request.getParameter("bankAgency"+p));
               bank.setAccount(request.getParameter("bankAccount"+p));
               bank.setCnpjCpf(request.getParameter("bankCnpjCpf"+p));
               banks.add(bank);
               p++;
           }
           if (banks==null) System.out.println("banks nulo");
           else
           supplier.setBankInfo(banks);
    //endereços
           p=0;
           while(null != request.getParameter("addressCountry"+p) && request.getParameter("addressCountry"+p).length() != 0){
               supplierAddressDO address = new supplierAddressDO();
               if(null != request.getParameter("addressId"+p) && request.getParameter("addressId"+p).length() != 0)
                    address.setId(Integer.parseInt(request.getParameter("addressId"+p)));
               address.setCountry(request.getParameter("addressCountry"+p));
               address.setState(request.getParameter("addressState"+p));
               address.setCity(request.getParameter("addressCity"+p));
               address.setStreet(request.getParameter("addressStreet"+p));
               address.setComplement(request.getParameter("addressComplement"+p));
               address.setPostalcode(request.getParameter("addressPostalcode"+p));
               addresses.add(address);
               p++;
           }
           if (addresses==null) System.out.println("addresses nulo");
           else supplier.setAddress(addresses);
    //materiais
           System.out.println("antes de materiais");
            p=0;
            while(null != request.getParameter("material"+p) && request.getParameter("material"+p).length() != 0){
                materials.add(p,request.getParameter("material"+p));
                p++;
            }
            if (materials==null) System.out.println("materials nulo");
            else supplier.setMaterials(materials.toArray());
           
           supplier sp = new supplier();
           System.out.println("vai inserir");
           if(null != request.getParameter("inserir")){
                supplierDO supplier2 = sp.include(supplier);
                if(supplier2.getId() != -1){// fornecedor inserido
                System.out.println("inserido");
                supplier = supplier2;
                
                %>
           Fornecedor inserido com sucesso!
                <%
                } else{
                System.out.println("nao inserido");
                %>
           Erro na inser&ccedil&atildeo do fornecedor!
                <%
            }//erro na inserção
           }else{//editar
                supplierDO supplier2 = sp.update(supplier);
                if(supplier2.getId() != -1){// fornecedor editado
                supplier = supplier2;
                System.out.println("editado");
                
                %>
           Fornecedor editado com sucesso!
                <%
                } else{
                System.out.println("nao editado");
                %>
           Erro na edi&ccedil&atildeo do fornecedor!
                <%
            }//erro na edição
           }//editar
           
       } // novo fornecedor
%>        

<! --------------------------abre geral-------------------------------------->
<h2>Editar Fornecedor</h2>
<table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                
            </tr>
            <form action="./supplierInsert.jsp" method="post">
            <tr>
                    <td>
                        <INPUT TYPE="text" NAME="name" value="<%= supplier.getName()%>">
                    </td>
                    <td>
                       <INPUT TYPE="text" NAME="eval" value="<%= supplier.getEval() %>">
                    </td>
                    <td>
                       <INPUT TYPE="text" NAME="capacity" value="<%= supplier.getCapacityId() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="comment" value="<%= supplier.getComment() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="description" value="<%= supplier.getDescription() %>">
                    </td>
                    
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
<%        // contatos
System.out.println("antes do if dos contatos!=null");
        if (contacts != null) {           
            System.out.println("antes do for dos contatos!=null");
            for(int j = 0; j < contacts.size(); j++) {
                contactInfoDO contact = (contactInfoDO) contacts.elementAt(j);
                
%>
                <input type="hidden" name="contactId<%=j%>" value="<%= contact.getId() %>">
                <tr>
                    <td>
                        <INPUT TYPE="text" NAME="contactName<%=j%>" value="<%= contact.getName() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="contactPosition<%=j%>" value="<%= contact.getPosition() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="contactEmail<%=j%>" value="<%= contact.getEmail() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="contactPhone<%=j%>" value="<%= contact.getPhone() %>">
                    </td>
                    
                </tr>        
<%          
            } // for j - contatos
%>
            
            <tr>
                <td> <INPUT TYPE="text" NAME="contactName<%=contacts.size()%>"  > </td>
                <td> <INPUT TYPE="text" NAME="contactPosition<%=contacts.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="contactEmail<%=contacts.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="contactPhone<%=contacts.size()%>" > </td>
            </tr>
                    
<%
        } // if (contacts != null)
        else{
            %>
            <tr>
                <td> <INPUT TYPE="text" NAME="contactName0" > </td>
                <td> <INPUT TYPE="text" NAME="contactPosition0" > </td>
                <td> <INPUT TYPE="text" NAME="contactEmail0" > </td>
                <td> <INPUT TYPE="text" NAME="contactPhone0" > </td>
            </tr>        
                    <%
            System.out.println("contact ==  null");
        }
%>              

        </table>
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
<%          // bancos


        if (banks != null){
            System.out.println("bancos nao nulo:" +banks.size());
            for(int k = 0; k < banks.size(); k++) {
                BankInfoDO bank = (BankInfoDO) banks.elementAt(k);
%>
                <input type="hidden" name="bankId<%=k%>" value="<%= bank.getId() %>">
                <tr>
                    <td>
                        <INPUT TYPE="text" NAME="bankNumber<%=k%>" value="<%= bank.getBankNumber() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="bankAgency<%=k%>" value="<%= bank.getAgency() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="bankAccount<%=k%>" value="<%= bank.getAccount() %>">
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="bankCnpjCpf<%=k%>" value="<%= bank.getCnpjCpf() %>">
                    </td>
                   
                </tr>        
<% 
            } // for k - bancos 
%>
            <tr>
                <td> <INPUT TYPE="text" NAME="bankNumber<%=banks.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="bankAgency<%=banks.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="bankAccount<%=banks.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="bankCnpjCpf<%=banks.size()%>" > </td>
            </tr>
         
<%
        } // if (banks != null)
        else{
            %>
            <tr>
                <td> <INPUT TYPE="text" NAME="bankNumber0" > </td>
                <td> <INPUT TYPE="text" NAME="bankAgency0" > </td>
                <td> <INPUT TYPE="text" NAME="bankAccount0" > </td>
                <td> <INPUT TYPE="text" NAME="bankCnpjCpf0" > </td>
            </tr>
            <%
        }
%>
        </table>
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
<%          //endereços
 System.out.println("antes de endereços");
        if (addresses != null){
            for(int u = 0; u < addresses.size(); u++) {
                supplierAddressDO address = (supplierAddressDO) addresses.elementAt(u);
%>              
                <input type="hidden" name="addressId<%=u%>" value="<%= address.getId() %>">
                <tr>
                    <td>
                        <INPUT TYPE="text" NAME="addressCountry<%=u%>" value="<%= address.getCountry() %>" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="addressState<%=u%>" value="<%= address.getState() %>" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="addressCity<%=u%>" value="<%= address.getCity() %>" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="addressStreet<%=u%>" value="<%= address.getStreet() %>" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="addressComplement<%=u%>" value="<%= address.getComplement() %>" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="addressPostalcode<%=u%>" value="<%= address.getPostalcode() %>" >
                    </td>
                   
                </tr>        
<%
            } // for u - endereços 
%>

            <tr>
                <td> <INPUT TYPE="text" NAME="addressCountry<%=addresses.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="addressState<%=addresses.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="addressCity<%=addresses.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="addressStreet<%=addresses.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="addressComplement<%=addresses.size()%>" > </td>
                <td> <INPUT TYPE="text" NAME="addressPostalcode<%=addresses.size()%>" > </td>
            
            </tr>
               
<%
        } // if (addresses != null)
        else{
            %>
            <tr>
                <td> <INPUT TYPE="text" NAME="addressCountry0" > </td>
                <td> <INPUT TYPE="text" NAME="addressState0" > </td>
                <td> <INPUT TYPE="text" NAME="addressCity0" > </td>
                <td> <INPUT TYPE="text" NAME="addressStreet0" > </td>
                <td> <INPUT TYPE="text" NAME="addressComplement0" > </td>
                <td> <INPUT TYPE="text" NAME="addressPostalcode0" > </td>
            
            </tr>
            <%
        }
%>
        </table>    
<! --------------------------fecha endereços---------------------------------->
<! --------------------------abre materiais----------------------------------->
Tabela de Materiais
<table BORDER="1">
             <tr>
                <td>Nome do Material</td>
             </tr>
<%         
 System.out.println("antes de materiais");
        if(materials != null){
            Object[] materials2 = materials.toArray();
            for(int v = 0; v < materials2.length; v++) {
                
%>              
                <tr>
                    <td>
                        <INPUT TYPE="text" NAME="material<%=v%>" value="<%=(String) materials2[v] %>" >
                    </td>
                    
                </tr>        
<%
            } // for v - materiais
%>
                <td>
                        <INPUT TYPE="text" NAME="material<%=materials2.length%>" >
                </td>
                   
<%
        } // if(materials != null)
        else{
            %>
            <td>
                        <INPUT TYPE="text" NAME="material0" >
            </td>
            <%
        }
%>
        </table>     
<! --------------------------fecha materiais---------------------------------->
                <input type="hidden" name="id" value="<%= supplier.getId()%>" />
                <input type="submit" name="voltarSI" value="Voltar" />
                <input type="submit" name="editar" value="Enviar" />
</form>     

<%

}//editar
       else /*if (null != request.getParameter ("inserir"))*/ {
       
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
        
%>        

<! --------------------------abre geral-------------------------------------->
<h2>Inserir Fornecedor</h2>
<table BORDER="1">
             <tr>
                <td>Nome</td>
                <td>Avaliação</td>
                <td>Capacidade</td>
                <td>Comentarios</td>
                <td>Descrição</td>
                
            </tr>
<form action="./supplierInsert.jsp" method="post">
              <tr>
                    <td>
                        <INPUT TYPE="text" NAME="name" >
                    </td>
                    <td>
                       <INPUT TYPE="text" NAME="eval" >
                    </td>
                    <td>
                       <INPUT TYPE="text" NAME="capacity" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="comment" >
                    </td>
                    <td>
                        <INPUT TYPE="text" NAME="description" >
                    </td>
                    
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
            <tr>
                <td> <INPUT TYPE="text" NAME="contactName0" > </td>
                <td> <INPUT TYPE="text" NAME="contactPosition0" > </td>
                <td> <INPUT TYPE="text" NAME="contactEmail0" > </td>
                <td> <INPUT TYPE="text" NAME="contactPhone0" > </td>
            </tr>
        </table>            
                
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
            <tr>
                <td> <INPUT TYPE="text" NAME="bankNumber0" > </td>
                <td> <INPUT TYPE="text" NAME="bankAgency0" > </td>
                <td> <INPUT TYPE="text" NAME="bankAccount0" > </td>
                <td> <INPUT TYPE="text" NAME="bankCnpjCpf0" > </td>
            </tr>
        </table> 
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
            <tr>
                <td> <INPUT TYPE="text" NAME="addressCountry0" > </td>
                <td> <INPUT TYPE="text" NAME="addressState0" > </td>
                <td> <INPUT TYPE="text" NAME="addressCity0" > </td>
                <td> <INPUT TYPE="text" NAME="addressStreet0" > </td>
                <td> <INPUT TYPE="text" NAME="addressComplement0" > </td>
                <td> <INPUT TYPE="text" NAME="addressPostalcode0" > </td>
            
            </tr>
        </table>            
                
<! --------------------------fecha endereços---------------------------------->
<! --------------------------abre materiais----------------------------------->
Tabela de Materiais
<table BORDER="1">
             <tr>
                <td>Nome do Material</td>
                
             </tr>
                <td>
                        <INPUT TYPE="text" NAME="material0" >
                </td>
       </table>            

                
<! --------------------------fecha materiais---------------------------------->

                <input type="hidden" name="inserir" value="Inserir" />
                <input type="submit" name="voltarSI" value="Voltar" />
                <input type="submit" name="editar" value="Enviar" />
</form>     

<%

}//inserir%>

<!--------------------------Footer--------------------------------------------->

</div>
</div>

<%@include file="WEB-INF/footer.jsp" %>    
<!-------------------Fim do Footer--------------------------------------------->

</body>

</html>



