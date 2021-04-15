package pages;

import Utilities.Common;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage extends Common {
    FacebookHomePage fbHomePage = null;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public FacebookLoginPage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
    }

    public void loginIntoFacebook(String username, String password) {
        setUserName(username);
        setPassword(password);
        js.executeScript("arguments[0].click();", loginBtn);
        checkLoadingOfPage();
        fbHomePage = new FacebookHomePage();
        Assert.assertTrue(fbHomePage.isUserLoggedIn());
    }

    private void setUserName(String value) {
        username.sendKeys(value);
    }

    private void setPassword(String value) {
        password.sendKeys(value);
    }

    public void navigateToFacebookPage() {
        driver.get("https://www.facebook.com");
        checkLoadingOfPage();
    }
}
