package com.example.study01.web.frontcontroller.v4;

import com.example.study01.web.frontcontroller.MyView;
import com.example.study01.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.example.study01.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.example.study01.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerV4Map = new HashMap<>();

    public FrontControllerServletV4() {
        this.controllerV4Map.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        this.controllerV4Map.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        this.controllerV4Map.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    // 와 이건 코드가 정말 예술이다
    // 인터페이스를 이렇게 생각하는게 어떻게 되지
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV4 controllerV4 = controllerV4Map.get(requestURI);
        if (controllerV4 == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // map 넘겨줘야 함
        Map<String, String> paramMap = paramMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = controllerV4.process(paramMap, model);

        MyView view = viewResolver(viewName);
        view.render(model, request, response);

    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> paramMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> map.put(paramName, request.getParameter(paramName)));
        return map;
    }
}
