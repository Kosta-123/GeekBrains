package com.geekbrains.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CrmTest3 {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
        login();
    }

    @Test
    void moveToElementProjectsTest() throws InterruptedException {
        WebElement projects = driver.findElement(By.xpath("//a//span[.='Проекты']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(projects).build().perform();
        Assertions.assertEquals(projects, driver.findElement(By.xpath("//a//span[.='Проекты']")));

        Thread.sleep(3000);
    }

    @Test
    void clickOnElementMyProjectsTest() throws InterruptedException {
        WebElement projects = driver.findElement(By.xpath("//a//span[.='Проекты']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(projects).build().perform();
        driver.findElement(By.xpath("//span[.='Мои проекты']")).click();

        Thread.sleep(3000);
    }

    @Test
    void clickOnCreateProject() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/my");
        WebElement createProject = driver.findElement(By.xpath("//*[text()='Создать проект']"));
        driver.findElement(By.xpath("//*[text()='Создать проект']")).click();
        Assertions.assertEquals(createProject, driver.findElement(By.xpath("//*[text()='Создать проект']")));
        Thread.sleep(3000);
    }

    @Test
    void clickOnItemFieldElement() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).click();
        WebElement itemFieldElement = driver.findElement(By.xpath("//input[@name='crm_project[name]']"));
        Assertions.assertEquals(itemFieldElement, driver.findElement(By.xpath("//input[@name='crm_project[name]']")));

        Thread.sleep(3000);
    }

    @Test
    void fillUpItemFieldTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("Hello");
//        WebElement text = driver.findElement(By.xpath("//input[@name='crm_project[name]']"));
//        Assertions.assertEquals("Hello", text.getText());  TODO= put a right assertion;



        Thread.sleep(5000);
    }

    @Test
    void clickOnChooseOrganizationTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();
        WebElement organization = driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]"));
        Assertions.assertEquals("Укажите организацию", organization.getText());

        Thread.sleep(3000);
    }

    @Test
    void clickOnAllOrganizationTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        driver.findElement(By.xpath("//span[contains(.,'Укажите организацию')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//div[text()='«Все организации»']")).click();
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='«Все организации»']")));

        WebElement allOrg = driver.findElement(By.xpath("//span[text()='«Все организации»']"));
        Assertions.assertEquals("«Все организации»", allOrg.getText());

        Thread.sleep(5000);
    }

    @Test
    void selectPriorityElementTest() {
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectPriority = new Select(driver.findElement(By.xpath("//select[@name='crm_project[priority]']")));
        selectPriority.selectByValue("3");
        Assertions.assertEquals("Высокий", selectPriority.getFirstSelectedOption().getText());
    }

    @Test
    void selectFinanceSourceTest() {
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectFinanceSource = new Select(driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']")));
        selectFinanceSource.selectByValue("3");
        Assertions.assertEquals("Инвестиции", selectFinanceSource.getFirstSelectedOption().getText());
    }

    @Test
    void selectBuisinessUnitTest(){
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectBuisinessUnit = new Select(driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        selectBuisinessUnit.selectByValue("1");
        Assertions.assertEquals("Research & Development", selectBuisinessUnit.getFirstSelectedOption().getText());

    }
    @Test
    void selectCuratorTest(){
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectCurator = new Select(driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        selectCurator.selectByValue("115");
        Assertions.assertEquals("Applanatest Applanatest Applanatest", selectCurator.getFirstSelectedOption().getText());
    }
    @Test
    void selectRPTest(){
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectRP = new Select(driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        selectRP.selectByValue("115");
        Assertions.assertEquals("Applanatest Applanatest Applanatest", selectRP.getFirstSelectedOption().getText());

    }
    @Test
    void selectAdministratorTest(){
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectAdministrator = new Select(driver.findElement(By.xpath("//select[@name='crm_project[administrator]']")));
        selectAdministrator.selectByValue("117");
        Assertions.assertEquals("Applanatest2 Applanatest2 Applanatest2", selectAdministrator.getFirstSelectedOption().getText());


    }
    @Test
    void selectManagerTest(){
        driver.get("https://crm.geekbrains.space/project/create/");
        Select selectManager = new Select(driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        selectManager.selectByValue("115");
        Assertions.assertEquals("Applanatest Applanatest Applanatest", selectManager.getFirstSelectedOption().getText());

    }
    @Test
    void clickSubmitAndCreateButtonTest(){
        driver.get("https://crm.geekbrains.space/project/create/");
        driver.findElement(By.xpath("//button[contains(@class,'btn btn-success action-button')]")).click();

    }
    @Test
    void iframeTest1() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id,'crm_project_planning')]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'crm_project_planning')]")));
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }
    @Test
    void iframeTest2() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/project/create/");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id,'crm_project_requirementsManagement')]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'crm_project_requirementsManagement')]")));
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2"))
                .sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }

}
