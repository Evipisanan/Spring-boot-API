package com.example.springbootvipiapi.controller;

import com.example.springbootvipiapi.model.CommentsModel;
import com.example.springbootvipiapi.model.UserModel;
import com.example.springbootvipiapi.repository.CommentsRepository;
import com.example.springbootvipiapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/{id}")
    private void addComment(@PathVariable int id, @RequestBody CommentsModel comments) {
        UserModel user = userRepository.findFirstById(id);

        Set<CommentsModel> setMsg = user.getCommentsModel();
        setMsg.add(comments);
        user.setCommentsModel(setMsg);


        userRepository.save(user);
        System.out.println(" ******************* " + user.getId());
    }


}
