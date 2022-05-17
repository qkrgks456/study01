package com.example.study01.web.frontcontroller.v2;

import com.example.study01.web.frontcontroller.MyView;
import com.example.study01.web.frontcontroller.v1.ControllerV1;
import com.example.study01.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.example.study01.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.example.study01.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import com.example.study01.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.example.study01.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.example.study01.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV2Map = new HashMap<>();

    public FrontControllerServletV2() {
        this.controllerV2Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        this.controllerV2Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        this.controllerV2Map.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    // 와 이건 코드가 정말 예술이다
    // 인터페이스를 이렇게 생각하는게 어떻게 되지
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV2 controllerV2 = controllerV2Map.get(requestURI);
        if (controllerV2 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV2.process(request, response).render(request, response);
    }
}
