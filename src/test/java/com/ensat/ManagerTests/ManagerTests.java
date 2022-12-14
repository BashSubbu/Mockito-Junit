package com.ensat.ManagerTests;

import com.ensat.entities.Product;
import com.ensat.entities.User;
import com.ensat.manager.ProductManager;
import com.ensat.services.ProductServiceImpl;
import com.ensat.services.UserServiceImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManagerTests {
    @Mock
    private ProductServiceImpl productService;
    @Mock
    private UserServiceImpl userService;
    @InjectMocks
    private ProductManager productManager;
    Product product = new Product(1, 1, "x2", "poco", 100, 1);
    User user = new User(1, "siva", "India");

    @Test
    void deleteAsset_Success_Test() {
        boolean isDeleted = false;
        when(productService.getProductById(1)).thenReturn(product);
        isDeleted = productManager.deleteProduct(1);
        Assertions.assertTrue(isDeleted);
    }

    @Test
    void deleteAsset_Failure_Test() {
        boolean isDeleted = false;
        when(productService.getProductById(1)).thenReturn(null);
        isDeleted = productManager.deleteProduct(1);
        Assertions.assertFalse(isDeleted);
    }

    @Test
    void updateProduct_Success_Test() {
        boolean isUpdated = false;
        Product updatedProduct = new Product(1, 1, "x2", "poco1", 100, 1);
        when(productService.getProductById(1)).thenReturn(product);
        when(productService.saveProduct(product)).thenReturn(updatedProduct);
        isUpdated = productManager.updateProduct(1, updatedProduct);
        Assertions.assertTrue(isUpdated);
    }

    @Test
    void getProductInformationWithUser_Success_Test() {
        String output = null;
        JsonObject jsonObject = null;
        String useName = null;

        when(productService.getProductById(1)).thenReturn(product);
        when(userService.getUserById(1)).thenReturn(user);
        output = productManager.getProductInformationWithUserInformation(1);
        jsonObject = (JsonObject) new JsonParser().parse(output);
        useName = jsonObject.get("userName").getAsString();
        Assertions.assertEquals("siva", useName);
    }

    @Test
    void getUserName_Success_Tes() {
        String userName = null;
        when(userService.getUserById(1)).thenReturn(user);
        userName = productManager.getUserInformation(1);
        Assertions.assertEquals("siva", userName);
    }

}
