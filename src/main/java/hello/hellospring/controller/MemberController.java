package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        // Dependency Injection!!
        // Consider defining a bean of type 'hello.hellospring.service.MemberService' in your configuration.
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String newMember(){
        return "members/newMembers";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String read(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/listMembers";
    }
}
