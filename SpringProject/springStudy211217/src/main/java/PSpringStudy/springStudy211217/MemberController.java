package PSpringStudy.springStudy211217;

import PSpringStudy.springStudy211217.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired //생성자 주입(추천)
   public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //@Autowired private MemberService memberService; : 필드주입(비추천) => 중간에 수정이 불가능하다
//    public void setMemberService(MemberService memberService) {
//      this.memberService = memberService; } : Setter주입 => public 때문에 중간에 불필요한 변경 가능성 있음
}
