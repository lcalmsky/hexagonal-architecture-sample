package io.github.lcalmsky.sample.modules.member.application.service;

import io.github.lcalmsky.sample.modules.member.application.port.in.api.MemberCommandUsecase;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.mapper.MemberMapper;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.ChangeMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.FindMemberPersistencePort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandService implements MemberCommandUsecase, UpdateMemberUsecase,
    DeleteMemberUsecase {

  private final ChangeMemberPersistencePort changeMemberPersistencePort;
  private final FindMemberPersistencePort findMemberPersistencePort;
  private final MemberMapper memberMapper;

  @Override
  public void create(CreateMemberDto member) {
    changeMemberPersistencePort.create(memberMapper.toEntity(member));
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
