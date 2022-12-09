package com.ensat.manager;

import com.ensat.entities.Product;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductManager {
    @Autowired
    private ProductService productService;
    public boolean deleteProduct(int id){
        boolean isDeleted = false;
        Product product = null;
        product = productService.getProductById(id);
        if(product!=null){
            productService.deleteProduct(id);
            isDeleted = true;
        }

        return isDeleted;
    }

}
