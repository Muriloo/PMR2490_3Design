package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import transaction.supplier;
import project.supplierDO;

public final class supplierPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/header.jsp");
    _jspx_dependants.add("/WEB-INF/footer.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\" media=\"all\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("<!--------------------Header--------------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

//allow access only if session exists
String customerId = (String) session.getAttribute("customerId");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("username")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
if(customerId != null){

      out.write("\r\n");
      out.write("<div style=\"height:90px;margin:0px;background-color: #6ED4B8\">\r\n");
      out.write("    <div id=\"header\" style=\"vertical-align: top;height:80px\">\r\n");
      out.write("        <a href=\"/3Design/index.jsp\">\r\n");
      out.write("            <img src=\"/3Design/images/Logo2.bmp\" alt=\"3Design\" style=\"width:250px;height:80px;float: left\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <div style=\"float:right;\">\r\n");
      out.write("          <form action=\"/3Design/logoutServlet\" method=\"post\">\r\n");
      out.write("                <input type=\"submit\" name=\"LogOut\" id=\"LogIn\" value=\"Log Out\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: 20px; right:85px\">\r\n");
      out.write("            </form>   \r\n");
      out.write("            <a href=\"/3Design/carrinho.jsp\">\r\n");
      out.write("                <img src=\"images/Carrinho.bmp\" alt=\"3Design\" style=\"width:40px;height:40px;position:relative;top:-20px\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"display:inline;text-align: center\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <form>\r\n");
      out.write("                <input type=\"search\" name=\"search\" placeholder=\"Search\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;\" size=\"50\">\r\n");
      out.write("                <input type=\"submit\" value=\"\" style=\"background:url(images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: -2px\" />\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

}else{

      out.write("\r\n");
      out.write("<div style=\"height:90px;margin:0px;background-color: #6ED4B8\">\r\n");
      out.write("    <div id=\"header\" style=\"vertical-align: top;height:80px\">\r\n");
      out.write("        <a href=\"/3Design/index.jsp\">\r\n");
      out.write("            <img src=\"/3Design/images/Logo2.bmp\" alt=\"3Design\" style=\"width:250px;height:80px;float: left\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <div style=\"float:right;\">\r\n");
      out.write("            <form method=\"post\" action=\"/3Design/signUp.jsp\">\r\n");
      out.write("                <input type=\"submit\" name=\"SignUp\" id=\"SignUp\" value=\"Sign Up\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top:20px; right:200px\">\r\n");
      out.write("            </form>   \r\n");
      out.write("            <form method=\"post\" action=\"/3Design/logIn.jsp\">\r\n");
      out.write("                <input type=\"submit\" name=\"LogIn\" id=\"LogIn\" value=\"Log In\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -20px; right:85px\">\r\n");
      out.write("            </form>   \r\n");
      out.write("            <a href=\"/3Design/carrinho.jsp\">\r\n");
      out.write("                <img src=\"images/Carrinho.bmp\" alt=\"3Design\" style=\"width:40px;height:40px;position:relative;top:-62px\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"display:inline;text-align: center\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <form method=\"post\" action=\"/3Design/search.jsp\">\r\n");
      out.write("                <input type=\"search\" name=\"keyword\" placeholder=\"Search\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;\" size=\"50\">\r\n");
      out.write("                <input type=\"submit\" value=\"\" style=\"background:url(/3Design/images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px\" />\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("    ");

}
    
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("<div id=\"nav\">\r\n");
      out.write("Coisa 3D<br>\r\n");
      out.write("Mais uma coisa 3D<br>\r\n");
      out.write("Such 3D!<br>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"section\">\r\n");
      out.write("<h2>Gerenciamento de Fornecedores</h2>\r\n");
      out.write("        \r\n");
      out.write("<!-------------Fim do Header--------------------------------------------------->\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!------------------------------------------------------------------->\r\n");
      out.write("<!--   sempre mostrar o formulario de busca, ateh acao ser \"voltar\" -->\r\n");
      out.write("\r\n");
     if ( null != request.getParameter("voltar")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./index.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
        return;
       }
        else if ( null != request.getParameter("inserir")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./supplierInsert.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
     return;
       }
       else if ( null == request.getParameter("excluir")){

      out.write("\r\n");
      out.write("\r\n");
      out.write("         <form action=\"./supplierPage.jsp\" method=\"post\">\r\n");
      out.write("              <input type=\"submit\" name=\"pesquisar\" value=\"Pesquisar\" />\r\n");
      out.write("              <input type=\"submit\" name=\"inserir\" value=\"Inserir\" />\r\n");
      out.write("              <input type=\"submit\" name=\"voltar\" value=\"Voltar\" />\r\n");
      out.write("         </form>\r\n");
      out.write("      ");
}//if excluir == null
      out.write("\r\n");
      out.write("<! ------------------------------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
 
       if ( null != request.getParameter("pesquisar")) {  
       transaction.supplier tn = new transaction.supplier();
       Vector suppliers = tn.getSuppliers();
       session.setAttribute("suppliers",suppliers);
       if ( (suppliers == null) || (suppliers.size() == 0)) {
         

      out.write("\r\n");
      out.write("          Nenhum fornecedor encontrado!\r\n");
      out.write("         \r\n");
     } else {

      out.write("\r\n");
      out.write("          \r\n");
      out.write("          <table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome</td>\r\n");
      out.write("                <td>Avaliação</td>\r\n");
      out.write("                <td>Capacidade</td>\r\n");
      out.write("                <td>Comentarios</td>\r\n");
      out.write("                <td>Descrição</td>\r\n");
      out.write("                <td>Ver</td>\r\n");
      out.write("                <td>Excluir</td>\r\n");
      out.write("            </tr>\r\n");
        
           for(int i = 0; i < suppliers.size(); i++) {
                supplierDO supplier = (supplierDO)suppliers.elementAt(i);

      out.write("              <tr>\r\n");
      out.write("                   <td>");
      out.print( supplier.getName() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getEval() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getCapacityId() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getComment() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getDescription() );
      out.write("</td>\r\n");
      out.write("                   <td>\r\n");
      out.write("                       <form action=\"./supplier2.jsp\" method=\"POST\">        \r\n");
      out.write("                <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />       \r\n");
      out.write("                <input type=\"submit\" name=\"ver\" value=\"Ver\" />\r\n");
      out.write("                       </form> \r\n");
      out.write("                   </td>               \r\n");
      out.write("                   <td>\r\n");
      out.write("                       <form action=\"./supplierPage.jsp\" method=\"post\">\r\n");
      out.write("                <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />               \r\n");
      out.write("                <input type=\"submit\" name=\"excluir\" value=\"Excluir\" />\r\n");
      out.write("                       </form></td>\r\n");
      out.write("                </tr>        \r\n");
           } // for i      

      out.write("        </table>            \r\n");
     } // returned versions
     } // pesquisar
       else if (null != request.getParameter ("excluir")){
            int i = Integer.parseInt(request.getParameter("indice"));
            transaction.supplier tn = new transaction.supplier();
            supplierDO supplier = new supplierDO();
            Vector vector = new Vector();
            vector = (Vector) session.getAttribute("suppliers");
            supplier = (supplierDO)vector.elementAt(i);
            session.setAttribute("remove",supplier);
            
        
      out.write("\r\n");
      out.write("         <h2>Você tem certeza que deseja excluir este fornecedor?</h2>\r\n");
      out.write("             \r\n");
      out.write("         <table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome</td>\r\n");
      out.write("                <td>Avaliação</td>\r\n");
      out.write("                <td>Capacidade</td>\r\n");
      out.write("                <td>Comentarios</td>\r\n");
      out.write("                <td>Descrição</td>                \r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                   <td>");
      out.print( supplier.getName() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getEval() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getCapacityId() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getComment() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( supplier.getDescription() );
      out.write("</td>\r\n");
      out.write("                </tr>        \r\n");
    

      out.write("        </table>   \r\n");
      out.write("          <form action=\"./supplier2.jsp\" method=\"POST\">        \r\n");
      out.write("                            <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />       \r\n");
      out.write("                            <input type=\"submit\" name=\"ver\" value=\"Ver\" />\r\n");
      out.write("                            <input type=\"submit\" name=\"excluir\" value=\"Excluir\" />\r\n");
      out.write("                            <input type=\"submit\" name=\"voltarsup\" value=\"Voltar\" />\r\n");
      out.write("          </form> \r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("            ");

    
           
       
    
    


       }//excluir

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--------------------------Footer--------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"height:160px;margin: 0px auto;display: block;background-color:#6ED4B8;clear:both;\">\r\n");
      out.write("            <div id=\"footer\">\r\n");
      out.write("                <table id=\"bottomlinks\">\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td style=\"vertical-align: top;width:800px\">\r\n");
      out.write("                                <h3>Modo de Pagamento</h3>\r\n");
      out.write("                                <a href=\"https://pagseguro.uol.com.br/\" target=\"_blank\">\r\n");
      out.write("                                    <img src=\"images/pagseguro.bmp\" alt=\"pagseguro\" style=\"width:100px;height:30px\">\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td style=\"vertical-align: top\">\r\n");
      out.write("                                <h3>Contato</h3>\r\n");
      out.write("                                <h5>Email: contato@3design.com</h5>\r\n");
      out.write("                                <h5>Telefone: +55 11 99975-6644</h5>\r\n");
      out.write("\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div> \r\n");
      out.write("    \r\n");
      out.write("<!-------------------Fim do Footer--------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
