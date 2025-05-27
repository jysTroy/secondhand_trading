package org.ourspring.member.repositories;

import org.ourspring.member.entities.Member;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface MemberRepository extends ListCrudRepository<Member, Long> {
    boolean existsByEmail(String email);
    Optional<Member> findByEmail(String email);
}
