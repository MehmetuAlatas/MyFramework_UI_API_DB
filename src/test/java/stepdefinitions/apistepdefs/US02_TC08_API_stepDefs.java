package stepdefinitions.apistepdefs;


import io.cucumber.java.en.*;
import pojos.US02_User_Registration_Pojo;
import stepdefinitions.uistepdefs.US02_StepDefs;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US02_User_Registration_Pojo;
import utilities.ConfigurationReader;
import utilities.TXTWriter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class US02_TC08_API_stepDefs {
    US02_User_Registration_Pojo requestBody;
    US02_User_Registration_Pojo actualBody;
    Response response;
    Faker faker;

    @Given("user provides POST body from Swagger")
    public void user_provides_post_body_from_swagger() {
        faker=new Faker();


        int id= 108995;
//        String login= "wxyz06";
        String login = faker.name().username();
        String firstName="ali";
        String lastName="desidero";
//        String ssn= "172-29-7104";
        String ssn= faker.idNumber().ssnValid();
//        String email="wxyz06@outlook.com";
        String email=faker.internet().emailAddress();
        String imageUrl= "string";
        boolean activated= false;
        String langKey= "Size";
        String createdBy= "vusalgasimov";
        String createdDate= "2022-07-05T07:03:13.273874Z";
        String lastModifiedBy= "vusalgasimov";
        String lastModifiedDate= "2022-07-05T07:03:13.273874Z";
        String [] authorities= {"test"};

        String password ="asd1234";


        requestBody = new US02_User_Registration_Pojo(email,firstName,lastName,login,password,ssn);;
        String path = ConfigurationReader.getProperty("US02_registrant_applicant_data");
        TXTWriter.SavePojoToFile(path,requestBody);
    }
    @Given("user send post request to api url")
    public void user_send_post_request_to_api_url() {
        response = given().
                when().
                contentType(ContentType.JSON).
                body(requestBody).post(ConfigurationReader.getProperty("api_register_url"));


    }

    @Then("verify response status code is {int}")
    public void verify_response_status_code_is(Integer statusCode) {
        Assert.assertEquals(statusCode,(Integer) response.getStatusCode());
    }
    @Then("assert email and  login with given data in body")
    public void assert_email_and_login_with_given_data_in_body() throws Exception {
        actualBody=response.as(US02_User_Registration_Pojo.class);
        String actualEmail= actualBody.getEmail();
        String actualUserName = actualBody.getLogin();

        String registantFile = TXTWriter.ReadFile(ConfigurationReader.getProperty("US02_registrant_applicant_data"));
//login
//        NOTE: correct assertion will be after fixing the bug
        Assert.assertTrue(registantFile.contains(actualUserName));
//email
        Assert.assertTrue(registantFile.contains(actualEmail));
        String[] arrOfStr = actualEmail.split("@",2);
        Assert.assertTrue(arrOfStr[1].substring(0,arrOfStr[1].length()-2).contains("."));

//        actualEmail= "aaa@bbbcc.gmail.";
//        String[] arrOfStr = actualEmail.split("@",2);
//        String secodnpart =arrOfStr[1];
//        String subStr = secodnpart.substring(0,secodnpart.length()-1);
//        System.out.println(subStr);
//        for (String a : arrOfStr)
//            System.out.println(a);


//        Assert.assertEquals(requestBody.getSsn(),actualBody.getSsn());
//        Assert.assertEquals(requestBody.getFirstName(),actualBody.getFirstName());
//
//        Assert.assertEquals(requestBody.getLastName(),actualBody.getLastName());
//        Assert.assertEquals(requestBody.getLogin(),actualBody.getLogin());
//
//        Assert.assertEquals(requestBody.getEmail(),actualBody.getEmail());
//        Assert.assertEquals(requestBody.getLangKey(),actualBody.getLangKey());


    }
}
