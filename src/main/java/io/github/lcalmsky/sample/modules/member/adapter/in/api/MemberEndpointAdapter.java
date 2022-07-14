package io.github.lcalmsky.sample.modules.member.adapter.in.api;

import io.github.lcalmsky.sample.infrastructure.annotation.ApiAdapter;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.MemberCommandUsecase;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.MemberQueryUseCase;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.ReadMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.model.mapper.MemberMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ApiAdapter
@RequiredArgsConstructor
public class MemberEndpointAdapter {

  private final MemberQueryUseCase memberQueryUseCase;
  private final MemberCommandUsecase memberCommandUsecase;
  private final MemberMapper memberMapper;

  @GetMapping("/members")
  public List<ReadMemberDto> members() {
    return memberQueryUseCase.findAll()
        .stream()
        .map(memberMapper::toReadMemberDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/members/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ReadMemberDto memberById(@PathVariable("id") Long id) {
    return memberMapper.toReadMemberDto(memberQueryUseCase.findById(id));
  }

  @PostMapping("/member")
  @ResponseStatus(HttpStatus.OK)
  public void createMember(CreateMemberDto createMemberDto) {
    memberCommandUsecase.create(createMemberDto);
  }

  @PutMapping("/member")
  @ResponseStatus(HttpStatus.OK)
  public void updateMember(UpdateMemberDto updateMemberDto) {
    memberCommandUsecase.update(updateMemberDto);
  }

  @DeleteMapping("/member/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteMember(@PathVariable("id") Long id) {
    memberCommandUsecase.deleteById(id);
  }

}
