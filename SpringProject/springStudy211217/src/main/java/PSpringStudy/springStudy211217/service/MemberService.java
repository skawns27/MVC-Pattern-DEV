package PSpringStudy.springStudy211217.service;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.reposipory.JdbcMemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service => 직접 컨테이너 설정하기 위해 주석처리
public class MemberService {
//    private final static MemberRepository memberRepository = new MemoryMemberRepository(); =
      private MemberRepository memberRepository;

      @Autowired //자동호출
     public MemberService(MemberRepository memberRepository) {
          this.memberRepository = memberRepository;
      }
    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member); // <= 회원중복 여부 확인
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원정보입니다.");
                });
    }
}
