package stepDefinition;

import Utilities.Common;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.FacebookLoginPage;

import java.util.logging.Logger;

public class FacebookSteps extends Common {
    FacebookLoginPage fbPage = null;
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Given("^user navigate to facebook application$")
    public void user_navigate_to_facebook_application() {
        fbPage = new FacebookLoginPage();
        fbPage.navigateToFacebookPage();
        Assert.assertEquals("[www.facebook.com/]", getHtmlPageName());
        logger.info("user navigated to facebook page.");
    }

    @When("^user login facebook with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_with_username_and_password(String username, String password) {
        fbPage.loginIntoFacebook(username, password);
        Assert.assertEquals("[www.facebook.com/]",getHtmlPageName());
        logger.info("user logged into facebook.");
    }

    @Then("^user post message \"([^\"]*)\"$")
    public void user_post_message(String message) {
        logger.info(message);
    }
}
