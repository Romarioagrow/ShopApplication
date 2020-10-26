package com.develop.shopapplication;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {

    public ProductDto(int productID, String name, String type, int price) {
        this.productID = productID;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    private long productID;
    private String name;
    private String type;
    private int price;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public String getAuthor() {
        return "Name";
    }
}
