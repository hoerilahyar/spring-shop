package com.belajar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.models.entities.Category;
import com.belajar.models.repos.CategoryInterface;

@Service
@Transactional
public class CategoryServices {
    
    @Autowired
    private CategoryInterface categoryInterface;

    public List<Category> save(Category product){
        try{
            categoryInterface.save(product);
        } catch (Exception e) {
            return new ArrayList<>();
        }
        ArrayList<Category> result=new ArrayList<>();
        result.add(product);
        return result;

    }

    public Category findOne(Long id){
        Optional<Category> product = categoryInterface.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public List<Category> findAll(){
        List<Category> result = new ArrayList<Category>();
        categoryInterface.findAll().forEach(result::add);
        return result;
    }

    public boolean removeOne(Long id){
        categoryInterface.deleteById(id);
        return true;
    }

    public List<Category> findByName(String name){
        return categoryInterface.findByNameContains(name);
    }
}
