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
     <div style="height:90px;margin:0px;background-color: #6ED4B8">
            <div id="header" style="vertical-align: top;height:80px">
                <a href="../../index.html">
                    <img src="../../images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
                </a>
                <div style="float:right;">
                    <form method="post" action="/PMR2490_3Design/home/signUp/signUp.jsp">
                        <input type="submit" name="SignUp" id="SignUp" value="Sign Up" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top:20px; right:200px">
                    </form>   
                    <form method="post" action="/PMR2490_3Design/home/logIn/logIn.jsp">
                        <input type="submit" name="LogIn" id="LogIn" value="Log In" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -20px; right:85px">
                    </form>   
                    <a href="../../index.html">
                        <img src="../../images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:-62px">
                    </a>
                </div>
                <div style="display:inline;text-align: center">
                    <br>
                    <form>
                        <input type="search" name="firstname" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
                        <input type="submit" value="" style="background:url(../../images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
                    </form>
                </div>
            </div>
        </div>



        <div>
            <form>
                <table>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" />
                    </tr>
                    <tr>
                        <td>Senha</td>
                        <td><input type="password" name="pwd" />
                    </tr>
                </table>
                <input type="submit" name="ok" value="Entrar" />
            </form>
        </div>


        <div style="height:160px;margin: 0px auto;display: block;background-color:#6ED4B8;clear:both;">
            <div id="footer">
                <table id="bottomlinks">
                    <tbody>
                        <tr>
                            <td style="vertical-align: top;width:800px">
                                <h3>Modo de Pagamento</h3>
                                <a href="https://pagseguro.uol.com.br/" target="_blank">
                                    <img src="../../images/pagseguro.bmp" alt="pagseguro" style="width:100px;height:30px">
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


    </body>
</html>
