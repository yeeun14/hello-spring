package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { // 인터페이스가 인터페이스를 받을 때는 extends를 사용
    // 스프링 빈을 자동적으로 만듬 -> 프록시라는 기술로 객체를 생성해 스프링 빈에 올림

    @Override
    Optional<Member> findByName(String name);
}
