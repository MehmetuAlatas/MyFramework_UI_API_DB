package stepdefinitions.apistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pogos.US01_RegistrantPojo;
import utilities.WriteToTxt;

import java.util.List;

import static io.restassured.RestAssured.given;

public class US01_StepDefs {
    US01_RegistrantPojo requestBody;
    US01_RegistrantPojo actualBody;
    Response response;
    Faker faker;

    @Given("user provides valid body from Swagger")
    public void user_provides_valid_body_from_swagger() {
        faker = new Faker();
        int id = faker.number().randomDigit();
        String login = faker.name().username();
        String ssn = faker.idNumber().ssnValid();
        String fistName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        requestBody = new US01_RegistrantPojo(12, login, true, "", "", "",
                "", ssn, fistName, lastName, "osayli3",
                email, password);
        String requestDataFile = null;
        List<US01_RegistrantPojo> data = null;
        WriteToTxt.saveDataInFileWithRequest(requestBody);
    }

    @Given("user send post request to url {string}")
    public void user_send_post_request_to_url(String url) {
        System.out.println("request body:" + requestBody);
        response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post(url);
        response.prettyPrint();
    }

    @Then("verify status code is {int}")
    public void verify_status_code_is(Integer statusCode) {
        Assert.assertEquals(statusCode, (Integer) response.getStatusCode());
    }

    @Then("assert email, login, firstname, lastname, ssn with given data in body")
    public void assert_email_login_firstname_lastname_ssn_with_given_data_in_body() {
        actualBody = response.as(US01_RegistrantPojo.class);

        Assert.assertEquals(requestBody.getEmail(), actualBody.getEmail());
        Assert.assertEquals(requestBody.getFirstName(), actualBody.getFirstName());
        Assert.assertEquals(requestBody.getLangKey(), actualBody.getLangKey());
        Assert.assertEquals(requestBody.getLastName(), actualBody.getLastName());
        Assert.assertEquals(requestBody.getLangKey(), actualBody.getLangKey());
        Assert.assertEquals(requestBody.getSsn(), actualBody.getSsn());
    }


}
