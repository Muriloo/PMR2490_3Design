<%-- 
    Document   : removerperfil
    Created on : 02/12/2014, 21:02:20
    Author     : RodrigoY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
    </head>

    <body>

        <%@include file="../WEB-INF/header.jsp" %>    

        <%        if (request.getParameter("campo_controle") != null) {
                String id = request.getParameter("id");

                user.userDO user = new user.userDO();
                user.setId(Integer.parseInt(id));

                transaction.DeletarUsuario delete = new transaction.DeletarUsuario();
                try {
                    boolean result = delete.deletarUsuario(user);
                    if (result = false) {
        %>
        Erro na hora de deletar o usuario favor tentar novamente!;
        <%
        } else {
        %>
        <jsp:forward page="../index.jsp" />
        <%
            }
        } catch (Exception e) {
        %>
        Erro na hora de deletar o Usuario favor tentar novamente!;
        <%
                }
            }

        %>
        <div id="form_container">

            <h1><a>Página de exclusão de Usuários</a></h1>

            <div class="form_description">

                <p>Você deseja realmente excluir este Usuário?</p>
            </div>	
            <ul >
                <form>        
                    <input type="hidden" name="id" value="<%= request.getParameter("id")%>"/>
                    <input type="submit" name="ok" value="Confirmar" />
                    <input type="hidden" name="campo_controle" />
                </form>
                <br><br>
                <a href="http://localhost:8080/3Design/user.jsp?Id=<%= request.getParameter("id")%>"> Voltar </a>
            </ul>

            <%@include file="../WEB-INF/footer.jsp" %>    


    </body>
</html>

