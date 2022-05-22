package com.example.study01.web.frontcontroller.v3;

import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.MyView;
import com.example.study01.web.frontcontroller.v2.ControllerV2;
import com.example.study01.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.example.study01.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.example.study01.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import com.example.study01.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.example.study01.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.study01.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV3Map = new HashMap<>();

    public FrontControllerServletV3() {
        this.controllerV3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        this.controllerV3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        this.controllerV3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    // 와 이건 코드가 정말 예술이다
    // 인터페이스를 이렇게 생각하는게 어떻게 되지
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV3 controllerV3 = controllerV3Map.get(requestURI);
        if (controllerV3 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // map 넘겨줘야 함
        Map<String, Object> paramMap = paramMap(request);

        ModelView modelView = controllerV3.process(paramMap);

        MyView view = viewResolver(modelView.getViewName());
        view.render(modelView.getModel(), request, response);

    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, Object> paramMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> map.put(paramName, request.getParameter(paramName)));
        return map;
    }
}
