package stepdefinitions.uistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.LoginPage;
import pages.UserDefaultPage;
import pages.physicianloginpages.InPatientEditPage;
import pages.physicianloginpages.PsInPatientsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.Arrays;
import java.util.List;



public class US14_StepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    UserDefaultPage userDefaultPage = new UserDefaultPage();
    InPatientEditPage inPatientEditPage = new InPatientEditPage();
    PsInPatientsPage psInPatientsPage = new PsInPatientsPage();




// Test Case_001

    @Given("doctor is on the Medunna page")
    public void doctor_is_on_the_medunna_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @When("doctor navigates to sign in page")
    public void doctor_navigates_to_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();
    }

    @When("enters his username {string} and password {string} and clicks sing in")
    public void enters_his_username_and_password_and_clicks_sing_in(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }

    @When("clicks on My Pages segment")
    public void clicks_on_my_pages_segment() {
        ReusableMethods.waitForVisibility(userDefaultPage.myPagesSegment, 1);
       userDefaultPage.myPagesSegment.click();
    }

    @When("clicks on My Inpatients")
    public void clicks_on_my_inpatients() {
        ReusableMethods.waitForVisibility(userDefaultPage.myInpatientsSegment,1);
        userDefaultPage.myInpatientsSegment.click();
    }

    @Then("verifies ID, Start Date, End Date, Status, Description, Created Date, Room, Appointment and Patient visible")
    public void verifies_id_start_date_end_date_status_description_created_date_room_appointment_and_patient_visible()  {

//  Check the table body size to see if there is any patient info(I am checking doctor who has patient can see the info)
        ReusableMethods.waitFor(1);
        int tableBodySize = (psInPatientsPage.tableRowList).size();

        if((tableBodySize < 1)) {
            Assert.assertTrue(false);
            System.out.println("TEST DOES NOT MEET THE PRE-CONDITION: The doctor does not have any inpatients. // TEST CANNOT COMPLETED");

        }else {

//  First condition: get the all section as list, and assert with your expected lis
            List<String> tableHeadText = ReusableMethods.getElementsText(psInPatientsPage.tableHeadList);
            List <String> expectedList = Arrays.asList("ID", "Start Date", "End Date", "Status", "Description", "Created Date","Room", "Appointment", "Patient");
            Assert.assertTrue(tableHeadText.containsAll(expectedList));


//  Second Condition: Check if there are ID for the patients (If there is ID , there is also patient)
            for(WebElement element : psInPatientsPage.tableRowList){
                String patientId = element.findElements(By.xpath("//tr/td")).get(0).getText();
                ReusableMethods.waitFor(1);
                Assert.assertFalse(patientId.isEmpty());
            }
        }
    }





//  Test Case_002

    @When("clicks edit button on Unapproved patients record")
    public void clicks_edit_button_on_Unapproved_patients_record() {


//  Find index of Status section
        ReusableMethods.waitFor(1);
        List<String> tableHeadText = ReusableMethods.getElementsText(psInPatientsPage.tableHeadList);
        int indexOfStatus = tableHeadText.indexOf("Status") + 1;
        System.out.println(indexOfStatus);


//  Find index of Status UNAPPROVED
        List<String> statusColumnText = ReusableMethods.getElementsText(psInPatientsPage.tableBodyList.findElements(By.xpath("//tr//td["+indexOfStatus+"]")));
        int indexOfStatusUnapproved = statusColumnText.indexOf("UNAPPROVED") + 1;


//  Check if you have any unapproved patient, if not stop the test.
       if(!statusColumnText.contains("UNAPPROVED")) {

           Assert.assertFalse(statusColumnText.contains("UNAPPROVED"));
           System.out.println("TEST DOES NOT MEET THE PRE-CONDITION:There is not any patient under status UNAPPROVED // TEST CANNOT COMPLETED");

       } else {

//  Click the edit button whose index same with status UNAPPROVED
           Assert.assertTrue(statusColumnText.contains("UNAPPROVED"));

           String editButtonOnUnapprovedPatientXpath = "(//*[text()='Edit'])[" + indexOfStatusUnapproved + "]";
           psInPatientsPage.editButtonList.get(indexOfStatus).findElement(By.xpath(editButtonOnUnapprovedPatientXpath)).click();

        }
    }


    @When("updates Description, Created Date, and Status and Room for Unapproved Patient")
    public void updates_description_created_date_and_status_and_room_for_unapproved_patient(){

//  Enter info in the description box
        ReusableMethods.waitForVisibility(inPatientEditPage.descriptionInputBox,1);
        inPatientEditPage.descriptionInputBox.clear();
        String description = Faker.instance().medical().diseaseName();
        inPatientEditPage.descriptionInputBox.sendKeys(description);

//  I need the ID of Unapproved patient, for later verification
        String idOfUnapproved = inPatientEditPage.idInputInEditPage.getAttribute("value");
        System.out.println(idOfUnapproved);


//  Click Save Button
        inPatientEditPage.saveButton.click();
        ReusableMethods.waitForVisibility(psInPatientsPage.successMessageAlert,3);
        Assert.assertTrue(psInPatientsPage.successMessageAlert.isDisplayed());


//   Find index of Status section and description section

        ReusableMethods.waitFor(1);
        List<String> tableHeadText = ReusableMethods.getElementsText(psInPatientsPage.tableHeadList);
        System.out.println(tableHeadText);
        int indexOfStatus = tableHeadText.indexOf("Status") + 1;
        System.out.println("index of status" + indexOfStatus);
        int indexOfDescription = tableHeadText.indexOf("Description") + 1;
        System.out.println("index of description" + indexOfDescription);

        int indexOfId = tableHeadText.indexOf("ID") + 1;
        System.out.println("index of ID" + indexOfId);


 // Find the index of ID whose same with the one we make changes on description

    //  Find index of Status UNAPPROVED
        List<String> statusColumnText = ReusableMethods.getElementsText(psInPatientsPage.tableBodyList.findElements(By.xpath("//tr//td["+indexOfStatus+"]")));
        int indexOfStatusUnapproved = statusColumnText.indexOf("UNAPPROVED") + 1;

    //
        List<String> idColumnText = ReusableMethods.getElementsText(psInPatientsPage.tableBodyList.findElements(By.xpath("//tr//td["+indexOfId+"]")));
        int indexOfClickedId = idColumnText.indexOf(idOfUnapproved) + 1;
        System.out.println(indexOfClickedId);

    }


//    @Then("verifies status can be updated with UNAPPROVED, DISCHARGED,STILL STAYING or CANCELLED")
//    public void verifies_status_can_be_updated_with_unapproved_discharged_still_staying_or_cancelled() {
//
//    }
//
//    @Then("clicks save button")
//    public void clicks_save_button() {
//
//    }
//
//    @Then("verifies In Patient is updated message appeared")
//    public void verifies_in_patient_is_updated_message_appeared() {
//
//    }
//
//    @Then("verifies changes are reflected on the patient record")
//    public void verifies_changes_are_reflected_on_the_patient_record() {
//
//    }




}
