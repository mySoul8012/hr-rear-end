package com.ming.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationAccessDeniedHandlerTest {

    @Test
    public void test(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String res = encoder.encode("ming");
        System.out.println(res);
        System.out.println("$2a$10$gZA7hlt1IZqIdyvyVpmCSu252O8HZ6HTA0DGtv.3YAgnVwaDuHZv.");
    }
}