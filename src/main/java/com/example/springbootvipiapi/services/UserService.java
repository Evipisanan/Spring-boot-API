package com.example.springbootvipiapi.services;

import com.example.springbootvipiapi.model.UserModel;
import com.example.springbootvipiapi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;

    public List<UserModel> getAll(){
        LOGGER.info("it is getAll method in UserService");
        return userRepository.findAll();
    }
}
