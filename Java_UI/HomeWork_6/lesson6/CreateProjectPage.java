package com.geekbrains.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseView {

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='crm_project[name]']")
    public WebElement projectName;

    public CreateProjectPage fillProjectNameField(String Name) {
        projectName.sendKeys(Name);
        return this;
    }

    @FindBy(xpath = "//span[contains(.,'Укажите организацию')]")
    public WebElement chooseOrganization;

    public CreateProjectPage chooseOrganizationClick() {
        chooseOrganization.click();
        return this;
    }

    @FindBy(xpath = "//span[text()='«Все организации»']")
    public WebElement allOrganizations;
    public CreateProjectPage allOrganizationsClick() {
        allOrganizations.click();
        return this;

    }

    @FindBy(xpath = "//select[@name='crm_project[priority]']")
    public WebElement choosePrioritySelect;

    public CreateProjectPage choosePriority(String option) {
        new Select(choosePrioritySelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[financeSource]']")
    public WebElement financeSourceSelect;

    public CreateProjectPage choosefinanceSource(String option) {
        new Select(financeSourceSelect).selectByVisibleText(option);
        return this;

    }

    @FindBy(xpath = "//select[@name='crm_project[businessUnit]']")
    public WebElement businessUnitSelect;

    public CreateProjectPage chooseBusinessUnite(String option) {
        new Select(businessUnitSelect).selectByVisibleText(option);
        return this;

    }

    @FindBy(xpath = "//select[@name='crm_project[curator]']")
    public WebElement curatorSelect;

    public CreateProjectPage chooseCurator(String option) {
        new Select(curatorSelect).selectByVisibleText(option);
        return this;

    }

    @FindBy(xpath = "//select[@name='crm_project[rp]']")
    public WebElement rpSelect;

    public CreateProjectPage chooseRP(String option) {
        new Select(rpSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[administrator]']")
    public WebElement administratorSelect;

    public CreateProjectPage chooseAdministrator(String option) {
        new Select(administratorSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//select[@name='crm_project[manager]']")
    public WebElement managerSelect;

    public CreateProjectPage chooseManager(String option) {
        new Select(managerSelect).selectByVisibleText(option);
        return this;
    }

    @FindBy(xpath = "//button[contains(@class,'btn btn-success action-button')]")
    public WebElement saveAndQuitButton;

    public CreateProjectPage saveAndCloseButtonClick() {
        saveAndQuitButton.click();
        return this;
    }


}


