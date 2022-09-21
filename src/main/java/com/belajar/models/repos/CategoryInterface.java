package com.belajar.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Category;

public interface CategoryInterface extends CrudRepository<Category, Long>{

    List<Category> findByNameContains(String name);
    
}
