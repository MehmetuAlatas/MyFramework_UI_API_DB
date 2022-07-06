package stepdefinitions.apistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.MehmetPojo;
import utilities.ConfigurationReader;


import static io.restassured.RestAssured.*;
import static utilities.MehmetWriter.savingUiRegistrant;

public class MehmetApiStepDefs {
    Response response;

    MehmetPojo [] mehmetPojos;

    @Given("user sends a get request for users data")
    public void user_sends_a_get_request_for_users_data() {
        response = given().headers(
                        "Authorization", "Bearer " + ConfigurationReader.getProperty("mehmet_token"),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().get(ConfigurationReader.getProperty("mehmet_registrant_endpoint"));
        //  response.prettyPeek();

    }

    @Given("user deserializes the users data to java")
    public void user_deserializes_the_users_data_to_java() throws Exception {

        ObjectMapper obj = new ObjectMapper();

        mehmetPojos = obj.readValue(response.asString(),MehmetPojo[].class);
//        System.out.println("mehmetPojos.length = " + mehmetPojos.length);
//        boolean flag=false;
//        for (int i = 0; i <mehmetPojos.length ; i++) {
//           // System.out.println(mehmetPojos [i].getFirstName() +" "+mehmetPojos[i].getLastName());
//            if("147-25-0613".contains(mehmetPojos[i].getSsn())){
//                flag=true;
//            }
//        }
//        Assert.assertTrue(flag);


    }

    @Then("user saves the users data to correspondent files and validates")
    public void user_saves_the_users_data_to_correspondent_files_and_validates() {

        savingUiRegistrant(mehmetPojos);

    }

}
