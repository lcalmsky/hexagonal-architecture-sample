package io.github.lcalmsky.sample.modules.member.adapter.out.persistence;

import io.github.lcalmsky.sample.infrastructure.annotation.CommandPersistenceAdapter;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.ChangeMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;

@CommandPersistenceAdapter
@RequiredArgsConstructor
public class MemberCommandAdapter implements ChangeMemberPersistencePort {

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
