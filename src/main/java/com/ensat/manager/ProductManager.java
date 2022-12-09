package com.ensat.manager;

import com.ensat.entities.Product;
import com.ensat.entities.User;
import com.ensat.services.ProductService;
import com.ensat.services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

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


    public String getProductInformationWithUserInformation(int id){
        Product product = null;
        int userId;
        Map<String,Object> productInfoMap = null;
        String productName = null;
        int version;
        String userName = null;
        Gson gson = new Gson();
        String output = null;

        product = productService.getProductById(id);
        if(product!=null) {
            productInfoMap = new HashMap<>();
            productName = product.getName();
            version = product.getVersion();
            userId = product.getUserId();
            userName = getUserInformation(userId);
            productInfoMap.put("id",id);
            productInfoMap.put("name",productName);
            productInfoMap.put("version",version);
            productInfoMap.put("userName",userName);
        }
        if(!productInfoMap.isEmpty()){
           output = gson.toJson(productInfoMap);
        }

        return output;
    }

    public String getUserInformation(int userId){
        User user = null;
        String name = null;
        user = userService.getUserById(userId);
        if(user!=null){
            name = user.getName();
        }
        return name;
    }

}
