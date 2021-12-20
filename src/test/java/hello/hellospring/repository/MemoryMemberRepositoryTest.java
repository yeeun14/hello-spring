package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // callback 메서드
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // new에서 저장한 멤버와 DB에서 꺼낸 멤버가 같다면 참이다.
        assertThat(member).isEqualTo(result);
       // Assertions.assertEquals(member, result); // 저장한 멤버가 find했을 때 나와야함
      //  System.out.println("result = " + (result == member));
    }

    // 테스트 코드는 순서에 의존성을 가지면 안되고 메소드별로 따로 보고 작성해야한다.
    // 하단의 코드는 이미 findByName()이나 findAll()에 spring1, 2가 저장되었기 때문에 오류가 뜬다.
    // 따라서 @AfterEach 메서드를 두고 테스트 코드가 다 따로 동작하도록 한다.

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
