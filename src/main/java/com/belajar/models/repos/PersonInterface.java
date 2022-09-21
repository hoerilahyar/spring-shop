package com.belajar.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Person;

public interface PersonInterface extends CrudRepository<Person,Long>{
    
}
