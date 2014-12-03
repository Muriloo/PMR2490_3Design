/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginServlet;

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
 * @author Mauri
 */
@WebServlet(name = "LogServlet", urlPatterns = {"/LogServlet"})
public class LogServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            // get request parameters for userID and password
            String username = request.getParameter("username");
            String senha = request.getParameter("senha");
            if (!username.isEmpty() && !senha.isEmpty()) {
                transacoes.loginUser tn = new transacoes.loginUser();
                data.LoginUserDO login = new data.LoginUserDO();
                data.LoginUserDO userSenha = new data.LoginUserDO();
                login.setUsername(username);
                login.setSenha(senha);
                userSenha = tn.buscarUsernameSenha(username);
                String customerId = Integer.toString(userSenha.getId());
                
                String user_permission_id = Integer.toString(userSenha.getUserpermissionid());
                System.out.print("LogServlet" + user_permission_id);
                if (username.equals(userSenha.getUsername()) && senha.equals(userSenha.getSenha())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("customerId", customerId);
                    session.setAttribute("user_permission_id", user_permission_id);
                    System.out.print("LogServet" + user_permission_id);
                    //setting session to expiry in 30 mins
                    session.setMaxInactiveInterval(30 * 60);
                    Cookie userName = new Cookie("customerId", customerId);
                    userName.setMaxAge(30 * 60);
                    response.addCookie(userName);
                    response.sendRedirect("index.jsp");
                } else if (username.equals(userSenha.getUsername()) && !senha.equals(userSenha.getSenha())) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/logIn.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font color=red>Senha Incorreta.</font>");
                    rd.include(request, response);
               } 
            } else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/logIn.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Preencha usuario e senha.</font>");
                rd.include(request, response);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
