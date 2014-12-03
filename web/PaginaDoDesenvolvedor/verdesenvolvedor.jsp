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
                <%@ page import="project.projectDO" %>
                <%@ page import="data.ContatoData" %>
                <%@ page import="data.ContatoDO" %>
        
                <!-------------- Fim do header ----------------->

<% boolean entra =true;%>
                
        <%  if (entra) {  
                System.out.println("------entra no ver ----");
                //      -------------- alterar CustId ----------------
                int CustId = 1;
                transaction.buscavenda bv = new transaction.buscavenda();
                Vector venda = bv.getCustProject(CustId);
                session.setAttribute("vector",venda);
                
                if( venda== null || venda.size() == 0){ // modificado, verificar no pending projects
                    %>
                   
                    <h2>Projetos do Desenvolvedor</h2>
                    Nenhum projeto encontrado.
<%          } else {
         
            ContatoDO nome = bv.getCustUsername(CustId);
            
            %>
            
            <h1>Desenvolvedor: <%=nome.getUsername() %></h1> 
            <br>
            <h2>Projetos do Desenvolvedor</h2>
            <table BORDER="1">
                    <tr>
                    <td><b>Nome do Projeto</b></td>
                    <td><b>Descrição do Projeto</b></td>
                    <td><b>Detalhes</b></td>
                    <td><b>Pre&ccedil;o</b></td>
                    </tr>
                    
<%                  for(int j = 0; j < venda.size(); j++) {
                        projectDO resultados = (projectDO)venda.elementAt(j);

%>                      <tr>
                            <td><a href="../project.jsp?projectId=<%=resultados.getId()%>"><%= resultados.getName()%></a></td>
                            <td><%= resultados.getDescription() %></td>
                            <td><%= resultados.getDetail()%></td>
                            <td><%= resultados.getPrice() %></td>
                        </tr>        
<%                  } // for i      
%>              </table>            
<%     } // returned
     } // pesquisar
%>

            </div> <!-- section -->
        </div> <!-- page -->
            
<%@include file="../WEB-INF/footer.jsp" %>    

</body>
</html>