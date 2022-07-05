package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US01_StepDefs {
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user navigates to Medunna url")
    public void user_navigates_to_medunna_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @Given("user navigates the registration page")
    public void user_navigates_the_registration_page() {
        registrationPage.homepageDropdown.click();
        registrationPage.registrationLink.click();
    }

    @Then("user provides valid ssn {string} number")
    public void user_provides_valid_ssn_number(String ssn) {
        registrationPage.ssnBox.sendKeys(ssn + Keys.ENTER);

    }

    @Then("user should not see the error message Your SSN is required or Your SSN is invalid")
    public void user_should_not_see_the_error_message_your_ssn_is_required_or_your_ssn_is_invalid() {
        String ssnBoxAttribute = registrationPage.ssnBox.getAttribute("class");
        Assert.assertFalse(ssnBoxAttribute.contains("invalid"));

    }

    @Then("user provides invalid ssn {string} number")
    public void user_provides_invalid_ssn_number(String ssn) {
        registrationPage.ssnBox.sendKeys(ssn + Keys.ENTER);
    }

    @Then("user should see the error message Your SSN is invalid")
    public void user_should_see_the_error_message_your_ssn_is_invalid() {
        Assert.assertTrue(registrationPage.invalidSsnMessage.isDisplayed());
    }

    @Then("user leaves ssn box blank")
    public void user_leaves_ssn_box_blank() {
        registrationPage.ssnBox.sendKeys("" + Keys.ENTER);
    }

    @Then("user should see the error message Your SSN is required.")
    public void user_should_see_the_error_message_your_ssn_is_required() {
        Assert.assertEquals("Your SSN is required.", registrationPage.blankSsnMessage.getText());
    }

    @Then("user provides valid firstname {string} that contains any chars")
    public void user_provides_valid_firstname_that_contains_any_chars(String firstname) {
        registrationPage.firstnameBox.sendKeys(firstname + Keys.ENTER);
    }

    @Then("user should not see the error message Your FirstName is required.")
    public void user_should_not_see_the_error_message_your_first_name_is_required() {
        String firstnameBoxAttribute = registrationPage.firstnameBox.getAttribute("class");
        Assert.assertFalse(firstnameBoxAttribute.contains("invalid"));
    }

    @Then("user leaves firstname box blank")
    public void user_leaves_firstname_box_blank() {
        registrationPage.firstnameBox.sendKeys("" + Keys.ENTER);
    }

    @Then("user should see the error message Your FirstName is required.")
    public void user_should_see_the_error_message_your_first_name_is_required() {
        Assert.assertTrue(registrationPage.blankFirstnameMessage.isDisplayed());
    }

    @Then("user provides valid lastname {string} that contains any chars")
    public void user_provides_valid_lastname_that_contains_any_chars(String lastname) {
        registrationPage.lastnameBox.sendKeys(lastname + Keys.ENTER);
    }

    @Then("user should not see the error message Your LastName is required.")
    public void user_should_not_see_the_error_message_your_last_name_is_required() {
        String lastnameBoxAttribute = registrationPage.lastnameBox.getAttribute("class");
        Assert.assertFalse(lastnameBoxAttribute.contains("invalid"));
    }

    @Then("user leaves lastname box blank")
    public void user_leaves_lastname_box_blank() {
        registrationPage.lastnameBox.sendKeys("" + Keys.ENTER);
    }

    @Then("user should see the error message Your LastName is required.")
    public void user_should_see_the_error_message_your_last_name_is_required() {
        Assert.assertTrue(registrationPage.blankLastnameMessage.isDisplayed());
    }


}
