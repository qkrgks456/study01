package com.example.study01.web.frontcontroller.v3.controller;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepository;
import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> param) {
        String username = (String) param.get("username");
        int age = Integer.parseInt((String) param.get("age"));
        Member saveMember = memberRepository.save(new Member(username, age));
        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", saveMember);
        System.out.println(modelView);
        return modelView;
    }
}
