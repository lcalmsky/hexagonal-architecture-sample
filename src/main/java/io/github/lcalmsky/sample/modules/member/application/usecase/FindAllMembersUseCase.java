package io.github.lcalmsky.sample.modules.member.application.usecase;

import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;

public interface FindAllMembersUseCase {

  List<Member> findAll();
}
