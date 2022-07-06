package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountResetRequestPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US04_StepDefs {


    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountResetRequestPage accountResetRequestPage = new AccountResetRequestPage();

    RegistrationPage registrationPage = new RegistrationPage();

    //@TC_01
    @Given("Firstly user goes to Medunna url")
    public void Firstly_user_goes_to_medunna_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @When("Then user navigates the sign in page")
    public void Then_user_navigates_the_sign_in_page() {
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

    //TC_07
    @When("User enters his or her valid or invalid username {string} and clicks Did you forget your password? button on popup window")
    public void user_enters_his_or_her_valid_or_invalid_username_and_clicks_did_you_forget_your_password_button_on_popup_window(String invalidUsername2) {
        loginPage.usernameInput.sendKeys(invalidUsername2);
        loginPage.forgetPasswordButton.click();
    }
    @When("User does not enter any character to Email box and clicks Reset password button")
    public void user_does_not_enter_any_character_to_email_box_and_clicks_reset_password_button() {
        accountResetRequestPage.resetPasswordButton.click();
    }
    @Then("User verifies there is a caution text under the email box what contains {string}")
    public void user_verifies_there_is_a_caution_text_under_the_email_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(accountResetRequestPage.emailRequirementText,3);
        Assert.assertTrue(accountResetRequestPage.emailRequirementText.isDisplayed());
    }

    //TC_08
    @When("User enters his or her valid or invalid username {string} to username box then clicks Did you forget your password? button on popup window")
    public void user_enters_his_or_her_valid_or_invalid_username_to_username_box_then_clicks_did_you_forget_your_password_button_on_popup_window(String invalidUsername3) {
        loginPage.usernameInput.sendKeys(invalidUsername3);
        loginPage.forgetPasswordButton.click();
    }
    @When("And User enters maximum four characters {string} or less in Email box")
    public void and_user_enters_maximum_four_characters_or_less_in_email_box(String invalidEmail) {
        accountResetRequestPage.resetRequestEmailBox.sendKeys(invalidEmail);
    }
    @When("User clicks Reset password button or anywhere on the page")
    public void user_clicks_reset_password_button_or_anywhere_on_the_page() {
        accountResetRequestPage.resetPasswordButton.click();
    }
    @Then("User verifies there is a warning under the email box what contains {string}")
    public void user_verifies_there_is_a_warning_under_the_email_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(accountResetRequestPage.emailRequiredCharText,3);
        Assert.assertTrue(accountResetRequestPage.emailRequiredCharText.isDisplayed());
    }

    //TC_09
    @When("User enters any username {string} and clicks Did you forget your password? button on popup window")
    public void user_enters_any_username_and_clicks_did_you_forget_your_password_button_on_popup_window(String invalidUsername4) {
        loginPage.usernameInput.sendKeys(invalidUsername4);
        loginPage.forgetPasswordButton.click();
    }
    @Then("User enters five or more characters {string} which is not contains @ and .com, .edu etc. extensions or does not sort those requirements properly")
    public void user_enters_five_or_more_characters_which_is_not_contains_and_com_edu_etc_extensions_or_does_not_sort_those_requirements_properly(String invalidEmail2) {
        accountResetRequestPage.resetRequestEmailBox.sendKeys(invalidEmail2);
    }
    @Then("User clicks Reset password button or anywhere on the Account Reset Request page")
    public void user_clicks_reset_password_button_or_anywhere_on_the_account_reset_request_page() {
        accountResetRequestPage.resetPasswordButton.click();
    }
    @Then("User verifies there is a warn message under the email box what contains {string}")
    public void user_verifies_there_is_a_warn_message_under_the_email_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(accountResetRequestPage.emailInvalidText,3);
        Assert.assertTrue(accountResetRequestPage.emailInvalidText.isDisplayed());
    }

    //TC_10
    @When("User verifies there is a text {string}")
    public void user_verifies_there_is_a_text(String string) {
        ReusableMethods.waitForVisibility(loginPage.isAccountExistYetText,2);
        Assert.assertTrue(loginPage.isAccountExistYetText.isDisplayed());
    }
    @When("User clicks Register a new account button")
    public void user_clicks_register_a_new_account_button() {
        loginPage.registerNewAccountButton.click();
    }
    @When("User verifies there is a text only under the Username box what contains {string}")
    public void user_verifies_there_is_a_text_only_under_the_username_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(loginPage.emptyUsernameWarning,2);
        Assert.assertTrue(loginPage.emptyUsernameWarning.isDisplayed());
    }
    @When("User clicks again Register a new account button")
    public void user_clicks_again_Register_a_new_account_button() {
        loginPage.registerNewAccountButton.click();
    }
    @Then("Verify is User on Registration page with URL")
    public void verify_is_user_on_registration_page_with_url() {
        ReusableMethods.waitForVisibility(registrationPage.registrationTitle,3);
        Assert.assertTrue(registrationPage.registrationTitle.isDisplayed());
    }

    //TC_11
    @When("User verifies there is a clickable Cancel button and clicks button")
    public void user_verifies_there_is_a_clickable_cancel_button_and_clicks_button() {
        ReusableMethods.waitForVisibility(loginPage.cancelButton,2);
        Assert.assertTrue(loginPage.cancelButton.isDisplayed());
        loginPage.cancelButton.click();
    }
    @When("User verifies there is a warn text under the Username box what contains {string}")
    public void user_verifies_there_is_a_warn_text_under_the_username_box_what_contains(String string) {
        ReusableMethods.waitForVisibility(loginPage.emptyUsernameWarning,2);
        Assert.assertTrue(loginPage.emptyUsernameWarning.isDisplayed());
    }
    @When("User clicks again Cancel button")
    public void user_clicks_again_Cancel_button() {
        loginPage.cancelButton.click();
    }
    @Then("User verifies after cancellation right top of the page a dropdown which contains {string} and {string} buttons.")
    public void user_verifies_after_cancellation_right_top_of_the_page_a_dropdown_which_contains_and_buttons(String string, String string2) {
        ReusableMethods.waitForVisibility(homePage.signInClickIcon,3);
        Assert.assertTrue(homePage.signInClickIcon.isDisplayed());
        homePage.signInClickIcon.click();
        ReusableMethods.waitForVisibility(homePage.signInLink,2);
        Assert.assertTrue(homePage.signInLink.isDisplayed());
        ReusableMethods.waitForVisibility(homePage.registerLink,3);
        Assert.assertTrue(homePage.registerLink.isDisplayed());
    }
}


    


