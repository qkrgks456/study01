package com.example.study01.web.frontcontroller.v5;

import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.MyView;
import com.example.study01.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.example.study01.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.example.study01.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import com.example.study01.web.frontcontroller.v4.controller.MemberFormControllerV4;
import com.example.study01.web.frontcontroller.v4.controller.MemberListControllerV4;
import com.example.study01.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import com.example.study01.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import com.example.study01.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapter();
    }

    private void initHandlerMappingMap() {
        this.handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        this.handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        this.handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
        this.handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        this.handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        this.handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapter() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object handler = getHandler(req);
        if (handler == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);

        ModelView modelView = handlerAdapter.handle(req, resp, handler);

        MyView view = viewResolver(modelView.getViewName());
        view.render(modelView.getModel(), req, resp);
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handler)) {
                return handlerAdapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다" + handler);
    }

    private Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }


}
