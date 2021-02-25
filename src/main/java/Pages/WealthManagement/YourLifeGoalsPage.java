package Pages.WealthManagement;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class YourLifeGoalsPage extends Base {

    @FindBy(xpath="(//*[@class=' listitem__link listitem__link--linklist'])[1]")
    protected WebElement buttonGrowWealth;

    @FindBy(xpath="//a[@href]")
    protected List<WebElement> genericLink;

    @FindBy(xpath="//a[@href='https://www.facebook.com/UBSglobal/']")
    protected WebElement linkFacebook;

    @FindBy(xpath="//a[@href='https://www.instagram.com/ubs/?hl=en']")
    protected WebElement linkInstagram;

    @FindBy(xpath="//a[@href='https://www.youtube.com/user/ubsglobal']")
    protected WebElement linkYoutube;

    @FindBy(xpath="//a[@href='https://twitter.com/UBS']")
    protected WebElement linkTwitter;

    @FindBy(xpath="//a[@href='https://www.linkedin.com/company/ubs/']")
    protected WebElement linkLinkedin;

    @FindBy(xpath="(//button[@aria-label='Select your language'])[1]")
    protected WebElement buttonLanguage;


    public YourLifeGoalsPage(){
        PageFactory.initElements(driver,this);
    }

    public void clickGrowWealth() throws InterruptedException {
        scrollByAmount(500);
        click(buttonGrowWealth);
    }

    public void checkLinks() throws InterruptedException, IOException {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://www.facebook.com/UBSglobal/']")));
        List<WebElement> socialMediaLinks = Arrays.asList(linkFacebook,linkYoutube,linkTwitter);

        HttpURLConnection huc;
        String url = "";
        int respCode;

        for (WebElement element : socialMediaLinks) {
            url = element.getAttribute("href");
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    logSystemOut(url + " is a broken link");
                } else {
                    logSystemOut(url + " is a valid link");
                }

                Assert.assertEquals(respCode, 200);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeLanguage(String language) throws InterruptedException {
        click(buttonLanguage);
        clickToText(language);
    }



}
