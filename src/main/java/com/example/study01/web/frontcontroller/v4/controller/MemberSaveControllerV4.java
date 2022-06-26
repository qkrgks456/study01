package com.example.study01.web.frontcontroller.v4.controller;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepo;
import com.example.study01.web.frontcontroller.ModelView;
import com.example.study01.web.frontcontroller.v3.ControllerV3;
import com.example.study01.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepo memberRepo = MemberRepo.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model) {
        String username = param.get("username");
        int age = Integer.parseInt(param.get("age"));

        Member member = memberRepo.save(new Member(username, age));
        model.put("member", member);
        return "save-result";
    }
}
