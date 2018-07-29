package com.example.rest.repository;

import com.example.rest.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByName(String name);
}