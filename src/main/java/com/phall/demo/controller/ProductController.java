package com.phall.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phall.demo.entity.Product;
import com.phall.demo.mapper.ProductMapper;
import com.phall.demo.request.ProductRequest;
import com.phall.demo.response.ProductResponse;
import com.phall.demo.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllEntity(){
        List<ProductResponse> response = productService.listAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> saveData(@Valid @RequestBody ProductRequest dto){
        Product product = productMapper.toEntity(dto);
        Product saveData = productService.saveData(product);

        ProductResponse response = productMapper.toDTO(saveData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getByid(@PathVariable Long id){
        Product getData = productService.getById(id);
        ProductResponse response = productMapper.toDTO(getData);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request){
        Product product = productMapper.toEntity(request);
        Product update = productService.update(id, product);
        ProductResponse response = productMapper.toDTO(update);
        return ResponseEntity.ok(response);
    }
}
