package com.koscom.hackathon1.configuration;

import com.koscom.hackathon1.utility.CustomAuthenticationFailureHandler;
import com.koscom.hackathon1.utility.CustomAuthenticationProvider;
import com.koscom.hackathon1.utility.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
                        authorizeHttpRequests.requestMatchers("/user/*").permitAll()
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