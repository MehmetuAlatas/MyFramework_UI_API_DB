package stepdefinitions.uistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.HomePage;
import pages.LoginPage;
import pages.adminloginpages.AdminHomePage;
import pages.adminloginpages.PatientNewPage;
import pages.adminloginpages.PatientPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.*;

public class US15_StepDefs {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminHomePage adminHomePage = new AdminHomePage();
    PatientPage patientPage = new PatientPage();
    PatientNewPage patientNewPage = new PatientNewPage();
    Faker faker = new Faker();
    Actions action = new Actions(Driver.getDriver());

    @Given("Admin goes to Medunna url")
    public void admin_goes_to_medunna_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Then("Admin navigates the sign in page")
    public void admin_navigates_the_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();
    }
    @Then("Admin enters his username {string} and {string} in popup window and clicks sign in button")
    public void admin_enters_his_username_and_in_popup_window_and_clicks_sign_in_button(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }
    @Then("Admin navigates to Items and Titles segment and clicks on patient")
    public void admin_navigates_to_items_and_titles_segment_and_clicks_on_patient() {
        ReusableMethods.waitForVisibility(adminHomePage.itemsAndTitles,5);
        adminHomePage.itemsAndTitles.click();
        adminHomePage.patientDropDown.click();
    }

    @Then("Admin clicks on Create a new Patient button")
    public void admin_clicks_on_create_a_new_patient_button() {
        patientPage.createNewPatient.click();
    }
    @Then("Admin enters All the credentials SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and State")
    public void admin_enters_all_the_credentials_ssn_first_name_last_name_birth_date_phone_gender_blood_group_address_description_created_date_user_country_and_state() {
        patientNewPage.firstNameBox.sendKeys(faker.name().firstName());
        patientNewPage.lastNameBox.sendKeys(faker.name().lastName());
        patientNewPage.birthDatePlaceHolder.sendKeys("1995-07-05 12:30");
        patientNewPage.emailBox.sendKeys(faker.internet().emailAddress());
        patientNewPage.phoneBox.sendKeys("518-230-4587");
        patientNewPage.genderDropDown.sendKeys("FEMALE");
        patientNewPage.bloodGroupDropDown.sendKeys("A-");
        patientNewPage.adressBox.sendKeys(faker.address().streetAddress());
        patientNewPage.descriptionBox.sendKeys("Patient create automated test");
        patientNewPage.userDropDown.click();
        patientNewPage.countryUSA.click();
        ReusableMethods.waitFor(2);
        patientNewPage.stateCA.click();
    }
    @Then("Then click on save button")
    public void then_click_on_save_button() {
        patientNewPage.submitButton.click();
    }
    @Then("Verify new patient created pop up")
    public void verify_new_patient_created_pop_up() {
        ReusableMethods.waitForVisibility(patientPage.createAlert,3);
        System.out.println(patientPage.createAlert.getText());
        Assert.assertTrue(patientPage.createAlert.isDisplayed());
    }


}
