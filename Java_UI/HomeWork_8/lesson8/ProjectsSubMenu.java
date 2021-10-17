package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProjectsSubMenu {

    private SelenideElement myProjectsButton = $(By.xpath("//span[.='Мои проекты']"));


    @Step("Click on 'My projects' button")
    public MyProjectPage myProjectsButtonClick() {
        myProjectsButton.click();
        return page(MyProjectPage.class);


    }

}
