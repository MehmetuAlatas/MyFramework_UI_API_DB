package stepdefinitions.uistepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DoctorsPage;
import utilities.Driver;
import utilities.JsUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.Driver.wait2;

public class US13_StepDefs {
    DoctorsPage doctorsPage = new DoctorsPage();
    Actions actions = new Actions(Driver.getDriver());

    @When("Doctor clicks on First Patient Edit button")
    public void doctor_clicks_on_first_patient_edit_button() {

        Driver.waitForClickablility(doctorsPage.edit, 19);
        actions.click(doctorsPage.edit).perform();

        //  Driver.waitForVisibility(doctorsPage.firstEditInpatientsId,17);
        // firstInpatientsId=doctorsPage.firstEditInpatientsId.getText();

    }

    @When("Doctor clicks on Request A Test button")
    public void doctor_clicks_on_request_a_test_button() {

        Driver.waitForClickablility(doctorsPage.requestTest, 10);
        actions.click(doctorsPage.requestTest).perform();


    }

    @When("Doctor selects in Urea, Sodium and diabetes medicine")
    public void doctor_selects_in_urea_sodium_and_diabetes_medicine() {

        Driver.waitForClickablility(doctorsPage.sodium, 10);
        Driver.waitForClickablility(doctorsPage.urea, 10);
        Driver.waitForClickablility(doctorsPage.diabetesMedicine, 10);

        Driver.waitAndClick(doctorsPage.sodium);
        Driver.waitAndClick(doctorsPage.urea);
        Driver.waitAndClick(doctorsPage.diabetesMedicine);

    }

    @When("Verify Test request is saved successfully")
    public void verify_test_request_is_saved_successfully() {
        Driver.waitForVisibility(doctorsPage.testRequestSuccesMessage, 13);
        Assert.assertTrue(doctorsPage.testRequestSuccesMessage.isDisplayed());

    }

    @When("Doctor clicks on Show Test Results button")
    public void doctor_clicks_on_show_test_results_button() {
        Driver.wait(3);
        Driver.waitForClickablility(doctorsPage.showTestResults, 10);
        Driver.waitAndClick(doctorsPage.showTestResults);

    }

    @When("Doctor clicks on first patient view results button")
    public void doctor_clicks_on_first_patient_view_results_button() {
        //Driver.wait(19);
        Driver.waitForClickablility(doctorsPage.viewLastTestResults, 33);
        actions.click(doctorsPage.viewLastTestResults).perform();

    }

    @When("Verify Test results of Urea, Sodium and Diabetes Medicine")
    public void verify_test_results_of_urea_sodium_and_diabetes_medicine() {
        Driver.wait(1);
        List<WebElement> testResultsNames = doctorsPage.testResultsNameList;
        List<String> expectedNames = new ArrayList<>(Arrays.asList("Sodium", "Urea", "diabetes medicine"));

        for (int i = 0; i < testResultsNames.size(); i++) {
            Driver.waitForVisibility(testResultsNames.get(i), 13);
            System.out.println(testResultsNames.get(i).getText());
            Assert.assertEquals(expectedNames.get(i), testResultsNames.get(i).getText());
        }

    }

    @When("Doctor clicks on request Inpatient button")
    public void doctor_clicks_on_request_inpatient_button() {
        Driver.wait(3);
        try {
            Driver.waitForClickablility(doctorsPage.requestInpatient, 33);
            doctorsPage.requestInpatient.click();
        } catch (NoSuchElementException e) {
            Driver.wait(3);
            actions.click(doctorsPage.requestInpatient).perform();
        }


    }

    @When("Doctor verifies the InPatient request done for this appointment")
    public void doctor_verifies_the_in_patient_request_done_for_this_appointment() {
        Driver.wait(3);
        try {
            Driver.waitForVisibility(doctorsPage.oldRequestSuccessMessage, 13);
            Assert.assertTrue(doctorsPage.oldRequestSuccessMessage.isDisplayed());

        } catch (NoSuchElementException e) {
            Driver.waitForVisibility(doctorsPage.newRequestSuccessMessage, 13);
            Assert.assertTrue(doctorsPage.newRequestSuccessMessage.isDisplayed());
        }


    }

    @When("Doctor clicks My Inpatients button")
    public void doctor_clicks_my_inpatients_button() {
        try {
            Driver.waitForClickablility(doctorsPage.myInpatients, 33);
            actions.click(doctorsPage.myInpatients).perform();
        } catch (NoSuchElementException e) {
            JsUtils.clickElementByJS(doctorsPage.myInpatients);
        }


    }

    @When("Doctor Verify the Inpatient is existing")
    public void doctor_verify_the_inpatient_is_existing() {

        WebElement inpatient = doctorsPage.lastlyAddedmyInpatientsId;
        //  Driver.waitForVisibility(inpatient,33);

        for (int i = 0; i < 13; i++) {
            Driver.wait(7);
            try {
                System.out.println("lastlyAddedmyInpatientsId = " + inpatient.getText());
                Assert.assertTrue(inpatient.isDisplayed());
                break;
            } catch (Exception e) {
                wait2(1);
            }

        }
    }










}
