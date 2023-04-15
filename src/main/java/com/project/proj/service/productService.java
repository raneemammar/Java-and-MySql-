package com.project.proj.service;

import com.project.proj.entity.product;
import com.project.proj.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    private productRepository repository;
    public product saveProduct(product Product){
       return repository.save(Product);
    }
    public List<product> saveProducts(List<product> Products){
        return repository.saveAll(Products);
    }
    public List<product> getProducts(){
        return repository.findAll();
    }
    public product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    public product getProductByName(String name){
        return repository.findByName(name);
    }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product removed"+id;
    }
    public product updateProduct(product Product){
        product existingProduct=repository.findById(Product.getId()).orElse(null);
        existingProduct.setName(Product.getName());
        existingProduct.setQuantity(Product.getQuantity());
        existingProduct.setPrice(Product.getPrice());
        return repository.save(existingProduct);
    }
}
