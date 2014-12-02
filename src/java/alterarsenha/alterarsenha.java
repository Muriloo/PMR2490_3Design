/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alterarsenha;

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
import project.projectData;
import utils.Transacao;

/**
 *
 * @author Mauri
 */
@WebServlet(name = "alterarsenha", urlPatterns = {"/alterarsenha"})
public class alterarsenha extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            // get request parameters for userID and password
            String username = request.getParameter("username");
            String senhaatual = request.getParameter("senhaatual");
            String novasenha1 = request.getParameter("novasenha1");
            String novasenha2 = request.getParameter("novasenha2");
            if (!username.isEmpty() && !senhaatual.isEmpty() && !novasenha1.isEmpty() && !novasenha2.isEmpty()) {
                transacoes.loginUser tn = new transacoes.loginUser();
                data.LoginUserDO login = new data.LoginUserDO();
                data.LoginUserDO userSenha = new data.LoginUserDO();
                transacoes.AlterarSenha altSenha = new transacoes.AlterarSenha();
                login.setUsername(username);
                login.setSenha(senhaatual);
                login.setNovasenha1(novasenha1);
                login.setNovasenha2(novasenha2);
                userSenha = tn.buscarUsernameSenha(username);
//                String customerId = Integer.toString(userSenha.getId());
                if (username.equals(userSenha.getUsername()) && senhaatual.equals(userSenha.getSenha())) {
                    if (novasenha1.equals(novasenha2)) {

                        if (altSenha.alterar(login)) {
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarsenha.jsp");
                            PrintWriter out = response.getWriter();
                            out.println("<font color=red>Senha alterada com sucesso.</font>");
                        } else {
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarsenha.jsp");
                            PrintWriter out = response.getWriter();
                            out.println("<font color=red>Erro. Verifique as informações digitadas.</font>");
                        }

                    } else {
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarsenha.jsp");
                        PrintWriter out = response.getWriter();
                        out.println("<font color=red>suas senhas estão diferentes.</font>");
                        rd.include(request, response);
                    }
//                    response.sendRedirect("index.jsp");
                } else if (username.equals(userSenha.getUsername()) && !senhaatual.equals(userSenha.getSenha())) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarsenha.jsp");
                    PrintWriter out = response.getWriter();
                    out.println("<font color=red>Senha ou usuário incorretos.</font>");
                    rd.include(request, response);
                }
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/alterarsenha.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Preencha usuario e senha.</font>");
                rd.include(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
