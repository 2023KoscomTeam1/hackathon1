package com.koscom.hackathon1.configuration;

import com.koscom.hackathon1.login.CustomAuthenticationFailureHandler;
import com.koscom.hackathon1.login.CustomAuthenticationProvider;
import com.koscom.hackathon1.login.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests.requestMatchers("/user/*").hasRole("USER")
                                .anyRequest().permitAll())
                .formLogin((formLogin) ->
                        formLogin.loginProcessingUrl("/api/login")
                                .usernameParameter("loginId")
                                .passwordParameter("password")
                                .successHandler(customAuthenticationSuccessHandler)
                                .failureHandler(customAuthenticationFailureHandler))
                .sessionManagement((sessionManagement) ->
                        sessionManagement.maximumSessions(1)
                                .maxSessionsPreventsLogin(true))
                .authenticationProvider(customAuthenticationProvider)
                .build();
    }
}