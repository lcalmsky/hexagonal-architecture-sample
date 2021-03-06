package io.github.lcalmsky.sample.modules.member.adapter.out.persistence;

import io.github.lcalmsky.sample.infrastructure.annotation.QueryPersistenceAdapter;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.MemberQueryPort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@QueryPersistenceAdapter
@RequiredArgsConstructor
class MemberQueryAdapter implements MemberQueryPort {

  private final MemberRepository memberRepository;

  @Override
  public List<Member> findAll() {
    return memberRepository.findAll();
  }

  @Override
  public Optional<Member> findById(Long id) {
    return memberRepository.findById(id);
  }
}
