package com.belajar.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Payment;

public interface PaymentInterface extends CrudRepository<Payment,Long>{
    
}
