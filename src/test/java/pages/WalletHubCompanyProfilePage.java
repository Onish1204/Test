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

    @FindBy(xpath = "//input[@placeholder='Email address or phone number']")
    private WebElement username;

    @FindBy(xpath = "//h3[text()='Your Rating']/..//review-star")
    private WebElement yourRatings;

    @FindBy(xpath = " //h3[text()='Your Rating']/..//review-star//*[name()='g']//*[name()='path']")
    private List<WebElement> yourStarRatings;

    public WalletHubCompanyProfilePage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public void clickOnLogin() {
        js.executeScript("arguments[0].click();", loginBtn);
        checkLoadingOfPage();
        Assert.assertEquals("https://wallethub.com/join/login", getHtmlPageName());
    }

    public void navigateToCompanyProfile(String companyName) {
        driver.get(url + companyName);
        checkLoadingOfPage();
        Assert.assertEquals("", getHtmlPageName());
    }

    //checking for each star and followers stars are getting highlighted and clicking on index passed star
    public void rateCompany(int rating, SoftAssertions softAssert) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yourRatings);
        for (int i = 0; i < yourStarRatings.size(); i++) {
            // checking default star color
            softAssert.assertThat(yourStarRatings.get(i).getAttribute("fill").equalsIgnoreCase("#e4e9eb"));
            action.moveToElement(yourStarRatings.get(i));
            softAssert.assertThat(isPreviousStarAlsoHighlighted(yourStarRatings, i).compareTo(true));
        }
        yourStarRatings.get(rating).click();
        checkLoadingOfPage();
    }

    /* checking all previous stars getting highlighted or
    not Like if user hover over 4 Then all first 4 should highlight*/
    Boolean isPreviousStarAlsoHighlighted(List<WebElement> listOfStars, int index) {
        Boolean isHighlighting = true;
        for (int i = 0; i < index; i++) {
            if (hasAttribute(yourStarRatings.get(i), "fill")) {
                if (!yourStarRatings.get(i).getAttribute("fill").equalsIgnoreCase("#4ae0e1")) {
                    isHighlighting = false;
                }
            }
        }
        return isHighlighting;
    }

    public Boolean verifyReview() {
        checkLoadingOfPage();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=' Your Review']")));
        return driver.findElement(By.xpath("//span[text()=' Your Review']")).isDisplayed();
    }
}
