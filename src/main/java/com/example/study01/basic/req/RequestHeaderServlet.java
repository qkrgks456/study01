package com.example.study01.basic.req;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "reqHeaderServlet", urlPatterns = "/req-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printHeader(req);
    }

    private void printLine(HttpServletRequest req) {
        String method = req.getMethod();
        String protocol = req.getProtocol();
        String scheme = req.getScheme();
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        String queryString = req.getQueryString();
        boolean secure = req.isSecure();
        System.out.println("secure = " + secure);
        System.out.println("queryString = " + queryString);
        System.out.println("requestURL = " + requestURL);
        System.out.println("requestURI = " + requestURI);
        System.out.println("scheme = " + scheme);
        System.out.println("protocol = " + protocol);
        System.out.println("method = " + method);
    }

    private void printHeader(HttpServletRequest req) {
    /*    Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println("headerName = " + headerName);
        }*/
        req.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName + " :" + headerName));
    }
}
