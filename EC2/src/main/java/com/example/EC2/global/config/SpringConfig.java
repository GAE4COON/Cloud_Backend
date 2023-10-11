package com.cloudmaestro.global.config;

import com.cloudmaestro.global.config.exception.JwtAccessDeniedHandler;
import com.cloudmaestro.global.config.exception.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringConfig {

    private final JwtTokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private static final String[] WHITE_LIST = {
            "/api/v1/users-api/**",
            "/api/v1/test-api/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/favicon.ico");
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .formLogin(form->form.disable())
                //.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/api/v1/test-api/**").access("hasRole('business')")
                        .requestMatchers(WHITE_LIST).permitAll()
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()) // 그외 인증없이 접근X
                .sessionManagement(session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS))
                // .exceptionHandling(e -> e //권한 없으면 해당 error 뜨게끔
                //          .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //          .accessDeniedHandler(jwtAccessDeniedHandler))
                .apply(new JWTConfig(tokenProvider));

        return http.build();
    }

}
