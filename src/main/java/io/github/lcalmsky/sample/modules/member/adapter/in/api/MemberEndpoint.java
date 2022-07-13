package io.github.lcalmsky.sample.modules.member.adapter.in.api;

import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.CreateMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.ReadMemberDto;
import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.UpdateMemberDto;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.ChangeMemberEndpointPort;
import io.github.lcalmsky.sample.modules.member.application.port.in.api.FindMemberEndpointPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberEndpoint {

  private final FindMemberEndpointPort findMemberEndpointPort;
  private final ChangeMemberEndpointPort changeMemberEndpointPort;

  @GetMapping("/members")
  public List<ReadMemberDto> members() {
    return findMemberEndpointPort.findAll();
  }

  @GetMapping("/members/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ReadMemberDto memberById(@PathVariable("id") Long id) {
    return findMemberEndpointPort.findById(id);
  }

  @PostMapping("/member")
  @ResponseStatus(HttpStatus.OK)
  public void createMember(CreateMemberDto createMemberDto) {
    changeMemberEndpointPort.create(createMemberDto);
  }

  @PutMapping("/member")
  @ResponseStatus(HttpStatus.OK)
  public void updateMember(UpdateMemberDto updateMemberDto) {
    changeMemberEndpointPort.update(updateMemberDto);
  }

  @DeleteMapping("/member/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteMember(@PathVariable("id") Long id) {
    changeMemberEndpointPort.deleteById(id);
  }
}
