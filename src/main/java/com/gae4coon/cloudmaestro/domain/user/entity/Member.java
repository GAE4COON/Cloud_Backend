package com.gae4coon.cloudmaestro.domain.user.entity;

import com.gae4coon.cloudmaestro.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;



//@AllArgsConstructor 에러를 Builder와 NOArgs를 사용하기 위해 일단은 사용 X
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "user_id", nullable = false, length = 50, unique = true)
    private String userId;

    @Column(name = "user_pw", nullable = false, length = 256)
    private String userPw;

    @Column(name = "user_name", nullable = false, length = 15)
    private String userName;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "varchar(255) default 'member'")
    private UserRole role;
    public enum UserRole {
        admin, business, member
    }

    @Builder
    public Member(String userId, String userPw, String userName, String email, String belong, String phoneNumber, UserRole role) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

}