package com.cloudmaestro.domain.Service;

import com.cloudmaestro.domain.dto.UserJoinRequestDto;
import com.cloudmaestro.domain.entity.Member;
import com.cloudmaestro.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;
    public List<Member> getList(){
        return this.memberRepository.findAll();
    }

    public HashMap<String, Object> idOverlap(String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", memberRepository.existsById(userId));
        return map;
    }

    public HashMap<String, Object> emailOverlap(String email) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", memberRepository.existsByEmail(email));
        return map;
    }

    @Transactional(readOnly = true)
    public Member findById(String userId){
        return memberRepository.findByUserId(userId);
    }


    public String join(UserJoinRequestDto dto){
        Member existingUser = this.memberRepository.findByUserId(dto.getUser_id());
        if(existingUser != null) {
            throw new RuntimeException(dto.getUser_id() + " 는 이미 있습니다.");
        }

        if(!dto.getUser_pw().equals(dto.getUser_check_pw())){
            throw new RuntimeException(dto.getUser_pw()+"가 다릅니다.");
        }

        if(!dto.getEmailCheck()){
            throw new RuntimeException("이메일 인증이 필요합니다.");
        }


        var encodedUserPw = passwordEncoder.encode(dto.getUser_pw());

        Member member = Member.builder()
            .userId(dto.getUser_id())
            .userPw(encodedUserPw)
            .userName(dto.getUser_name())
            .belong(dto.getBelong())
            .phoneNumber(dto.getPhone_number())
            .email(dto.getEmail())
            .role(Member.UserRole.member)
            .build();

        this.memberRepository.save(member);
        return "success";
    }

}
