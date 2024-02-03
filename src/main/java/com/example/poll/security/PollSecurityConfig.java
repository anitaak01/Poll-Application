package com.example.poll.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PollSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails user1 = User.builder()
                .username("user1")
                .password("{bcrypt}$2a$12$T.MAdKqAQcy6YT5N/R9OwunlbJrqtAj0aA2DZ7wJ6.rCin3o76PyG")
                .roles("RESPONDER")
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password("{bcrypt}$2a$12$aT9UrsCy7NGUhDlMF2Xfu.pu8.nvc7OAsyMoa7D1DuR/nZSyWr8rK")
                .roles("VIEWER")
                .build();
        UserDetails user3 = User.builder()
                .username("user3")
                .password("{bcrypt}$2a$12$/3RGHqs68TLyJ79nLKQdeujKQTqWzQeIDfnZJVfXnSckc4amJa70y")
                .roles("VIEWER", "RESPONDER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
 @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/poll/list").hasRole("VIEWER")
                        .requestMatchers(HttpMethod.GET, "/poll/list/**").hasRole("VIEWER")
                        .requestMatchers(HttpMethod.GET, "/poll/showFormForAdd").hasRole("RESPONDER")
                        .requestMatchers(HttpMethod.POST, "/poll/save").hasRole("RESPONDER")
                        .requestMatchers(HttpMethod.GET, "/poll/showFormForUpdate").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/poll/**").hasRole("ADMIN"));

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
