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

    public boolean updateProduct(int id,Product updateProduct){
        boolean isUpdated = false;
        Product product = null;
        String productName = updateProduct.getName();
        Product updatedProduct = null;
        product = productService.getProductById(id);
        if(product!=null){
            product.setName(productName);
            updatedProduct = productService.saveProduct(product);
            if(updatedProduct!=null) {
                isUpdated = true;
            }
        }
        return isUpdated;
    }


}
