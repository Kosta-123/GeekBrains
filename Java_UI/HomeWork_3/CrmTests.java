package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CrmTests {
    private static final String CRM_URL= "https://crm.geekbrains.space/";
    private static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);

        driver.get(CRM_URL);

        login();

        WebElement Project = driver.findElement(By.xpath("//a//span[.='Проекты']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(Project).build().perform();
        driver.findElement(By.xpath("//span[.='Мои проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Создать проект']")));
//        webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//*[text()='Создать проект']")));
        driver.findElement(By.xpath("//*[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_project[name]']")));
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).click();
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("Hello");

        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();

        Select selectPriority = new Select(driver.findElement(By.xpath("//select[@name='crm_project[priority]']")));
        selectPriority.selectByValue("3");

        Select selectFinanceSource = new Select(driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']")));
        selectFinanceSource.selectByValue("3");

        Select selectBuisinessUnit = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        selectBuisinessUnit.selectByValue("1");

        Select selectCurator = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        selectCurator.selectByValue("115");

        Select selectRP = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        selectRP.selectByValue("115");

        Select selectAdministrator = new Select(driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
        selectAdministrator.selectByValue("117");

        Select selectManager = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        selectManager.selectByValue("115");

        driver.findElement(By.xpath("//button[contains(@class,'btn btn-success action-button')]")).click();



        Thread.sleep(10000);
        driver.quit();



    }
    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2"))
                .sendKeys("Student2020!");

        driver.findElement(By.id("_submit")).click();






    }

}
