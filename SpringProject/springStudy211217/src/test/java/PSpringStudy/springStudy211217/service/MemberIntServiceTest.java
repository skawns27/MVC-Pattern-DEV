package PSpringStudy.springStudy211217.service;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.reposipory.JdbcMemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional
public class MemberIntServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;


    @Test
    void join() {
        Member testMember = new Member();
        testMember.setName("홍위");

        Long joinId = memberService.join(testMember);
        Member checkJoiner = memberService.findOne(joinId).get(); //Optional<Member> (get()) => Member
        assertThat(testMember.getName()).isEqualTo(checkJoiner.getName());


        /* 중복가입 요청 */

        /* 방법1
        Long dupJoiner = memberService.join(testMember);
        Assertions.assertThat(illegalStateException).isEqualTo(dupJoiner);
        */

        // => Junit 5 Error : import package 추가
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class,
                ()-> memberService.join(testMember));
    }

    @Test
    void findMember() {
        String testMemName = "James";
        Member findMember1 = new Member();

    }
}
