package com.cloudmaestro.domain.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class principleDetails implements UserDetails {

    private Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // UserRole을 GrantedAuthority로 변환하여 반환
        return List.of(() -> member.getRole().name());
    }
    public void setUser(Member member) {
        this.member=member;
    }

    public String getUserID() {
        return member.getUserId();
    }

    public Member.UserRole getRole() {
        return member.getRole();
    }

    @Override
    public String getPassword() {
        return member.getUserPw();
    }

    @Override
    public String getUsername() {
        return member.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정이 만료되지 않았음을 나타냅니다. 필요한 경우 로직 추가
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정이 잠기지 않았음을 나타냅니다. 필요한 경우 로직 추가
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 자격이 만료되지 않았음을 나타냅니다. 필요한 경우 로직 추가
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정이 활성화되었음을 나타냅니다. 필요한 경우 로직 추가
    }

}
