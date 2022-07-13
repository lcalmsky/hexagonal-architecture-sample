package io.github.lcalmsky.sample.modules.member.application.port.out.persistance;

import io.github.lcalmsky.sample.modules.member.domain.entity.Member;

public interface ChangeMemberPersistencePort {

  void create(Member member);

  void update(Member member);

  void deleteById(Long id);
}
