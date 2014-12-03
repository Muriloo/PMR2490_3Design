<%-- 
    Document   : Perfil
    Created on : 18/11/2014, 15:48:09
    Author     : Rodrigo & Caue
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina do Perfil</title>
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

                <!-------------Fim do Header--------------------------------------------------->

                <%@ page import="java.util.Vector" %>
                <%@ page import="utils.MetodosUteis" %>
                <%@ page import="data.ContatoDO" %>
                <%@ page import="user.userDO" %>
                <%@ page import="project.projectDO" %>

                <!------------pega o projeto do BD--------------------------------------------->
                <% if (customerId == null) {
                    %> Por favor fazer Login. 
                <%
                    } else {
                
                
                String customerIdStr = request.getParameter("id");

                    transaction.VerPerfil Perfil = new transaction.VerPerfil();
                    Vector pInfo = Perfil.getCustomerInfo(customerIdStr);
                    session.setAttribute("vector", pInfo);

                    transaction.VerPerfil Perfil2 = new transaction.VerPerfil();
                    Vector pInfo2 = Perfil2.getCustomerProjectInfo(customerIdStr);
                    session.setAttribute("vector", pInfo2);

                    userDO user = (userDO) pInfo.elementAt(0);%>
                <h1> Perfil: <%=user.getName()%></h1> 
                <table><tr><td>Nome:</td> <td><%=user.getName()%> <%=user.getLastname()%></td></tr>
                    <tr><td>País:</td> <td><%=user.getCountry()%></td> </tr>
                </table>
                <br>
                <%
                    if ((pInfo2 == null) || (pInfo2.size() == 0)) {
                        // avisar usuario que nao ha' contatos com este nome
                %>
                Projetos encontrados: Nenhum.

                <%
                } //if nenhum resultado 
                else {
                %> 
                <table><tr><td>Projetos:</td></tr>
                    <%          for (int i = 0; i < pInfo2.size(); i++) {
                            projectDO project = (projectDO) pInfo2.elementAt(i);

                    %>
                    <tr><td><a href="./project.jsp?projectId=<%=project.getId()%>"><%= project.getName()%></a></td></tr>
                            <%           } // for i      
                            %>
                </table>
                <%
                    } //searchproject
                %>

                <!--------------------------Botões--------------------------------------------->              

                <br><br>
                <%if (customerId == null) {
                    } else if (Integer.parseInt(customerId) == user.getId()) {
                %>
                <div style="width:400px;">
                    <div style="float: left; width: 130px"> 
                        <form id="thisone">
                            <a href="./PaginaDoUsuário/editarperfil.jsp?id=<%=customerIdStr%>">Editar Perfil</a>
                        </form>
                    </div>
                    <div style="float: right; width: 225px"> 
                        <form id="thistoo">
                            <a href="./PaginaDoUsuário/removerperfil.jsp?id=<%=customerIdStr%>">Remover Perfil</a>
                        </form>
                    </div>
                </div>
                <%
    } else if (Integer.parseInt(user_permission_id) == 2) {%>
                <div> 
                    <form>
                        <a href="./PaginaDoModerador/removerusuario.jsp?id=<%=customerIdStr%>">Remover Projeto</a>
                    </form>
                </div>
                <%
                    }
                %>
                <%
                    }
                %>
                <!--------------------------Footer--------------------------------------------->

            </div>
        </div>

        <%@include file="WEB-INF/footer.jsp" %>    
        <!-------------------Fim do Footer--------------------------------------------->

    </body>

</html>
