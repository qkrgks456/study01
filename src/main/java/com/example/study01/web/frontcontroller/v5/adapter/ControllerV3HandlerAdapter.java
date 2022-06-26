package com.example.study01.web.frontcontroller.v5.adapter;

import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.v3.ControllerV3;
import com.example.study01.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException, IOException {
        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = paramMap(request);
        ModelView modelView = controller.process(paramMap);
        return modelView;
    }

    private Map<String, String> paramMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> map.put(paramName, request.getParameter(paramName)));
        return map;
    }
}
