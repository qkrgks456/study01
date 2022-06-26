package com.example.study01.web.frontcontroller.v3;

import com.example.study01.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> param);
}
