package stepDefinition;

import Utilities.Common;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.WalletHubCompanyProfilePage;
import pages.WalletHubLoginPage;
import pages.WalletHubReviewSubmitPage;

import java.util.logging.Logger;

public class WalletHubSteps extends Common {
    String company = null;
    Logger logger = Logger.getLogger(this.getClass().getName());
    int ratingToBeSelected = 0;

    @Given("^user navigate to \"([^\"]*)\" profile$")
    public void user_navigate_to_profile(String companyName) {
        whCompanyProfilePage = new WalletHubCompanyProfilePage();
        whCompanyProfilePage.navigateToCompanyProfile(companyName);
        logger.info("user navigated to " + companyName + "profile page.");
        whCompanyProfilePage.clickOnLogin();
        logger.info("User redirected to login page.");
    }

    @When("^user login WalletHub with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_WalletHub_with_username_and_password(String username, String password) {
        whLoginPage = new WalletHubLoginPage();
        whLoginPage.loginIntoWalletHub(username, password);
        whCompanyProfilePage = new WalletHubCompanyProfilePage();
    }

    @When("^user rate '(\\d+)' to the company$")
    public void user_rate_to_the_company(int rating) {
        ratingToBeSelected = rating;
        whCompanyProfilePage.rateCompany(rating);
        logger.info("User redirected to Review Submit Page.");
    }

    @When("^user select \"([^\"]*)\" in Policy dropdown$")
    public void user_select_Policy_dropdown(String policyValue) {
        whReviewSubmitPage = new WalletHubReviewSubmitPage();
        whReviewSubmitPage.selectPolicySelection(policyValue);
    }

    @When("^user writes random review of length \"([^\"]*)\"$")
    public void user_writes_random_review_of_length(int length) {
        whReviewSubmitPage.writeReview(length);
    }

    @Then("^verify review feed got updated$")
    public void verify_review_feed_got_updated() {
        whReviewSubmitPage.submitReview();
    }

    @Then("^user navigate to profile page$")
    public void user_navigate_to_profile_page() {
        whReviewSubmitPage = new WalletHubReviewSubmitPage();
        whReviewSubmitPage.clickOnBack();
    }

    @Then("^verify visibility of review\\.$")
    public void verify_visibility_of_review() {
        Assert.assertTrue(whCompanyProfilePage.verifyReview());
    }

    @And("^User close the application$")
    public void userCloseTheApplication() {
        driver.close();
    }
}
