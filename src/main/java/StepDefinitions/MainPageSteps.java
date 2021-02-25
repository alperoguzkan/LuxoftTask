package StepDefinitions;

import Pages.DigitalEBankingPage;
import Pages.MainPage;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MainPageSteps extends Base {

    MainPage mainPage = new MainPage();


    @Given("user clicks to UBS logins-UBS Neo-Register with UBS Neo")
    public void userClicksToUBSLoginsUBSNeoRegisterWithUBSNeo() throws InterruptedException {
        mainPage.navigateToRegisterPage();
    }

    @Given("user clicks to Wealth Management- Your Life goals link")
    public void userClicksToWealthManagementYourLifeGoalsLink() throws InterruptedException {
        mainPage.navigateToYourLifeGoalsPage();
    }

    @Given("user clicks to UBS logins")
    public void userClicksToUBSLogins() throws InterruptedException {
        mainPage.clickTOUBSLogins();
    }

    @And("user clicks to E-Banking Switzerland")
    public void userClicksToEBankingSwitzerland() throws InterruptedException {
        mainPage.clickToEBankingSwitzerland();
    }

    @And("click Trial E-Banking demo")
    public DigitalEBankingPage clickTrialEBankingDemo() throws InterruptedException {
        mainPage.clickToEBankingDemo();
        return new DigitalEBankingPage();
    }

    @Given("user clicks to Asset Management")
    public void userClicksToAssetManagement() throws InterruptedException {
        mainPage.clickToButtonAssetManagement();
    }

    @And("user clicks to Product And Capabilities")
    public void userClicksToProductAndCapabilities() throws InterruptedException {
        mainPage.navigateToProductAndCapabilities();
    }
}
