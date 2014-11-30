<%-- 
    Document   : header
    Created on : Nov 20, 2014, 4:18:06 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//allow access only if session exists
String customerId = (String) session.getAttribute("customerId");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("username")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
if(customerId != null){
%>
<div style="height:90px;margin:0px;background-color: #6ED4B8">
    <div id="header" style="vertical-align: top;height:80px">
        <a href="../index.jsp">
            <img src="/3Design/images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
        </a>
        <div style="float:right;">
          <form action="logoutServlet" method="post">
                <input type="submit" name="LogOut" id="LogIn" value="Log Out" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: 20px; right:85px">
            </form>   
            <a href="../index.jsp">
                <img src="/3Design/images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:-20px">
            </a>
        </div>
        <div style="display:inline;text-align: center">
            <br>
            <form>
                <input type="search" name="firstname" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
                <input type="submit" value="" style="background:url(/3Design/images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
            </form>
        </div>
    </div>

</div>

<%
}else{
%>
<div style="height:90px;margin:0px;background-color: #6ED4B8">
    <div id="header" style="vertical-align: top;height:80px">
        <a href="../index.jsp">
            <img src="/3Design/images/Logo2.bmp" alt="3Design" style="width:250px;height:80px;float: left">
        </a>
        <div style="float:right;">
            <form method="post" action="/3Design/signUp.jsp">
                <input type="submit" name="SignUp" id="SignUp" value="Sign Up" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top:20px; right:200px">
            </form>   
            <form method="post" action="/3Design/logIn.jsp">
                <input type="submit" name="LogIn" id="LogIn" value="Log In" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -20px; right:85px">
            </form>   
            <a href="../index.jsp">
                <img src="/3Design/images/Carrinho.bmp" alt="3Design" style="width:40px;height:40px;position:relative;top:-62px">
            </a>
        </div>
        <div style="display:inline;text-align: center">
            <br>
            <form method="post" action="/3Design/search.jsp">
                <input type="search" name="keyword" placeholder="Search" style="height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;" size="50">
                <input type="submit" value="" style="background:url(/3Design/images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px" />
            </form>
        </div>
    </div>
</div>
    <%
}
    
    %>

