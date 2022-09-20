package com.belajar.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tbl_transactions")
public class Transaction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "total is required!")
    private Double total;
    
    @Column(nullable = false)
    private Boolean status;

    @OneToOne
    private Order order;

    @OneToOne
    private User user;
    
    @OneToOne
    private Payment payment;

}
