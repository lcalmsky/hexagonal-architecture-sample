package io.github.lcalmsky.sample.modules.member.application.port.in.api;

import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.UpdateMemberDto;

public interface MemberCommandUsecase {

  void create(CreateMemberDto toEntity);

  void update(UpdateMemberDto updateMemberDto);

  void deleteById(Long id);
}
