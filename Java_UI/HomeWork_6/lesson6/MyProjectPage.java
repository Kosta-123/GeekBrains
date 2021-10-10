package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyProjectPage extends BaseView{

    public MyProjectPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[.='Создать проект']")
    public WebElement createMyProjectButton;
    public void createMyProjectButtonClick(){
        createMyProjectButton.click();

    }

}
