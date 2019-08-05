package com.ericroca.springbootdemo.service.interfaces;

import com.ericroca.springbootdemo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
}
