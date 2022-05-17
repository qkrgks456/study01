package com.example.study01.web.frontcontroller.v1;

import com.example.study01.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.example.study01.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.example.study01.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerV1Map = new HashMap<>();

    public FrontControllerServletV1() {
        this.controllerV1Map.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        this.controllerV1Map.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        this.controllerV1Map.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    // 와 이건 코드가 정말 예술이다
    // 인터페이스를 이렇게 생각하는게 어떻게 되지
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV1 controllerV1 = controllerV1Map.get(requestURI);
        if (controllerV1 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(request, response);
    }
}
