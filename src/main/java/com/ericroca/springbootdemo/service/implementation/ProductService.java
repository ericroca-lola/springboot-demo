package com.ericroca.springbootdemo.service.implementation;

import com.ericroca.springbootdemo.dao.interfaces.IProductDAO;
import com.ericroca.springbootdemo.model.Product;
import com.ericroca.springbootdemo.service.interfaces.IProductService;
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
