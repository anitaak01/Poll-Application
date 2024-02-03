package com.example.poll.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class PollSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails user1 = User.builder()
                .username("user1")
                .password("{noop}user1")
                .roles("RESPONDER")
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password("{noop}user2")
                .roles("VIEWER")
                .build();
        UserDetails user3 = User.builder()
                .username("user3")
                .password("{noop}user3")
                .roles("VIEWER", "RESPONDER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
