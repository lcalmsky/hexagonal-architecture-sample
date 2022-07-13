package io.github.lcalmsky.sample.modules.member.application.usecase;

import io.github.lcalmsky.sample.modules.member.domain.entity.Member;

public interface FindMemberUseCase {

  Member findById(Long id);
}
