package com.cloudmaestro.domain.controller;

import com.cloudmaestro.domain.Service.EmailService;
import com.cloudmaestro.domain.Service.MemberService;
import com.cloudmaestro.domain.Service.UserDetailsServiceImpl;
import com.cloudmaestro.domain.dto.*;
import com.cloudmaestro.domain.entity.Member;
import com.cloudmaestro.global.config.JwtTokenProvider;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping("/api/v1/users-api")
public class MemberController {
    private final MemberService memberService;
    private final EmailService emailService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsService;
    @Autowired
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world!";
    }

    @GetMapping("/hmm")
    public List<Member> member() {
        List<Member> memberEntityList = this.memberService.getList();
        return memberEntityList;
    }

    @PostMapping("/id-dup-check")
    public ResponseEntity<HashMap<String, Object>> idCheck(@RequestBody UserIdDupDto dto) {
        try {
            HashMap<String, Object> result = memberService.idOverlap(dto.getUserId());
            return ResponseEntity.ok().body(result);
        } catch (RuntimeException e) {
            HashMap<String, Object> errorResult = new HashMap<>();
            errorResult.put("message", "fail");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResult);
        }
    }

    @PostMapping("/mailConfirm")
    public ResponseEntity<HashMap<String, Object>> mailConfirm(@RequestBody EmailAuthRequestDto emailDto) throws MessagingException, UnsupportedEncodingException {
        memberService.emailOverlap(emailDto.getEmail());
        String authCode = emailService.sendAuthMail(emailDto.getEmail());
        HashMap<String, Object> codeResult = new HashMap<>();
        codeResult.put("result", true);
        return ResponseEntity.ok().body(codeResult);
    }

    @PostMapping("/authCode")
    public ResponseEntity<HashMap<String, Object>> sendEmailAndCode(@RequestBody EmailCodeDto dto) throws NoSuchAlgorithmException {
        if (emailService.verifyEmailCode(dto.getEmail(), dto.getCode())) {
            HashMap<String, Object> codeResult = new HashMap<>();
            codeResult.put("result", true);
            return ResponseEntity.ok().body(codeResult);
        }
        else {
            HashMap<String, Object> errorResult = new HashMap<>();
            errorResult.put("result", false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<HashMap<String, String>> signUpProcess(@RequestBody @Valid UserJoinRequestDto dto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        try {
        this.memberService.join(dto);
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "success");
        return ResponseEntity.ok().body(map);

        } catch (RuntimeException e) {
            HashMap<String, String> map = new HashMap<>();
            map.put("result", "fail");
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.ok().body(map);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<MemberLoginResponseDto> signInProcess(@RequestBody @Valid UserLoginRequestDto dto, @org.jetbrains.annotations.NotNull BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Member user1 =memberService.findById(dto.getUser_id());

        if(!passwordEncoder.matches(dto.getUser_pw(), user1.getUserPw())){
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUser_id());
        Authentication newAuth = new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuth);

        // JwtToken 생성
        String  jwt = jwtTokenProvider.createAccessToken(newAuth);
        String  refresh = jwtTokenProvider.createRefreshToken(newAuth);

        MemberLoginResponseDto loginResponse = MemberLoginResponseDto.builder()
                .accessToken(jwt)
                .refreshToken(refresh)
                //.userName(user1.getUserName())  // 추가
                //.userId(user1.getUserId())      // 추가
                //.role(user1.getRole())  // 추가
                .build();

        return ResponseEntity.ok().body(loginResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


}
