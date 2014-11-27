package org.apache.jsp.PaginaDoDesenvolvedor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class uploadprojeto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/PaginaDoDesenvolvedor/../WEB-INF/header.jsp");
    _jspx_dependants.add("/PaginaDoDesenvolvedor/../WEB-INF/footer.jsp");
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
      out.write("   \r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\" media=\"all\">\r\n");
      out.write("</head>\r\n");
      out.write("    \r\n");
      out.write("<body>\r\n");
      out.write("    ");
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
      out.write("        <a href=\"index.html\">\r\n");
      out.write("            <img src=\"/3Design/images/Logo2.bmp\" alt=\"3Design\" style=\"width:250px;height:80px;float: left\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <div style=\"float:right;\">\r\n");
      out.write("          <form action=\"logoutServlet\" method=\"post\">\r\n");
      out.write("                <input type=\"submit\" name=\"LogOut\" id=\"LogIn\" value=\"Log Out\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: 20px; right:85px\">\r\n");
      out.write("            </form>   \r\n");
      out.write("            <a href=\"index.html\">\r\n");
      out.write("                <img src=\"/3Design/images/Carrinho.bmp\" alt=\"3Design\" style=\"width:40px;height:40px;position:relative;top:-20px\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"display:inline;text-align: center\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <form>\r\n");
      out.write("                <input type=\"search\" name=\"firstname\" placeholder=\"Search\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;\" size=\"50\">\r\n");
      out.write("                <input type=\"submit\" value=\"\" style=\"background:url(/3Design/images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px\" />\r\n");
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
      out.write("        <a href=\"index.html\">\r\n");
      out.write("            <img src=\"/3Design/images/Logo2.bmp\" alt=\"3Design\" style=\"width:250px;height:80px;float: left\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <div style=\"float:right;\">\r\n");
      out.write("            <form method=\"post\" action=\"/3Design/signUp.jsp\">\r\n");
      out.write("                <input type=\"submit\" name=\"SignUp\" id=\"SignUp\" value=\"Sign Up\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top:20px; right:200px\">\r\n");
      out.write("            </form>   \r\n");
      out.write("            <form method=\"post\" action=\"/3Design/logIn.jsp\">\r\n");
      out.write("                <input type=\"submit\" name=\"LogIn\" id=\"LogIn\" value=\"Log In\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px; position:relative; top: -20px; right:85px\">\r\n");
      out.write("            </form>   \r\n");
      out.write("            <a href=\"index.html\">\r\n");
      out.write("                <img src=\"/3Design/images/Carrinho.bmp\" alt=\"3Design\" style=\"width:40px;height:40px;position:relative;top:-62px\">\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div style=\"display:inline;text-align: center\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <form method=\"post\" action=\"/PMR2490_3Design/search.jsp\">\r\n");
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
      out.write("        ");
if (request.getParameter("upload") != null) {
            
           
            System.out.print("fez a request");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String comments = request.getParameter("comments");
            Part file = request.getPart("file");
            String images = request.getParameter("images");
            String price_str = request.getParameter("price");
            float price = 0;
            boolean result = false;
            
            System.out.print("file:"+file);
            try {
                if (!utils.MetodosUteis.isEmpty(price_str)){
                    price = Float.valueOf(price_str).floatValue();                    
                }
                project.projectDO project = new project.projectDO(name, description, comments, price, "");
                project.versionDO version = new project.versionDO();
                if(file.getSize() > 0){
                    version.setFile(file.getInputStream());
                }
                
                transaction.UploadProject upProject = new transaction.UploadProject();
                try {
                    result = upProject.uploadProject(project, version);
                } catch (Exception e){
                    
      out.write("\r\n");
      out.write("                    Erro na hora de inserir o projeto favor tentar novamente!;\r\n");
      out.write("                    ");

                }
            } catch (NumberFormatException e){
                
      out.write("\r\n");
      out.write("               <div style=\"color: red;\">Favor inserir valor de preço usando ponto para separar casas decimais.</div>\r\n");
      out.write("                ");

            }
            //FileInputStream	inputStream = new FileInputStream(image);
			//convert image
            //byte imageData[] = new byte[(int) image.length()];
            //inputStream.read(imageData);
            //inputStream.close();
        	//System.out.print("\n\n(SimulatingImageAgent) - imagedata:"+imageData.toString());
			//declare test variables
            if (result) {
            
      out.write("\r\n");
      out.write("            <div style=\"color:green;\">Projeto inserido com sucesso!</div>\r\n");
      out.write("             ");

            } else {
            
      out.write("\r\n");
      out.write("             <div style=\"color:red;\">Projeto não inserido. Favor preencher todos os campos adequadamente.</div>\r\n");
      out.write("             ");
    
            }
        }
         
      out.write("           \r\n");
      out.write("        \r\n");
      out.write("\t<div id=\"form_container\">\r\n");
      out.write("\t\r\n");
      out.write("            <form action=\"../upload\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<div class=\"form_description\">\r\n");
      out.write("                    <h2>Upload de novo projeto</h2>\r\n");
      out.write("                    <p>Escolha um arquivo em formato adequado e faça o upload do mesmo nesta página.</p>\r\n");
      out.write("                </div>\t\t\t\t\t\t\r\n");
      out.write("                 <ul>\t\r\n");
      out.write("\r\n");
      out.write("                    <li id=\"li_1\">\r\n");
      out.write("                    <label class=\"description\" for=\"element_1\">Nome: </label>\r\n");
      out.write("                    <div>\r\n");
      out.write("                            <input id=\"name\" name=\"name\" class=\"element text medium\" type=\"text\" maxlength=\"255\" value=\"\"> \r\n");
      out.write("                    </div> \r\n");
      out.write("                    </li>\t\t\r\n");
      out.write("                    <li id=\"li_2\">\r\n");
      out.write("                    <label class=\"description\" for=\"element_2\">Descri&ccedil;&atilde;o: </label>\r\n");
      out.write("                    <div>\r\n");
      out.write("                            <input id=\"description\" name=\"description\" class=\"element text large\" type=\"text\" maxlength=\"255\" value=\"\"> \r\n");
      out.write("                    </div><p class=\"guidelines\" id=\"guide_2\"><small>Insira uma breve descri&ccedil;&atilde;o sobre o projeto</small></p> \r\n");
      out.write("                    </li>\t\t\r\n");
      out.write("                    <li id=\"li_3\">\r\n");
      out.write("                        <label class=\"comments\" for=\"element_3\">Coment&aacute;rios: </label>\r\n");
      out.write("                    <div>\r\n");
      out.write("                            <textarea id=\"comments\" name=\"comments\" class=\"element textarea large\"  value=\"\"\r\n");
      out.write("                                   style=\"height:80px;width:400px \"></textarea>\r\n");
      out.write("                    </div><p class=\"guidelines\" id=\"guide_3\"><small>Coloque todas as observa&ccedil;&otilde;es desejadas.</small></p> \r\n");
      out.write("                    </li>\t\t\r\n");
      out.write("                    <li id=\"li_4\">\r\n");
      out.write("                    <label class=\"description\" for=\"element_4\">Escolher Arquivo </label>\r\n");
      out.write("                    <div>\r\n");
      out.write("                            <input id=\"file\" name=\"file\" class=\"element file\" type=\"file\"> \r\n");
      out.write("                    </div> <p class=\"guidelines\" id=\"guide_4\"><small>Escolha um arquivo de até 50Mb para fazer upload. Os formatos aceitos são bla,bla,bla,bla,bla,bla,bla</small></p> \r\n");
      out.write("                    </li>\t\t\r\n");
      out.write("                    <li id=\"li_5\">\r\n");
      out.write("                    <label class=\"description\" for=\"element_5\">Escolha at&eacute; 3 imagens para seu projeto </label>\r\n");
      out.write("                    <div>\r\n");
      out.write("                            <input id=\"images\" name=\"images\" class=\"element file\" type=\"file\"> \r\n");
      out.write("                    </div> <p class=\"guidelines\" id=\"guide_5\"><small>Imagens de até 500Kb.</small></p> \r\n");
      out.write("                    </li>\t\t\r\n");
      out.write("                    <li id=\"li_6\">\r\n");
      out.write("                    <label class=\"price\" for=\"element_6\">Pre&ccedil;o </label>\r\n");
      out.write("                    <span class=\"symbol\">R$</span>\r\n");
      out.write("                    <span>\r\n");
      out.write("                            <input id=\"price\" name=\"price\" class=\"element text currency\" size=\"10\" value=\"\" type=\"text\"> .\t\t\r\n");
      out.write("                            <label for=\"element_6_1\">Reais</label>\r\n");
      out.write("                    </span>\r\n");
      out.write("                    \r\n");
      out.write("                    <p class=\"guidelines\" id=\"guide_6\"><small>Escolha o valor que você deseja receber por cada unidade vendida do seu projeto.</small></p> \r\n");
      out.write("                    </li>\r\n");
      out.write("                    \r\n");
      out.write("                    <br><br>\r\n");
      out.write("                    <li class=\"buttons\">\r\n");
      out.write("                        <input type=\"hidden\" name=\"upload\" value=\"upload\" />\r\n");
      out.write("                        <input id=\"saveForm\" class=\"button_text\" type=\"submit\" name=\"submit\" value=\"Enviar\" />\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
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
      out.write("                                    <img src=\"/3Design/images/pagseguro.bmp\" alt=\"pagseguro\" style=\"width:100px;height:30px\">\r\n");
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
      out.write("       \r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
