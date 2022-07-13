package io.github.lcalmsky.sample.modules.member.application.port.in.api;

import io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto.MemberDto.ReadMemberDto;
import java.util.List;

public interface FindMemberEndpointPort {

  List<ReadMemberDto> findAll();

  ReadMemberDto findById(Long id);

}
