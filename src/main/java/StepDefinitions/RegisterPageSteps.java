package StepDefinitions;

import Pages.RegisterPage;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegisterPageSteps extends Base {

    RegisterPage registerPage = new RegisterPage();

    @When("user fills the necessary information by country: {string} and area of interest: {string}")
    public void userFillsTheNecessaryInformationByCountryAndAreaOfInterest(String arg0, String arg1) throws InterruptedException {
        registerPage.register(arg0,arg1);
    }

    @And("user clicks to submit button")
    public void userClicksToSubmitButton() throws InterruptedException {
        registerPage.clickSubmit();
    }

    @And("it is seen that url changes as the registration is completed")
    public void itIsSeenThatUrlChangesAsTheRegistrationIsCompleted() {
        wait.until(ExpectedConditions.urlToBe("https://www.ubs.com/global/en/investment-bank/ubs-neo/register/confirmation.html"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ubs.com/global/en/investment-bank/ubs-neo/register/confirmation.html");
    }


    @Then("user clicks to Equities")
    public void userClicksToEquities() {
    }


}
