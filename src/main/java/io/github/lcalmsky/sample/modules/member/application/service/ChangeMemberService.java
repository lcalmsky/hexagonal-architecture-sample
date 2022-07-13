package io.github.lcalmsky.sample.modules.member.application.service;

import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.ChangeMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.FindMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.application.usecase.CreateMemberUsecase;
import io.github.lcalmsky.sample.modules.member.application.usecase.DeleteMemberUsecase;
import io.github.lcalmsky.sample.modules.member.application.usecase.UpdateMemberUsecase;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeMemberService implements CreateMemberUsecase, UpdateMemberUsecase,
    DeleteMemberUsecase {

  private final ChangeMemberPersistencePort changeMemberPersistencePort;
  private final FindMemberPersistencePort findMemberPersistencePort;

  @Override
  public void create(Member member) {
    changeMemberPersistencePort.create(member);
  }

  @Override
  public void update(UpdateMemberDto updateMemberDto) {
    Member member = findMemberPersistencePort.findById(updateMemberDto.id());
    member.rename(updateMemberDto.name());
    member.modifyEmail(updateMemberDto.email());
    changeMemberPersistencePort.update(member);
  }

  @Override
  public void deleteById(Long id) {
    changeMemberPersistencePort.deleteById(id);
  }
}
