package com.example.springbootvipiapi.controller;

import com.example.springbootvipiapi.model.UserModel;
import com.example.springbootvipiapi.payload.ApiResponse;
import com.example.springbootvipiapi.repository.UserRepository;
import com.example.springbootvipiapi.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

//    @Autowired
//    UserRepository userRepository;
    @Autowired
    UserService userService;

    @PostMapping("/")
    private ResponseEntity<?> addUser(@RequestBody UserModel user) {
        userService.save(user);
        return new ResponseEntity<>(new ApiResponse(user), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    private ApiResponse<?> getAll() {
//        return userRepository.findAll();
//        return new ApiResponse<>( true , "these are the users........" ,userService.getAll());
        return new ApiResponse<>(userService.getAll());
    }


    @DeleteMapping("/")
    private ApiResponse deleteAll() {
//        userRepository.deleteAll();
        return new ApiResponse(userService.deleteAll());
    }

    @DeleteMapping("/{id}")
    private ApiResponse deletebyid(@PathVariable int id) {
//        userRepository.deleteById(id);
        return new ApiResponse(userService.deleteById(id));
    }

    //update
    @PutMapping("/{id}")
    private ApiResponse update(@PathVariable int id, @RequestBody UserModel updateduser) {
//        UserModel user = new UserModel();
//        user = userRepository.findFirstById(id); //if we don't use this insert as a new set of user data
//
//        user.setName(updateduser.getName());
//        user.setAddress(updateduser.getName());
//        user.setPno(updateduser.getPno());
//        userRepository.save(user);
        UserModel userModel = new UserModel();
        userModel= userService.findFirstById(id);

        userModel.setName(updateduser.getName());
        userModel.setAddress(updateduser.getAddress());

//        BeanUtils.copyProperties(userModel ,updateduser);
        return new ApiResponse(userService.save(userModel));
    }

}
