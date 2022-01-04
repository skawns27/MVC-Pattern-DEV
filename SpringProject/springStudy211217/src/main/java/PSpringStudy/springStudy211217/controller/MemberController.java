package PSpringStudy.springStudy211217.controller;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //생성자 주입(추천)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
//    createMemberForm에서 사용자 정보 입력시 PostMapping 동작 (action 태그)
    @PostMapping("/members/new")
//    MemberForm 에서 문자열 파라미터 시 setName(Name) 호출하여 입력값 전달
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
//        members 리스트 => model에 담아서 전달
       List<Member> members = memberService.findMembers();
       model.addAttribute("members", members);
       return "members/memberList";
    }

    //@Autowired private MemberService memberService; : 필드주입(비추천) => 중간에 수정이 불가능하다
//    public void setMemberService(MemberService memberService) {
//      this.memberService = memberService; } : Setter주입 => public 때문에 중간에 불필요한 변경 가능성 있음
}
