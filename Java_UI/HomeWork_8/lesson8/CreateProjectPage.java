package com.geekbrains.lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class CreateProjectPage {

    private SelenideElement projectName = $(By.xpath("//input[@name='crm_project[name]']"));

    @Step("Fill 'Project name' field")
    public CreateProjectPage fillProjectNameField(String Name) {
        projectName.sendKeys(Name);
        return this;
    }

    private SelenideElement chooseOrganization = $(By.xpath("//span[contains(.,'Укажите организацию')]"));

    @Step("Click on 'Choose organization' button")
    public CreateProjectPage chooseOrganizationClick() {
        chooseOrganization.click();
        return this;
    }

    public SelenideElement allOrganizations = $(By.xpath("//div[text()='«Все организации»']"));

    @Step("Click on'All organizations' button")
    public CreateProjectPage allOrganizationsClick() {
        allOrganizations.click();
        return this;

    }

    private SelenideElement choosePrioritySelect = $(By.xpath("//select[@name='crm_project[priority]']"));

    @Step("Select 'Priority'")
    public CreateProjectPage choosePriority(String option) {
        choosePrioritySelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement financeSourceSelect = $(By.xpath("//select[@name='crm_project[financeSource]']"));

    @Step("Select 'Finance source'")
    public CreateProjectPage choosefinanceSource(String option) {
        financeSourceSelect.selectOptionContainingText(option);
        return this;

    }

    private SelenideElement businessUnitSelect = $(By.xpath("//select[@name='crm_project[businessUnit]']"));

    @Step("Select 'Business unit'")
    public CreateProjectPage chooseBusinessUnite(String option) {
        businessUnitSelect.selectOptionContainingText(option);
        return this;

    }

    private SelenideElement curatorSelect = $(By.xpath("//select[@name='crm_project[curator]']"));

    @Step("Select 'Curator'")
    public CreateProjectPage chooseCurator(String option) {
        curatorSelect.selectOptionContainingText(option);
        return this;

    }

    private SelenideElement rpSelect = $(By.xpath("//select[@name='crm_project[rp]']"));

    @Step("Select 'RP'")
    public CreateProjectPage chooseRP(String option) {
        rpSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement administratorSelect = $(By.xpath("//select[@name='crm_project[administrator]']"));

    @Step("Select 'Administrator'")
    public CreateProjectPage chooseAdministrator(String option) {
        administratorSelect.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement managerSelect = $(By.xpath("//select[@name='crm_project[manager]']"));

    @Step("Select 'Manager'")
    public CreateProjectPage chooseManager(String option) {
        managerSelect.selectOptionContainingText(option);
        return this;
    }

    //    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
//    public WebElement saveAndQuitButton;
//    @Step("Click on 'Save and Quit' button")
//    public CreateProjectPage saveAndCloseButtonClick() {
//        saveAndQuitButton.click();
//        return this;
//    }
//    @Step("Click on 'Save and quit' button")
//    public void saveAndQuit(WebDriver driver, WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
//
//    }
    private SelenideElement saveAndQuitButton = $(By.xpath("//button[contains(text(),'Сохранить и закрыть')]"));

    @Step("Click on 'Save and quit' button")
    public CreateProjectPage saveAndCloseButtonClick() {
        saveAndQuitButton.click();
        return this;
    }

    public SelenideElement errorMessage = $(By.xpath("//span[contains(text(),'Это значение уже используется.')]"));


}


