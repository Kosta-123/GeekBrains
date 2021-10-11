package com.geekbrains.lesson6;

import com.sun.xml.internal.bind.v2.TODO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get("https://crm.geekbrains.space/");
    }

    @Test
    void loginTest() throws InterruptedException {
        new LogInPage(driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitButton()
                .navigationMenu.openNavigationSubMenuItems("Проекты");
        new ProjectsSubMenu(driver)
                .myProjectsButtonClick();

        Thread.sleep(3000);
//        TODO= make a better wait;
        new MyProjectPage(driver).createMyProjectButtonClick();
        Thread.sleep(5000);
        new CreateProjectPage(driver)
                .fillProjectNameField("Hello")
                .chooseOrganization.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        new CreateProjectPage(driver).allOrganizations.click();
        new CreateProjectPage(driver)
                .choosePriority("Высокий")
                .choosefinanceSource("Инвестиции")
                .chooseBusinessUnite("Research & Development")
                .chooseCurator("Applanatest Applanatest Applanatest")
                .chooseRP("Applanatest Applanatest Applanatest")
                .chooseAdministrator("Applanatest2 Applanatest2 Applanatest2")
                .chooseManager("Applanatest Applanatest Applanatest")
                .saveAndQuitButton.click();


        Thread.sleep(5000);

    }

//    @Test
//    void loginTest(){
//        new LogInPage(webDriver).login("Applanatest1","Student2020!");

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}




