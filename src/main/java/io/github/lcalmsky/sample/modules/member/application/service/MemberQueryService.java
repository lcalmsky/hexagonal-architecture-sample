package io.github.lcalmsky.sample.modules.member.application.service;

import io.github.lcalmsky.sample.modules.member.application.port.in.api.MemberQueryUseCase;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.MemberQueryPort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class MemberQueryService implements MemberQueryUseCase {

  private final MemberQueryPort memberQueryPort;

  @Override
  public List<Member> findAll() {
    return memberQueryPort.findAll();
  }

  @Override
  public Member findById(Long id) {
    return memberQueryPort.findById(id)
        .orElseThrow(IllegalAccessError::new);
  }
}
