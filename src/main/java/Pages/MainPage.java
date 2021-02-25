package Pages;

import Pages.AssetManagement.ProductAndCapabilitiesPage;
import Pages.WealthManagement.YourLifeGoalsPage;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Base {

    @FindBy(xpath="(//*[@class='headerLogin__title'])[1]")
    protected WebElement buttonUBSLogins;

    @FindBy(xpath="//*[@href='https://neo.ubs.com/static/login.html?origin=%2f']")
    protected WebElement buttonUBSNeo;

    @FindBy(xpath="//*[contains(text(),'Register with UBS Neo')]")
    protected WebElement buttonRegisterWithNeo;

    @FindBy(xpath="(//button[contains(text(),'Asset Management')])[1]")
    protected WebElement buttonAssetManagement;

    @FindBy(xpath="(//*[@href='/global/en/asset-management/investment-capabilities.html'])[1]")
    protected WebElement buttonProductAndCapabilities;

    @FindBy(xpath="(//*[contains(text(),'Wealth Management')])[1]")
    protected WebElement buttonWealthManagement;

    @FindBy(xpath="(//a[@href='/global/en/wealth-management/life-goals.html'])[1]")
    protected WebElement buttonYourLifeGoals;

    @FindBy(xpath="//*[contains(text(),'UBS E-Banking Switzerland') or contains(text(),'UBS E-Banking in der Schweiz')]")
    protected WebElement buttonUBSEBankingInSwitzerland;

    @FindBy(xpath="(//*[@class='uwr-link'])[4]")
    protected WebElement buttonEBankingDemo;

    @FindBy(xpath="(//*[contains(text(),'Kontakt') or contains(text(),'Contact')])[1]")
    protected WebElement buttonContact;

    @FindBy(xpath="//*[contains(text(),'Kontakt') or contains(text(),'Contact')])[1]/..//ul//li[2]")
    protected WebElement buttonContactUs;


    public MainPage(){
        PageFactory.initElements(driver,this);
    }

    public RegisterPage navigateToRegisterPage() throws InterruptedException {
        click(buttonUBSLogins);
        click(buttonUBSNeo);
        waiting(4000);
        click(buttonRegisterWithNeo);
        waiting(4000);
        return new RegisterPage();
    }

    public YourLifeGoalsPage navigateToYourLifeGoalsPage() throws InterruptedException {
        click(buttonWealthManagement);
        click(buttonYourLifeGoals);
        return new YourLifeGoalsPage();
    }

    public void clickToButtonAssetManagement() throws InterruptedException {
        click(buttonAssetManagement);
    }

    public ProductAndCapabilitiesPage navigateToProductAndCapabilities() throws InterruptedException {
        click(buttonProductAndCapabilities);
        return new ProductAndCapabilitiesPage();
    }

    public void clickTOUBSLogins() throws InterruptedException {
        click(buttonUBSLogins);
    }

    public void clickToEBankingSwitzerland() throws InterruptedException {
        click(buttonUBSEBankingInSwitzerland);
    }

    public void clickToEBankingDemo() throws InterruptedException {
        click(buttonEBankingDemo);
    }

}
