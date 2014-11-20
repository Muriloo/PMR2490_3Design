package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import transaction.pendingProject;
import project.versionDO;

public final class pending_002dprojects_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\" media=\"all\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("<!--------------------Header--------------------------------------------------->\n");
      out.write("        \n");
      out.write("        <div style=\"height:90px;margin:0px;background-color: #6ED4B8\">\n");
      out.write("<div id=\"header\" style=\"vertical-align: top;height:80px\">\n");
      out.write("    <a href=\"index.html\">\n");
      out.write("        <img src=\"images/Logo2.bmp\" alt=\"3Design\" style=\"width:250px;height:80px;float: left\">\n");
      out.write("    </a>\n");
      out.write("    <div style=\"float:right;\">\n");
      out.write("    <a class=\"header\" href=\"teste.jsp\">Sign Up</a>\n");
      out.write("    <span style=\"letter-spacing:14px;\"> |</span>\n");
      out.write("    <a class=\"header\" href=\"index.html\">Log In </a>\n");
      out.write("    <span style=\"letter-spacing:14px;\"> |</span>\n");
      out.write("    <a href=\"index.html\">\n");
      out.write("        <img src=\"images/Carrinho.bmp\" alt=\"3Design\" style=\"width:40px;height:40px;position:relative;top:12px\">\n");
      out.write("    </a>\n");
      out.write("    </div>\n");
      out.write("    <div style=\"display:inline;text-align: center\">\n");
      out.write("    <br>\n");
      out.write("    <form>\n");
      out.write("        <input type=\"search\" name=\"firstname\" placeholder=\"Search\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;\" size=\"50\">\n");
      out.write("        <input type=\"submit\" value=\"\" style=\"background:url(images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px\" />\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"page\">\n");
      out.write("<div id=\"nav\">\n");
      out.write("Coisa 3D<br>\n");
      out.write("Mais uma coisa 3D<br>\n");
      out.write("Such 3D!<br>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"section\">\n");
      out.write("<h2>Gerenciamento de Versões Pendentes</h2>\n");
      out.write("        \n");
      out.write("<!-------------Fim do Header--------------------------------------------------->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<! ------------------------------------------------------------------->\n");
      out.write("<!--   sempre mostrar o formulario de busca, ateh acao ser \"voltar\" -->\n");
      out.write("\n");
     if ( null != request.getParameter("voltar")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./index.html");
        return;
      }
      out.write('\n');
        return;
       }

      out.write("\n");
      out.write("\n");
      out.write("         <form action=\"./pending-projects.jsp\" method=\"post\">\n");
      out.write("             \n");
      out.write("             \n");
      out.write("          \n");
      out.write("         <input type=\"submit\" name=\"pesquisar\" value=\"Pesquisar\" />\n");
      out.write("         <input type=\"submit\" name=\"voltar\" value=\"Voltar\" />\n");
      out.write("         </form>\n");
      out.write("\n");
      out.write("<! ------------------------------------------------------------------->\n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
   if ( null != request.getParameter("pesquisar")) {  
       transaction.pendingProject tn = new transaction.pendingProject();
       Vector versions = tn.getPending();
       session.setAttribute("vector",versions);
       if ( (versions == null) || (versions.size() == 0)) {
         // avisar usuario que nao ha' contatos com este nome

      out.write("\n");
      out.write("          Nenhuma versão pendente encontrada!\n");
      out.write("         \n");
     } else {

      out.write("\n");
      out.write("          \n");
      out.write("          <table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>ID do Projeto</td>\n");
      out.write("                <td>Nome da Versão</td>\n");
      out.write("                <td>Visibilidade</td>\n");
      out.write("                <td>Status</td>\n");
      out.write("                <td>Aprovar</td>\n");
      out.write("                <td>Rejeitar</td>\n");
      out.write("             </tr>\n");
           for(int i = 0; i < versions.size(); i++) {
                versionDO version = (versionDO)versions.elementAt(i);

      out.write("              <tr>\n");
      out.write("                   <td>");
      out.print( version.getProjectId() );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( version.getName() );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( version.getVisibility() );
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( version.getStatusId() );
      out.write("</td>\n");
      out.write("                   <td><form action=\"./approval-confirmation.jsp\" method=\"post\">\n");
      out.write("             \n");
      out.write("         <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />             \n");
      out.write("         <input type=\"submit\" name=\"aprovar\" value=\"Aprovar\" />\n");
      out.write("      \n");
      out.write("         </form></td>\n");
      out.write("                <td><form action=\"./approval-confirmation.jsp\" method=\"post\">\n");
      out.write("             \n");
      out.write("         <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />               \n");
      out.write("         <input type=\"submit\" name=\"rejeitar\" value=\"Rejeitar\" />\n");
      out.write("      \n");
      out.write("         </form></td>\n");
      out.write("                </tr>        \n");
           } // for i      

      out.write("        </table>            \n");
     } // returned versions
     } // pesquisar

      out.write("\n");
      out.write("\n");
      out.write("<!--------------------------Footer--------------------------------------------->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("<div style=\"height:160px;margin: 0px auto;display: block;background-color:#6ED4B8;clear:both;\">\n");
      out.write("<div id=\"footer\">\n");
      out.write("    <table id=\"bottomlinks\">\n");
      out.write("        <tbody>\n");
      out.write("            <tr>\n");
      out.write("                <td style=\"vertical-align: top;width:800px\">\n");
      out.write("                    <h3>Modo de Pagamento</h3>\n");
      out.write("                    <a href=\"https://pagseguro.uol.com.br/\" target=\"_blank\">\n");
      out.write("                        <img src=\"images/pagseguro.bmp\" alt=\"pagseguro\" style=\"width:100px;height:30px\">\n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("                <td style=\"vertical-align: top\">\n");
      out.write("                    <h3>Contato</h3>\n");
      out.write("                    <h5>Email: contato@3design.com</h5>\n");
      out.write("                    <h5>Telefone: +55 11 99975-6644</h5>\n");
      out.write("                    \n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("</div>    \n");
      out.write("    \n");
      out.write("<!-------------------Fim do Footer--------------------------------------------->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
