<%-- 
    Document   : esqueceusenha
    Created on : Nov 26, 2014, 10:25:12 AM
    Author     : 44rbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="index.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esqueceu Senha</title>
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <div>
            <form action="esqueceusenha" method="post">
            <table>
                    <tr>
                        <td>E-mail: </td>
                        <td><input type="text" name="email" />
                        <td>
                    </tr>
                </table>
                <input type="submit" value="Recuperar Senha" />
            </table>
            </div>
        
        <%@include file="/WEB-INF/footer.jsp" %>   
        
        
    </body>
</html>