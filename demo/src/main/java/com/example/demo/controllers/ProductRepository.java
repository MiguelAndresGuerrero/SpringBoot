package com.example.demo.repository;

import com.example.demo.Producto;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Producto> products = new ArrayList<>();

    public ProductRepository() {
        for (long i = 1; i <= 20; i++) {
            products.add(new Product(
                i,
                "Product " + i,
                i % 2 == 0 ? "Electronics" : "Books",
                10.0 + (i * 2),
                (int) (5 + (i % 10))
            ));
        }
    }

    public List<Product> findAll() {
        return products;
    }
}