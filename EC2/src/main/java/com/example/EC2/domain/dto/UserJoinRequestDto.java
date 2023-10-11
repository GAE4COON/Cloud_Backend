package com.cloudmaestro.domain.dto;

import com.cloudmaestro.domain.entity.Member;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinRequestDto {
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]{6,20}$")
    private String user_id;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z0-9])(?=.*\\\\d)(?=.*[!@#$%^&*()\\\\-_+=])[A-Za-z0-9!@#$%^&*()\\\\-_+=]{8,20}$")
    private String user_pw;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z0-9])(?=.*\\\\d)(?=.*[!@#$%^&*()\\\\-_+=])[A-Za-z0-9!@#$%^&*()\\\\-_+=]{8,20}$")
    private String user_check_pw;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z가-힣\\\\s]{2,15}",
            message = "이름은 영문자, 한글, 공백포함 2글자부터 15글자까지 가능합니다.")
    private String user_name;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z가-힣\\\\s]{2,15}",
            message = "소속은 영문자, 한글, 공백포함 2글자부터 15글자까지 가능합니다.")
    private String belong;
    @NotEmpty
    @Pattern(regexp = "^[0-9]{3,15}",
            message = "전화번호는 3글자부터 15글자까지 가능합니다.")
    private String phone_number;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,10}$")
    private String email;
    @NotEmpty
    private Boolean emailCheck;


}
