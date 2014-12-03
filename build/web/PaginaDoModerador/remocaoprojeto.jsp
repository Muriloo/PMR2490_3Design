<%-- 
    Document   : remocaoprojeto
    Created on : 02/12/2014, 00:02:14
    Author     : RodrigoY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
        <title>Remover Projeto</title>
    </head>

    <body>
<!--------------------Header--------------------------------------------------->
        <%@include file="../WEB-INF/header.jsp" %>    
<!-------------Fim do Header--------------------------------------------------->
        <%            boolean is_printable = true;

            if (request.getParameter("campo_controle") != null) {
                String id = request.getParameter("id");

                project.projectDO project = new project.projectDO();
                project.setId(Integer.parseInt(id));

                transaction.DeletarProjeto delete = new transaction.DeletarProjeto();
                try {
                    boolean result = delete.deletarPojeto(project);
                    if (result = false) {
        %>
        Erro na hora de deletar o projeto favor tentar novamente!;
        <%
        } else {
            is_printable = false;
        %>
        Projeto deletado com sucesso
        <%
            }
        } catch (Exception e) {
        %>
        Erro na hora de deletar o projeto favor tentar novamente!;
        <%
                }
            }
            if (is_printable) {

        %>
        <div id="form_container">

            <h1><a>Página de exclusão de projeto</a></h1>

            <div class="form_description">		
                <p>Você deseja realmente excluir este projeto?</p>
            </div>	
            <ul >
                <form>        
                    <input type="hidden" name="id" value="<%= request.getParameter("id")%>"/>
                    <input type="submit" name="ok" value="Confirmar" />
                    <input type="hidden" name="campo_controle" />
                </form>
                <br><br>
                <%}%>
                <br><br>
                <a href="http://localhost:8080/3Design/project.jsp?projectId=<%= request.getParameter("id")%>"> Voltar </a>
            </ul>

            <%@include file="../WEB-INF/footer.jsp" %>    


    </body>
</html>

