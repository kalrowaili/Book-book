package com.example.Book.Microservice.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/book/**").permitAll()
                .and()

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/info/**").authenticated()
                .and()

                .authorizeRequests()
                .antMatchers("/actuator/health/**").authenticated()
                .and()

                .authorizeRequests()
                .antMatchers("/actuator/beans/**").authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/actuator/caches/**").authenticated()
                .and()

                .httpBasic();
        return http.build();
    }
}

