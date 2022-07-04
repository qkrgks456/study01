package com.example.study01.web.springmvc.v1;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepo;
import com.example.study01.web.frontcontroller.ModelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepo memberRepo = MemberRepo.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> members = memberRepo.findAll();
        ModelAndView modelView = new ModelAndView("members");
        modelView.addObject("members", members);
        return modelView;
    }
}
