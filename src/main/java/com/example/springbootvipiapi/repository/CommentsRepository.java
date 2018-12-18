package com.example.springbootvipiapi.repository;

import com.example.springbootvipiapi.model.CommentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsModel , Integer> {

}
