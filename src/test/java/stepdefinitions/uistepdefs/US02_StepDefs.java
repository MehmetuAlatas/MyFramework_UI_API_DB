package stepdefinitions.uistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.awt.image.Kernel;

/*
    by Kadir Tufan
 */
public class US02_StepDefs {
    Faker faker = new Faker();
    RegistrationPage registrationPage;

//    =============================COMMON==============================

    @Given("Go to Medunna url and navigates the register page")
    public void go_to_medunna_url_and_navigates_the_register_page() {
        registrationPage = new RegistrationPage();

        registrationPage.accountMenu.click();
        Driver.wait(1);
        registrationPage.registerMenu.click();
        Driver.wait(1);
    }

    @Then("user click register button")
    public void user_click_register_button() {
        registrationPage = new RegistrationPage();
        Driver.wait(15);
        registrationPage.submitButton.submit();

    }



//  ============================ USERNAME===========================================

    @When("user write {string} on Username Textbox")
    public void user_write_valid_on_snn_text_box(String username) {
        registrationPage=new RegistrationPage();
        registrationPage.usernameTextbox.sendKeys(username);
        registrationPage.usernameTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
    }
    @Then("Assert that Username Label is grey color")
    public void assert_that_username_label_is_grey_color() {
        registrationPage=new RegistrationPage();
        String gerycolor = registrationPage.usernameLabel.getCssValue("color");
        System.out.println("GREY "+gerycolor);
        Assert.assertTrue(gerycolor.contains("rgba(34, 34, 34, 1)"));
    }

    @Then("Assert that Username Label is red color")
    public void assert_that_username_label_is_red_color() {
        registrationPage=new RegistrationPage();
        String color = registrationPage.usernameLabel.getCssValue("color");
        System.out.println("RED "+color);
        Assert.assertTrue(color.contains("rgba(240, 65, 36, 1)"));
    }

//  ============================ PASSWORD===========================================


    @When("user write {string} on Email Textbox")
    public void user_write_on_email_textbox(String email) {
        registrationPage=new RegistrationPage();
        registrationPage.emailTextbox.sendKeys(email);
        registrationPage.emailTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
    }

    @Then("Assert that Email Label is grey color")
    public void assert_that_email_label_is_grey_color() {
        registrationPage=new RegistrationPage();
        String gerycolor = registrationPage.emailLabel.getCssValue("color");
        System.out.println("GREY "+gerycolor);
        Assert.assertTrue(gerycolor.contains("rgba(34, 34, 34, 1)"));
    }

    @Then("Assert that Email Label is red color")
    public void assert_that_email_label_is_red_color() {
        registrationPage=new RegistrationPage();
        String gerycolor = registrationPage.emailLabel.getCssValue("color");
        System.out.println("RED "+gerycolor);
        Assert.assertTrue(gerycolor.contains("rgba(240, 65, 36, 1)"));
    }

//  ============================ REGISTRATION===========================================


    @When("user write {string} on SSN Textbox")
    public void user_write_on_ssn_textbox(String ssn) {
        registrationPage=new RegistrationPage();
        ssn=faker.idNumber().ssnValid();
        registrationPage.ssnBox.sendKeys(ssn);

    }
    @When("user write {string} on First Name Textbox")
    public void user_write_on_first_name_textbox(String firstName) {
        registrationPage=new RegistrationPage();
        firstName=faker.name().firstName();
        registrationPage.firstnameBox.sendKeys(firstName);


    }
    @When("user write {string} on Last Name Textbox")
    public void user_write_on_last_name_textbox(String lastName) {
        registrationPage=new RegistrationPage();
        lastName=faker.name().lastName();
        registrationPage.lastnameBox.sendKeys(lastName);

    }

    @When("user write new {string} on Username Textbox")
    public void user_write_new_on_username_textbox(String login) {
        login=faker.name().username();
        registrationPage.usernameTextbox.sendKeys(login);

    }
    @When("user write new {string} on Email Textbox")
    public void user_write_new_on_email_textbox(String email) {
        registrationPage=new RegistrationPage();
        email=faker.internet().emailAddress();
        System.out.println("EMail: "+email);
        registrationPage.emailTextbox.sendKeys(email);

    }

    @When("user write {string} on New Password Textbox")
    public void user_write_on_new_password_textbox(String password) {
        registrationPage=new RegistrationPage();
        registrationPage.firstPasswordTextbox.sendKeys(password);


    }
    @When("user write {string} on New Password Conformation Textbox")
    public void user_write_on_new_password_conformation_textbox(String password) {
        registrationPage=new RegistrationPage();
        registrationPage.secondPasswordTextbox.sendKeys(password);

    }
    @Then("verify Registration saved message is diplayed")
    public void verify_registration_saved_message_is_diplayed() {
        registrationPage=new RegistrationPage();
        Driver.wait(3);
        Assert.assertTrue(registrationPage.registrationSavedMessage.isDisplayed());

    }
//  ============================ REGISTRATION * IN-USE USERNAME ===========================================



    @When("user write in-use {string} on Username Textbox")
    public void user_write_invalid_on_username_textbox(String username) {
        registrationPage=new RegistrationPage();
        registrationPage.usernameTextbox.sendKeys(username);
//        registrationPage.usernameTextbox.sendKeys(Keys.ENTER);
//        Driver.wait(1);
    }
    @Then("verify username is already registered message is diplayed")
    public void verify_invalid_username_message_is_diplayed() {
        registrationPage=new RegistrationPage();
        Driver.wait(3);
        Assert.assertTrue(registrationPage.usernameAlreadyUsedMessage.isDisplayed());

    }

//  ============================ REGISTRATION * IN-USE EMAIL ===========================================

    @When("user write in-use {string} on Email Textbox")
    public void user_write_in_use_on_email_textbox(String email) {
        registrationPage=new RegistrationPage();
        registrationPage.emailTextbox.sendKeys(email);
    }
    @Then("verify email is already registered message is diplayed")
    public void verify_email_is_already_registered_message_is_diplayed() {
        registrationPage=new RegistrationPage();
        Driver.wait(3);
        Assert.assertTrue(registrationPage.emailAlreadyUsedMessage.isDisplayed());

    }


}





