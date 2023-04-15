package com.project.proj.repository;

import com.project.proj.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Integer> {
    product findByName(String name);
}
