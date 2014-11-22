<%-- 
    Document   : editarprojeto
    Created on : 20/11/2014, 15:14:57
    Author     : PFA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
   
<head>
<link rel="stylesheet" type="text/css" href="index.css" media="all">
</head>
    
<body>
    
 <%@include file="../WEB-INF/header.jsp" %>    
    
    <div class="form_description">
            
        <%
            String id = request.getParameter("id");       
        %>
        <h1>Produtos adicionados no carrinho</h1>
        
        <h2><%= id %></h2>
        
        <%
            // Setando parámetros para conectar com o servidor de banco de dados
            String url = "jdbc:mysql://localhost/3design?";
            String uid = "root";
            String pwd = "Pmr2490";
            

            Connection conn = null;
            ResultSet results = null;
            Statement statement = null;
            
            ResultSet list = null;

            try
            {
                %>

                <%
                // fazendo a conexão com o servidor
                // carregando driver certo para conexão
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, uid, pwd);
                statement = conn.createStatement();
                results = statement.executeQuery("select * from item_cart "
                                                 + "where customer_id = 1 AND deleted = 0" );

                // leendo o banco para mostrar conteudo em tabela HTML
                %>
                <TABLE BORDER="1">
                    <TR>
                        <TD>Nome do Projeto</TD>
                        <TD>Descrição</TD>
                        <TD>Detalhes</TD>
                        <TD>Preço</TD>
                    </TR>
               
                    <%
                // mentras existam dados para processar
                while(results.next())
                { 
                    list = statement.executeQuery("select * from project where id = " + results.getString(1));

                %>
                        <!lendo cada um dos campos da tabela (nome, sobrenome, etc)
                        e mostrando na tabela HTML>
                        <TR>
                            <TD> <%= list.getString(2) %> </TD>
                            <TD> <%= list.getString(3) %> </TD>
                            <TD> <%= list.getString(4) %> </TD>
                            <TD> t </TD>
                        </TR>
                <%
                }
                %>
                </TABLE>
                
                
                <%
            }
            // capturando exeções em caso de erro
            catch (ClassNotFoundException e)
            {
                System.out.println("Opps I can't find the JDBC Driver!");
                e.printStackTrace();
            }
            catch (Exception e)
            {
                System.out.println("There was a problem with the SQL!");
                e.printStackTrace();
            }
            finally
            {
                // fechando conexão com o servidor
                if (conn != null)
                {
                    try
                    {
                        conn.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        %>
        <br>
        
        <%@include file="../WEB-INF/footer.jsp" %>    
    
</body>
</html>
