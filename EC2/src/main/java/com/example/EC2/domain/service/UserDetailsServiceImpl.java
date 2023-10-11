package com.cloudmaestro.domain.Service;

import com.antkorwin.commonutils.exceptions.BaseException;
import com.cloudmaestro.domain.entity.Member;
import com.cloudmaestro.domain.entity.principleDetails;
import com.cloudmaestro.domain.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MemberRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws BaseException {
        Member user = userRepository.findByUserId(id);
//                .orElseThrow(() -> {
//                    log.error(INVALID_USER_NUM.getMessage());
//                    return new BaseException(INVALID_USER_NUM);
//                });

        principleDetails userDetails = new principleDetails();
        userDetails.setUser(user);

        return userDetails;
    }
}