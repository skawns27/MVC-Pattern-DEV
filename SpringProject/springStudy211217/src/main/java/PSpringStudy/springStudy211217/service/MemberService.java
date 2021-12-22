package PSpringStudy.springStudy211217.service;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.reposipory.MemberRepository;
import PSpringStudy.springStudy211217.reposipory.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final static MemberRepository memberRepository = new MemoryMemberRepository();
    /**
     * 회원가입
     */
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
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원정보입니다.");
                });
    }
}
