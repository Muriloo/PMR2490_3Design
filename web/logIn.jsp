<%-- 
    Document   : logIn
    Created on : 19/11/2014, 00:25:14
    Author     : Mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <%@include file="/WEB-INF/header.jsp" %>
        <div>
            <form action="LogServlet" method="post">
                <table>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" />
                    </tr>
                    <tr>
                        <td>Senha</td>
                        <td><input type="password" name="senha" />
                    </tr>
                </table>
                <input type="submit" value="Login" />
                 <a class="header" href="esqueceusenha.jsp">esqueci minha senha </a>
            </form>
        </div>


        <%@include file="/WEB-INF/footer.jsp" %>   


    </body>
</html>
