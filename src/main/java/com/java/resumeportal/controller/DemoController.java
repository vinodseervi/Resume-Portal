package com.java.resumeportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world, this is vinod!!";
    }

    @GetMapping("/edit")
    public String edit(){
        return "edit page";
    }

}
