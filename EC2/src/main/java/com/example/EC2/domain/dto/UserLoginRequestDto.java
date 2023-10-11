package com.cloudmaestro.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDto {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+[@a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String user_id;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$")
    private String user_pw;
}