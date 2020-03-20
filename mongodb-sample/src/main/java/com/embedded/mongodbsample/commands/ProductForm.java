package com.embedded.mongodbsample.commands;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {
    private String id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
}