package io.github.lcalmsky.sample.modules.member.adapter.in.api;

import io.github.lcalmsky.sample.infrastructure.annotation.Adapter;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.ReadMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.mapper.MemberMapper;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.FindMemberEndpointPort;
import io.github.lcalmsky.sample.modules.member.application.usecase.FindAllMembersUseCase;
import io.github.lcalmsky.sample.modules.member.application.usecase.FindMemberUseCase;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class FindMemberEndpointAdapter implements FindMemberEndpointPort {

  private FindAllMembersUseCase findAllMembersUseCase;
  private FindMemberUseCase findMemberUseCase;
  private MemberMapper memberMapper;

  @Override
  public List<ReadMemberDto> findAll() {
    return findAllMembersUseCase.findAll()
        .stream()
        .map(memberMapper::toReadMemberDto)
        .collect(Collectors.toList());
  }

  @Override
  public ReadMemberDto findById(Long id) {
    return memberMapper.toReadMemberDto(findMemberUseCase.findById(id));
  }
}
