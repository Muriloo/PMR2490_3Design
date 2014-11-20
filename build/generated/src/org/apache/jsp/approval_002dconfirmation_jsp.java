package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import transaction.pendingProject;
import project.versionDO;

public final class approval_002dconfirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
     if ( null != request.getParameter("voltar")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./pending-projects.jsp");
        return;
      }
      out.write('\n');
        return;
       }

      out.write('\n');
      out.write('\n');
     if ( null != request.getParameter("aprovarC")) {
    String a = request.getParameter("indiceC");
    System.out.println("aprovarC "+a);
    transaction.pendingProject pp = new transaction.pendingProject();
    versionDO version = new versionDO();
    Vector vector = new Vector();
    vector = (Vector)session.getAttribute("vector");
    int i = Integer.parseInt(request.getParameter("indiceC"));
    System.out.println("INDICE="+i);
    version = (versionDO)vector.elementAt(i);
    if (version == null){
        System.out.println("versão nula");
    }
    if (pp.approve(version)){

      out.write("        \n");
      out.write("\n");
      out.write("<h2>Versão Aprovada!</h2>\n");
      out.write("\n");

    }//se aprovada com sucesso
    else {
        
      out.write("\n");
      out.write("        \n");
      out.write("<h2>Erro na aprovação!</h2>\n");
      out.write("        \n");
      out.write("        ");

    }//Erro na aprovação

}//aprovarC
else{
    System.out.println("else");
    String aprovar_rejeitar;
    int i = Integer.parseInt(request.getParameter("indice"));
    if( null != request.getParameter("aprovar") ){
         System.out.println("aprovar "+i);
        
      out.write("\n");
      out.write("         <h2>Você tem certeza que deseja aprovar essa versão?</h2>\n");
      out.write("         <form action=\"./approval-confirmation.jsp\" method=\"getS\"\n");
      out.write("               <input type=\"text\" name=\"teste\" value=\"testee\">\n");
      out.write("                <input type=\"hidden\" name=\"indiceC\" value=\"");
      out.print(i);
      out.write("\"  > \n");
      out.write("                <input type=\"submit\" name=\"aprovarC\" value=\"Aprovar\" >                 \n");
      out.write("                <input type=\"submit\" name=\"voltar\" value=\"Voltar\" >\n");
      out.write("         </form>        \n");
      out.write("            \n");
      out.write("            ");

    }
        else if( null != request.getParameter("rejeitar") ){
            System.out.println("rejeitar "+i);
            
      out.write("\n");
      out.write("            <h2>Você tem certeza que deseja rejeitar essa versão?</h2>\n");
      out.write("            <form action=\"./approval-confirmation.jsp\" method=\"post\"\n");
      out.write("                <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />\n");
      out.write("                <input type=\"submit\" name=\"rejeitarC\" value=\"Rejeitar\" />\n");
      out.write("                <input type=\"submit\" name=\"voltar\" value=\"Voltar\" />\n");
      out.write("            </form>        \n");
      out.write("            \n");
      out.write("            ");

           
        }
        else{
            aprovar_rejeitar = "MERDA";
            System.out.println("merda");
        }
    
    
    


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

}//else (primeira entrada na página)


      out.write("                     \n");
      out.write("                     \n");
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
