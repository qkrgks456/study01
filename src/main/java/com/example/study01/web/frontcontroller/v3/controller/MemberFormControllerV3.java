package com.example.study01.web.frontcontroller.v3.controller;

import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> param) {
        return new ModelView("new-form");
    }
}
