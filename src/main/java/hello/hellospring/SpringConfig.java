package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration // Controller는 이미 Spring이 관리하기 때문에 따로 설정하지 않아도 된다.
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired // 생성자가 하나인 경우 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // JPA
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    // Jdbc
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//     //    return new MemoryMemberRepository();
//     //   return new JdbcMemberRepository(dataSource);
//     //   return new JdbcTemplateMemberRepository(dataSource);
//     //   return new JpaMemberRepository(em);
//    }
}
