package com.ensat.services;

import com.ensat.entities.Product;

public interface ProductService {
    // added comment in product service class

    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);

}
