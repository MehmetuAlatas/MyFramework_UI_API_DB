package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPasswordPage;
import pages.AccountSettingsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US06_StepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AccountSettingsPage accountSettingsPage = new AccountSettingsPage();

    @Given("User goes to Medunna url")
    public void user_goes_to_medunna_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @When("User navigates the sign in page")
    public void user_navigates_the_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();
    }
    @When("user sends username {string}")
    public void user_sends_username(String userName) {
        loginPage.usernameInput.sendKeys(userName);
    }
    @When("user sends password {string}")
    public void user_sends_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }
    @Then("user clicks Sign in button")
    public void user_clicks_sign_in_button() {
    loginPage.signInButton.click();
    }
    @Then("verify sign in success")
    public void verify_sign_in_success() {
        Assert.assertFalse(loginPage.userProfile.getText().isEmpty());
    }
    @Then("user clicks on user profile")
    public void user_clicks_on_user_profile() {
    loginPage.userProfile.click();
    }
    @Then("navigates and click Settings from dropdown list")
    public void navigates_and_click_settings_from_dropdown_list() {
    loginPage.dropdownSettings.click();
    }
    @Then("Verify firstname populated")
    public void verify_firstname_populated() {
    Assert.assertTrue(accountSettingsPage.userProfile.getText().contains(accountSettingsPage.userFirstName.getText()));
    }
    @Then("Verify lastname populated")
    public void verify_lastname_populated() {
    Assert.assertTrue(accountSettingsPage.userProfile.getText().contains(accountSettingsPage.userLastname.getText()));
    }
    @Then("Verify email populated")
    public void verify_email_populated() {
    Assert.assertTrue(accountSettingsPage.userEmail.isDisplayed());
    }
    @Then("Verify language populated")
    public void verify_language_populated() {
    Assert.assertTrue("US06_TC01_Language Segment NOT populated",false);
    }
    @Then("User sign out")
    public void user_sign_out() {
    accountSettingsPage.dropdownSignOut.click();
    }
    @Then("Close application")
    public void close_application() {
    Driver.closeDriver();
    }

}
