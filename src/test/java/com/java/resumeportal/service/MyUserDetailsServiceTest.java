package com.java.resumeportal.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class MyUserDetailsServiceTest {

    @InjectMocks
    private MyUserDetailsService myUserDetailsService;

//    @BeforeAll
    public void setUp(){
        myUserDetailsService = new MyUserDetailsService();
    }

    @Test
    void loadUserByUsername() {
    }

}