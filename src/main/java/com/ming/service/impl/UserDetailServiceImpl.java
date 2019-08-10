package com.ming.service.impl;

import com.ming.bean.Hr;
import com.ming.mapper.HrMapper;
import com.ming.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws Exception {
        Hr hr =  hrMapper.loadUserByUsername(s);
        if(hr == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
