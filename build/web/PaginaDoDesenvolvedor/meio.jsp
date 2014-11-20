<%-- 
    Document   : meio
    Created on : Nov 20, 2014, 3:43:22 PM
    Author     : Eduardo Seiti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%
// Setando parametros para conectar com o servidor de banco de dados
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
    results = statement.executeQuery("select * order_item");
    %>
        <!código HTML para a tabela que mostra os dados do banco>
        <TABLE BORDER="1">
        <TR>
        <TD><b>Data</b></TD>
        <TD><b>Projeto</b></TD>
        <TD><b>No. Pedido</b></TD>
        <TD><b>Quantidade</b></TD>
        <TD><b>Preço</b></TD>
        <TD><b>Quantifade</b></TD>
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
 <a href="index.html">Back</a>

    </body>
</html>
