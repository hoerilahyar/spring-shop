package com.belajar.services;

import java.util.ArrayList;
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

    public List<Product> save(Product product){
        try{
            productInterface.save(product);
        } catch (Exception e) {
            return new ArrayList<>();
        }
        ArrayList<Product> result=new ArrayList<>();
        result.add(product);
        return result;

    }

    public Product findOne(Long id){
        Optional<Product> product = productInterface.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public List<Product> findAll(){
        List<Product> result = new ArrayList<Product>();
        productInterface.findAll().forEach(result::add);
        return result;
    }

    public boolean removeOne(Long id){
        productInterface.deleteById(id);
        return true;
    }

    public List<Product> findByName(String name){
        return productInterface.findByNameContains(name);
    }

}
