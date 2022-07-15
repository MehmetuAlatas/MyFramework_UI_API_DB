package stepdefinitions.apistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import pojos.MehmetMessages;
import pojos.MehmetPojo;
import pojos.PatientsBody;
import pojos.US01_RegistrantPojo;
import utilities.ConfigurationReader;
import utilities.MehmetWriter;
import utilities.WriteToTxt;

import java.util.List;

import static hooks.Hooks.spec;


import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import static utilities.Authentication.generateToken;
import static utilities.MehmetWriter.savingUiRegistrant;

public class MehmetApiStepDefs {
    Response response;
    MehmetPojo mehmetPojo;
    MehmetPojo[] mehmetPojos;
    US01_RegistrantPojo data;
    MehmetMessages mehmetMessages;
    MehmetMessages[] mehmetMessageses;
    PatientsBody patientsBody;
    PatientsBody[] patientsBodies;


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
        boolean flag = false;
        for (int i = 0; i < mehmetPojos.length; i++) {
            // System.out.println(mehmetPojos [i].getFirstName() +" "+mehmetPojos[i].getLastName());
            if ("147-25-0613".contains(mehmetPojos[i].getSsn())) {
                flag = true;
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
        spec.pathParams("first", "api", "second", "register");
        //set the expected data

        Faker faker = new Faker();
        int id = faker.number().randomDigit();
        String login = faker.name().username();
        String ssn = faker.idNumber().ssnValid();
        String fistName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        data = new US01_RegistrantPojo(12, login, true, "", "", "",
                "", ssn, fistName, lastName, "osayli3",
                email, password);

    }

    @Given("user deserializes the response to java")
    public void user_deserializes_the_response_to_java() {
        //send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(data).when().post("/{first}/{second}");

        //response.prettyPeek();
        //do validation
        US01_RegistrantPojo actual = response.as(US01_RegistrantPojo.class);
        Assert.assertEquals(data.getLangKey(), actual.getLangKey());
        Assert.assertEquals(data.getFirstName(), actual.getFirstName());
        Assert.assertEquals(data.getLastName(), actual.getLastName());
        Assert.assertEquals(data.getSsn(), actual.getSsn());
        Assert.assertEquals(data.getEmail(), actual.getEmail());
    }

    @Then("user saves the users data to correspondent files")
    public void user_saves_the_users_data_to_correspondent_files() {
        MehmetWriter.savingApiRegistrant(data);
    }

    @Given("user analyses the response for existing some specific data")
    public void user_analyses_the_response_for_existing_some_specific_data() {

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("id", hasSize(6464),
                        "firstName", hasItem("ali"),
                        "id", hasItems(34657, 34658, 114215));

    }


    @Given("user sends a get request for messages")
    public void user_sends_a_get_request_for_messages() {
        spec.pathParams("1", "api", "2", "c-messages").
                queryParams("size", "200");

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).spec(spec).when().get("/{1}/{2}");
        //response.prettyPeek();
    }

    @Then("user deserializes the response to java for messages")
    public void user_deserializes_the_response_to_java_for_messages() {
        mehmetMessageses = response.as(MehmetMessages[].class);
        System.out.println("mehmetMessageses.length = " + mehmetMessageses.length);

        for (int i = 0; i < mehmetMessageses.length; i++) {
            if (mehmetMessageses[i].getName().toLowerCase().contains("ugur")) {
                System.out.println("mehmetMessageses[i].getName().toString() = " + mehmetMessageses[i].getMessage().toString());
            }
        }
    }

    @Then("user manipulate the messages and does assertion")
    public void user_manipulate_the_messages_and_does_assertion() {
        response.then().assertThat().statusCode(200).
                body("id", hasItems(83534, 83533));
        Assert.assertTrue(response.asString().contains("id"));

        JsonPath json = response.jsonPath();
        List<String> ids = json.getList("findAll{it.id>83500}.message");
        System.out.println("mua ==> " + ids);

    }

    @Given("user sends a get request for patients info")
    public void user_sends_a_get_request_for_patients_info() {
        spec.pathParams("1", "api", "2", "patients").
                queryParams("size", "3000");

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON).spec(spec).when().get("/{1}/{2}");
        response.prettyPeek();

        response.then().assertThat().statusCode(200).body("id", hasItem(121291),
                "user.id", hasItem(3302),
                "cstate.country.id", hasItem(1202));
        JsonPath jsonPath = response.jsonPath();
//        List<Integer> idlist = jsonPath.getList("user.findAll{it.firstName='tekin'}");
//        System.out.println(idlist);


        List<String> userLogin = jsonPath.getList("user.login");
        System.out.println(userLogin);
        for (String w :userLogin ) {
            if (w.contains("mustafatekin")){
                System.out.println(w);
                break;
            }
        }


/**{
 "createdBy": "anonymousUser",
 "createdDate": "2021-12-16T16:34:24.652207Z",
 "id": 2551,
 "firstName": "Doctor",
 "lastName": "Doctor",
 "birthDate": null,
 "phone": "222-333-2322",
 "gender": "MALE",
 "bloodGroup": "ABnegative",
 "adress": null,
 "email": "doctor@email.com",
 "description": null,
 "user": {
 "createdBy": "anonymousUser",
 "createdDate": "2021-12-14T10:38:26.705059Z",
 "id": 2001,
 "login": "doctor",
 "firstName": "Doctor",
 "lastName": "Doctor",
 "email": "doctore@email.com",
 "activated": true,
 "langKey": "en",
 "imageUrl": null,
 "resetDate": null,
 "ssn": "234-55-3432"
 },
 "appointments": null,
 "inPatients": null,
 "country": {
 "id": 1201,
 "name": "Türkye"
 },
 "cstate": {
 "id": 1262,
 "name": "Hawaii",
 "country": {
 "id": 1201,
 "name": "Türkye"
 }
 }
 }
 *
 */


//        spec.pathParams("1", "api", "2", "patients");
//        response = given().headers(
//                "Authorization",
//                "Bearer " + generateToken(),
//                "Content-Type", ContentType.JSON,
//                "Accept", ContentType.JSON).spec(spec).when().get("/{1}/{2}");
//        JsonPath jsonPath = response.jsonPath();
//        response.prettyPeek();
//        List<Integer> list = jsonPath.getList("id");
//        System.out.println("list = " + list);

    }

    @Then("user deserializes the response to java for patients info")
    public void user_deserializes_the_response_to_java_for_patients_info() {
//        PatientsBody[] patientsBodies = response.as(PatientsBody[].class);
//        for (int i = 0; i < patientsBodies.length; i++) {
//            System.out.println("patientsBodies= " + patientsBodies[i].toString());
//        }
//        System.out.println("patientsBodies[1].getCstate().getCountry().getId() = " + patientsBodies[1].getCstate().getCountry().getId());
    }


}
