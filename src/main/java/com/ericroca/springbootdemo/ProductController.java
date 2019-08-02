package com.ericroca.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }
}
