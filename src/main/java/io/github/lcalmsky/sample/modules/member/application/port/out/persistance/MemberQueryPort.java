package io.github.lcalmsky.sample.modules.member.application.port.out.persistance;


import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberQueryPort {

  List<Member> findAll();

  Optional<Member> findById(Long id);

}
