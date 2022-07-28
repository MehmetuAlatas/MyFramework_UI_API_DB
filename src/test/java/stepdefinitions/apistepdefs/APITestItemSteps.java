package stepdefinitions.apistepdefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import pojos.TestItem;
import utilities.Authentication;
import utilities.ConfigurationReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APITestItemSteps {

    TestItem testItem = new TestItem();
    Response response;
    public static RequestSpecification spec;

    @Given("user sets the necessary path parameters")
    public void user_sets_the_necessary_path_parameters() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "c-test-items");

    }

    @Given("user sets the expected data {string}, {string}, {string}, {string}, {string}")
    public void user_sets_the_expected_data(String name, String description, String price, String defMinVal, String defMaxVal) {

        testItem.setName(name);
        testItem.setDescription(description);
        testItem.setPrice(Integer.parseInt(price));
        testItem.setDefaultValMax(defMaxVal);
        testItem.setDefaultValMin(defMinVal);
    }

    @Given("user send the post request and gets the response")
    public void user_send_the_post_request_and_gets_the_response() {

        response = given().headers(
                "Authorization",
                "Bearer " + Authentication.generateToken())
                .given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testItem).when()
                .post("/{first}/{second}");
        response.prettyPrint();

        /*
        {
    "createdBy": "team83admin",
    "createdDate": "2022-04-20T14:58:29.139430Z",
    "id": 79937,
    "name": "H1bAc5",
    "description": "3 AYLIK SEKER",
    "price": 599,
    "defaultValMin": "1",
    "defaultValMax": "15"
    }
    */

    }

    @Given("user validates all api records")
    public void user_validates_all_api_records() throws IOException {

        ObjectMapper obj = new ObjectMapper();

        TestItem actualTestItem = obj.readValue(response.asString(), TestItem.class);

        System.out.println(actualTestItem);
        //TestItem{name='H1bAc2', description='3 AYLIK SEKER', price=599, defaultValMin='1', defaultValMax='15'}

        assertEquals(testItem.getName(), actualTestItem.getName());
        assertEquals(testItem.getDescription(), actualTestItem.getDescription());
        assertEquals(testItem.getPrice(), actualTestItem.getPrice());
        assertEquals(testItem.getDefaultValMin(), actualTestItem.getDefaultValMin());
        assertEquals(testItem.getDefaultValMax(), actualTestItem.getDefaultValMax());

    }
}