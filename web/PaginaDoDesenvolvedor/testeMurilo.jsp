<%-- 
    Document   : query
    Created on : 25-nov-2009, 14:54:52
    Author     : sanpedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database Query</title>
    </head>
    <body>
        <h3>Database content</h3>
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
                <!código HTML para a tabela que mostra os dados do banco>
                <%
                // fazendo a conexão com o servidor
                // carregando driver certo para conexão
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, uid, pwd);
                statement = conn.createStatement();

                // leendo o banco para mostrar conteudo em tabela HTML
               results = statement.executeQuery("select * from project");
                %>
                <!código HTML para a tabela que mostra os dados do banco>
                <TABLE BORDER="1">
                    <TR>
                        <TD><b>Nome do Projeto</b></TD>
                        <TD><b>Descrição</b></TD>
                        <TD><b>Detalhes</b></TD>
                        <TD><b>Preçoo</b></TD>
                    </TR>
               
                    <%
                // mentras existam dados para processar
                while(results.next())
                {
                %>
                        <!lendo cada um dos campos da tabela (nome, sobrenome, etc)
                        e mostrando na tabela HTML>
                        <TR>
                            <TD> <%= results.getString(2) %> </TD>
                            <TD> <%= results.getString(3) %> </TD>
                            <TD> <%= results.getString(4) %> </TD>
                            <TD> <%= results.getString(5) %> </TD>
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
        <a href="index.jsp">Back</a>
    </body>
</html>
