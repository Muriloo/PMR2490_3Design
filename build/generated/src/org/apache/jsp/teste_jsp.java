package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class teste_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Database Query</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h3>Database content</h3>\n");
      out.write("        ");

            // Setando parámetros para conectar com o servidor de banco de dados
            String url = "jdbc:mysql://localhost/3design?";
            String uid = "root";
            String pwd = "Pmr2490";

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

                // leendo o banco para mostrar conteudo em tabela HTML
                results = statement.executeQuery("select * from project WHERE project_status_id = '2'");
                
      out.write("\n");
      out.write("                <!código HTML para a tabela que mostra os dados do banco>\n");
      out.write("                <TABLE BORDER=\"1\">\n");
      out.write("                    <TR>\n");
      out.write("                        <TH>Nome do Projeto</TH>\n");
      out.write("                        <TH>Descrição</TH>\n");
      out.write("                        <TH>Detalhes</TH>\n");
      out.write("                        <TH>Preço</TH>\n");
      out.write("                    </TR>\n");
      out.write("                ");

                // mentras existam dados para processar
                while(results.next())
                {
                
      out.write("\n");
      out.write("                        <!lendo cada um dos campos da tabela (nome, sobrenome, etc)\n");
      out.write("                        e mostrando na tabela HTML>\n");
      out.write("                        <TR>\n");
      out.write("                            <TD> ");
      out.print( results.getString(3) );
      out.write(" </TD>\n");
      out.write("                            <TD> ");
      out.print( results.getString(4) );
      out.write(" </TD>\n");
      out.write("                            <TD> ");
      out.print( results.getString(5) );
      out.write(" </TD>\n");
      out.write("                            <TD> ");
      out.print( results.getString(7) );
      out.write(" </TD>\n");
      out.write("                        \n");
      out.write("                        </TR>\n");
      out.write("                ");

                }
                
      out.write("\n");
      out.write("                </TABLE>\n");
      out.write("                ");

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
        
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <a href=\"index.jsp\">Back</a>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
