package com.pawelkorniak.facade;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index","/comnat/**","/sendMessage/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/index", true)
                .and().csrf().disable();
    }
}
