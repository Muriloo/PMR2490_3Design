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
        
        <div style="height:90px;margin:0px;background-color: #6ED4B8">
<div id="header" style="vertical-align: top;height:80px">
    <a href="index.html">
        <img src="images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
    </a>
    <div style="float:right;">
    <a class="header" href="teste.jsp">Sign Up</a>
    <span style="letter-spacing:14px;"> |</span>
    <a class="header" href="index.html">Log In </a>
    <span style="letter-spacing:14px;"> |</span>
    <a href="index.html">
        <img src="images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:12px">
    </a>
    </div>
    <div style="display:inline;text-align: center">
    <br>
    <form>
        <input type="search" name="firstname" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
        <input type="submit" value="" style="background:url(images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
    </form>
    </div>
</div>
</div>

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

<form action="suppliersPage.jsp" method="post">
               
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
