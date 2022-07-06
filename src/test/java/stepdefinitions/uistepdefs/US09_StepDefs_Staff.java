package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.staffloginpages.PatientUpdatePage;
import pages.staffloginpages.SearchPatientPage;
import pages.staffloginpages.StaffHomePage;
import utilities.JsUtils;
import utilities.ReusableMethods;

public class US09_StepDefs_Staff {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    StaffHomePage staffHomePage = new StaffHomePage();
    SearchPatientPage searchPatientPage = new SearchPatientPage();
    PatientUpdatePage patientUpdatePage = new PatientUpdatePage();

    @Then("Staff navigates to the sign in page")
    public void staff_navigates_to_the_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();


    }
    @Then("Staff signs in")
    public void staff_signs_in() {
        loginPage.usernameInput.sendKeys("team84staff");
        loginPage.passwordInput.sendKeys("654321");
        loginPage.signInButton.click();
    }
    @Then("Staff clicks on My Pages link")
    public void staff_clicks_on_my_pages_link() {
        ReusableMethods.waitFor(1);
        staffHomePage.myPagesLink.click();
    }

    @Then("Staff clicks on Search Patient link")
    public void staff_clicks_on_search_patient_link() {
        staffHomePage.searchPatientLink.click();
    }
    @Then("Staff enters the patient SSN number")
    public void staff_enters_the_patient_ssn_number() {
        ReusableMethods.waitFor(1);
        searchPatientPage.ssnBox.sendKeys("839-97-7135");
    }
    @Then("Staff clicks on Edit Button")
    public void staff_clicks_on_edit_button() {
        ReusableMethods.waitFor(1);
        JsUtils.clickElementByJS(searchPatientPage.editButton);
    }
    @Then("Staff edits firstname")
    public void staff_edits_firstname() {
        ReusableMethods.waitFor(1);
        patientUpdatePage.firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Ahmet");
    }
    @Then("Staff edits lastname")
    public void staff_edits_lastname() {
        patientUpdatePage.lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Uwu");
    }
    @Then("Staff edits birthdate")
    public void staff_edits_birthdate() {
        WebElement webElement = patientUpdatePage.birthDate;
        patientUpdatePage.birthDate.sendKeys("2000");
        webElement.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("09");
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("06");
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("10");
        ReusableMethods.waitFor(1);
        patientUpdatePage.birthDate.sendKeys("11");
        patientUpdatePage.birthDate.sendKeys("PM");
    }
    @Then("Staff edits email")
    public void staff_edits_email() {
        patientUpdatePage.email.sendKeys(Keys.chord(Keys.CONTROL, "a"), "ahmetuslu@gmail.com");

    }
    @Then("Staff edits phone")
    public void staff_edits_phone() {
        patientUpdatePage.phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), "6869653333");

    }
    @Then("Staff edits gender")
    public void staff_edits_gender() {
        WebElement dropdown = patientUpdatePage.gender;
        Select select = new Select(dropdown);
        select.selectByValue("OTHER");
    }
    @Then("Staff edits blood group")
    public void staff_edits_blood_group() {
        WebElement dropdown = patientUpdatePage.bloodGroup;
        Select select = new Select(dropdown);
        select.selectByValue("ABnegative");
    }
    @Then("Staff edits address")
    public void staff_edits_address() {
        patientUpdatePage.adress.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1953 Beverly Hills CA");
    }
    @Then("Staff edits description")
    public void staff_edits_description() {
        patientUpdatePage.description.sendKeys(Keys.chord(Keys.CONTROL, "a"), "vision lost, dizzy");

    }
    @Then("Staff edits user")
    public void staff_edits_user() {
        WebElement dropdown = patientUpdatePage.user;
        Select select = new Select(dropdown);
        select.selectByValue("3338");
    }
    @Then("Staff edits country")
    public void staff_edits_country() {
        WebElement dropdown = patientUpdatePage.country;
        Select select = new Select(dropdown);
        select.selectByValue("73994");
    }
    @Then("Staff edits state-city")
    public void staff_edits_state_city() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Staff clicks on Save Button")
    public void staff_clicks_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Staff verifies A Patient is updated with identifier <patient Id> message")
    public void staff_verifies_a_patient_is_updated_with_identifier_patient_id_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
