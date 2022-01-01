package PSpringStudy.springStudy211217.service;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.reposipory.MemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows; // 211223: Junit v5 추가
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    final MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(memberRepository);

    @AfterEach
    void mClear() {
        memberRepository.clearStore();
    }
    @Test
    void join() {
        Member testMember = new Member();
        testMember.setName("홍위");

        Long joinId = memberService.join(testMember);
        Member checkJoiner = memberService.findOne(joinId).get(); //Optional<Member> (get()) => Member
        assertThat(testMember).isEqualTo(checkJoiner);


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
