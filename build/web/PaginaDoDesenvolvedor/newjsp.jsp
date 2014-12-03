<%-- 
    Document   : verdesenvolvedor
    Created on : Nov 30, 2014, 5:00:31 PM
    Author     : Eduardo Seiti
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
                <h2>P&aacutegina do Desenvolvedor</h2>
                
                <%@ page import="java.util.Vector" %>
                <%@ page import="order.orderitemDO" %>
                <%@ page import="transaction.buscavenda" %>
                <%@ page import="project.projectDO" %>
        
                <!-------------- Fim do header ----------------->
                
                <div>
                <form action="LogServlet" method="post">
                <table>
                    <tr>
                        <td>ID desenvolvedor</td>
                        <td><input type="text" name="iddesenvolvedor" />
                    </tr>
                    </table>
                <input type="submit" value="Ver" />
                </form>
                </div>
                
                <%
                if(null != request.getParameter("iddesenvolvedor")){
                int CustId = Integer.parseInt(request.getParameter("iddesenvolvedor"));
                transaction.buscavenda bv = new transaction.buscavenda();
                Vector venda = bv.getCustProject(CustId);
                session.setAttribute("vector",venda);
                }
                
                if(venda == null || venda.size() == 0){
                    %>
                    Nenhifuma venda encontrada.
                    <%
                }
                else{
                    %>
                    <table BORDER="1">
                    <tr>
                    <td>ID do Projeto</td>
                    </tr>
<%                  for(int i = 0; i < venda.size(); i++) {
                    projectDO projetos = (projectDO)venda.elementAt(i);
                    //orderitemDO projetos = (orderitemDO)venda.elementAt(i);
%>                  <tr>
                    <td><%=projetos.getId() %></td> <!-- mudar:  getProject_id para getId -->
                    </tr>        
<%                  } // for i      
%>                  </table>
                    <%
                }// else
                
            %>

            </div> <!-- section -->
        </div> <!-- page -->


            
<%@include file="../WEB-INF/footer.jsp" %>    

</body>
</html>