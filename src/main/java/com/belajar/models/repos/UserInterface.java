package com.belajar.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.User;

public interface UserInterface extends CrudRepository<User,Long>{
    
}
