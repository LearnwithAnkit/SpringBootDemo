package com.ankit.crudexample.service;

import com.ankit.crudexample.entity.Product;
import com.ankit.crudexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getProductByName(String name) {
        return (List<Product>) repository.findAllByName(name);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product UpdateProduct(Product product) {

        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName((product.getName()));
        existingProduct.setId((product.getId()));
        existingProduct.setPrice((product.getPrice()));
        existingProduct.setQuantity((product.getQuantity()));
        return repository.save(existingProduct);

    }


}
