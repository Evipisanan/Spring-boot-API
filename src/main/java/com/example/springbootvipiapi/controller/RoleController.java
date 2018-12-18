package com.example.springbootvipiapi.controller;

import com.example.springbootvipiapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/")
    private void addRole(){

    }

}
