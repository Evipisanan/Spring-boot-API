package com.example.springbootvipiapi.controller;

import com.example.springbootvipiapi.model.UserModel;
import com.example.springbootvipiapi.payload.ApiResponse;
import com.example.springbootvipiapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   UserRepository userRepository;

    @PostMapping("/")
    private ResponseEntity<?> addUser(@RequestBody UserModel  user){
        userRepository.save(user);
        return new ResponseEntity<>(new ApiResponse(true , "saved"), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    private List<UserModel> getAll(){
        return userRepository.findAll();
    }

    @DeleteMapping("/")
    private void deleteAll(){
        userRepository.deleteAll();
    }
    @DeleteMapping("/{id}")
    private void deletebyid(@PathVariable int id){
        userRepository.deleteById(id);
    }

//update
    @PutMapping("/{id}")
    private void update(@PathVariable int id, @RequestBody UserModel updateduser){
        UserModel user = new UserModel();
        user = userRepository.findFirstById(id); //if we don't use this insert as a new set of user data

        user.setName(updateduser.getName());
        user.setAddress(updateduser.getName());
        user.setPno(updateduser.getPno());
        userRepository.save(user);
    }

}
