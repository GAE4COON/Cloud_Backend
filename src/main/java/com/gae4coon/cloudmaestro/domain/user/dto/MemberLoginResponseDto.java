package com.gae4coon.cloudmaestro.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberLoginResponseDto {
    private String accessToken;
    private String refreshToken;
    //private String userId;
    //private String userName;
    //private Member.UserRole role;

}