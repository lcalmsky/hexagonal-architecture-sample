package io.github.lcalmsky.sample.modules.member.adapter.out.persistence;

import io.github.lcalmsky.sample.infrastructure.annotation.CommandPersistenceAdapter;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.MemberCommandPort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;

@CommandPersistenceAdapter
@RequiredArgsConstructor
class MemberCommandAdapter implements MemberCommandPort {

  private final MemberRepository memberRepository;

  @Override
  public void create(Member member) {
    memberRepository.save(member);
  }

  @Override
  public void update(Member member) {
    memberRepository.save(member);
  }

  @Override
  public void deleteById(Long id) {
    memberRepository.deleteById(id);
  }
}
