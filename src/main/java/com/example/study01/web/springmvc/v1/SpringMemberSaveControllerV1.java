package com.example.study01.web.springmvc.v1;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberSaveControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member saveMember = memberRepository.save(new Member(username, age));

        ModelAndView modelView = new ModelAndView("save-result");

        modelView.addObject("member", saveMember);

        return modelView;
    }


}
