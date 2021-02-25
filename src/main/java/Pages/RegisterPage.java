package Pages;

import base.Base;
import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class RegisterPage extends Base {

    @FindBy(xpath="//*[@class='radio__label' and @for='gender_sfcollection_0']")
    protected WebElement radioButtonTitleMr;

    @FindBy(xpath="//*[@id='firstName']")
    protected WebElement textFirstName;

    @FindBy(xpath="//*[@id='lastName']")
    protected WebElement textLastName;

    @FindBy(xpath="//*[@id='company']")
    protected WebElement textCompany;

    @FindBy(xpath="//*[@id='phoneNumber']")
    protected WebElement textPhoneNumber;

    @FindBy(xpath="//*[@id='email']")
    protected WebElement textEmail;

    @FindBy(xpath="//*[@id='domicile_sfcollection']")
    protected WebElement dropdownLocation;

    @FindBy(xpath="//*[@id='multi1_sfcollection']")
    protected WebElement dropdownAreaOfInterest;

    @FindBy(xpath="//*[@id='text1_sfcollection']")
    protected WebElement dropdownClientType;

    @FindBy(xpath="//*[@type='checkbox']")
    protected WebElement checkboxConfirm;

    @FindBy(xpath="//*[@class='actionbutton__txtbody']")
    protected WebElement buttonSubmit;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    public void register(String country,String areaOfInterest) throws InterruptedException {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Person person = Fairy.create().person();
        click(radioButtonTitleMr);
        write(textFirstName,person.getFirstName());
        write(textLastName,person.getLastName());
        write(textCompany,person.getCompany().getName());
        write(textPhoneNumber,"+"+person.getTelephoneNumber());
        write(textEmail,person.getCompanyEmail());
        selectOptionByText(dropdownLocation,country);
        scrollByAmount(500);
        selectOptionByText(dropdownAreaOfInterest,areaOfInterest);
        selectOptionByText(dropdownClientType,"New");
    }

    public void clickSubmit() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxConfirm).click().build().perform();
        scrollByAmount(500);
        click(buttonSubmit);
    }




}
