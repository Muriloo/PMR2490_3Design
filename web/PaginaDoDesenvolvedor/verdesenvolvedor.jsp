<%-- 
    Document   : verdesenvolvedor
    Created on : Nov 30, 2014, 5:00:31 PM
    Author     : Mari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="../index.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Ver Desenvolvedor</title>
    </head>

    <body>
        <%@include file="../WEB-INF/header.jsp" %>     
        
        <div id="page">
            <div id="nav">
                Coisa 3D<br>
                Mais uma coisa 3D<br>
                Such 3D!<br>
            </div> <!-- Nav -->

            <div id="section">
                                
                <%@ page import="java.util.Vector" %>
                <%@ page import="order.orderitemDO" %>
                <%@ page import="transaction.buscavenda" %>
                <%@ page import="order.projectDO" %>
                <%@ page import="data.ContatoData" %>
                <%@ page import="data.ContatoDO" %>
        
                <!-------------- Fim do header ----------------->

<% boolean entra =true;%>
                
        <%  if (entra) {  
                System.out.println("------entra no ver ----");
                //int CustId = Integer.parseInt(request.getParameter("iddesenvolvedor"));
                int CustId = 1;
                transaction.buscavenda bv = new transaction.buscavenda();
                Vector venda = bv.getCustProject(CustId);
                session.setAttribute("vector",venda);
                
                if( venda== null || venda.size() == 0){ // modificado, verificar no pending projects
                    %>
                   
                    <h2>Projetos do Desenvolvedor</h2>
                    Nenhum projeto encontrado :/
<%          } else {
         
            ContatoDO nome = bv.getCustUsername(CustId);
            
            %>
            
            <h1>Desenvolvedor: <%=nome.getUsername() %></h1> 
            <br>
            <h2>Projetos do Desenvolvedor</h2>
            <table BORDER="1">
                    <tr>
                    <td>ID do Projeto</td>
                    <td>Nome do Projeto</td>
                    <td>Descrição do Projeto</td>
                    <td>Detalhes</td>
                    <td>Pre&ccedil;o</td>
                    <td>Status</td>
                    </tr>
                    
<%                  for(int i = 0; i < venda.size(); i++) {
                    projectDO projetos = (projectDO)venda.elementAt(i);
                    //orderitemDO projetos = (orderitemDO)venda.elementAt(i);
%>                  <tr>
                    <td><%=projetos.getId() %></td> <!-- mudar:  getProject_id para getId -->
                    <td><%=projetos.getName() %></td>
                    <td><%=projetos.getDescription() %></td>
                    <td><%=projetos.getDetail()%></td>
                    <td><%=projetos.getPrice() %></td>
                    <td><%=projetos.getStatus_id() %></td>
                    </tr>        
<%                  } // for i      
%>                  </table>            
<%     } // returned
     } // pesquisar
%>

            </div> <!-- section -->
        </div> <!-- page -->
            
<%@include file="../WEB-INF/footer.jsp" %>    

</body>
</html>