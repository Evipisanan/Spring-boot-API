package com.example.springbootvipiapi.repository;

import com.example.springbootvipiapi.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel , Integer> {
}
