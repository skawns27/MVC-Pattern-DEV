package PSpringStudy.springStudy211217.service;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.reposipory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//Congiuration Annotation으로 Spring 컨테이너 설정(SpringBean)=> 이 방법은 각 클래스의 @Service Annotation 사용과 다른 방법
// dependency injection : [생성자, setter, 필드]
// 변경가능성이 있다면 @Service가 아닌 @Bean 등록 추천
@Configuration
public class SpringConfig {
//    private DataSource dataSource;
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
////        this.dataSource = dataSource;
//        this.em = em;
//    } //springDataSource 호출하여 설정
    /* Jpa Data 사용*/

    private final MemberRepository memberRepository;
    @Autowired // 사실 생성자 1개면 생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // injection으로 주입받는 memberRepository 호출
    }
    @Bean //Bean 등록 => 아래 로직을 실행시 호출 : 사용자 서비스 생성
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // jdbc레포지토리로 변경
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
