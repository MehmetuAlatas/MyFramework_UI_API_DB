package stepdefinitions.uistepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import pages.AppointmentPage;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US07_StepDefs {

    AppointmentPage appointmentPage = new AppointmentPage();
    Actions actions = new Actions(Driver.getDriver());
    @Given("user goes to Medunna url")
    public void user_goes_to_medunna_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }

    @Given("user clicks on Get Started button")
    public void user_clicks_on_get_started_button() {

    }

    @Given("user enters valid first name")
    public void user_enters_valid_first_name() {

    }

    @Given("user enters valid last name")
    public void user_enters_valid_last_name() {

    }

    @Given("user enters valid ssn")
    public void user_enters_valid_ssn() {

    }

    @Given("user enters valid email")
    public void user_enters_valid_email() {

    }

    @Given("user enters valid phone number")
    public void user_enters_valid_phone_number() {

    }

    @Given("user enters valid appointment date")
    public void user_enters_valid_appointment_date() {

    }

    @Given("user clicks on Send and Appointment Request")
    public void user_clicks_on_send_and_appointment_request() {

    }

    @Then("verify user can make an appointment successfully")
    public void verify_user_can_make_an_appointment_successfully() {

    }

    @Given("user clicks calendar button on Appointment DateTime box")
    public void user_clicks_calendar_button_on_appointment_date_time_box() {

    }

    @Given("user clicks on clear")
    public void user_clicks_on_clear() {

    }

    @Given("user does not enter any date")
    public void user_does_not_enter_any_date() {

    }

    @Given("user clicks {string}")
    public void user_clicks(String string) {


    }

    @Given("user clicks Send and Appointment Request")
    public void user_clicks_send_and_appointment_request() {

    }

    @Then("verify user can not make an appointment successfully")
    public void verify_user_can_not_make_an_appointment_successfully() {

    }

    @When("user enters a older date")
    public void user_enters_a_older_date() {

    }

    @When("user sees Appointment date can not be past date! warning on date field")
    public void user_sees_appointment_date_can_not_be_past_date_warning_on_date_field() {

    }

    @When("user clicks on today error message")
    public void user_clicks_on_today_error_message() {

    }

    @When("user should not see any error message")
    public void user_should_not_see_any_error_message() {

    }

    @And("user clicksSend and Appointment Request")
    public void userClicksSendAndAppointmentRequest() {
    }

    @And("user enters valid month")
    public void userEntersValidMonth() {
    }

    @And("user enter valid day")
    public void userEnterValidDay() {
    }

    @And("user does not enter year")
    public void userDoesNotEnterYear() {
    }


    @And("verify that user is on day field")
    public void verifyThatUserIsOnDayField() {
    }

    @And("user enters invalid month")
    public void userEntersInvalidMonth() {
    }

    @And("user clicks on up arrow")
    public void userClicksOnUpArrow() {

    }

    @And("verify that user is navigated to previous month")
    public void verifyThatUserIsNavigatedToPreviousMonth() {
    }

    @And("user enters valid future date")
    public void userEntersValidFutureDate() {
    }

    @And("user verifies that correct date is displayed")
    public void userVerifiesThatCorrectDateIsDisplayed() {
    }


    @Then("veridy that usser can see years")
    public void veridyThatUsserCanSeeYears() {
    }

    @When("user clicks on Month\\/Year button")
    public void user_clicks_on_month_year_button() {

    }
    @When("user clicks on next year")
    public void user_clicks_on_next_year() {

    }
    @When("user chooses month")
    public void user_chooses_month() {

    }
    @When("user chooses day")
    public void user_chooses_day() {

    }
    @When("user sees correct choosen month, day, and year")
    public void user_sees_correct_choosen_month_day_and_year() {

    }


    @And("user enter vaid date using forward slash")
    public void userEnterVaidDateUsingForwardSlash() {
        
    }

    @When("user enters letters on date box")
    public void userEntersLettersOnDateBox() {
        
    }

    @And("user does not see any change on date")
    public void userDoesNotSeeAnyChangeOnDate() {



    }

    @When("user enters symbols date box")
    public void userEntersSymbolsDateBox() {
    }

    @Then("user clicks on upper arrow and select older date")
    public void userClicksOnUpperArrowAndSelectOlderDate() {
    }


    @And("user clicks on Month Year button")
    public void userClicksOnMonthYearButton() {
    }
}