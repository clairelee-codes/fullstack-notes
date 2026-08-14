package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 메서드 이름 파싱해서 자동으로 JPQL쿼리 만들어줌
    @Override
    Optional<Member> findByName(String name);

}
