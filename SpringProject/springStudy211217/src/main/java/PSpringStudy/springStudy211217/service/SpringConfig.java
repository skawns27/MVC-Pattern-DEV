package PSpringStudy.springStudy211217.service;

import PSpringStudy.springStudy211217.reposipory.MemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Congiuration Annotation으로 Spring 컨테이너 설정(SpringBean)=> 이 방법은 각 클래스의 @Service Annotation 사용과 다른 방법
// dependency injection : [생성자, setter, 필드]
// 변경가능성이 있다면 @Service가 아닌 @Bean 등록 추천
@Configuration
public class SpringConfig {
    @Bean //Bean 등록 => 아래 로직을 실행시 호출 : 사용자 서비스 생성
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
