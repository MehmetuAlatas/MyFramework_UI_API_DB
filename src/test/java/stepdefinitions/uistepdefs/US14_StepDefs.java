package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import pages.UserDefaultPage;
import pages.physicianloginpages.PsInPatientsPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.Arrays;
import java.util.List;



public class US14_StepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    UserDefaultPage userDefaultPage =new UserDefaultPage();
    PsInPatientsPage psInPatientsPage = new PsInPatientsPage();



// Test Case001

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
        ReusableMethods.waitForVisibility(userDefaultPage.myPagesSegment, 3);
       userDefaultPage.myPagesSegment.click();
    }

    @When("clicks on My Inpatients")
    public void clicks_on_my_inpatients() {
        ReusableMethods.waitForVisibility(userDefaultPage.myInpatientsSegment,3);
        userDefaultPage.myInpatientsSegment.click();
    }

    @Then("verifies ID, Start Date, End Date, Status, Description, Created Date, Room, Appointment and Patient visible")
    public void verifies_id_start_date_end_date_status_description_created_date_room_appointment_and_patient_visible()  {

// First condition: get the all section as list, and assert with your expected list
        ReusableMethods.waitFor(1);
        List<WebElement> tableHead = Driver.getDriver().findElements(By.xpath("//*[@class='table']/thead/tr/th"));
        List<String> tableHeadText = ReusableMethods.getElementsText(tableHead);
        List <String> expectedList = Arrays.asList("ID", "Start Date", "End Date", "Status", "Description", "Created Date","Room", "Appointment", "Patient");
        Assert.assertTrue(tableHeadText.containsAll(expectedList));

//Second Condition: Check the tablebody size to see if there is any patient info(I am checking doctor who has patient can see the info)
        List<WebElement> tableBody = Driver.getDriver().findElements(By.xpath("//*[@class='table']/tbody/tr"));
        Assert.assertTrue(tableBody.size() > 0);

//Third Condition: Check if there are ID for the patients (If there is ID , there is also patient)
        for(WebElement element : tableBody){
            String patientId = element.findElements(By.xpath("//tr/td")).get(0).getText();
            Assert.assertFalse(patientId.isEmpty());
        }
    }



//    Test Case002

    @When("clicks edit button on Unapproved patients record")
    public void clicks_edit_button_on_Unapproved_patients_record() {


//  Find index of Status section
        ReusableMethods.waitFor(1);
        List<WebElement> tableHead = Driver.getDriver().findElements(By.xpath("//*[@class='table']/thead/tr/th"));
        List<String> tableHeadText = ReusableMethods.getElementsText(tableHead);
        int indexOfStatus = tableHeadText.indexOf("Status") + 1;

//  Find index of Status UNAPPROVED
        List<WebElement> statusColumn = Driver.getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr//td["+indexOfStatus+"]"));
        List<String> statusColumnText = ReusableMethods.getElementsText(statusColumn);
        int indexOfStatusUnapproved = statusColumnText.indexOf("UNAPPROVED") + 1;


        if(!statusColumnText.contains("UNAPPROVED")) {
            System.out.println("TEST CANNOT COMPLETED!  !!! There is not any patient under status UNAPPROVED !!!");
        } else {

//  Click the edit button whose index same with status UNAPPROVED
            List<WebElement> editButtonList = Driver.getDriver().findElements(By.xpath("//table[@class='table']//tbody//tr//td[last()]"));
            editButtonList.get(indexOfStatus).findElement(By.xpath("(//*[text()='Edit'])[" + indexOfStatusUnapproved + "]")).click();
        }

    }



//    @When("updates ID, Start Date, End Date, Status, Description, Created Date, Room, Appointment and Patient")
//    public void updates_id_start_date_end_date_status_description_created_date_room_appointment_and_patient() {
//
//    }
//
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
