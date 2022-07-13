package io.github.lcalmsky.sample.modules.member.application.port.out.persistance;


import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;

public interface FindMemberPersistencePort {

  List<Member> findAll();

  Member findById(Long id);

  Member findByName(String name);

  Member findByEmail(String email);
}
