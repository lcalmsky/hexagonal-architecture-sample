package io.github.lcalmsky.sample.modules.member.application.service;

import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.FindMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.application.usecase.FindAllMembersUseCase;
import io.github.lcalmsky.sample.modules.member.application.usecase.FindMemberUseCase;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FindMemberService implements FindAllMembersUseCase, FindMemberUseCase {

  private final FindMemberPersistencePort findMemberPersistencePort;

  @Override
  public List<Member> findAll() {
    return findMemberPersistencePort.findAll();
  }

  @Override
  public Member findById(Long id) {
    return findMemberPersistencePort.findById(id);
  }
}
