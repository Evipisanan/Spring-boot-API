package com.example.springbootvipiapi.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentsModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;


    public CommentsModel() {

    }

    public CommentsModel(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
