package com.project.proj.controller;

import com.project.proj.entity.product;
import com.project.proj.service.productService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class productController {
    @Autowired
    private productService service;
    @PostMapping("/addProduct")
    public product addProduct( @RequestBody product Product){
        return service.saveProduct(Product);

    }
    @PostMapping("/addProducts")
    public List<product> addProduct(@RequestBody List<product> Products){
        return service.saveProducts(Products);

    }
    @GetMapping("/products")
    public List<product> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/productById/{id}")
    public product findProductsById( @PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public product findProductsByName(@PathVariable String name ){
        return service.getProductByName(name);
    }
    @PutMapping("/update")
    public product updateProduct( @RequestBody product Product){
        return service.updateProduct(Product);

    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
