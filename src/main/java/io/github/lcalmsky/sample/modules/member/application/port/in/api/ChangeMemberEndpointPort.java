package io.github.lcalmsky.sample.modules.member.application.port.in.api;

import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.UpdateMemberDto;

public interface ChangeMemberEndpointPort {

  void create(CreateMemberDto createMemberDto);

  void update(UpdateMemberDto updateMemberDto);

  void deleteById(Long id);
}
