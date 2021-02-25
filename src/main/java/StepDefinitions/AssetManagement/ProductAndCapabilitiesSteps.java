package StepDefinitions.AssetManagement;

import Pages.AssetManagement.ProductAndCapabilitiesPage;
import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductAndCapabilitiesSteps extends Base {

    ProductAndCapabilitiesPage productAndCapabilitiesPage = new ProductAndCapabilitiesPage();

    @And("user clicks to Contact us")
    public void userClicksToContactUs() throws InterruptedException {
        productAndCapabilitiesPage.clickToContactUs();
    }

    @Then("user clicks ETF Contacts")
    public void userClicksETFContacts() throws InterruptedException {
        productAndCapabilitiesPage.clickToETFContacts();
    }

    @And("the number is written to etfContactNumber.txt")
    public void theNumberIsWrittenToEtfContactNumberTxt() throws InterruptedException {
        productAndCapabilitiesPage.getETFContactNumber();
    }

    @And("verify it redirects to contacts page")
    public void verifyItRedirectsToContactsPage() {
        productAndCapabilitiesPage.verifyContactPageIsCorrect();
    }
}
