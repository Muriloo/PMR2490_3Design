<%-- 
    Document   : paginadomoderador.jsp
    Created on : 02/12/2014, 17:58:38
    Author     : Edson Yuji Tsuzuke
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
<h2>Página do Moderador</h2>
        
<!-------------Fim do Header--------------------------------------------------->

<form action="pending-projects.jsp" method="post">
               
   <input type="submit" value="Projetos Pendentes" style="position:relative;float: right" />
</form>

<form action="supplierPage.jsp" method="post">
               
   <input type="submit" value="Consulta de Fornecedores" style="position:relative;float: left" />
   
</form>
                     <!código da página>

                     
                     
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
