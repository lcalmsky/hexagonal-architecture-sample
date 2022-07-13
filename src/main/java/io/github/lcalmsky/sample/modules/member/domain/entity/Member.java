package io.github.lcalmsky.sample.modules.member.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String email;

  private Member(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public static Member withNameAndEmail(String name, String email) {
    return new Member(name, email);
  }

  public void rename(String name) {
    this.name = name;
  }

  public void modifyEmail(String email) {
    this.email = email;
  }
}
