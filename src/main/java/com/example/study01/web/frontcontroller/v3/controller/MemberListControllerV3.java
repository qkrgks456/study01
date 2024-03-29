package com.example.study01.web.frontcontroller.v3.controller;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepository;
import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> param) {
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);
        System.out.println(modelView);
        return modelView;
    }
}
