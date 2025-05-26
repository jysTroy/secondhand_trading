package org.ourspring.member.entities;

import lombok.Data;
import org.ourspring.global.entities.BaseEntity;
import org.ourspring.member.constants.Authority;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("MEMBER")
public class Member extends BaseEntity {
    @Id
    private Long seq;
    private String email;
    private String password;
    private String name;
    private String mobile;
    private Authority authority = Authority.MEMBER;

    @Column("termsAgree")
    private boolean termsAgree;
}
