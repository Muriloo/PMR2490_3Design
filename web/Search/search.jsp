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
            String keyword = request.getParameter("keyword");
            keyword = keyword.toUpperCase();       
        %>
        
        <h3>Resultados encontrados para o termo: "<%=keyword%>"</h3>     
        
        <%
            // Setando parámetros para conectar com o servidor de banco de dados
            String url = "jdbc:mysql://localhost/3design?";
            String uid = "root";
            String pwd = "Pmr2490";

            Connection conn = null;
            ResultSet results = null;
            Statement statement = null;
            int count = 0;
            
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
                results = statement.executeQuery("select * from project where upper(project_name) like '%" + keyword + "%'" );
                %>
                <!código HTML para a tabela que mostra os dados do banco>
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
                    count++;
                %>
                        <!lendo cada um dos campos da tabela (nome, sobrenome, etc)
                        e mostrando na tabela HTML>
                        <TR>
                            <TD><a href="/PMR2490_3Design/Search/pageProjeto.jsp?id=<%=results.getString(1)%>"> <%= results.getString(3) %></a> </TD>
                            <TD> <%= results.getString(4) %> </TD>
                            <TD> <%= results.getString(5) %> </TD>
                            <TD> <%= results.getString(7) %> </TD>
                        </TR>
                <%
                }
                %>
                </TABLE>
                <h3> Foram encontrados <%= count %> resultado(s)</h3>
                
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
