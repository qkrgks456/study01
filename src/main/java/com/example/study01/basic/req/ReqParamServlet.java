package com.example.study01.basic.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "reqParamServlet", urlPatterns = "/req_param")
public class ReqParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getLocales()
                .asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("ReqParamServlet.service");
        // 전체 파라미터 조회
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));
        System.out.println();

        // 단일 파라미터 조회
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println();

        // 이름이 같은 복수 파라미터 조회
        String[] usernames = req.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("username = " + s);
        }

        resp.getWriter().write("ok");
    }
}
