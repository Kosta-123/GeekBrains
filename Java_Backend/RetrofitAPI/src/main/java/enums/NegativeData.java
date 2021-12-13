package enums;

import lombok.Getter;

public enum NegativeData  {

    NUTS ("Pot", "Food", 100, 18411);

    @Getter
    private final String title;
    @Getter
    private final Integer id;
    @Getter
    private Integer price;
    @Getter
    private String categoryTitle;


    NegativeData (String title, String categoryTitle, Integer price, Integer id) {
        this.title = title;
        this.id = id;
        this.categoryTitle = categoryTitle;
        this.price = price;
    }
}


