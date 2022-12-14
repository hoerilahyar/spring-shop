package com.belajar.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.dto.ResponseHandler;
import com.belajar.models.entities.Product;
import com.belajar.services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductServices productServices;
    
    @GetMapping
    public ResponseEntity<Object> findAll(){
        try {
            List<Product> result = productServices.findAll();
            return ResponseHandler.generateResponse(HttpStatus.OK, result,null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(null, HttpStatus.MULTI_STATUS,e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody Product product, Errors errors){

        if(errors.hasErrors()){
            ArrayList<String> err = new ArrayList<>();
            for (ObjectError error : errors.getAllErrors()) {
                err.add(error.getDefaultMessage());
            }

            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,null,String.join(" ",err));
        }

        try {
            List<Product> result = productServices.save(product);
            if (result != null){
                return ResponseHandler.generateResponse(HttpStatus.OK, result,null);
            }else{
                return ResponseHandler.generateResponse(HttpStatus.OK, null,"No data found!");
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse( HttpStatus.MULTI_STATUS,null,e.getMessage());
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByID(@PathVariable("id") Long id){
        try {
            Product result = productServices.findOne(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, result,null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(null, HttpStatus.MULTI_STATUS,e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @Valid @RequestBody Product product, Errors errors){
        
        if(errors.hasErrors()){
            ArrayList<String> err = new ArrayList<>();
            for (ObjectError error : errors.getAllErrors()) {
                err.add(error.getDefaultMessage());
            }

            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST,null,String.join(" ",err));
        }

        try {
            if (productServices.findOne(id) != null){
                product.setId(id);
                List<Product> result = productServices.save(product);
                if (result != null){
                    return ResponseHandler.generateResponse(HttpStatus.OK, result,null);
                }else{
                    return ResponseHandler.generateResponse(HttpStatus.OK, null,"No data found!");
                }
            }else{
                return ResponseHandler.generateResponse(HttpStatus.OK, null,"No data updated!");
            }
            
        } catch (Exception e) {
            return ResponseHandler.generateResponse( HttpStatus.MULTI_STATUS,null,e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") Long id){
        try {
            if (productServices.removeOne(id)){
                return ResponseHandler.generateResponse(HttpStatus.OK, null, String.format("ID %d deleted",id));
            } else {
                return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, null, String.format("ID %d not found",id));
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(null, HttpStatus.MULTI_STATUS,e.getMessage());
        }
    }
}
