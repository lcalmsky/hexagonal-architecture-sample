package io.github.lcalmsky.sample.modules.member.adapter.out.persistence;

import io.github.lcalmsky.sample.infrastructure.annotation.Adapter;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.FindMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class FindMemberPersistenceAdapter implements FindMemberPersistencePort {

  private MemberRepository memberRepository;

  @Override
  public List<Member> findAll() {
    return memberRepository.findAll();
  }

  @Override
  public Member findById(Long id) {
    return memberRepository.findById(id)
        .orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public Member findByName(String name) {
    return memberRepository.findByName(name)
        .orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public Member findByEmail(String email) {
    return memberRepository.findByEmail(email)
        .orElseThrow(IllegalArgumentException::new);
  }
}
