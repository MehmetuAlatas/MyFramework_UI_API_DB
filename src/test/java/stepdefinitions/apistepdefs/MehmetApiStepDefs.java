package stepdefinitions.apistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pojos.MehmetPojo;
import pojos.US01_RegistrantPojo;
import utilities.ConfigurationReader;
import utilities.MehmetWriter;
import utilities.WriteToTxt;

import java.util.List;

import static hooks.Hooks.spec;


import static io.restassured.RestAssured.*;

import static utilities.Authentication.generateToken;
import static utilities.MehmetWriter.savingUiRegistrant;

public class MehmetApiStepDefs {
    Response response;
    MehmetPojo mehmetPojo;
    MehmetPojo[] mehmetPojos;
    US01_RegistrantPojo data;

    @Given("user sends a get request for users data")
    public void user_sends_a_get_request_for_users_data() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().get(ConfigurationReader.getProperty("mehmet_registrant_endpoint"));
        //response.prettyPeek();


    }

    @Given("user deserializes the users data to java")
    public void user_deserializes_the_users_data_to_java() throws Exception {

        ObjectMapper obj = new ObjectMapper();

        mehmetPojos = obj.readValue(response.asString(), MehmetPojo[].class);
        System.out.println("mehmetPojos.length = " + mehmetPojos.length);
        boolean flag=false;
        for (int i = 0; i <mehmetPojos.length ; i++) {
           // System.out.println(mehmetPojos [i].getFirstName() +" "+mehmetPojos[i].getLastName());
            if("147-25-0613".contains(mehmetPojos[i].getSsn())){
                flag=true;
            }
        }
        Assert.assertTrue(flag);


    }

    @Then("user saves the users data to correspondent files and validates")
    public void user_saves_the_users_data_to_correspondent_files_and_validates() {

        savingUiRegistrant(mehmetPojos);

    }


    @Given("user sends a post request for create a new user")
    public void user_sends_a_put_request_for_update_the_user() {
       //set the url
        spec.pathParams("first","api","second","register");
        //set the expected data

       Faker faker=new Faker();
        int id=faker.number().randomDigit();
        String login=faker.name().username();
        String ssn=faker.idNumber().ssnValid();
        String fistName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email=faker.internet().emailAddress();
        String password=faker.internet().password();
         data=new US01_RegistrantPojo(12,login, true,"","","",
                "",ssn,fistName,lastName,"osayli3",
                email,password);

    }
    @Given("user deserializes the response to java")
    public void user_deserializes_the_response_to_java() {
        //send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(data).when().post("/{first}/{second}");

        response.prettyPeek();
        //do validation
        US01_RegistrantPojo actual =  response.as(US01_RegistrantPojo.class);
        Assert.assertEquals(data.getLangKey(),actual.getLangKey());
        Assert.assertEquals(data.getFirstName(),actual.getFirstName());
        Assert.assertEquals(data.getLastName(),actual.getLastName());
        Assert.assertEquals(data.getSsn(),actual.getSsn());
        Assert.assertEquals(data.getEmail(),actual.getEmail());
    }

    @Then("user saves the users data to correspondent files")
    public void user_saves_the_users_data_to_correspondent_files() {
        MehmetWriter.savingApiRegistrant(data);
    }


}
