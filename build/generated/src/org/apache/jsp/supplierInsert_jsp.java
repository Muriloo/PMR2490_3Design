package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.ArrayList;
import transaction.supplier;
import project.*;

public final class supplierInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            <form>\r\n");
      out.write("                <input type=\"search\" name=\"firstname\" placeholder=\"Search\" style=\"height:40px;font-size:14pt;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 5px;\" size=\"50\">\r\n");
      out.write("                <input type=\"submit\" value=\"\" style=\"background:url(/3Design/images/lupa.bmp) no-repeat;width: 30px;height: 30px;position:relative;left:-42px;top: 6px\" />\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("    ");

}
    
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"page\">\n");
      out.write("<div id=\"nav\">\n");
      out.write("Coisa 3D<br>\n");
      out.write("Mais uma coisa 3D<br>\n");
      out.write("Such 3D!<br>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"section\">\n");
      out.write("<h2>Gerenciamento de Fornecedores</h2>\n");
      out.write("        \n");
      out.write("<!-------------Fim do Header--------------------------------------------------->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!------------------------------------------------------------------->\n");
      out.write("<!--   sempre mostrar o formulario de busca, ateh acao ser \"voltar\" -->\n");
      out.write("\n");
     if ( null != request.getParameter("voltarSI")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./supplierPage.jsp");
        return;
      }
      out.write('\n');
        return;
       }
    
     

      out.write("\n");
      out.write("\n");
      out.write("         <form action=\"./supplierInsert.jsp\" method=\"post\">\n");
      out.write("              <input type=\"submit\" name=\"inserir\" value=\"Inserir\" />\n");
      out.write("              <input type=\"submit\" name=\"voltarSI\" value=\"Voltar\" />\n");
      out.write("         </form>\n");
      out.write("\n");
      out.write("<! ------------------------------------------------------------------->\n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
 
       if (null != request.getParameter ("editar")) {      
        
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    
    Vector contacts = supplier.getContactInfo();
    Vector contacts2 = new Vector();
    
    Vector banks2 = new Vector();
    Vector banks = supplier.getBankInfo();
    
    Vector addresses2 = new Vector();
    Vector addresses = supplier.getAddress();
            
    Object[] materials = supplier.getMaterials();
    ArrayList<String> materials2 = new ArrayList<String> ();
    
    if(null != request.getParameter("indice")){
        // editar fornecedor específico
        
    Vector vector = new Vector();
    vector = (Vector) session.getAttribute("suppliers");
    int i = Integer.parseInt(request.getParameter("indice"));
    System.out.println("INDICE="+i);
    supplier = (supplierDO)vector.elementAt(i);
    System.out.println("supplier");
    if (supplier == null){
        System.out.println("fornecedor nulo");
    }
    
    }else{
    /* inserir novo fornecedor: pegar os parâmetros-------------------------*/
    //gerais
           supplier.setName(request.getParameter("name"));
           System.out.println("supplier name: "+ supplier.getName());
           supplier.setEval( Double.parseDouble(request.getParameter("eval")) );
           supplier.setCapacityId(Integer.parseInt(request.getParameter("capacity")) );
           supplier.setComment(request.getParameter("comment"));
           supplier.setDescription(request.getParameter("description"));
           System.out.println("parametros ok");
           
    //contatos
           
           int p=0;
           String name = request.getParameter("contactName"+p);
           System.out.println("contactName "+name+" size "+name.length());
           
           while(null != request.getParameter("contactName"+p) && request.getParameter("contactName"+p).length() != 0){
               contactInfoDO contact = new contactInfoDO();
               System.out.println("entrei no contacts "+request.getParameter("contactName"+p));
               contact.setName(request.getParameter("contactName"+p));
               contact.setPosition(request.getParameter("contactPosition"+p));
               contact.setEmail(request.getParameter("contactEmail"+p));
               contact.setPhone(request.getParameter("contactPhone"+p));
               contacts2.add(contact);
               p++;
           }
           if (contacts2==null) System.out.println("contacts nulo");
           else{
           supplier.setContactInfo(contacts2);
           System.out.println("contacts ok medio");}
    //bancos
           p=0;
           while(null != request.getParameter("bankName"+p) && request.getParameter("bankName"+p).length() != 0){
               BankInfoDO bank = new BankInfoDO();
               bank.setBankNumber(request.getParameter("bankNumber"+p));
               bank.setAgency(request.getParameter("bankAgency"+p));
               bank.setAccount(request.getParameter("bankAccount"+p));
               bank.setCnpjCpf(request.getParameter("bankCnpjCpf"+p));
               banks2.add(bank);
               p++;
           }
           if (banks2==null) System.out.println("banks nulo");
           else
           supplier.setBankInfo(banks2);
    //endereços
           p=0;
           while(null != request.getParameter("addressCountry"+p) && request.getParameter("addressCountry"+p).length() != 0){
               supplierAddressDO address = new supplierAddressDO();
               address.setCountry(request.getParameter("addressCountry"+p));
               address.setState(request.getParameter("addressState"+p));
               address.setCity(request.getParameter("addressCity"+p));
               address.setStreet(request.getParameter("addressStreet"+p));
               address.setComplement(request.getParameter("addressComplement"+p));
               address.setPostalcode(request.getParameter("addressPostalcode"+p));
               addresses2.add(address);
               p++;
           }
           if (addresses2==null) System.out.println("addresses nulo");
           else supplier.setAddress(addresses2);
    //materiais
           System.out.println("antes de materiais");
            p=0;
            while(null != request.getParameter("material"+p) && request.getParameter("material"+p).length() != 0){
                materials2.add(p,request.getParameter("material"+p));
                p++;
            }
            if (materials2==null) System.out.println("materials nulo");
            else supplier.setMaterials(materials2.toArray());
           
           supplier sp = new supplier();
           System.out.println("vai inserir");
           if(sp.include(supplier)){// fornecedor inserido
               System.out.println("inserido");
               
      out.write("\n");
      out.write("           Fornecedor inserido com sucesso!\n");
      out.write("               ");

               } else{
               System.out.println("nao inserido");
               
      out.write("\n");
      out.write("           Erro na inser&ccedil&atildeo do fornecedor!\n");
      out.write("               ");

           }//erro na inserção
       }

      out.write("        \n");
      out.write("\n");
      out.write("<! --------------------------abre geral-------------------------------------->\n");
      out.write("<h2>Editar Fornecedor</h2>\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Nome</td>\n");
      out.write("                <td>Avaliação</td>\n");
      out.write("                <td>Capacidade</td>\n");
      out.write("                <td>Comentarios</td>\n");
      out.write("                <td>Descrição</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            <form action=\"./supplierInsert.jsp\" method=\"post\">\n");
      out.write("            <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"name\" value=\"");
      out.print( supplier.getName());
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                       <INPUT TYPE=\"text\" NAME=\"eval\" value=\"");
      out.print( supplier.getEval() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                       <INPUT TYPE=\"text\" NAME=\"capacity\" value=\"");
      out.print( supplier.getCapacityId() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"comment\" value=\"");
      out.print( supplier.getComment() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"description\" value=\"");
      out.print( supplier.getDescription() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>        \n");
      out.write("        </table> \n");
      out.write("                \n");
      out.write("<! --------------------------fecha geral-------------------------------------->\n");
      out.write("<! --------------------------abre contatos------------------------------------>\n");
      out.write("Tabela de Contatos\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Nome</td>\n");
      out.write("                <td>Cargo</td>\n");
      out.write("                <td>Email</td>\n");
      out.write("                <td>Telefone</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
        // contatos
System.out.println("antes do if dos contatos!=null");
        if (contacts != null) {           
            System.out.println("antes do for dos contatos!=null");
            for(int j = 0; j < contacts.size(); j++) {
                contactInfoDO contact = (contactInfoDO) contacts.elementAt(j);
                

      out.write("              <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactName");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getName() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactPosition");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getPosition() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactEmail");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getEmail() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactPhone");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getPhone() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>        \n");
          
            } // for j - contatos

      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactName");
      out.print(contacts.size());
      out.write("\"  > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPosition");
      out.print(contacts.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactEmail");
      out.print(contacts.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPhone");
      out.print(contacts.size());
      out.write("\" > </td>\n");
      out.write("            </tr>\n");
      out.write("                    \n");

        } // if (contacts != null)
        else{
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactName0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPosition0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactEmail0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPhone0\" > </td>\n");
      out.write("            </tr>        \n");
      out.write("                    ");

            System.out.println("contact ==  null");
        }

      out.write("              \n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("<! --------------------------fecha contatos----------------------------------->\n");
      out.write("<! --------------------------abre bancos-------------------------------------->\n");
      out.write("Tabela de Dados Bancários\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                 <td>N&uacutemero do Banco</td>\n");
      out.write("                 <td>Ag&ecircncia</td>\n");
      out.write("                <td>Conta</td>\n");
      out.write("                <td>CNPJ/CPF</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
          // bancos
System.out.println("antes de bancos");

        if (banks != null){
            for(int k = 0; k < banks.size(); k++) {
                BankInfoDO bank = (BankInfoDO) banks.elementAt(k);

      out.write("              <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankNumber");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getBankNumber() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankAgency");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getAgency() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankAccount");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getAccount() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getCnpjCpf() );
      out.write("\">\n");
      out.write("                    </td>\n");
      out.write("                   \n");
      out.write("                </tr>        \n");
 
            } // for k - bancos 

      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankNumber");
      out.print(banks.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAgency");
      out.print(banks.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAccount");
      out.print(banks.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf");
      out.print(banks.size());
      out.write("\" > </td>\n");
      out.write("            </tr>\n");
      out.write("         \n");

        } // if (banks != null)
        else{
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankNumber0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAgency0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAccount0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf0\" > </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

        }

      out.write("\n");
      out.write("        </table>\n");
      out.write("<! --------------------------fecha bancos------------------------------------->\n");
      out.write("<! --------------------------abre endereços----------------------------------->\n");
      out.write("Tabela de Endere&ccedilos\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Pa&iacutes</td>\n");
      out.write("                <td>Estado</td>\n");
      out.write("                <td>Cidade</td>\n");
      out.write("                <td>Logradouro</td>\n");
      out.write("                <td>Complemento</td>\n");
      out.write("                <td>CEP</td>\n");
      out.write("            </tr>\n");
          //endereços
 System.out.println("antes de endereços");
        if (addresses != null){
            for(int u = 0; u < addresses.size(); u++) {
                supplierAddressDO address = (supplierAddressDO) addresses.elementAt(u);

      out.write("              <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressCountry");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getCountry() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressState");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getState() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressCity");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getCity() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressStreet");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getStreet() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressComplement");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getComplement() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressPostalcode");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getPostalcode() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                   \n");
      out.write("                </tr>        \n");

            } // for u - endereços 

      out.write("\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCountry");
      out.print(addresses.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressState");
      out.print(addresses.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCity");
      out.print(addresses.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressStreet");
      out.print(addresses.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressComplement");
      out.print(addresses.size());
      out.write("\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressPostalcode");
      out.print(addresses.size());
      out.write("\" > </td>\n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("               \n");

        } // if (addresses != null)
        else{
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCountry0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressState0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCity0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressStreet0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressComplement0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressPostalcode0\" > </td>\n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("            ");

        }

      out.write("\n");
      out.write("        </table>    \n");
      out.write("<! --------------------------fecha endereços---------------------------------->\n");
      out.write("<! --------------------------abre materiais----------------------------------->\n");
      out.write("Tabela de Materiais\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Nome do Material</td>\n");
      out.write("             </tr>\n");
         
 System.out.println("antes de materiais");
        if(materials != null){
            for(int v = 0; v < materials.length; v++) {
                

      out.write("              <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material");
      out.print(v);
      out.write("\" value=\"");
      out.print((String) materials[v] );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>        \n");

            } // for v - materiais

      out.write("\n");
      out.write("                <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material");
      out.print(materials.length);
      out.write("\" >\n");
      out.write("                </td>\n");
      out.write("                   \n");

        } // if(materials != null)
        else{
            
      out.write("\n");
      out.write("            <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material0\" >\n");
      out.write("            </td>\n");
      out.write("            ");

        }

      out.write("\n");
      out.write("        </table>     \n");
      out.write("<! --------------------------fecha materiais---------------------------------->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <input type=\"submit\" name=\"voltarSI\" value=\"Voltar\" />\n");
      out.write("                <input type=\"submit\" name=\"enviar\" value=\"Enviar\" />\n");
      out.write("</form>     \n");
      out.write("\n");


}//editar
       else /*if (null != request.getParameter ("inserir"))*/ {
       
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
        

      out.write("        \n");
      out.write("\n");
      out.write("<! --------------------------abre geral-------------------------------------->\n");
      out.write("<h2>Inserir Fornecedor</h2>\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Nome</td>\n");
      out.write("                <td>Avaliação</td>\n");
      out.write("                <td>Capacidade</td>\n");
      out.write("                <td>Comentarios</td>\n");
      out.write("                <td>Descrição</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("<form action=\"./supplierInsert.jsp\" method=\"post\">\n");
      out.write("              <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"name\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                       <INPUT TYPE=\"text\" NAME=\"eval\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                       <INPUT TYPE=\"text\" NAME=\"capacity\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"comment\" >\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"description\" >\n");
      out.write("                    </td>\n");
      out.write("                    \n");
      out.write("                </tr>        \n");
      out.write("        </table> \n");
      out.write("                \n");
      out.write("<! --------------------------fecha geral-------------------------------------->\n");
      out.write("<! --------------------------abre contatos------------------------------------>\n");
      out.write("Tabela de Contatos\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Nome</td>\n");
      out.write("                <td>Cargo</td>\n");
      out.write("                <td>Email</td>\n");
      out.write("                <td>Telefone</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactName0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPosition0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactEmail0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPhone0\" > </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>            \n");
      out.write("                \n");
      out.write("<! --------------------------fecha contatos----------------------------------->\n");
      out.write("<! --------------------------abre bancos-------------------------------------->\n");
      out.write("Tabela de Dados Bancários\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                 <td>N&uacutemero do Banco</td>\n");
      out.write("                 <td>Ag&ecircncia</td>\n");
      out.write("                <td>Conta</td>\n");
      out.write("                <td>CNPJ/CPF</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankNumber0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAgency0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAccount0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf0\" > </td>\n");
      out.write("            </tr>\n");
      out.write("        </table> \n");
      out.write("<! --------------------------fecha bancos------------------------------------->\n");
      out.write("<! --------------------------abre endereços----------------------------------->\n");
      out.write("Tabela de Endere&ccedilos\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Pa&iacutes</td>\n");
      out.write("                <td>Estado</td>\n");
      out.write("                <td>Cidade</td>\n");
      out.write("                <td>Logradouro</td>\n");
      out.write("                <td>Complemento</td>\n");
      out.write("                <td>CEP</td>\n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCountry0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressState0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCity0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressStreet0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressComplement0\" > </td>\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressPostalcode0\" > </td>\n");
      out.write("            \n");
      out.write("            </tr>\n");
      out.write("        </table>            \n");
      out.write("                \n");
      out.write("<! --------------------------fecha endereços---------------------------------->\n");
      out.write("<! --------------------------abre materiais----------------------------------->\n");
      out.write("Tabela de Materiais\n");
      out.write("<table BORDER=\"1\">\n");
      out.write("             <tr>\n");
      out.write("                <td>Nome do Material</td>\n");
      out.write("                \n");
      out.write("             </tr>\n");
      out.write("                <td>\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material0\" >\n");
      out.write("                </td>\n");
      out.write("       </table>            \n");
      out.write("\n");
      out.write("                \n");
      out.write("<! --------------------------fecha materiais---------------------------------->\n");
      out.write("\n");
      out.write("\n");
      out.write("                <input type=\"submit\" name=\"voltarSI\" value=\"Voltar\" />\n");
      out.write("                <input type=\"submit\" name=\"editar\" value=\"Enviar\" />\n");
      out.write("</form>     \n");
      out.write("\n");


}//inserir
      out.write("\n");
      out.write("\n");
      out.write("<!--------------------------Footer--------------------------------------------->\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("\n");
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
      out.write("    \n");
      out.write("<!-------------------Fim do Footer--------------------------------------------->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
