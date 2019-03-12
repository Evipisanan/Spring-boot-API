package com.example.springbootvipiapi.repository;

import com.example.springbootvipiapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

   UserModel deleteByNameAndAddress(String name , String address);

    UserModel findFirstById(int id);
    UserModel deleteById(int id);

}
