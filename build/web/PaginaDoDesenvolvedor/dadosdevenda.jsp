<%-- 
    Document   : dadosdevenda
    Created on : Nov 26, 2014, 9:50:13 AM
    Author     : Mari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="../index.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                
        <title>Dados de Venda</title>
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
                <h2>Dados de venda</h2>
            <p>Consulte as suas vendas!</p>
        
            <%@ page import="java.util.Vector" %>
            <%@ page import="order.dadosdevendaDO" %>
            <%@ page import="transaction.buscavenda" %>
            
       <!--------------verifica se o usuário está logado-------------->
            <%
            if(customerId != null){
                int CustId = Integer.parseInt(customerId);
                
                //Dados de venda
                transaction.buscavenda bv = new transaction.buscavenda();
                Vector venda = bv.getSold(CustId);
                session.setAttribute("vector",venda);
                               
                if(venda == null || venda.size() == 0){
                    %>
                    N&atilde;o h&aacute projetos dispon&iacute;veis para visualiza&ccedil;&atilde;o
                    <%
                }
                else{
                    %>
                    <!----------------- busca projetos no customer ------------>                  
                        <table BORDER="1">
                            <tr>
                                <td><b>Nome do Projeto</b></td>
                                <td><b>Quantidade Vendida</b></td>
                                <td><b>Preço Total</b></td>
                                <td><b>Status</b></td>
                            </tr>
<%                    
                        for(int i = 0; i < venda.size(); i++){     //imprime order
                            dadosdevendaDO resultados = (dadosdevendaDO)venda.elementAt(i);                  
%>
                            <tr>
                                <td><a href="../project.jsp?projectId=<%=resultados.getId()%>"><%=resultados.getProject_name()%></a></td>
                                <td><%=resultados.getSold_quantity()%></td>
                                <td><%=resultados.getSold_total()%></td>
                                <td><%=bv.VerifStatus(resultados.getProject_status_id())%></td>
                                   
                            </tr>
<%
                            } // imprime order
%>                         
                            </table>
                    <%                     
                   }// else venda
                
            } //if customer logado
            else{
                %>
                <p>Por favor, fa&ccedil;a login</p>
                <%
            }
            %>
            
            
              
             <!--      Ainda tem que alterar abaixo  -->           

            </div> <!-- dection -->
        </div> <!-- page -->


        <br><br><br>           
<%@include file="../WEB-INF/footer.jsp" %>    

</body>
</html>