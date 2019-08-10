package com.ming.service;

import com.ming.bean.Hr;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
    public UserDetails loadUserByUsername(String s) throws Exception;
}
