package com.cachacajambu.filter;

import com.cachacajambu.entity.Users;
import org.jboss.weld.context.http.Http;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/pages/*")
public class PageFilter extends AbstractFilter implements Filter {

    private ArrayList<String> allowedURIs = null;
    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        //HttpServletRequest request2 = (HttpServletRequest) request;
        //String url = request2.getRequestURI();

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = ((HttpServletRequest) request).getRequestURI();
        HttpSession sess = req.getSession();
        //Users user = (Users) sess.getAttribute("usuario");

     /*   if(sess.isNew() || sess.getAttribute("usuario") == null) {
            doLogin(request, response, req);
        } else {
            chain.doFilter(request, response);
        }
        */

     if(sess.getAttribute("usuario")!= null
                || url.lastIndexOf("login.xhtml")>-1) {
            try {
                chain.doFilter(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.xhtml");
        }


    }

    public void init(FilterConfig fConfig) throws ServletException {

    }

}