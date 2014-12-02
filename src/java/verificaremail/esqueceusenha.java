/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificaremail;

import transacoes.EsqueceuSenhaUser;
import utils.sendEmail;
import data.LoginUserDO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bobrow
 */
@WebServlet(name = "esqueceusenha", urlPatterns = {"/esqueceusenha"})
public class esqueceusenha extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            // get request parameters for userID and password
            String email = request.getParameter("email");
            if (!email.isEmpty() ) {
                transacoes.EsqueceuSenhaUser tn = new transacoes.EsqueceuSenhaUser();
                data.LoginUserDO emailfornecido = new data.LoginUserDO();
                data.LoginUserDO emaildobanco = new data.LoginUserDO();
                emailfornecido.setEmail(email);
                emaildobanco = tn.buscarUsernameEmail(email);
                String customerId = Integer.toString(emaildobanco.getId());
                if (email.equals(emaildobanco.getEmail()) ) {
                    utils.sendEmail enviar = new utils.sendEmail();
                    enviar.RecoveryKeyEmail(emaildobanco.getEmail(), emaildobanco.getSenha());
                    
                    //perguntar pro artur qual parte do codigo precisa daqui pra baixo
                    HttpSession session = request.getSession();
                    session.setAttribute("customerId", customerId);
                    //setting session to expiry in 30 mins
                    session.setMaxInactiveInterval(30 * 60);
                    Cookie userName = new Cookie("customerId", customerId);
                    userName.setMaxAge(30 * 60);
                    response.addCookie(userName);
                    response.sendRedirect("index.jsp");
                } else {
//                    response.sendRedirect("esqueceusenha.jsp");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/esqueceusenha.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font color=red>e-mail incorreto.</font>");
                    rd.include(request, response);
               } 
            } 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}