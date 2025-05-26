package org.ourspring.member.repositories;

import org.ourspring.member.entities.Member;
import org.springframework.data.repository.ListCrudRepository;

public interface MemberRepository extends ListCrudRepository<Member, Long> {
}
