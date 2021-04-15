package pages;

import Utilities.Common;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WalletHubCompanyProfilePage extends Common {
    String url = "http://wallethub.com/profile/";
    Actions action = null;

    @FindBy(xpath = "//span[text()='Login']")
    private WebElement loginBtn;

    @FindBy(xpath = "//span/span[text()='Most Recent']")
    private WebElement mostRecentLinkDropdown;
    @FindBy(xpath = "//div/span[text()='Most Recent']")
    private WebElement mostRecentLink;

    @FindBy(xpath = "//div[@class='brgm-button brgm-user brgm-list-box']")
    private WebElement profileDropDown;

    @FindBy(xpath = "//input[@placeholder='Email address or phone number']")
    private WebElement username;

    @FindBy(xpath = "//h3[text()='Your Rating']/..//review-star")
    private WebElement yourRatings;

    @FindBy(xpath = "//h3[text()='Your Rating']/..//review-star//*[name()='g']//*[name()='path']")
    private List<WebElement> yourStarRatings;

    @FindBy(xpath = "//h3[text()='Your Rating']/..//review-star//*[name()='g']//*[name()='path'][2]")
    private List<WebElement> yourHighlightedStarRatings;

    @FindBy(xpath = "//h3[text()='Your Rating']")
    private WebElement yourRatingLabel;

    public WalletHubCompanyProfilePage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public void clickOnLogin() {
        loginBtn.click();
        checkLoadingOfPage();
        Assert.assertEquals("[wallethub.com/join/login?redirect_to=https:%2F%2Fwallethub.com%2Fprofile%2Ftest-insurance-company-13732055i]", getHtmlPageName());
    }

    public void navigateToCompanyProfile(String companyName) {
        driver.get(url + companyName);
        checkLoadingOfPage();
        Assert.assertEquals("[wallethub.com/profile/test-insurance-company-13732055i]", getHtmlPageName());
    }

    //checking for each star and followers stars are getting highlighted so checking count of stars highlighted
    public void rateCompany(int rating) {
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yourRatings);
        //initially no star should be highlighted
        Assert.assertEquals(yourHighlightedStarRatings.size(), 0);
        int highlightedCount =1;
        // moving to each star and verifying Highlighting pattern
        for (int i = 0; i < yourStarRatings.size(); i = i+2) {
            action.moveToElement(yourStarRatings.get(i)).perform();
            whCompanyProfilePage = new WalletHubCompanyProfilePage();
            Assert.assertEquals(yourHighlightedStarRatings.size(), highlightedCount++);
            waitForPreloader(1);
        }
        action.moveToElement(yourRatingLabel).perform();
        whCompanyProfilePage = new WalletHubCompanyProfilePage();
        action.moveToElement( yourStarRatings.get(rating-1)).click().perform();
        checkLoadingOfPage();
        Assert.assertEquals("[wallethub.com/profile/test-insurance-company-13732055i]", getHtmlPageName());
    }

    //First select most Recent review and Then verify
    public Boolean verifyReview() {
        checkLoadingOfPage();
        whCompanyProfilePage = new WalletHubCompanyProfilePage();
        mostRecentLinkDropdown.click();
        mostRecentLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Your Review']")));
        return driver.findElement(By.xpath("//span[text()=' Your Review']")).isDisplayed();
    }

}
