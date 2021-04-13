package pages;

import Utilities.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class FacebookHomePage extends Common {
    @FindBy(xpath = "//a[@aria-label='Home']")
    private WebElement homeIcon;

    FacebookHomePage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
    }

    Boolean isUserLoggedIn() {
        Boolean isLoggedIn = homeIcon == null ? false : true;
        return isLoggedIn;
    }
}
