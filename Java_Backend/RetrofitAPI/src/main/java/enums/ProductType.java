package enums;

import lombok.Getter;


public enum ProductType  {

    GOORT ("Robotic", "Food", 100, 18398);


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

