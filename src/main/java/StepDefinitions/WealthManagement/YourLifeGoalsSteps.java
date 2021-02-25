package StepDefinitions.WealthManagement;

import Pages.WealthManagement.YourLifeGoalsPage;
import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class YourLifeGoalsSteps extends Base {

    YourLifeGoalsPage yourLifeGoalsPage = new YourLifeGoalsPage();
    @Then("user clicks to {string} link")
    public void userClicksToHelpingYouGrowYourWealthLink(String arg0) throws InterruptedException {
        yourLifeGoalsPage.clickGrowWealth();
    }

    @And("selects the {string}")
    public void selectsThe(String arg0) throws InterruptedException {
        yourLifeGoalsPage.changeLanguage(arg0);
    }

    @Then("it is being checked no social media link is broken")
    public void itIsBeingCheckedNoSocialMediaLinkIsBroken() throws IOException, InterruptedException {
        yourLifeGoalsPage.checkLinks();
    }
}
