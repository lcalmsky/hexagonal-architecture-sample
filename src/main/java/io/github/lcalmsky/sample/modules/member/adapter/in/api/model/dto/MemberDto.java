package io.github.lcalmsky.sample.modules.member.adapter.in.api.model.dto;

public class MemberDto {

  public static record CreateMemberDto(String name, String email) {

  }

  public static record ReadMemberDto(Long id, String name, String email) {

  }

  public static record UpdateMemberDto(Long id, String name, String email) {

  }
}
