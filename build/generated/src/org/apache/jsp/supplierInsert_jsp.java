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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!------------------------------------------------------------------->\r\n");
      out.write("<!--   sempre mostrar o formulario de busca, ateh acao ser \"voltar\" -->\r\n");
      out.write("\r\n");
     if ( null != request.getParameter("voltarSI")) {

      out.write("        ");
      if (true) {
        _jspx_page_context.forward("./supplierPage.jsp");
        return;
      }
      out.write('\r');
      out.write('\n');
        return;
       }
    
     

      out.write("\r\n");
      out.write("\r\n");
      out.write("         <form action=\"./supplierInsert.jsp\" method=\"post\">\r\n");
      out.write("              <input type=\"submit\" name=\"inserir\" value=\"Inserir\" />\r\n");
      out.write("              <input type=\"submit\" name=\"voltarSI\" value=\"Voltar\" />\r\n");
      out.write("         </form>\r\n");
      out.write("\r\n");
      out.write("<! ------------------------------------------------------------------->\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        ");
 
       if (null != request.getParameter ("editar")) {      
        
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
    Vector contacts = new Vector();
    Vector banks = new Vector();
    Vector addresses = new Vector();
    ArrayList<String> materials = new ArrayList<String>();
    boolean erro = false;
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
    }else if(null != request.getParameter("editar2") && session.getAttribute("supplier")!=null){
    supplier = (supplierDO) session.getAttribute("supplier");
    contacts = supplier.getContactInfo();
    addresses = supplier.getAddress();
    banks = supplier.getBankInfo();
    System.out.println("supplier editar2");
    }else {
    /* inserir novo fornecedor: pegar os parâmetros-------------------------*/
    //gerais
        if(session.getAttribute("supplier")==null) System.out.println("supplier nulo");
           if(request.getParameter("id") != null && request.getParameter("id").length() !=0)
               supplier.setId(Integer.parseInt(request.getParameter("id")));
               if(request.getParameter("name") != null) supplier.setName(request.getParameter("name"));
               else {
                   
      out.write(" Nome de Fornecedor inválido!");

                   erro = true;
               }
               System.out.println("supplier name: "+ supplier.getName());
               
               
               
               if (request.getParameter("comment") != null)
                    supplier.setComment(request.getParameter("comment"));
               else supplier.setComment("");
               if (request.getParameter("description") != null )
                    supplier.setDescription(request.getParameter("description"));
               else supplier.setDescription("");
               System.out.println("parametros ok");
           
    //contatos
           
           int p=0;      
           while(null != request.getParameter("contactName"+p) && request.getParameter("contactName"+p).length() != 0){
               contactInfoDO contact = new contactInfoDO();
               if(null != request.getParameter("contactId"+p) && request.getParameter("contactId"+p).length() != 0)
                    contact.setId(Integer.parseInt(request.getParameter("contactId"+p)));
               System.out.println("entrei no contacts "+request.getParameter("contactName"+p));
               contact.setName(request.getParameter("contactName"+p));
               if(request.getParameter("contactPosition"+p) !=null)
                    contact.setPosition(request.getParameter("contactPosition"+p));
               else contact.setPosition("");
               if(request.getParameter("contactEmail"+p) != null)
                    contact.setEmail(request.getParameter("contactEmail"+p));
               else contact.setEmail("");
               if(request.getParameter("contactPhone"+p) != null)
                    contact.setPhone(request.getParameter("contactPhone"+p));
               else contact.setPhone("");
               contacts.add(contact);
               p++;
           }
           if (contacts==null) System.out.println("contacts nulo");
           else{
           supplier.setContactInfo(contacts);
           System.out.println("contacts ok medio");
           }
           System.out.println("contacts.length="+contacts.size());
           
           
    //bancos
           p=0;
           while(null != request.getParameter("bankNumber"+p) && request.getParameter("bankNumber"+p).length() != 0){
               BankInfoDO bank = new BankInfoDO();
               if(null != request.getParameter("bankId"+p) && request.getParameter("bankId"+p).length() != 0)
                    bank.setId(Integer.parseInt(request.getParameter("bankId"+p)));
               bank.setBankNumber(request.getParameter("bankNumber"+p));
               if(request.getParameter("bankAgency"+p)!=null)
                    bank.setAgency(request.getParameter("bankAgency"+p));
               else bank.setAgency("");
               if(request.getParameter("bankAccount"+p)!=null)
                    bank.setAccount(request.getParameter("bankAccount"+p));
               else bank.setAccount("");
               if(request.getParameter("bankCnpjCpf"+p)!=null)
                    bank.setCnpjCpf(request.getParameter("bankCnpjCpf"+p));
               else bank.setCnpjCpf("");
               banks.add(bank);
               p++;
           }
           if (banks==null) System.out.println("banks nulo");
           else
           supplier.setBankInfo(banks);
    //endereços
           p=0;
           while(null != request.getParameter("addressCountry"+p) && request.getParameter("addressCountry"+p).length() != 0){
               supplierAddressDO address = new supplierAddressDO();
               if(null != request.getParameter("addressId"+p) && request.getParameter("addressId"+p).length() != 0)
                    address.setId(Integer.parseInt(request.getParameter("addressId"+p)));
               address.setCountry(request.getParameter("addressCountry"+p));
               if(request.getParameter("addressState"+p)!=null)
                    address.setState(request.getParameter("addressState"+p));
               else address.setState("");
               if(request.getParameter("addressCity"+p)!=null)
                    address.setCity(request.getParameter("addressCity"+p));
               else address.setCity("");
               if(request.getParameter("addressStreet"+p)!=null)
                    address.setStreet(request.getParameter("addressStreet"+p));
               else address.setStreet("");
               if(request.getParameter("addressComplement"+p)!=null)
                    address.setComplement(request.getParameter("addressComplement"+p));
               else address.setComplement("");
               if(request.getParameter("addressPostalcode"+p)!=null)
                    address.setPostalcode(request.getParameter("addressPostalcode"+p));
               else address.setPostalcode("");
               addresses.add(address);
               p++;
           }
           if (addresses==null) System.out.println("addresses nulo");
           else supplier.setAddress(addresses);
    //materiais
           System.out.println("antes de materiais");
            p=0;
            while(null != request.getParameter("material"+p) && request.getParameter("material"+p).length() != 0){
                materials.add(p,request.getParameter("material"+p));
                p++;
            }
            if (materials==null) System.out.println("materials nulo");
            else supplier.setMaterials(materials.toArray());
           session.setAttribute("supplier", supplier);
           supplier sp = new supplier();
           System.out.println("vai inserir");
           if(erro){
               
      out.write("\r\n");
      out.write("               Erro no formul&aacuterio!\r\n");
      out.write("               ");

           }else {
               
                if(null != request.getParameter("inserir")){
                supplierDO supplier2 = sp.include(supplier);
                if(supplier2.getId() != -1){// fornecedor inserido
                System.out.println("inserido");
                supplier = supplier2;
                response.sendRedirect("./supplier2.jsp?indice=0&ver=1&ok=1");  
                
      out.write("\r\n");
      out.write("           Fornecedor inserido com sucesso!\r\n");
      out.write("                ");

                } else{
                System.out.println("nao inserido");
                
      out.write("\r\n");
      out.write("           Erro na inser&ccedil&atildeo do fornecedor!\r\n");
      out.write("                ");

            }//erro na inserção
           }else{//editar
                supplierDO supplier2 = sp.update(supplier);
                if(supplier2.getId() != -1){// fornecedor editado
                supplier = supplier2;
                System.out.println("editado");
                
                
      out.write("\r\n");
      out.write("           Fornecedor editado com sucesso!\r\n");
      out.write("                ");

                } else{
                System.out.println("nao editado");
                
      out.write("\r\n");
      out.write("           Erro na edi&ccedil&atildeo do fornecedor!\r\n");
      out.write("                ");

            }//erro na edição
           }//editar
           } //erro no formulario
       } // novo fornecedor

      out.write("        \r\n");
      out.write("\r\n");
      out.write("<! --------------------------abre geral-------------------------------------->\r\n");
      out.write("<h2>Editar Fornecedor</h2>\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome</td>\r\n");
      out.write("                <td>Comentarios</td>\r\n");
      out.write("                <td>Descrição</td>\r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");
      out.write("            <form action=\"./supplierInsert.jsp\" method=\"post\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"name\" value=\"");
      out.print( supplier.getName());
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"comment\" value=\"");
      out.print( supplier.getComment() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"description\" value=\"");
      out.print( supplier.getDescription() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    \r\n");
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
      out.write("            </tr>\r\n");
        // contatos
System.out.println("antes do if dos contatos!=null");
        if (contacts != null) {           
            System.out.println("antes do for dos contatos!=null");
            for(int j = 0; j < contacts.size(); j++) {
                contactInfoDO contact = (contactInfoDO) contacts.elementAt(j);
                

      out.write("\r\n");
      out.write("                <input type=\"hidden\" name=\"contactId");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getId() );
      out.write("\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactName");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getName() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactPosition");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getPosition() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactEmail");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getEmail() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"contactPhone");
      out.print(j);
      out.write("\" value=\"");
      out.print( contact.getPhone() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>        \r\n");
          
            } // for j - contatos

      out.write("\r\n");
      out.write("            \r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactName");
      out.print(contacts.size());
      out.write("\"  > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPosition");
      out.print(contacts.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactEmail");
      out.print(contacts.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPhone");
      out.print(contacts.size());
      out.write("\" > </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("                    \r\n");

        } // if (contacts != null)
        else{
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactName0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPosition0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactEmail0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPhone0\" > </td>\r\n");
      out.write("            </tr>        \r\n");
      out.write("                    ");

            System.out.println("contact ==  null");
        }

      out.write("              \r\n");
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("<! --------------------------fecha contatos----------------------------------->\r\n");
      out.write("<! --------------------------abre bancos-------------------------------------->\r\n");
      out.write("Tabela de Dados Bancários\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                 <td>N&uacutemero do Banco</td>\r\n");
      out.write("                 <td>Ag&ecircncia</td>\r\n");
      out.write("                <td>Conta</td>\r\n");
      out.write("                <td>CNPJ/CPF</td>\r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");
          // bancos


        if (banks != null){
            System.out.println("bancos nao nulo:" +banks.size());
            for(int k = 0; k < banks.size(); k++) {
                BankInfoDO bank = (BankInfoDO) banks.elementAt(k);

      out.write("\r\n");
      out.write("                <input type=\"hidden\" name=\"bankId");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getId() );
      out.write("\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankNumber");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getBankNumber() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankAgency");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getAgency() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankAccount");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getAccount() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf");
      out.print(k);
      out.write("\" value=\"");
      out.print( bank.getCnpjCpf() );
      out.write("\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                   \r\n");
      out.write("                </tr>        \r\n");
 
            } // for k - bancos 

      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankNumber");
      out.print(banks.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAgency");
      out.print(banks.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAccount");
      out.print(banks.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf");
      out.print(banks.size());
      out.write("\" > </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("         \r\n");

        } // if (banks != null)
        else{
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankNumber0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAgency0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAccount0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf0\" > </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

        }

      out.write("\r\n");
      out.write("        </table>\r\n");
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
      out.write("            </tr>\r\n");
          //endereços
 System.out.println("antes de endereços");
        if (addresses != null){
            for(int u = 0; u < addresses.size(); u++) {
                supplierAddressDO address = (supplierAddressDO) addresses.elementAt(u);

      out.write("              \r\n");
      out.write("                <input type=\"hidden\" name=\"addressId");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getId() );
      out.write("\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressCountry");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getCountry() );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressState");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getState() );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressCity");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getCity() );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressStreet");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getStreet() );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressComplement");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getComplement() );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"addressPostalcode");
      out.print(u);
      out.write("\" value=\"");
      out.print( address.getPostalcode() );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                   \r\n");
      out.write("                </tr>        \r\n");

            } // for u - endereços 

      out.write("\r\n");
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCountry");
      out.print(addresses.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressState");
      out.print(addresses.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCity");
      out.print(addresses.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressStreet");
      out.print(addresses.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressComplement");
      out.print(addresses.size());
      out.write("\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressPostalcode");
      out.print(addresses.size());
      out.write("\" > </td>\r\n");
      out.write("            \r\n");
      out.write("            </tr>\r\n");
      out.write("               \r\n");

        } // if (addresses != null)
        else{
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCountry0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressState0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCity0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressStreet0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressComplement0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressPostalcode0\" > </td>\r\n");
      out.write("            \r\n");
      out.write("            </tr>\r\n");
      out.write("            ");

        }

      out.write("\r\n");
      out.write("        </table>    \r\n");
      out.write("<! --------------------------fecha endereços---------------------------------->\r\n");
      out.write("<! --------------------------abre materiais----------------------------------->\r\n");
      out.write("Tabela de Materiais\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome do Material</td>\r\n");
      out.write("             </tr>\r\n");
         
 System.out.println("antes de materiais");
        if(materials != null){
            Object[] materials2 = materials.toArray();
            for(int v = 0; v < materials2.length; v++) {
                

      out.write("              \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material");
      out.print(v);
      out.write("\" value=\"");
      out.print((String) materials2[v] );
      out.write("\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    \r\n");
      out.write("                </tr>        \r\n");

            } // for v - materiais

      out.write("\r\n");
      out.write("                <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material");
      out.print(materials2.length);
      out.write("\" >\r\n");
      out.write("                </td>\r\n");
      out.write("                   \r\n");

        } // if(materials != null)
        else{
            
      out.write("\r\n");
      out.write("            <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material0\" >\r\n");
      out.write("            </td>\r\n");
      out.write("            ");

        }

      out.write("\r\n");
      out.write("        </table>     \r\n");
      out.write("<! --------------------------fecha materiais---------------------------------->\r\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( supplier.getId());
      out.write("\" />\r\n");
      out.write("                <input type=\"submit\" name=\"voltarSI\" value=\"Voltar\" />\r\n");
      out.write("                <!input type=\"submit\" name=\"editar\" value=\"Enviar\" />\r\n");
      out.write("</form>     \r\n");
      out.write("\r\n");


}//editar
       else /*if (null != request.getParameter ("inserir"))*/ {
       
    transaction.supplier tn = new transaction.supplier();
    supplierDO supplier = new supplierDO();
        

      out.write("        \r\n");
      out.write("\r\n");
      out.write("<! --------------------------abre geral-------------------------------------->\r\n");
      out.write("<h2>Inserir Fornecedor</h2>\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome</td>\r\n");
      out.write("                <td>Comentarios</td>\r\n");
      out.write("                <td>Descrição</td>\r\n");
      out.write("                \r\n");
      out.write("            </tr>\r\n");
      out.write("<form action=\"./supplierInsert.jsp\" method=\"post\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"name\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"comment\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"description\" >\r\n");
      out.write("                    </td>\r\n");
      out.write("                    \r\n");
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
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactName0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPosition0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactEmail0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"contactPhone0\" > </td>\r\n");
      out.write("            </tr>\r\n");
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
      out.write("                \r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankNumber0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAgency0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankAccount0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"bankCnpjCpf0\" > </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table> \r\n");
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
      out.write("                \r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCountry0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressState0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressCity0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressStreet0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressComplement0\" > </td>\r\n");
      out.write("                <td> <INPUT TYPE=\"text\" NAME=\"addressPostalcode0\" > </td>\r\n");
      out.write("            \r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>            \r\n");
      out.write("                \r\n");
      out.write("<! --------------------------fecha endereços---------------------------------->\r\n");
      out.write("<! --------------------------abre materiais----------------------------------->\r\n");
      out.write("Tabela de Materiais\r\n");
      out.write("<table BORDER=\"1\">\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td>Nome do Material</td>\r\n");
      out.write("                \r\n");
      out.write("             </tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                        <INPUT TYPE=\"text\" NAME=\"material0\" >\r\n");
      out.write("                </td>\r\n");
      out.write("       </table>            \r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("<! --------------------------fecha materiais---------------------------------->\r\n");
      out.write("\r\n");
      out.write("                <input type=\"hidden\" name=\"inserir\" value=\"Inserir\" />\r\n");
      out.write("                <!input type=\"submit\" name=\"voltarSI\" value=\"Voltar\" />\r\n");
      out.write("                <input type=\"submit\" name=\"editar\" value=\"Enviar\" />\r\n");
      out.write("</form>     \r\n");
      out.write("\r\n");


}//inserir
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
