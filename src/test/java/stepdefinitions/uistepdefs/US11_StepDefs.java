package stepdefinitions.uistepdefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.DoctorsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.GridWebDriver;
import utilities.JsUtils;

import java.net.URL;

public class US11_StepDefs extends GridWebDriver {


    DoctorsPage doctorsPage = new DoctorsPage();


    @Given("Doctor goes to Medunna url")
    public void doctor_goes_to_medunna_url() {
        driver.get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @When("Doctor navigates the sign in page")
    public void doctor_navigates_the_sign_in_page() {
        doctorsPage.signinSymbol.click();
       doctorsPage.signinButton.click();
    }

    @When("Doctor enters his credentials in popup window")
    public void doctor_enters_his_credentials_in_popup_window() {
        doctorsPage.userName.sendKeys("drteam84");
        doctorsPage.password.sendKeys("drteam84");

    }

    @When("Doctor clicks on Sign in button")
    public void doctor_clicks_on_sign_in_button() {

        doctorsPage.signinWithCredentials.click();

    }

    @When("Doctor navigates to My Pages segment")
    public void doctor_navigates_to_my_pages_segment() {

        doctorsPage.myPages.click();
    }

    @When("clicks on My appointments")
    public void clicks_on_my_appointments() {

        doctorsPage.myAppointments.click();
    }

    @When("Doctor clicks on Edit button")
    public void doctor_clicks_on_edit_button() {

        doctorsPage.edit.click();
    }

    @When("Doctor verifies patient's info")
    public void doctor_verifies_patient_s_info() {

        String id = doctorsPage.idPatient.getAttribute("value");
        System.out.println("id = " + id);

        Assert.assertTrue(doctorsPage.idPatient.isDisplayed());

    }

    @When("id, start and end date, status, physician are present")
    public void id_start_and_end_date_status_physician_are_present() {

        String id = doctorsPage.idPatient.getAttribute("value");
        String startDateTime = doctorsPage.startDateTime.getAttribute("value");
        String endTimeText = doctorsPage.startEndTime.getAttribute("value");
        String status = doctorsPage.status.getAttribute("value");
        String physician = doctorsPage.physician.getAttribute("value");

        System.out.println("id = " + id);
        System.out.println("startDateTime = " + startDateTime);
        System.out.println("endTimeText = " + endTimeText);
        System.out.println("status = " + status);
        System.out.println("physician = " + physician);
/**id = 98984
 * startDateTime = 2022-06-27T03:00
 * endTimeText = 2022-06-27T04:00
 * status = CANCELLED
 * physician = CANCELLED
 */
        Assert.assertTrue(doctorsPage.idPatient.isDisplayed());
        Assert.assertTrue(doctorsPage.startDateTime.isDisplayed());
        Assert.assertTrue(doctorsPage.startEndTime.isDisplayed());
        Assert.assertTrue(doctorsPage.status.isDisplayed());
        Assert.assertTrue(doctorsPage.physician.isDisplayed());

    }

    @When("Doctor fills in required fields, anemnesis, treatment, diagnosis")
    public void doctor_fills_in_required_fields_anemnesis_treatment_diagnosis() {
        doctorsPage.anamnesis.clear();
        doctorsPage.treatment.clear();
        doctorsPage.diagnosis.clear();

    }

    @When("Doctor clicks on Save button")
    public void doctor_clicks_on_save_button() {

        JsUtils.scrollIntoViewJS(doctorsPage.saveButton);
        doctorsPage.saveButton.click();

    }

    @When("Verify appointment is saved successfully")
    public void verify_appointment_is_saved_successfully() {

        String message = doctorsPage.succesfullysaved.getText();
        System.out.println("message = " + message);

        Assert.assertTrue(doctorsPage.succesfullysaved.isDisplayed());

    }

    @When("Doctor selects status as UNAPPROVED from dropdown")
    public void doctor_selects_status_as_unapproved_from_dropdown() {
        Assert.assertTrue(doctorsPage.unapproved.isDisplayed());
        Select select = new Select(doctorsPage.statusDropDown);
        select.selectByVisibleText("UNAPPROVED");
    }

    @When("Doctor verifies UNAPPROVED cannot be selectable")
    public void doctor_verifies_unapproved_cannot_be_selectable() {
        Select select = new Select(doctorsPage.statusDropDown);
        select.selectByVisibleText("UNAPPROVED");
        Assert.assertFalse(select.getFirstSelectedOption().getText().contains("UNAPPROVED"));

    }

    @When("Doctor selects status as COMPLETED from dropdown")
    public void doctor_selects_status_as_completed_from_dropdown() {
        Select select = new Select(doctorsPage.statusDropDown);
        select.selectByVisibleText("COMPLETED");

    }

    @When("Doctor leaves blank required fields, anemnesis, treatment, diagnosis")
    public void doctor_leaves_blank_required_fields_anemnesis_treatment_diagnosis() {
        doctorsPage.anamnesis.clear();
        doctorsPage.treatment.clear();
        doctorsPage.diagnosis.clear();


    }

    @When("Doctor verifies This field is required message")
    public void doctor_verifies_message() {
        String expected = "This field is required.";
        for (int i = 0; i < doctorsPage.requiredWarning.size(); i++) {
            System.out.println(doctorsPage.requiredWarning.get(i).getText());
            Driver.waitForVisibility(doctorsPage.requiredWarning.get(i), 3);
            Assert.assertEquals(expected, doctorsPage.requiredWarning.get(i).getText());
        }

    }

    @When("Doctor selects and verify status as {string} from dropdown can selectable")
    public void doctor_selects_status_as_from_dropdown(String status) {
        Driver.waitForVisibility(doctorsPage.statusDropDown, 7);
        Select select = new Select(doctorsPage.statusDropDown);
        select.selectByVisibleText(status);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains(status));


    }

    @When("Doctor leaves blank precription and description")
    public void doctor_leaves_blank_precription_and_description() {
        doctorsPage.prescription.clear();
        doctorsPage.description.clear();
    }

    @When("close the browser")
    public void close_the_browser() {
        Driver.closeDriver();
    }

}
