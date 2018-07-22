package com.liuchang.backend.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class MyUserDetailService implements UserDetailsService{
    private Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);


    /**
     * 解决java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
     * In spring-security-core:5.0.0.RC1, the default PasswordEncoder is built as a DelegatingPasswordEncoder. When you store the users in memory, you are providing the passwords in plain text and when trying to retrieve the encoder from the DelegatingPasswordEncoder to validate the password it can't find one that matches the way in which these passwords were stored.
     * @return
     */
    @Autowired
    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("+++++++MyLogInfo++++++:"+username);
        return new User(username,passwordEncoder().encode("11"), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
