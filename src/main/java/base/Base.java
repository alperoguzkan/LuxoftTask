package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriverWait wait;
    public static Properties prop;
    public static String url;
    public static String userDirectory = "user.dir";
    public static WebDriver driver;

    public static void setup() throws IOException, InterruptedException {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", System.getProperty(userDirectory) + "\\Drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty(userDirectory) + "\\Drivers\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty(userDirectory) + "\\Drivers\\msedge.exe");

        url = getConf("url");

        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options2 = new FirefoxOptions();
        EdgeOptions options3 = new EdgeOptions();

        if (getConf("defaultBrowser").equals(getConf("browser_Chrome"))) {
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        } else if (getConf("defaultBrowser").equals(getConf("browser_Firefox"))) {
            options2.addArguments("--incognito");
            driver = new FirefoxDriver(options2);
        } else if (System.getProperty("browser").equals(getConf("browser_Edge"))) {
            driver = new EdgeDriver(options3);
        }

        driver.manage().window().maximize();
        driver.get(url);

        int waitTime = Integer.parseInt(getConf("waitTime")) * Integer.parseInt(getConf("waitTimeMultiplier"));
        wait = new WebDriverWait(driver, waitTime);

        int implicitWait = 3;
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

        /* I used ChromeCapabilities to accept cookies as default, but it was not working, so I used above code blocks
         * to handle cookies.It waits a while until if there is cookie acceptance screen. I need to use
         * static waiting time, since it is not certain that cookie popup reveals of It might been alright selected.
         */
        //Possible cookie flow #1
        Thread.sleep(3000);
        Boolean ifCookiePresent=driver.findElements(By.xpath("//*[contains(text(),'Agree to all')]")).size() != 0;
        if(ifCookiePresent){driver.findElement(By.xpath("//*[contains(text(),'Agree to all')]")).click();}

        //Possible cookie flow #2
        Boolean ifCookiePresent2=driver.findElements(By.xpath("//*[contains(text(),'Go to privacy settings')]")).size() != 0;
        if(ifCookiePresent2){driver.findElement(By.xpath("//*[contains(text(),'Go to privacy settings')]")).click();}
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Agree to all')]"))).click();

        //Language selector
        if(getConf("defaultLanguage").equals(getConf("language_german"))){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'metaNav__hl')]"))).click();
        }
    }

    public static String getConf(String value) throws FileNotFoundException, IOException {
        prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        String val = prop.getProperty(value);
        return val;
    }

    public void click(WebElement element) throws InterruptedException {
        System.out.println("Clicking to" + element);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            waiting(300); //Making more slow to checkout the flow while cases are running
            element.click();
            if (!element.getText().isEmpty()) {
                logSystemOut("Successfully clicked on by the text: " + element.getText());
            }
        } catch (Exception e) {
            logSystemOut("Cannot clicked to: " + element);
            logSystemOut((e.getMessage()));
        }
    }

    public void write(WebElement element, String text) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
                    if (element.getAttribute("value").compareTo(text) != 0) {
                        write(element, text);
                    } else {
                        if (!element.getText().isEmpty()) {
                            logSystemOut("Successfully wrote: " + text + ",to the element by the text:" + element.getText());
                        } else {
                            logSystemOut("Successfully wrote: " + text + ",to the element by the xpath:" + getByFromElement(element).toString());
                        }
                    }
        } catch (StaleElementReferenceException e) {
            logSystemOut("Cannot written: " + text.toLowerCase());
            logSystemOut(e.getMessage());
        }
    }

    public void selectOptionByText(WebElement element, String text) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Select elements = new Select(element);
            elements.selectByVisibleText(text);
        } catch (StaleElementReferenceException e) {
            selectOptionByText(element, text);
        }
    }

    public void scrollByAmount(int amount) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("window.scrollBy(0," + amount + ")");
            Thread.sleep(200);
            logSystemOut("Scrolled by the amount: " + amount);
        }catch (Exception e){
            logSystemOut("Cannot scrolled by the amount: " + amount);
            logSystemOut(e.getMessage());
        }
    }

    public By getByFromElement(WebElement element) {
        /**
         * This method get the By of a given WebElement
         * @param element WebElement that is to the method to be applied on
         */
        logSystemOut(element.toString());
        By by = null;
        String[] selectorWithValue = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":(.*?)");

        String selector = selectorWithValue[0].trim();
        String value = selectorWithValue[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }

    public void waiting(long i) throws InterruptedException {
        Thread.sleep(i);
    }

    public void logSystemOut(String logText) {
        System.out.println(logText);
    }

    public void clickToText(String text) throws InterruptedException {
        System.out.println("Clicking to: " + text);
        String xpath = "//*[contains(text(),'" + text + "') or text()[contains(.,'" + text + "')]]";
        WebElement element = driver.findElement(By.xpath(xpath));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logSystemOut("Successfully clicked to" + element);
        } catch (Exception e) {
            logSystemOut("Cannot clicked to" + element);
            logSystemOut(e.getMessage());
        }
    }

    public void scrollToElement(WebElement element) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(getByFromElement(element)));
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
            waiting(200);
            logSystemOut("Successfully scrolled to element by the text: " + element.getText());

        } catch (Exception e) {
            logSystemOut("Cannot scrolled to the element: " + element.getText());

            logSystemOut(e.getMessage());
        }
    }

    public void writeToTextFile(String text){
        try {
            FileWriter myWriter = new FileWriter( System.getProperty(userDirectory)+"\\etfContactNumber.txt");
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
