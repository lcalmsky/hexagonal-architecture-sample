package io.github.lcalmsky.sample.modules.member.application.port.in.api;

import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;

public interface MemberQueryUseCase {

  List<Member> findAll();

  Member findById(Long id);
}
