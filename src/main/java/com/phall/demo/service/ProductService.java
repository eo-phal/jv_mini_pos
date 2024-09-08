package com.phall.demo.service;

import java.util.List;

import com.phall.demo.entity.Product;
import com.phall.demo.response.ProductResponse;

public interface ProductService {

    List<ProductResponse> listAll();

    Product saveData(Product product);

    Product getById(Long id);

    Product update(Long id, Product update);

    void deleteById(Long id);
}
