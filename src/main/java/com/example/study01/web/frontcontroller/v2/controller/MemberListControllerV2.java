package com.example.study01.web.frontcontroller.v2.controller;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepo;
import com.example.study01.web.frontcontroller.MyView;
import com.example.study01.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepo memberRepo = MemberRepo.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepo.findAll();
        request.setAttribute("members", members);
        return new MyView("/WEB-INF/views/members.jsp");
    }
}
