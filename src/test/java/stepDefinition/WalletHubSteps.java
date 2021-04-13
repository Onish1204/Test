package stepDefinition;

import Utilities.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.WalletHubCompanyProfilePage;
import pages.WalletHubLoginPage;
import pages.WalletHubReviewSubmitPage;

import java.util.logging.Logger;

public class WalletHubSteps extends Common {
    WalletHubLoginPage whLoginPage = null;
    WalletHubCompanyProfilePage whCompanyProfilePage = null;
    WalletHubReviewSubmitPage whReviewSubmitPage =null;
    String company = null;
    Logger logger = Logger.getLogger(this.getClass().getName());
    int ratingToBeSelected = 0;

    @Given("^user navigate to \"([^\"]*)\" profile$")
    public void user_navigate_to_profile(String companyName) {
        this.company=companyName;
        whCompanyProfilePage = new WalletHubCompanyProfilePage();
        whCompanyProfilePage.navigateToCompanyProfile(companyName);
        checkLoadingOfPage();
        Assert.assertEquals("", getHtmlPageName());
        logger.info("user navigated to " + companyName + "profile page.");
        whCompanyProfilePage.clickOnLogin();
        logger.info("User redirected to login page.");
    }

    @When("^user login WalletHub with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_WalletHub_with_username_and_password(String username, String password) {
        whLoginPage = new WalletHubLoginPage();
        whLoginPage.loginIntoWalletHub(username, password);
        whCompanyProfilePage = new WalletHubCompanyProfilePage();
        whCompanyProfilePage.navigateToCompanyProfile(company);
    }

    @When("^user rate '(\\d+)' to the company$")
    public void user_rate_to_the_company(int rating) {
        ratingToBeSelected = rating;
        SoftAssertions softAssert = new SoftAssertions();
        whCompanyProfilePage.rateCompany(rating, softAssert);
        softAssert.assertAll();
    }

    @When("^user navigates to \"([^\"]*)\" page$")
    public void user_navigates_to_page(String pageName) {
        checkLoadingOfPage();
        whReviewSubmitPage = new WalletHubReviewSubmitPage();
        Assert.assertEquals("", getHtmlPageName());
        whReviewSubmitPage.checkRatedStars(whCompanyProfilePage, company, ratingToBeSelected);
    }

    @When("^user select \"([^\"]*)\" in Policy dropdown$")
    public void user_select_Policy_dropdown(String policyValue) {
        whReviewSubmitPage.selectPolicySelection(policyValue);
    }

    @When("^user writes random review of \"([^\"]*)\"$")
    public void user_writes_random_review_of_length(int length) {
        whReviewSubmitPage.writeReview(length);
    }

    @Then("^verify review feed got updated$")
    public void verify_review_feed_got_updated() {
        whReviewSubmitPage.submitReview();
    }

    @Then("^user navigate to profile page$")
    public void user_navigate_to_profile_page() {
        whReviewSubmitPage.clickOnBack();
    }

    @Then("^verify visibility of review\\.$")
    public void verify_visibility_of_review() {
        Assert.assertTrue(whCompanyProfilePage.verifyReview());
    }
}
