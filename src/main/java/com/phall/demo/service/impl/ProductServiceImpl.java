package com.phall.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.phall.demo.entity.Product;
import com.phall.demo.exception.ResourceNotFoundException;
import com.phall.demo.mapper.ProductMapper;
import com.phall.demo.repository.ProductRepository;
import com.phall.demo.response.ProductResponse;
import com.phall.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductResponse> listAll(){
        return productRepository.findAll().stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Product saveData(Product branch){
        return productRepository.save(branch);
    }

    public Product getById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product", id));
    }

    @Override
    public Product update(Long id, Product update) {
        Product dataUpdate = getById(id);
        dataUpdate.setTitle(update.getTitle());
        return productRepository.save(dataUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Product byId = getById(id);
        productRepository.delete(byId);
    }
}
