package hello.hellospring.domain;

import javax.persistence.*;

@Entity // 자바JPA가 관리한다를 나타냄
public class Member {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) // Id는 자동적으로 생성->identity 전략
    private Long id;

//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
