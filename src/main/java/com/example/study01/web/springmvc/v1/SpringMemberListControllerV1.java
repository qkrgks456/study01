package com.example.study01.web.springmvc.v1;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> members = memberRepository.findAll();

        ModelAndView modelView = new ModelAndView("members");

        modelView.addObject("members", members);

        return modelView;
    }
}
