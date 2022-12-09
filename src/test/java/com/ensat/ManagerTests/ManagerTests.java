package com.ensat.ManagerTests;

import com.ensat.entities.Product;
import com.ensat.manager.ProductManager;
import com.ensat.services.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManagerTests {
    @Mock
    private ProductServiceImpl productService;
    @InjectMocks
    private ProductManager productManager;

    @Test
    public void deleteAsset_Success_Test(){
        boolean isDeleted = false;
        Product product = new Product(1,1,"x2","poco",100);
        when(productService.getProductById(1)).thenReturn(product);
        isDeleted = productManager.deleteProduct(1);
        Assertions.assertEquals(true,isDeleted);
    }
    @Test
    public void deleteAsset_Failure_Test(){
        boolean isDeleted = false;
        when(productService.getProductById(1)).thenReturn(null);
        isDeleted = productManager.deleteProduct(1);
        Assertions.assertEquals(false,isDeleted);
    }


}
