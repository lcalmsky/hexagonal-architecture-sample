package io.github.lcalmsky.sample.modules.member.application.usecase;

import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.UpdateMemberDto;

public interface UpdateMemberUsecase {

  void update(UpdateMemberDto updateMemberDto);
}
