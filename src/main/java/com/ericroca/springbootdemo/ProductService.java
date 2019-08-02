package com.ericroca.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
