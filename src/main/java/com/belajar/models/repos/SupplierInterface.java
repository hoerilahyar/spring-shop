package com.belajar.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Supplier;

public interface SupplierInterface extends CrudRepository<Supplier,Long>{
    
}
