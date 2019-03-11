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
    public UserModel save(UserModel userModel){
        userRepository.save(userModel);
        return userModel;
    }
    public List<UserModel> deleteAll(){
        List<UserModel> userModel;
        userModel = userRepository.findAll();
        userRepository.deleteAll();
        return userModel;
    }
    public UserModel deleteById(int id){
        UserModel userModel;
        userModel = userRepository.findFirstById(id);
        userRepository.deleteById(id);
        return userModel;
    }
    public UserModel findFirstById(int id){
        return userRepository.findFirstById(id);
    }
}
