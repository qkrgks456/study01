package com.example.study01.basic.resp;

import com.example.study01.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/resp-json")
public class RespJson extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        HelloData helloData = new HelloData();
        helloData.setAge(13);
        helloData.setUsername("한솔");
        String result = objectMapper.writeValueAsString(helloData);
        resp.getWriter().write(result);
    }
}
