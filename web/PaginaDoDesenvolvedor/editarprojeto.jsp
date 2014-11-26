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
        <title>Editar projeto</title>

    <body>

        <%@include file="../WEB-INF/header.jsp" %>   


        <div class="form_description">
            <h2>Edição de projeto</h2>
            <p>Edite aqui as informações básicas do seu projeto!.</p>
        </div>						
        <ul >

            <%
                if (request.getParameter("campo_controle") != null) {
                    // processa signUp
                    String nomeProjeto = request.getParameter("nomeProjeto");
                    String descricao = request.getParameter("descricao");
                    String preco = request.getParameter("preco");
//                    int preco2;
//                    preco2 = Integer.parseInt(preco.trim());
//                    
//                    System.out.print(preco2);
                    System.out.print(nomeProjeto);
                    System.out.print(descricao);
                    System.out.print(preco);

                    if (nomeProjeto == null || descricao == null) {
                        
                        System.out.print(1);
                    System.out.print(descricao);
                    System.out.print(preco);
            %> Preencha todos os campos<%
                    } else {
                        System.out.print(2);
                    System.out.print(descricao);
                    System.out.print(preco);
                        transacoes.Contato tn = new transacoes.Contato();
                        data.ContatoDO contato = new data.ContatoDO();

//                            contato.setNomeProjeto(nomeProjeto);
//                            contato.setDescricao(descricao);
//                            contato.setPreco(preco);
                    }
                }
            %>
            <form >
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
              


                    <input  type="submit" name="ok" value="Enviar" >
                    <input type="hidden" name="campo_controle" />
            </form>

        </li>
    </ul>


</div>

<%@include file="../WEB-INF/footer.jsp" %>    

</body>
</html>
