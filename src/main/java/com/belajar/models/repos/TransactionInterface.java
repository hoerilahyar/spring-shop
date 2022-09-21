package com.belajar.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Transaction;

public interface TransactionInterface extends CrudRepository<Transaction,Long>{
    
}
