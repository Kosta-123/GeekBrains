package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;
import java.util.List;

public class NavigationMenu {

    private List<SelenideElement> navigationMenuItems = $$(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li"));

    @Step("Hover on 'Projects' sub menu")
    public void openNavigationSubMenuItems(String menuName) {
        navigationMenuItems.stream().filter(element -> element.getText().equals(menuName))
                .findFirst().get().hover();

    }
}

