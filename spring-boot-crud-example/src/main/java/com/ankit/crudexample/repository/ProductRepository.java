package com.ankit.crudexample.repository;

import com.ankit.crudexample.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findAllByName(String name);
}
