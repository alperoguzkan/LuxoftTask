package StepDefinitions;

import Pages.DigitalEBankingPage;
import base.Base;
import io.cucumber.java.en.And;

public class DigitalEBankingSteps extends Base {

    DigitalEBankingPage digitalEBankingPage = new DigitalEBankingPage();

    @And("clicks to account transfer")
    public void clicksToAccountTransfer() throws InterruptedException {
        digitalEBankingPage.clickToButtonAccountTransfer();
    }
    @And("clicks to new")
    public void clicksToNew() throws InterruptedException {
        digitalEBankingPage.clickToNew();
    }

    @And("makes a transaction for Daniel Gerber's konto to his sparkonto with amount of {string} CHF and the note: {string}")
    public void makesATransactionForDanielGerberSKontoToHisSparkontoWithAmountOfCHFAndTheNote(String arg0, String arg1) throws InterruptedException {
        digitalEBankingPage.makeATransActionBetweenGerber1toGerber2(arg0,arg1);
    }

}
