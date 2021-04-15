package pages;

import Utilities.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WalletHubReviewSubmitPage extends Common {

    @FindBy(xpath = "//textarea[@placeholder='Write your review...']")
    private WebElement reviewWritingTxtBx;

    @FindBy(xpath = "//span[text()='Select...']")
    private WebElement selectDropdown;

    @FindBy(xpath = "//span[text()='Back']")
    private WebElement backBtn;

    @FindBy(xpath = "//div[text()='Submit']")
    private WebElement submitBtn;

    public WalletHubReviewSubmitPage() {
        // This initElements method will initialize all defined WebElements
        PageFactory.initElements(driver, this);
    }

    public void selectPolicySelection(String value) {
        selectDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + value + "']")).click();
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
        backBtn.click();
    }

}
