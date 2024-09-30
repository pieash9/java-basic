package com.pieash9.SpringBoot.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public  String HelloWorld(){
        return  "Hello world test khan sab";
    }
}
