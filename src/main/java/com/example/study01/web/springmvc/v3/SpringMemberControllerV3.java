package com.example.study01.web.springmvc.v3;

import com.example.study01.domain.member.Member;
import com.example.study01.domain.member.MemberRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepo memberRepo = MemberRepo.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepo.findAll();
        model.addAttribute("members", members);
        return "members";
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age, Model model) {
        Member saveMember = memberRepo.save(new Member(username, age));
        model.addAttribute("member", saveMember);
        return "save-result";
    }
}
