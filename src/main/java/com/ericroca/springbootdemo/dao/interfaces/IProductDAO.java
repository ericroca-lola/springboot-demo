package com.ericroca.springbootdemo.dao.interfaces;

import com.ericroca.springbootdemo.model.Product;

import java.util.List;

public interface IProductDAO {

    List<Product> getAllProducts();
}
