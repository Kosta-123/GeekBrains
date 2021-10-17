package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class LogInPage {
    WebDriver driver;

    private SelenideElement inputLogin = $(By.id("prependedInput"));

    private SelenideElement inputPassword = $(By.id("prependedInput2"));

    private SelenideElement buttonLogin = $(By.id("_submit"));

    @Step("Fill login field")
    public LogInPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Fill password field")
    public LogInPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Click 'Submit' button")
    public MainPage submitButton() {
        buttonLogin.click();
        return page(MainPage.class);
    }


    public void login(String login, String password) {
        open("https://crm.geekbrains.space/");
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }


}