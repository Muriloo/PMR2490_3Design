<%-- 
    Document   : alterarsenha
    Created on : Nov 29, 2014, 8:37:39 PM
    Author     : 44RBO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="index.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aterar Senha</title>
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <div>
            <form action="alterarsenha" method="post">
            <table>
                    <tr>
                        <td>Confirmar nome de usuario: </td>
                        <td><input type="text" name="username" />
                        <td>
                    </tr>
                     <tr>
                        <td>Senha atual: </td>
                        <td><input type="text" name="senhaatual" />
                        <td>
                    </tr>
                     <tr>
                        <td>Nova senha: </td>
                        <td><input type="text" name="novasenha1" />
                        <td>
                    </tr>
                     <tr>
                        <td>Repetir nova senha: </td>
                        <td><input type="text" name="novasenha2" />
                        <td>
                    </tr>
                </table>
            
                <input type="submit" value="Alterar senha" />
                </form>
            </div>
        
        <%@include file="/WEB-INF/footer.jsp" %>   
        
        
    </body>
</html>
