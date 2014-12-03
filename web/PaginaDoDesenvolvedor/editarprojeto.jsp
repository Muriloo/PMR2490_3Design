<%-- 
    Document   : editarprojeto
    Created on : 20/11/2014, 15:14:57
    Author     : PFA
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar Projeto</title>
    <link rel="stylesheet" type="text/css" href="index.css" media="all">
</head>
<body>

    <!--------------------Header--------------------------------------------------->

    <%@include file="../WEB-INF/header.jsp" %>  
    <div id="page">


        <div id="section">
            <h2>Edição de projeto</h2>
            <p>Edite aqui as informaçõees básicas do seu projeto!.</p>

            <!-------------Fim do Header--------------------------------------------------->


            <%            if (request.getParameter("campo_controle") != null) {

                    String nomeProjeto = request.getParameter("nomeProjeto");
                    String descricao = request.getParameter("descricao");
                    String preco = request.getParameter("preco");
                    String id = request.getParameter("id");

                    if (nomeProjeto == "" || descricao == "" || preco == "") {

            %> Preencha todos os campos<%        } else {
                project.projectDO project = new project.projectDO();
                project.setId(Integer.parseInt(id));
                project.setPrice(Float.parseFloat(preco));
                project.setName(nomeProjeto);
                project.setDescription(descricao);

                transaction.EditarProjeto edit = new transaction.EditarProjeto();
                try {
                    boolean result = edit.editarProjeto(project);
                    if (result == false) {

            %>
            Erro na hora de editar o projeto favor tentar novamente!;
            <%        } else {                            %>
            Projeto editado com sucesso 
            <%

                }
            } catch (Exception e) {
            %>
            Erro na hora de editar o projeto favor tentar novamente!;
            <%
                        }
                    }
                }
            %>
            <form>
                <table>
                    <tr>
                        <td>Nome do projeto</td>
                        <td><input type="text" name="nomeProjeto" />
                    </tr>
                    <tr>
                        <td>Descrição</td>
                        <td><input type="text" name="descricao" />
                    </tr>
                    <tr>
                        <td>Preço</td>
                        <td><input type="text" name="preco" />
                    </tr>                                  
                </table>
                <br>
                <input type="hidden" name="id" value="<%= request.getParameter("id")%>"/>
                <input type="submit" name="ok" value="Enviar" />
                <div style="float: left; width: 130px"> 
                        <a href="../project.jsp?projectId=<%= request.getParameter("id")%>">Voltar</a>
                </div>

                <input type="hidden" name="campo_controle" />
                <br>
            </form>
            <br>

            <!--------------------------Footer--------------------------------------------->
        </div>
    </div>
    <%@include file="../WEB-INF/footer.jsp" %>    
    <!-------------------Fim do Footer--------------------------------------------->
</body>