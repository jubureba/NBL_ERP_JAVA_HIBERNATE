package com.cachacajambu.util;

import com.cachacajambu.dao.UsersDAO;
import com.cachacajambu.entity.Users;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class autenticador {

    public autenticador() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession(false);
        if(sess != null) {
            sess.invalidate();
        }
        response.sendRedirect(request.getContextPath() +  "/login/login.xhtml");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String slogin = request.getParameter("login");
        String ssenha = request.getParameter("senha");

        Users user = new Users();
        user.setLogin(slogin);
        user.setSenha(ssenha);

        UsersDAO userDao = new UsersDAO();
        Users userAutenticado =  userDao.Login(user);

        if(userAutenticado != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("userAutenticado", userAutenticado);
            request.getRequestDispatcher("index.xhtml").forward(request, response);
        } else {
            response.sendRedirect( request.getContextPath() + "/login/login.xhtml");
        }
    }
}
