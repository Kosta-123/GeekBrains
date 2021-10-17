package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class MyProjectPage  {

    private SelenideElement createMyProjectButton = $(By.xpath("//a[.='Создать проект']"));

    @Step("Click on 'Create project' button")
    public void createMyProjectButtonClick(){
        createMyProjectButton.click();

    }

}
