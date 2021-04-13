package pages;

import Utilities.Common;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletHubLoginPage extends Common {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[text()='Remember']")
    private WebElement rememberLoginBtn;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    public WalletHubLoginPage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
    }

    public void loginIntoWalletHub(String username, String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        js.executeScript("arguments[0].click();", rememberLoginBtn);
        js.executeScript("arguments[0].click();", loginBtn);
        checkLoadingOfPage();
    }

}
