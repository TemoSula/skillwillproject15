package com.example.skillwill15.Models;

import org.springframework.stereotype.Service;


public class Computer implements Product {

    private String productType;
    private String price;
    private String quantity;

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String getPrice() {
        return price;
    }

    @Override
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
