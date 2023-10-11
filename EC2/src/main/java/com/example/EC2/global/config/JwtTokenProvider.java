package com.cloudmaestro.global.config;

import com.antkorwin.commonutils.exceptions.BaseException;
import com.cloudmaestro.domain.Service.UserDetailsServiceImpl;
import com.cloudmaestro.domain.entity.principleDetails;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Log4j2
public class JwtTokenProvider {

    private final RedisTemplate<String, String> redisTemplate;
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${spring.jwt.secretKey}")
    private String secretKey;

    @Value("${spring.jwt.token.access-expiration-time}")
    private long accessExpirationTime;

    @Value("${spring.jwt.token.refresh-expiration-time}")
    private long refreshExpirationTime;

    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Access 토큰 생성
     */
    public String createAccessToken(Authentication authentication){
        Claims claims = Jwts.claims().setSubject(authentication.getName());
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + accessExpirationTime);
        if (authentication.getPrincipal() instanceof UserDetails) {
            principleDetails details = (principleDetails) authentication.getPrincipal();
            // 예를 들어, email과 roles 정보를 추가한다고 가정
            claims.put("id", details.getUserID());  // 이메일 정보 추가 (여기서는 username이 이메일로 가정)
            claims.put("role", details.getRole());
        }
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * Refresh 토큰 생성
     */
    public String createRefreshToken(Authentication authentication){
        Claims claims = Jwts.claims().setSubject(authentication.getName());
        if (authentication.getPrincipal() instanceof UserDetails) {
            principleDetails details = (principleDetails) authentication.getPrincipal();
            // 예를 들어, email과 roles 정보를 추가한다고 가정
            claims.put("id", details.getUserID());  // 이메일 정보 추가 (여기서는 username이 이메일로 가정)
            claims.put("role", details.getRole());
        }
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + refreshExpirationTime);

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        // redis에 저장
        redisTemplate.opsForValue().set(
                authentication.getName(),
                refreshToken,
                refreshExpirationTime,
                TimeUnit.MILLISECONDS
        );

        return refreshToken;
    }

    /**
     * 토큰으로부터 클레임을 만들고, 이를 통해 User 객체 생성해 Authentication 객체 반환
     */
    public Authentication getAuthentication(String token) {
        String userPrincipal = Jwts.parser().
                setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();
        UserDetails userDetails = userDetailsService.loadUserByUsername(userPrincipal);

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    /**
     * http 헤더로부터 bearer 토큰을 가져옴.
     */
    public String resolveToken(@NotNull HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    /**
     * Access 토큰을 검증
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired", e);
            throw new RuntimeException("JWT token is expired", e);
        } catch (JwtException e) {
            logger.error("Invalid JWT token", e);
            throw new RuntimeException("Invalid JWT token", e);
        }
    }
}