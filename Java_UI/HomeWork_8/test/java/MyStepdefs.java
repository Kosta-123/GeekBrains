import com.codeborne.selenide.Condition;
import com.geekbrains.lesson8.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class MyStepdefs {
    @Step("I am authorized")
    @Given("I am authorized")
    public void iAmAuthorized() {
        new LogInPage().login("Applanatest1", "Student2020!");
    }

    @Step("i am at main page")
    @Given("i am at main page")
    public void iAmAtMainPage() {
    }

    @Step("i hover on Projects button")
    @When("i hover on Projects button")
    public void iHoverOnProjectsButton() {
        new MainPage().navigationMenu.openNavigationSubMenuItems("Проекты");
    }

    @Step("i click at My projects button")
    @And("i click at My projects button")
    public void iClickAtMyProjectsButton() {
        new ProjectsSubMenu().myProjectsButtonClick();

    }

    @Step("i click at Create project button")
    @And("i click at Create project button")
    public void iClickAtCreateProjectButton() {
        new MyProjectPage().createMyProjectButtonClick();

    }

    @Step("i am at Create project page")
    @Then("i am at Create project page")
    public void iAmAtCreateProjectPage() {
    }

    @And("i fill Project name field")
    public void iFillProjectNameField() {
        new CreateProjectPage().fillProjectNameField("Hello");
    }

    @And("i click at Choose organization button")
    public void iClickAtChooseOrganizationButton() {
        new CreateProjectPage().chooseOrganizationClick();
    }

    @And("i click All organizations button")
    public void iClickAllOrganizationsButton() {
        new CreateProjectPage().allOrganizationsClick();
        //.allOrganizations.selectOptionContainingText("«Все организации»");

    }

    @And("i select Priority")
    public void iSelectPriority() {
        new CreateProjectPage().choosePriority("Высокий");
    }

    @And("i select Finance source")
    public void iSelectFinanceSource() {
        new CreateProjectPage().choosefinanceSource("Инвестиции");
    }

    @And("i select Business unit")
    public void iSelectBusinessUnit() {
        new CreateProjectPage().chooseBusinessUnite("Research & Development");
    }

    @And("i select Curator")
    public void iSelectCurator() {
        new CreateProjectPage().chooseCurator("Applanatest Applanatest Applanatest");
    }

    @And("i select RP")
    public void iSelectRP() {
        new CreateProjectPage().chooseRP("Applanatest Applanatest Applanatest");
    }

    @And("i select Administrator")
    public void iSelectAdministrator() {
        new CreateProjectPage().chooseAdministrator("Applanatest2 Applanatest2 Applanatest2");
    }

    @And("i select Manager")
    public void iSelectManager() {
        new CreateProjectPage().chooseManager("Applanatest Applanatest Applanatest");
    }

    @And("i click at Save and quit button")
    public void iClickAtSaveAndQuitButton() {

        new CreateProjectPage().saveAndCloseButtonClick();
    }

    @Then("i see error message")
    public void iSeeErrorMessage() {
        new CreateProjectPage().errorMessage.shouldBe(Condition.appear);

    }
}
