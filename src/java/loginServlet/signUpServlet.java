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
@WebServlet(name = "signUpServlet", urlPatterns = {"/signUpServlet"})
public class signUpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            // get request parameters for userID and password
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String pais = (String) request.getParameter("pais");
            String checkbox = request.getParameter("checkbox");
            if (nome.isEmpty() || sobrenome.isEmpty() || username.isEmpty() || email.isEmpty()
                    || senha.isEmpty() || pais.isEmpty() || checkbox == null) {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/signUp.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Preencha todos os campos e assinale a checkbox.</font>");
                rd.include(request, response);
            } else {
                transacoes.Contato tn = new transacoes.Contato();
                data.ContatoDO contato = new data.ContatoDO();
                contato.setNome(nome);
                contato.setSobrenome(sobrenome);
                contato.setUsername(username);
                contato.setEmail(email);
                contato.setSenha(senha);
                contato.setPais(pais);

                if (tn.buscarEmail(email) || tn.buscarUsername(username)) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/signUp.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font color=red>Usuario ou email ja cadastrados </font>");
                    rd.include(request, response);
                } else {

                    if (tn.incluir(contato)) {
                        transacoes.loginUser tn1 = new transacoes.loginUser();
                        data.LoginUserDO customer = new data.LoginUserDO();
                        customer = tn1.buscarUsernameSenha(username);
                        String customerId = Integer.toString(customer.getId());
                        // avisar usuario que transacao foi feita com sucesso
                        HttpSession session = request.getSession();
                        session.setAttribute("customerId", customerId);
                        //setting session to expiry in 30 mins
                        session.setMaxInactiveInterval(30 * 60);
                        Cookie userName = new Cookie("customerId", customerId);
                        userName.setMaxAge(30 * 60);
                        response.addCookie(userName);
                        response.sendRedirect("index.jsp");

                    } else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/signUp.jsp");
                        PrintWriter out = response.getWriter();
                        out.println("<font color=red>Erro ao incluir usuario </font>");
                        rd.include(request, response);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
