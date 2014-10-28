<%-- 
    Document   : results
    Created on : 25-nov-2009, 14:06:33
    Author     : sanpedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<!especificando objeto JAVA que contém os dados do formulário em index.jsp>
<jsp:useBean id="user" class="user.UserData" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Result</title>
    </head>
    <body>
        <h3>Insert Result</h3>
        <%
            // Setando parámetros para conectar com o servidor de banco de dados
            String url = "jdbc:mysql://localhost/email_contacts?";
            String uid = "root";
            String pwd = "venceremos";

            Connection conn = null;
            ResultSet results = null;
            Statement statement = null;

            try
            {
                // fazendo a conexão com o servidor
                // carregando driver certo para conexão
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, uid, pwd);
                statement = conn.createStatement();

                // lendo parámetros obtido do formulário na página index.jsp
                String nome = user.getNome();
                String sobrenome = user.getSobrenome();
                String email = user.getEmail();
                String sexo;

                if (user.getSexo().equals("H"))
                    sexo = "Homem";
                else if (user.getSexo().equals("M"))
                    sexo = "Mulher";
                else
                    sexo = "N/D";

                boolean proceed = false;

                // verificando que os parámetros sejam diferentes de NULL ou vazio
                if(nome != null && sobrenome != null && email != null && sexo != null)
                    if(nome.length() > 0 && sobrenome.length() > 0 && email.length() > 0 && sexo.length() > 0)
                        proceed = true;

                // preparando operação de INSERT
        		PreparedStatement ps = null;
                String sql;

                // comando SQL
                sql = "INSERT INTO agenda(nome, sobrenome, email, sexo) VALUES (?,?,?,?)";
                ps = conn.prepareStatement(sql);

                // insertando parámetros lidos
                if(proceed)
                {
                    ps.setString(1, nome);
                    ps.setString(2, sobrenome);
                    ps.setString(3, email);
                    ps.setString(4, sexo);
                    ps.executeUpdate();
                }

                // leendo o banco para mostrar conteudo em tabela HTML
                results = statement.executeQuery("select * from agenda");
                %>
                <!código HTML para a tabela que mostra os dados do banco>
                <TABLE BORDER="1">
                    <TR>
                        <TH>ID</TH>
                        <TH>Nome</TH>
                        <TH>Sobrenome</TH>
                        <TH>email</TH>
                        <TH>sexo</TH>
                    </TR>
                <%
                // mentras existam dados para processar
                while(results.next()){
                %>
                        <!lendo cada um dos campos da tabela (nome, sobrenome, etc)
                        e mostrando na tabela HTML>
                        <TR>
                            <TD> <%= results.getString(1) %> </TD>
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
            catch (SQLException e)
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
        <a href="http://localhost/testeBD/index.jsp">Back</a>
    </body>
</html>
