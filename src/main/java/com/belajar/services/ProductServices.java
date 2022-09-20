package com.belajar.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.models.entities.Product;
import com.belajar.models.repos.ProductInterface;

@Service
@Transactional
public class ProductServices {
    
    @Autowired
    private ProductInterface productInterface;

    public Product save(Product product){
        return  productInterface.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> product = productInterface.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll(){
        return productInterface.findAll();
    }

    public void removeOne(Long id){
        productInterface.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productInterface.findByNameContains(name);
    }

}
