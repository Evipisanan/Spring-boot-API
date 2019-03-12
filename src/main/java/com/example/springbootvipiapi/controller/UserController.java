package com.example.springbootvipiapi.controller;

import com.example.springbootvipiapi.model.UserModel;
import com.example.springbootvipiapi.payload.ApiResponse;
import com.example.springbootvipiapi.repository.UserRepository;
import com.example.springbootvipiapi.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;
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


    @DeleteMapping("/delete-all")
    private ApiResponse deleteAll() {
        LOGGER.info("Delete all method");
        return new ApiResponse(userService.deleteAll());
    }

    @DeleteMapping("/{id}")
    private ApiResponse deleteById(@PathVariable(value = "id") int id) {
        LOGGER.info("Delete by id method");
        return new ApiResponse(userService.deleteById(id));
    }

    //update
    @PutMapping("/{id}")
    private ApiResponse update(@PathVariable(value = "id") int id, @RequestBody UserModel updateduser) {
        UserModel user = new UserModel();
        user= userService.findFirstById(id);

        user.setName(updateduser.getName());
        user.setAddress(updateduser.getAddress());
        user.setCommentsModel(updateduser.getCommentsModel());
        user.setPno(updateduser.getPno());

        LOGGER.info("update method in Controller.....");

        return new ApiResponse(userService.save(user));
    }

}
