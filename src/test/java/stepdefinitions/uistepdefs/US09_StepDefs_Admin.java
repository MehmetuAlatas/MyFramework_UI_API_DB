package stepdefinitions.uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;
import pages.adminloginpages.AdminHomePage;
import pages.adminloginpages.PatientEditPage;
import pages.adminloginpages.PatientPage;
import pages.adminloginpages.PatientPageSortIdPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.JsUtils;
import utilities.ReusableMethods;

public class US09_StepDefs_Admin {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminHomePage adminHomePage = new AdminHomePage();
    PatientPage patientPage = new PatientPage();
    PatientEditPage patientEditPage = new PatientEditPage();
    PatientPageSortIdPage patientPageSortIdPage = new PatientPageSortIdPage();

    //US09_TC001

    @Given("Launch browser and navigate to medunna.com")
    public void launch_browser_and_navigate_to_medunna_com() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Then("Admin navigates to the sign in page")
    public void admin_navigates_the_sign_in_page() {
        homePage.signInClickIcon.click();
        homePage.signInLink.click();
    }
    @Then("Admin signs in")
    public void admin_signs_in() {
        loginPage.usernameInput.sendKeys("vusalgasimov");
        loginPage.passwordInput.sendKeys("vusalgasimov");
        loginPage.signInButton.click();
    }
    @Then("Admin clicks to items&title link")
    public void admin_clicks_to_items_title_link() {
        ReusableMethods.waitForClickablility(adminHomePage.itemsAndTitles, 3);
        adminHomePage.itemsAndTitles.click();

    }
    @Then("Admin clicks on Patient link")
    public void admin_clicks_on_patient_link() {
        adminHomePage.patientDropDown.click();
    }
    @Then("Admin verifies he-she is on Patient page")
    public void admin_verifies_he_she_is_on_patient_page() {
        ReusableMethods.waitForVisibility(patientPage.patientTitle, 3);
        Assert.assertTrue(patientPage.patientTitle.isDisplayed());
    }
    @Then("Admin clicks on »» to go to the last page")
    public void admin_clicks_on_to_go_to_the_last_page() {
        JsUtils.clickElementByJS(Driver.getDriver().findElement(By.xpath("(//a[@href='javascript:void(0)'])[8]")));
    }

    @Then("Admin clicks on ID")
    public void admin_clicks_on_id() {
        //ReusableMethods.waitForVisibility(Driver.getDriver().findElement(By.xpath("//*[contains(text(),'107939')]")), 3);
        ReusableMethods.waitFor(2);
        JsUtils.clickElementByJS(Driver.getDriver().findElement(By.xpath("//*[contains(text(),'107939')]")));
    }
    @Then("Admin clicks on Edit Button")
    public void admin_clicks_on_edit_button() {
        ReusableMethods.waitForVisibility(patientPage.editButton, 3);
        JsUtils.clickElementByJS(Driver.getDriver().findElement(By.xpath("//*[text()='Edit']")));
        //patientPage.editButton.click();
    }

    @Then("Admin edits firstname")
    public void admin_edits_firstname() {
        ReusableMethods.waitForVisibility(patientEditPage.firstName, 3);
        patientEditPage.firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Ahmet");
        //  patientEditPage.firstName.sendKeys("Ahmet");

    }
    @Then("Admin edits lastname")
    public void admin_edits_lastname() {

        patientEditPage.lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Uwu");
    }

    @Then("Admin edits birthdate")
    public void admin_edits_birthdate() {

        WebElement webElement = patientEditPage.birthDate;
        patientEditPage.birthDate.sendKeys("2000");
        webElement.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(1);
        patientEditPage.birthDate.sendKeys("09");
        ReusableMethods.waitFor(1);
        patientEditPage.birthDate.sendKeys("06");
        ReusableMethods.waitFor(1);
        patientEditPage.birthDate.sendKeys("10");
        ReusableMethods.waitFor(1);
        patientEditPage.birthDate.sendKeys("11");
        patientEditPage.birthDate.sendKeys("PM");


    }
    @Then("Admin edits email")
    public void admin_edits_email() {
        patientEditPage.email.sendKeys(Keys.chord(Keys.CONTROL, "a"), "ahmetuslu@gmail.com");
    }
    @Then("Admin edits phone")
    public void admin_edits_phone() {

        patientEditPage.phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), "6869653333");
    }
    @Then("Admin edits gender")
    public void admin_edits_gender() {
        WebElement dropdown = patientEditPage.gender;
        Select select = new Select(dropdown);
        select.selectByValue("OTHER");

    }
    @Then("Admin edits blood group")
    public void admin_edits_blood_group() {
        WebElement dropdown = patientEditPage.bloodGroup;
        Select select = new Select(dropdown);
        select.selectByValue("ABnegative");
    }
    @Then("Admin edits address")
    public void admin_edits_address() {
        patientEditPage.adress.sendKeys(Keys.chord(Keys.CONTROL, "a"), "1953 Beverly Hills CA");
    }
    @Then("Admin edits description")
    public void admin_edits_description() {
        patientEditPage.description.sendKeys(Keys.chord(Keys.CONTROL, "a"), "vision lost, dizzy");

    }
    @Then("Admin edits user")
    public void admin_edits_user() {
        WebElement dropdown = patientEditPage.user;
        Select select = new Select(dropdown);
        select.selectByValue("3338");
    }
    @Then("Admin edits country")
    public void admin_edits_country() {
        WebElement dropdown = patientEditPage.country;
        Select select = new Select(dropdown);
        select.selectByValue("73994");
    }
//    @Then("Admin edits state-city")
//    public void admin_edits_state_city() {
//        WebElement dropdown = patientEditPage.cstate;
//        Select select = new Select(dropdown);
//        select.selectByIndex(1);
//    }
    @Then("Admin clicks on Save Button")
    public void admin_clicks_on_save_button() {
        ReusableMethods.waitFor(2);
        JsUtils.clickElementByJS(patientEditPage.saveButton);
    }

    @Then("Admin verifies A Patient is updated with identifier <patient Id> message")
    public void admin_verifies_a_patient_is_updated_with_identifier_patient_id_message() {
        ReusableMethods.waitForVisibility(patientEditPage.alertText, 1);
        String actualText = patientEditPage.alertText.getText();
        String expectedText = "A Patient is updated with identifier 107939";
        Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue(patientEditPage.alertText.isDisplayed());
    }

    //@TC02_Admin_Delete_Patient

    @Then("Admin clicks on Delete Button")
    public void admin_clicks_on_delete_button() {
        ReusableMethods.waitForVisibility(patientPageSortIdPage.deleteButton, 3);
        JsUtils.clickElementByJS(patientPageSortIdPage.deleteButton);
    }

    @Then("Admin clicks on pop ups delete button")
    public void admin_clicks_on_pop_ups_delete_button() {
        patientPageSortIdPage.popUpDelete.click();
    }

    @Then("Admin verifies A Patient is deleted with identifier <patient Id> message")
    public void admin_verifies_a_patient_is_deleted_with_identifier_patient_id_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //@TC03_Admin_Verify_NoSearch

    @Then("Admin verifies that there is no search patient section")
    public void admin_verifies_that_there_is_no_search_patient_section() {

    }



}
