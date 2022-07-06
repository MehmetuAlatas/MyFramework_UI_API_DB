package stepdefinitions.uistepdefs;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Mehmet;
import pojos.MehmetPojo;
import utilities.Driver;
import utilities.MehmetWriter;

import static utilities.MehmetWriter.savingUiRegistrant;

public class MehmetStepDefs {

    MehmetPojo mehmetPojo = new MehmetPojo();
    Mehmet mehmet = new Mehmet();
    Faker faker = new Faker();

    @Given("user provides their ssn id as {string}")
    public void user_provides_their_ssn_id_as(String ssn) {
       ssn = faker.idNumber().ssnValid();
        Driver.waitAndSendText(mehmet.ssnBox,ssn);
        mehmetPojo.setSsn(ssn);
    }
    @Given("user provides their firstname as {string}")
    public void user_provides_their_firstname_as(String firstname) {
        firstname = faker.name().firstName();
        Driver.waitAndSendText(mehmet.firstnameBox,firstname);
        mehmetPojo.setFirstName(firstname);
    }
    @Given("user provides their lastname as {string}")
    public void user_provides_their_lastname_as(String lastname) {
        lastname = faker.name().lastName();
        Driver.waitAndSendText(mehmet.lastnameBox,lastname);
        mehmetPojo.setLastName(lastname);
    }
    @Given("user provides their username as {string}")
    public void user_provides_their_username_as(String username) {
        username = faker.name().username();
        Driver.waitAndSendText(mehmet.usernameTextbox,username);
        mehmetPojo.setLogin(username);
    }
    @Given("user provides their email as {string}")
    public void user_provides_their_email_as(String email) {
        email = faker.internet().emailAddress();
        Driver.waitAndSendText(mehmet.emailTextbox,email);
        mehmetPojo.setEmail(email);
    }
    @Given("user provides their password as {string}")
    public void user_provides_their_password_as(String password) {
        password = faker.internet().password(8,20,true,true);
        Driver.waitAndSendText(mehmet.firstPasswordTextbox,password);
        mehmetPojo.setPassword(password);
    }
    @Given("user types their password confirmatino as {string}")
    public void user_types_their_password_confirmatino_as(String passwordcnfirm) {
        passwordcnfirm = mehmetPojo.getPassword();
        Driver.waitAndSendText(mehmet.newPasswordConfirmationLabel,passwordcnfirm);
        mehmetPojo.setPassword(passwordcnfirm);
    }
    @Then("user registers and saves the records")
    public void user_registers_and_saves_the_records() {
        Driver.waitAndClick(mehmet.submitButton);
        Driver.sleep(1000);
        Assert.assertTrue(mehmet.registrationSavedMessage.isDisplayed());
        savingUiRegistrant(mehmetPojo);
    }

}
