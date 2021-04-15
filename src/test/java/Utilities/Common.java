package Utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WalletHubCompanyProfilePage;
import pages.WalletHubLoginPage;
import pages.WalletHubReviewSubmitPage;

import java.util.concurrent.TimeUnit;

public class Common {
    public static WebDriver driver;
    public static JavascriptExecutor js = null;
    public WalletHubLoginPage whLoginPage = null;
    public WalletHubCompanyProfilePage whCompanyProfilePage = null;
    public WalletHubReviewSubmitPage whReviewSubmitPage = null;
    public WebDriverWait wait = new WebDriverWait(driver,40);

    static {
        //Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        //Creating an object of ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Deleting all the cookies
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }

    // Using java script function to wait till page loads
    public boolean checkLoadingOfPage() {
        boolean isLoaded = false;
        int count = 0;
        String documentValue = "";
        while (!(documentValue.equalsIgnoreCase("complete")) && count < 50) {
            documentValue = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
            waitForPreloader(1);
            count++;
        }
        waitForPreloader(1);
        isLoaded = documentValue.equalsIgnoreCase("complete") ? true : false;
        return isLoaded;
    }

    public void waitForPreloader(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to read html page stack to confirm right page is loaded.
    public String getHtmlPageName() {
        checkLoadingOfPage();
        String pageName = "";
        pageName = ((JavascriptExecutor) driver).executeScript("return location.href.split(\"//\").slice(-1)").toString();
        return pageName;
    }

    // Generates random string of given length
    public String generateRandomReview(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }


    public boolean hasAttribute(WebElement element, String attribute) {
        Boolean result = null;
        try {
            String value = element.getAttribute(attribute);
            result = value != null ? true : false;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
