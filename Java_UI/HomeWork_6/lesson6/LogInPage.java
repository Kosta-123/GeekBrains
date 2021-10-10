package com.geekbrains.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BaseView {
    WebDriver driver;

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id = "_submit")
    public WebElement buttonLogin;

    public LogInPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LogInPage fillPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage submitButton() {
        buttonLogin.click();
        return new MainPage(driver);
    }

    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //    public void login(String login, String password){
//        inputLogin.sendKeys(login);
//        inputPassword.sendKeys(password);
//        buttonLogin.click();
//    }


}