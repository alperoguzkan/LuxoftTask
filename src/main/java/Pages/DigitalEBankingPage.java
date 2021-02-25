package Pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DigitalEBankingPage extends Base {

    @FindBy(xpath="(//*[contains(text(),'New') or contains(text(),'Neu')])[2]")
    protected WebElement buttonNew;

    @FindBy(xpath="(//*[@class='Tile__StyledTitle-sc-1yx9x5k-3 gNAfoN'])[12]")
    protected WebElement buttonAccountTransfer;

    @FindBy(xpath="//*[contains(text(),'UBS Konto')]")
    protected WebElement buttonDanielGerber;

    @FindBy(xpath="//*[contains(text(),'UBS Sparkonto')]")
    protected WebElement buttonDanielGerber2;

    @FindBy(xpath="(//*[@class='isvg loaded AccountSelect__StyledSelectIcon-sc-11r84h6-3 lldOnu'])[1]")
    protected WebElement buttonDebitFrom;

    @FindBy(xpath="//*[@class='AccountSelect__StyledEmpty-sc-11r84h6-2 kRrHFF']")
    protected WebElement buttonDebitTo;

    @FindBy(xpath="//*[@class='readOnlyInput']")
    protected WebElement textboxPayment;

    @FindBy(xpath="(//*[@class='fixIEInput'])[2]")
    protected WebElement textboxNote;

    @FindBy(xpath="//button//div")
    protected WebElement buttonTransfer;


    public DigitalEBankingPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickToNew() throws InterruptedException {
        click(driver.findElement(By.xpath("//html")));
        click(buttonNew);
    }

    public void clickToButtonAccountTransfer() throws InterruptedException {
        click(buttonAccountTransfer);
    }

    public void makeATransActionBetweenGerber1toGerber2(String payment, String note) throws InterruptedException {
        click(buttonDebitFrom);
        waiting(3000);
        click(buttonDanielGerber);
        click(buttonDebitTo);
        waiting(2000);
        click(buttonDanielGerber2);
        waiting(3000);
        click(textboxPayment);
        new Actions(driver).sendKeys(payment).perform();
        wait.until(ExpectedConditions.elementToBeClickable(textboxNote));
        textboxNote.sendKeys(note);
        scrollByAmount(500);
        scrollToElement(buttonTransfer);
        click(buttonTransfer);
    }

}
