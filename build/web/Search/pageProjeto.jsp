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
            id = id.toUpperCase();       
        %>    
        
        <%
            // Setando parámetros para conectar com o servidor de banco de dados
            String url = "jdbc:mysql://localhost/3design?";
            String uid = "root";
            String pwd = "Pmr2490";
            

            Connection conn = null;
            ResultSet results = null;
            Statement statement = null;

            try
            {
                %>

                <%
                // fazendo a conexão com o servidor
                // carregando driver certo para conexão
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, uid, pwd);
                statement = conn.createStatement();

                // leendo o banco para mostrar conteudo em tabela HTML
                results = statement.executeQuery("select * from project where id =" + id);
                %>
               
                    <%
                // mentras existam dados para processar
                while(results.next())
                {
                %>
                        <!lendo cada um dos campos da tabela (nome, sobrenome, etc)
                        e mostrando na tabela HTML>
                        <TR>
                            <h1> <%= results.getString(3) %> </h1>
                            
                            <h3> Preço: <%= results.getString(7) %></h3>
                            
                            <form action="/PMR2490_3Design/Search/Cart.jsp">
                                <button type="submit" name = "id" value=<%= id %>>Adicionar ao carrinho</button>
                                
                            </form>
                            
                            <h3> Descrição do projeto</h3>
                            <h4> <%= results.getString(4) %> </h4>
                            
                            <h3> Detalhes do projeto</h3>
                            <h4> <%= results.getString(5) %> </h4>
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
