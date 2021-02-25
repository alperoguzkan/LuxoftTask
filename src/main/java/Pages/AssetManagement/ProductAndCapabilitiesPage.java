package Pages.AssetManagement;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductAndCapabilitiesPage extends Base {

    @FindBy(xpath="//*[contains(text(),'Contact us')]")
    protected WebElement buttonContactUs;

    @FindBy(xpath="//*[contains(text(),'ETF Contacts')]")
    protected WebElement buttonETFContacts;

    @FindBy(xpath="(//a[@href and contains(text(),'Tel')])[1]")
    protected WebElement textETFContact;


    public ProductAndCapabilitiesPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickToContactUs() throws InterruptedException {
        click(buttonContactUs);
    }

    public void clickToETFContacts() throws InterruptedException {
        scrollByAmount(300);
        click(buttonContactUs);
        click(buttonETFContacts);
    }

    public void verifyContactPageIsCorrect(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.ubs.com/global/en/asset-management/contact.html");
    }

    public void getETFContactNumber() throws InterruptedException {
        waiting(4000);
        logSystemOut(textETFContact.getText());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href and contains(text(),'Tel')])[1]")));
        writeToTextFile(textETFContact.getText());
    }


}
