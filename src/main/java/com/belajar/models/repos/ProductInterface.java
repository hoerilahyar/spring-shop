package com.belajar.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Product;

public interface ProductInterface extends CrudRepository<Product, Long>{

    List<Product> findByNameContains(String name);
    
}