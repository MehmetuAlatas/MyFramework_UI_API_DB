package stepdefinitions.uistepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.UserDefaultPage;
import pages.physicianloginpages.PhysicianAppointmentPage;
import pages.physicianloginpages.PsInPatientsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US10_StepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    UserDefaultPage userDefaultPage =new UserDefaultPage();
    PhysicianAppointmentPage physicianAppointmentPage = new PhysicianAppointmentPage();


    @Given("user launches the browser and navigates to url")
    public void user_launches_the_browser_and_navigates_to_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }


    @When("user navigates to sign in page")
    public void user_navigates_to_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();


    }


    @Then("user types username as {string}")
    public void user_types_username_as(String username) {
        loginPage.usernameInput.sendKeys(username);

    }


    @Then("user types password as {string}")
    public void user_types_password_as(String password) {
        loginPage.passwordInput.sendKeys(password);
    }


    @Then("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        loginPage.signInButton.click();
    }


    @Then("user clicks on my page")
    public void user_clicks_on_my_page() {
        ReusableMethods.waitForVisibility(userDefaultPage.myPagesSegment, 3);
        userDefaultPage.myPagesSegment.click();

    }


    @Then("user clicks on my appointments")
    public void user_clicks_on_my_appointments() {
        ReusableMethods.waitForVisibility(userDefaultPage.myAppointmentsSegment, 3);
        userDefaultPage.myAppointmentsSegment.click();

    }


    @Then("user verifies appointments list")
    public void user_verifies_appointments_list() {
        List <String> l = ReusableMethods.getElementsText((List<WebElement>) physicianAppointmentPage.myAppointmentsTableList);
        System.out.println(l);

    }


    @Then("user verifies time slots")
    public void user_verifies_time_slots() {

    }












}
