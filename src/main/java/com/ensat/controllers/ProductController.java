package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.manager.ProductManager;
import com.ensat.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Product controller.
 */
@RestController("/products")
public class ProductController {
     @Autowired
     private ProductService productService;
     @Autowired
     private ProductManager productManager;
     Logger logger = LoggerFactory.getLogger(ProductController.class);

   

    /**
     * List all products.
     *
     * @param model
     * @return
     */
   @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        logger.info("returning products");
        return "products";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    // Afficher le formulaire de modification du Product
    @PutMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @PostMapping
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/" + product.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        productManager.deleteProduct(id);
        return "redirect:/products";
    }

}
