package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import transaction.supplier;
import project.*;

public final class supplier2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
     if ( null != request.getParameter("voltarS")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./supplierPage.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
        return;
       }
     if ( null != request.getParameter("voltarsup")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./supplierPage.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
        return;
       }
     if ( null != request.getParameter("inserir")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./supplierInsert.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
        
   return;
       }

      out.write("\r\n");
      out.write("\r\n");
      out.write("         <form action=\"./supplier2.jsp\" method=\"post\">\r\n");
      out.write("              <input type=\"submit\" name=\"inserir\" value=\"Inserir\" />\r\n");
      out.write("              <input type=\"submit\" name=\"voltarS\" value=\"Voltar\" />\r\n");
      out.write("         </form>\r\n");
      out.write("\r\n");
      out.write("<! ------------------------------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
 
       if (null != request.getParameter ("excluir")) {
        System.out.println("vai excluir");
        transaction.supplier tn = new transaction.supplier();
        supplierDO supplier = (supplierDO) session.getAttribute("supplier");
        if (supplier == null){
            System.out.println("fornecedor nulo");
        }
        if (tn.delete(supplier)){

      out.write("        \r\n");
      out.write("\r\n");
      out.write("<h2>Fornecedor Excluido!</h2>\r\n");
      out.write("    \r\n");
      out.write("\r\n");

    }//se rejeitada com sucesso
    else {
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <h2>Erro na exclus&atildeo!</h2>\r\n");
      out.write("<form action=\"./supplierPage.jsp\" method=\"post\">\r\n");
      out.write("                <input type=\"submit\" name=\"voltarS\" value=\"Voltar\" />\r\n");
      out.write("</form>        \r\n");
      out.write("        \r\n");
      out.write("        ");

    }//Erro na esclusão

}//excluir
       else if (null != request.getParameter ("ver")) {
        System.out.println("ver fornecedor");
    String a = request.getParameter("indice");
    System.out.println("fornecedor "+a);
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("suppliers");
    int i = Integer.parseInt(request.getParameter("indice"));
    System.out.println("INDICE="+i);
    supplier = (supplierDO)vector.elementAt(i);
    session.setAttribute("supplier",supplier);
    System.out.println("supplier");
    if (supplier == null){
        System.out.println("fornecedor nulo");
    }
    

      out.write("        \r\n");
      out.write("\r\n");
      out.write("<! --------------------------abre geral-------------------------------------->\r\n");
      out.write("<h2>Ver Fornecedor</h2>\r\n");

        if(request.getParameter("ok") != null) {
            
      out.write("\r\n");
      out.write("          Fornecedor inserido com sucesso!\r\n");
      out.write("            \r\n");
      out.write("            ");

        }


      out.write("\r\n");
      out.write("\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome</td>\r\n");
      out.write("                <td>Avaliação</td>\r\n");
      out.write("                <td>Capacidade</td>\r\n");
      out.write("                <td>Comentarios</td>\r\n");
      out.write("                <td>Descrição</td>\r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");
        
           

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
      out.write("                   \r\n");
      out.write("                </tr>        \r\n");
      out.write("        </table> \r\n");
      out.write("                \r\n");
      out.write("<! --------------------------fecha geral-------------------------------------->\r\n");
      out.write("<! --------------------------abre contatos------------------------------------>\r\n");
      out.write("Tabela de Contatos\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome</td>\r\n");
      out.write("                <td>Cargo</td>\r\n");
      out.write("                <td>Email</td>\r\n");
      out.write("                <td>Telefone</td>\r\n");
      out.write("                \r\n");
      out.write("           \r\n");
      out.write("            </tr>\r\n");
        

            Vector contacts = new Vector();
            contacts = supplier.getContactInfo();
            
            for(int j = 0; j < contacts.size(); j++) {
                contactInfoDO contact = (contactInfoDO) contacts.elementAt(j);

      out.write("              <tr>\r\n");
      out.write("                   <td>");
      out.print( contact.getName() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( contact.getPosition() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( contact.getEmail() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( contact.getPhone() );
      out.write("</td>\r\n");
      out.write("               \r\n");
      out.write("                </tr>        \r\n");
           } // for j - contatos      

      out.write("        </table>            \r\n");
      out.write("                \r\n");
      out.write("<! --------------------------fecha contatos----------------------------------->\r\n");
      out.write("<! --------------------------abre bancos-------------------------------------->\r\n");
      out.write("Tabela de Dados Bancários\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                 <td>N&uacutemero do Banco</td>\r\n");
      out.write("                 <td>Ag&ecircncia</td>\r\n");
      out.write("                <td>Conta</td>\r\n");
      out.write("                <td>CNPJ/CPF</td>\r\n");
      out.write("               \r\n");
      out.write("            </tr>\r\n");
        
       
            Vector banks = new Vector();
            banks = supplier.getBankInfo();
            for(int k = 0; k < banks.size(); k++) {
                BankInfoDO bank = (BankInfoDO) banks.elementAt(k);

      out.write("              <tr>\r\n");
      out.write("                   <td>");
      out.print( bank.getBankNumber() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( bank.getAgency() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( bank.getAccount() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( bank.getCnpjCpf() );
      out.write("</td>\r\n");
      out.write("                   <td>\r\n");
      out.write("                  \r\n");
      out.write("                </tr>        \r\n");
           } // for k - bancos      

      out.write("        </table> \r\n");
      out.write("                \r\n");
      out.write("\r\n");
      out.write("<! --------------------------fecha bancos------------------------------------->\r\n");
      out.write("<! --------------------------abre endereços----------------------------------->\r\n");
      out.write("Tabela de Endere&ccedilos\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Pa&iacutes</td>\r\n");
      out.write("                <td>Estado</td>\r\n");
      out.write("                <td>Cidade</td>\r\n");
      out.write("                <td>Logradouro</td>\r\n");
      out.write("                <td>Complemento</td>\r\n");
      out.write("                <td>CEP</td>\r\n");
      out.write("       \r\n");
      out.write("            </tr>\r\n");
        
       
            Vector addresses = new Vector();
            addresses = supplier.getAddress();
            for(int u = 0; u < addresses.size(); u++) {
                supplierAddressDO address = (supplierAddressDO) addresses.elementAt(u);

      out.write("              <tr>\r\n");
      out.write("                   <td>");
      out.print( address.getCountry() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( address.getState() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( address.getCity() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( address.getStreet() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( address.getComplement() );
      out.write("</td>\r\n");
      out.write("                   <td>");
      out.print( address.getPostalcode() );
      out.write("</td>\r\n");
      out.write("         \r\n");
      out.write("                 \r\n");
      out.write("                </tr>        \r\n");
           } // for u - endereços      

      out.write("        </table>            \r\n");
      out.write("                \r\n");
      out.write("<! --------------------------fecha endereços---------------------------------->\r\n");
      out.write("<! --------------------------abre materiais----------------------------------->\r\n");
      out.write("Tabela de Materiais\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome do Material</td>\r\n");
      out.write("            \r\n");
      out.write("             </tr>\r\n");
        
            Object[] materials = supplier.getMaterials();
            for(int v = 0; v < materials.length; v++) {
                

      out.write("              <tr>\r\n");
      out.write("                   <td>");
      out.print((String) materials[v] );
      out.write("</td>\r\n");
      out.write("                   \r\n");
      out.write("                </tr>        \r\n");
           } // for v - materiais     

      out.write("        </table>            \r\n");
      out.write("\r\n");
      out.write("                <form action=\"./supplierInsert.jsp\" method=\"post\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"editar2\" value=\"Editar\"\r\n");
      out.write("                    <input type=\"submit\" name=\"excluir\" value=\"Excluir\" />\r\n");
      out.write("                    <!input type=\"submit\" name=\"editar\" value=\"Editar\" />\r\n");
      out.write("                </form>\r\n");
      out.write("<! --------------------------fecha materiais---------------------------------->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");


}//ver fornecedor
       
           else if ( null != request.getParameter("pesquisar")) {  
       transaction.supplier tn = new transaction.supplier();
       Vector suppliers = tn.getSuppliers();
       session.setAttribute("vector",suppliers);
       
       if ( (suppliers == null) || (suppliers.size() == 0)) {
         

      out.write("\r\n");
      out.write("          Nenhuma versão pendente encontrada!\r\n");
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
      out.write("                <td>Contatos</td>\r\n");
      out.write("                <td>Dados Bancários</td>\r\n");
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
      out.write("                <input type=\"submit\" name=\"contacts\" value=\"Contatos\" />\r\n");
      out.write("                       </form> \r\n");
      out.write("                   </td>               \r\n");
      out.write("                   <td>\r\n");
      out.write("                       <form action=\"./supplier2.jsp\" method=\"POST\">\r\n");
      out.write("                <input type=\"hidden\" name=\"indice\" value=\"");
      out.print(i);
      out.write("\"  />             \r\n");
      out.write("                <input type=\"submit\" name=\"bank\" value=\"Dados Bancarios\" />\r\n");
      out.write("                       </form>\r\n");
      out.write("                   </td>\r\n");
      out.write("                   <td>\r\n");
      out.write("                       <form action=\"./supplier2.jsp\" method=\"post\">\r\n");
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
