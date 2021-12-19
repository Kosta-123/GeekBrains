package ru.annachemic.db.enums;

import lombok.Getter;

public enum ProductType {
    GOORT ("Hello", "Food", 100, 18631),
    BONZO ("Bones", "Food", 100, 19337),
    GOOO ("Stix","Food", 100, 19338),
    NUTS ("ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg","Food",
            100, 19343);


    @Getter
    private final String title;
    @Getter
    private final Integer id;
    @Getter
    private Integer price;
    @Getter
    private String categoryTitle;


    ProductType(String title, String categoryTitle, Integer price, Integer id) {
        this.title = title;
        this.id = id;
        this.categoryTitle = title;
        this.price = price;
    }
}
