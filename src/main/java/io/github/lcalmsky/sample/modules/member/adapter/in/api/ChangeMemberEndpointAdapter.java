package io.github.lcalmsky.sample.modules.member.adapter.in.api;

import io.github.lcalmsky.sample.infrastructure.annotation.Adapter;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.mapper.MemberMapper;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.ChangeMemberEndpointPort;
import io.github.lcalmsky.sample.modules.member.application.usecase.CreateMemberUsecase;
import io.github.lcalmsky.sample.modules.member.application.usecase.DeleteMemberUsecase;
import io.github.lcalmsky.sample.modules.member.application.usecase.UpdateMemberUsecase;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class ChangeMemberEndpointAdapter implements ChangeMemberEndpointPort {

  private final CreateMemberUsecase createMemberUsecase;
  private final UpdateMemberUsecase updateMemberUsecase;
  private final DeleteMemberUsecase deleteMemberUsecase;
  private final MemberMapper memberMapper;

  @Override
  public void create(CreateMemberDto createMemberDto) {
    createMemberUsecase.create(memberMapper.toEntity(createMemberDto));
  }

  @Override
  public void update(UpdateMemberDto updateMemberDto) {
    updateMemberUsecase.update(updateMemberDto);
  }

  @Override
  public void deleteById(Long id) {
    deleteMemberUsecase.deleteById(id);
  }
}
