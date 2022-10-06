package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save (Member member);
    Optional<Member> findById(Long id); // null이 반환될 수 있는걸 Optional로 감싸서 반환해주는역할
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
