package io.github.lcalmsky.sample.modules.member.adapter.in.api.model.mapper;

import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.ReadMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;

public class MemberMapper {

  public ReadMemberDto toReadMemberDto(Member member) {
    return new ReadMemberDto(member.getId(), member.getName(), member.getEmail());
  }

  public Member toEntity(CreateMemberDto createMemberDto) {
    return Member.withNameAndEmail(createMemberDto.name(), createMemberDto.email());
  }
}
