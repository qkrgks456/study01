package com.example.study01.basic.resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp_header")
public class RespHeader extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // status line
        resp.setStatus(HttpServletResponse.SC_FOUND);

        // header
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store , must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        //Cookie cookie = new Cookie("test", "hello");
        //cookie.setMaxAge(600);
        //resp.addCookie(cookie);
        resp.sendRedirect("/basic.html");
        resp.getWriter().println("안녕하세요");
    }
}
