package PSpringStudy.springStudy211217.reposipory;

import PSpringStudy.springStudy211217.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface SpringDataJapMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    List<Member> findAllById(Iterable<Long> longs);

    @Override
    List<Member> findAll();

    @Override
    Optional findByName(String name); // => 이름으로 사용자 찾기
}
