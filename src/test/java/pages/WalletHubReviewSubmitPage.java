package pages;

import Utilities.Common;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WalletHubReviewSubmitPage extends Common {

    @FindBy(xpath = "//li[text()='Health Insurance']")
    private WebElement healthInsurancePolicySelection;

    @FindBy(xpath = "//textarea[@placeholder='Write your review...']")
    private WebElement reviewWritingTxtBx;

    @FindBy(xpath = "//span[text()='Back']")
    private WebElement backBtn;

    @FindBy(xpath = "//div[text()='Submit']")
    private WebElement submitBtn;

    public WalletHubReviewSubmitPage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
    }

    // checking on review written page also, same ratings are selected
    public void checkRatedStars(WalletHubCompanyProfilePage whCompanyProfilePage, String company, int ratingToBeSelected) {
        List<WebElement> starsRated = driver.findElements(By.xpath("//h4[text()='" + company + "']/..//div[@class='rating-box-wrapper']//*[name()='g']"));
        Boolean sameNoOfStarsSelected = whCompanyProfilePage.isPreviousStarAlsoHighlighted(starsRated, ratingToBeSelected);
        Assert.assertEquals(sameNoOfStarsSelected, true);
    }

    public void selectPolicySelection(String value) {
        js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//li[text()='" + value + "']")));
    }

    public void writeReview(int reviewLength) {
        reviewWritingTxtBx.sendKeys(generateRandomReview(reviewLength));
    }

    public void submitReview() {
        submitBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='you have reviewed the institution']")));
        checkLoadingOfPage();
    }

    public void clickOnBack() {
        js.executeScript("arguments[0].click();", backBtn);
    }

}
