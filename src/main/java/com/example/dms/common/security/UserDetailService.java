package com.example.dms.common.security;

import jodd.util.BCrypt;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Base64;

/**
 * @author zhouy
 * @date 2023/1/5
 * good 01
 */
public class UserDetailService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    public UserDetailService(){
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByDb(username);
        User.builder().roles("1", "1").password(user.getPassword());
        BCrypt.gensalt();
        return null;
    }

    public User getUserByDb(String userName){
        return new User(null, null, null);
    }


}
