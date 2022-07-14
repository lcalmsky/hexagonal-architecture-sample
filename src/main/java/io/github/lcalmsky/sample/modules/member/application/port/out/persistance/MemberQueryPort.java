package io.github.lcalmsky.sample.modules.member.application.port.out.persistance;


import io.github.lcalmsky.sample.modules.member.domain.entity.Member;
import java.util.List;

public interface MemberQueryPort {

  List<Member> findAll();

  Member findById(Long id);

}
