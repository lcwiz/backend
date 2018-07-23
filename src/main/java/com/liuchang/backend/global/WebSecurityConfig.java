package com.liuchang.backend.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/static/welcome.html")
                .and()
                .authorizeRequests()
                .antMatchers("/static/welcome.html").permitAll()
                .anyRequest()
                .authenticated();
    }
}
