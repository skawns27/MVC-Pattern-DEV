package PSpringStudy.springStudy211217;

import PSpringStudy.springStudy211217.reposipory.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sController {
    @GetMapping("Hi")
    public String Hi(Model model) {
        model.addAttribute("data", "안녕하세요!!");
        return "Hi";
    }
    @GetMapping("Bye")
    public String Bye(Model model) {
        model.addAttribute("data", "잘가세요!!");
        return "Hi";
    }
    @GetMapping("mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model) { // name 파라미터 => 변수 name에서 받아옴
        if(name == null) {
            model.addAttribute("name", "Nam Jun?");
        } else {
            model.addAttribute("name", name);
        }
        return "mvc-template";

    }
    @GetMapping("mvcAPI")
    @ResponseBody
    public HelloThere apiRes(@RequestParam(name = "name", required = false) String name) {
        HelloThere HT = new HelloThere();
        return HT;
    }

    static class HelloThere {
        private String name;

        {
            name = "남준섭";
        }

        public String getName() {
            return name;
        }
        public void setName(String Name) {
            this.name = Name;
        }
    }

    @Controller
    public static class MemberController {
        private MemberRepository memberRepository;


    }
}
