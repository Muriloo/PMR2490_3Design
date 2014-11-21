<%-- 
    Document   : header
    Created on : Nov 20, 2014, 4:18:06 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div style="height:90px;margin:0px;background-color: #6ED4B8">
    <div id="header" style="vertical-align: top;height:80px">
        <a href="index.html">
            <img src="/3Design/images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
        </a>
        <div style="float:right;">
            <form method="post" action="/3Design/home/signUp/signUp.jsp">
                <input type="submit" name="SignUp" id="SignUp" value="Sign Up" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top:20px; right:200px">
            </form>   
            <form method="post" action="/3Design/home/logIn/logIn.jsp">
                <input type="submit" name="LogIn" id="LogIn" value="Log In" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -20px; right:85px">
            </form>   
            <a href="index.html">
                <img src="/3Design/images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:-62px">
            </a>
        </div>
        <div style="display:inline;text-align: center">
            <br>
            <form method="post" action="/PMR2490_3Design/Search/search.jsp">
                <input type="search" name="keyword" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
                <input type="submit" value="" style="background:url(/3Design/images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
            </form>
        </div>
    </div>
</div>
