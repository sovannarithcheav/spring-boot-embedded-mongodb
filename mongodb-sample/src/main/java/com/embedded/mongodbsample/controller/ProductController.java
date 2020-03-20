package com.embedded.mongodbsample.controller;

import com.embedded.mongodbsample.commands.ProductForm;
import com.embedded.mongodbsample.converters.ProductToProductForm;
import com.embedded.mongodbsample.domain.Product;
import com.embedded.mongodbsample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    private ProductToProductForm productToProductForm;

    @Autowired
    public void setProductToProductForm(ProductToProductForm productToProductForm) {
        this.productToProductForm = productToProductForm;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping({"/product/list", "/product"})
    public List<Product> listProducts(Model model) {
        return productService.listAll();
    }

    @RequestMapping("/product/show/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getById(id);
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("productForm", new ProductForm());
        return "product/productform";
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id) {
        productService.delete(id);
        return "DELETE";
    }
}