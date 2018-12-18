package com.example.springbootvipiapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Helloworld  {
    @GetMapping("/return")
    private String Hello(){
        return "vipisanan";
    }

    @PostMapping("/post")
    private String SomePost(){
        return "vipi post";
    }

}
