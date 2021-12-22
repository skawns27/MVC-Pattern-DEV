package PSpringStudy.springStudy211217;

import PSpringStudy.springStudy211217.domain.Member;
import PSpringStudy.springStudy211217.reposipory.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SpringStudy211217ApplicationTests {
	MemoryMemberRepository repository = new MemoryMemberRepository();

	@AfterEach
	public void afterEach () {
		repository.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("남준섭");
		repository.save(member);

		Member resultMember = repository.findById(member.getId()).get(); // get()으로 가져오는게 좋은 방법은 아님
		assertThat(member).isEqualTo(resultMember);
	}

	@Test
	public void findByName() {
		Member nameFinder = new Member();
		nameFinder.setName("류서애");
		repository.save(nameFinder);

		Member wrongNameFinder = new Member();
		wrongNameFinder.setName("강신원");
		repository.save(wrongNameFinder);

		Member result = repository.findByName(nameFinder.getName()).get();
		assertThat(wrongNameFinder).isEqualTo(result);
	}

	@Test
	public void findAll() {
		Member member1 = new Member();

	}

}
