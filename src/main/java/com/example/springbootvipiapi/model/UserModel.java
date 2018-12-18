package com.example.springbootvipiapi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;
    private String pno;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roleModels = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<CommentsModel> commentsModel = new HashSet<>(); //Set is like Array of message not is Set

    public UserModel() {
    }

    public UserModel(String name, String address, String pno) {
        this.name = name;
        this.address = address;
        this.pno = pno;
    }

    public Set<CommentsModel> getCommentsModel() {
        return commentsModel;
    }

    public void setCommentsModel(Set<CommentsModel> commentsModel) {
        this.commentsModel = commentsModel;
    }

    public Set<RoleModel> getRoleModels() {
        return roleModels;
    }

    public void setRoleModels(Set<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }
}
