package PSpringStudy.springStudy211217.reposipory;

import PSpringStudy.springStudy211217.domain.Member;

import java.util.List;
import java.util.Optional;

// 사용자 저장 Repository 인터페이스
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
