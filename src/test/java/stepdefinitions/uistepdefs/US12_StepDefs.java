package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserDefaultPage;
import pages.physicianloginpages.PhysicianAppointmentPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US12_StepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    UserDefaultPage userDefaultPage =new UserDefaultPage();
    PhysicianAppointmentPage physicianAppointmentPage = new PhysicianAppointmentPage();

    @Then("user clicks on edit button")
    public void user_as_doctor_clicks_on_edit_button() {
        physicianAppointmentPage.appointmentEditButton.click();

    }


    @Then("user clicks on Request a test")
    public void user_clicks_on_request_a_test() {

    }


    @Then("user verifies test types Urea, Creatinine, Sodium Potassium, Total protein, Albumin, Hemoglobin")
    public void user_verifies_test_types_urea_creatinine_sodium_potassium_total_protein_albumin_hemoglobin() {

    }


    @Then("user clicks on the  Urea checkbox")
    public void user_clicks_on_the_urea_checkbox() {

    }


    @Then("user clicks on the  Creatinine checkbox")
    public void user_clicks_on_the_creatinine_checkbox() {

    }


    @Then("user clicks on the  Sodium checkbox")
    public void user_clicks_on_the_sodium_checkbox() {

    }


    @Then("user clicks on the  Potassium checkbox")
    public void user_clicks_on_the_potassium_checkbox() {

    }


    @Then("user clicks on the  Total Protein checkbox")
    public void user_clicks_on_the_total_protein_checkbox() {

    }


    @Then("user clicks on the Albumin checkbox")
    public void user_clicks_on_the_albumin_checkbox() {

    }


    @Then("user clicks on the  Hemoglobin checkbox")
    public void user_clicks_on_the_hemoglobin_checkbox() {

    }


    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {

    }


    @Then("user verifies a new Test is created with identifier <id>\" message")
    public void user_verifies_a_new_test_is_created_with_identifier_id_message() {

    }



}
