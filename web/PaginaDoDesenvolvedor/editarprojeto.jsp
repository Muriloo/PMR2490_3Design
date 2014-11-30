<%-- 
    Document   : editarprojeto
    Created on : 20/11/2014, 15:14:57
    Author     : PFA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="index.css" media="all">
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>

        <%@include file="../WEB-INF/header.jsp" %>   


        <div class="form_description">
            <h2>Edição de projeto</h2>
            <p>Edite aqui as informaçõees básicas do seu projeto!.</p>
        </div>						
       
            <%
                if (request.getParameter("campo_controle") != null) {
                    // processa signUp
                    String nomeProjeto = request.getParameter("nomeProjeto");
                    String descricao = request.getParameter("descricao");
                    String preco = request.getParameter("preco");
                    String id = request.getParameter("id");
//                    int preco2;
//                    preco2 = Integer.parseInt(preco.trim());
//                    
//                    System.out.print(preco2);
                if (nomeProjeto == "" || descricao == "" || preco == "") {
                        
                        System.out.print(1);
                        System.out.print(descricao);
                        System.out.print(preco);
            %> Preencha todos os campos<%
                    } else {
                        project.projectDO project = new project.projectDO();
                        project.setId(Integer.parseInt(id));
                        project.setPrice(Float.parseFloat(preco));
                        project.setName(nomeProjeto);
                        project.setDescription(descricao);
    
                        System.out.print(2);
                        System.out.print(descricao);
                        System.out.print(preco);
                        
                        transaction.EditarProjeto edit = new transaction.EditarProjeto();
                        try {
                            boolean result = edit.editarProjeto(project);
                            if (result==false) {
                               
                            %>
                    Erro na hora de editar o projeto favor tentar novamente!;
                            <%
                            }
                            else {                            %>
                    Projeto editado com sucesso
                            <%
                            }
                        }
                            catch (Exception e){
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
                     <input type="submit" name="ok" value="Cancelar" />
                     <input type="hidden" name="campo_controle" />
                     <br>
            </form>
            <br>
</div>

<%@include file="../WEB-INF/footer.jsp" %>    

</body>
</html>