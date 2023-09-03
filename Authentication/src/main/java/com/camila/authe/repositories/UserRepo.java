package com.camila.authe.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.camila.authe.models.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findByEmail(String email);
} 


