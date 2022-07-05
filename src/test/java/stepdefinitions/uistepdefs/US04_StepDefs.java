package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountResetRequestPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US04_StepDefs {


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountResetRequestPage accountResetRequestPage = new AccountResetRequestPage();

    //@TC_01
    @Given("User goes to Medunna url")
    public void user_goes_to_medunna_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @When("User navigates the sign in page")
    public void user_navigates_the_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();
    }
    @When("User enters his or her valid username {string} and password {string} in popup window")
    public void user_enters_his_her_valid_username_and_password_in_popup_window(String username,String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
    }
    @When("User click to {string} radio button")
    public void user_click_to_radio_button(String string) {
        loginPage.rememberMeRadioButton.click();
    }
    @Then("User clicks {string} button and enter Home page")
    public void user_clicks_button_and_enter_home_page(String string) {
        loginPage.signInButton.click();
    }

    //@TC_02
    @When("User leaves username box blank {string} in popup window then click anywhere on the screen.")
    public void user_leaves_username_box_blank_in_popup_window_then_click_anywhere_on_the_screen(String string) {
        loginPage.usernameInput.sendKeys("");
        loginPage.signInButton.click();
    }

    @Then("User verifies there is a warn text only under the Username box what contains {string}")
    public void user_verifies_there_is_a_warn_text_only_under_the_username_box_what_contains(String text) {
        ReusableMethods.waitForVisibility(loginPage.emptyUsernameWarning, 3);
        Assert.assertTrue(loginPage.emptyUsernameWarning.getText().contains(text));
    }

    //@TC_03
    @When("User enters invalid credentials username {string} password {string} in popup window then click Sign in button.")
    public void user_enters_invalid_credentials_username_lastname_in_popup_window_then_click_sign_in_button(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }

    @When("User verifies there is a temporary alert message on left top of the page")
    public void user_verifies_there_is_a_temporary_alert_message_on_left_top_of_the_page() {
        ReusableMethods.waitForVisibility(loginPage.redLabelWarning, 3);
        Assert.assertTrue(loginPage.redLabelWarning.isDisplayed());
    }

    @Then("User verifies there is an warn text above the Username box what contains: {string}")
    public void user_verifies_there_is_an_warn_text_above_the_username_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsWarning, 3);
        Assert.assertTrue(loginPage.invalidCredentialsWarning.isDisplayed());
    }

    //@TC_04
    @When("User enters his or her valid username {string} then clicks Sign in button without go to the password box")
    public void user_enters_his_or_her_valid_username_then_clicks_sign_in_button_without_go_to_the_password_box(String username) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.signInButton.click();
    }

    @When("User verifies there is a warn text under the Password box what contains {string}")
    public void user_verifies_there_is_a_warn_text_under_the_password_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(loginPage.emptyPasswordWarning, 3);
        Assert.assertTrue(loginPage.emptyPasswordWarning.isDisplayed());

    }

    @When("User verifies there is a warn text above the Username box what contains: {string}")
    public void user_verifies_there_is_a_warn_text_above_the_username_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsWarning, 3);
        Assert.assertTrue(loginPage.invalidCredentialsWarning.isDisplayed());
    }

    @Then("User verifies there is a temporary alert message because of blank password box on left top of the page")
    public void user_verifies_there_is_a_temporary_alert_message_because_of_blank_password_box_on_left_top_of_the_page() {
        ReusableMethods.waitForVisibility(loginPage.redLabelWarning, 3);
        Assert.assertTrue(loginPage.redLabelWarning.isDisplayed());
    }

    //@TC_05
    @When("User enters his or her valid username {string} but does not enter valid password {string} in popup window then click Sign in button.")
    public void user_enters_his_or_her_valid_username_but_does_not_enter_valid_password_in_popup_window_then_click_sign_in_button(String username, String invalidPassword) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(invalidPassword);
        loginPage.signInButton.click();
    }

    @When("User verifies when password invalid there is a warn text above the Username box what contains: {string}")
    public void user_verifies_when_password_invalid_there_is_a_warn_text_above_the_username_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(loginPage.invalidCredentialsWarning, 3);
        Assert.assertTrue(loginPage.invalidCredentialsWarning.isDisplayed());
    }

    @When("User verifies there is a temporary alert message after invalid password on left top of the page")
    public void user_verifies_there_is_a_temporary_alert_message_after_invalid_password_on_left_top_of_the_page() {
        ReusableMethods.waitForVisibility(loginPage.redLabelWarning, 3);
        Assert.assertTrue(loginPage.redLabelWarning.isDisplayed());
    }

    //TC_06
    @When("User enters his or her valid or invalid username {string} to username box and clicks Did you forget your password? button on popup window")
    public void user_enters_his_or_her_valid_or_invalid_username_to_username_box_and_clicks_did_you_forget_your_password_button_on_popup_window(String invalidUsername) {
        loginPage.usernameInput.sendKeys(invalidUsername);
        loginPage.forgetPasswordButton.click();
    }

    @When("User enters a valid email address {string} which is required @ and .com, .edu etc. extensions and requires at least five characters into the email box.")
    public void user_enters_a_valid_email_address_which_is_required_and_com_edu_etc_extensions_and_requires_at_least_characters_into_the_email_box(String validEmail) {
        accountResetRequestPage.resetRequestEmailBox.sendKeys(validEmail);
    }

    @When("User clicks Reset password button")
    public void user_clicks_button() {
        accountResetRequestPage.resetPasswordButton.click();
    }

    @Then("User verifies there is a temporary alert message on left top of the webpage what contains {string}")
    public void user_verifies_there_is_a_temporary_alert_message_on_left_top_of_the_webpage_what_contains(String string) {
        ReusableMethods.waitForVisibility(accountResetRequestPage.greenLabelMessage, 3);
        Assert.assertTrue(accountResetRequestPage.greenLabelMessage.isDisplayed());
    }


}


    


