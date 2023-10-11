package com.cloudmaestro.domain.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/test-api")
public class TestController {

    @GetMapping("/login-test")
    public String helloWorld(HttpServletRequest req) {
        System.out.println("--------------------------------------------------------------------");

        String token = req.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            System.out.println("Extracted JWT token: " + token);

            // 여기에서 토큰 검증 로직을 추가할 수 있습니다.
        } else {
            System.out.println("JWT token not found in request header.");
        }

        System.out.println("--------------------------------------------------------------------");
        return "Token processed"; // 변경된 응답 메시지
    }
}
