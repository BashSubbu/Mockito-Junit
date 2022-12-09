package com.ensat;

import com.ensat.entities.Product;
import com.ensat.repositories.ProductRepository;
import com.ensat.services.ProductService;
import com.ensat.services.ProductServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;


    @Test
    public void getProductById_Success_Test(){
        Product product = new Product(1,1,"x2","poco",100);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        Product product1 = productService.getProductById(1);

        Assertions.assertEquals("x2",product1.getProductId());
    }




}
