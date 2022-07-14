package io.github.lcalmsky.sample.modules.member.application.service;

import io.github.lcalmsky.sample.modules.member.application.port.in.api.MemberCommandUsecase;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.mapper.MemberMapper;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.MemberCommandPort;
import io.github.lcalmsky.sample.modules.member.application.port.out.persistance.MemberQueryPort;
import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCommandService implements MemberCommandUsecase {

  private final MemberCommandPort memberCommandPort;
  private final MemberQueryPort memberQueryPort;
  private final MemberMapper memberMapper;

  @Override
  public void create(CreateMemberDto member) {
    memberCommandPort.create(memberMapper.toEntity(member));
  }

  @Override
  public void update(UpdateMemberDto updateMemberDto) {
    Member member = memberQueryPort.findById(updateMemberDto.id());
    member.rename(updateMemberDto.name());
    member.modifyEmail(updateMemberDto.email());
    memberCommandPort.update(member);
  }

  @Override
  public void deleteById(Long id) {
    memberCommandPort.deleteById(id);
  }
}
