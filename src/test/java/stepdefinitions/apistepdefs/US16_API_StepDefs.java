package stepdefinitions.apistepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Room;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static utilities.Authentication.generateToken;

public class US16_API_StepDefs {
    Response response;
    Room room;


    @Given("user sends a get request for room data with {int} id")
    public void user_sends_a_get_request_for_room_data_with_id(Integer int1) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().get(ConfigurationReader.getProperty("getRoomEndpoint") + int1);
        response.prettyPeek();
    }

    @Given("user deserializes the room data with {int} id to java")
    public void user_deserializes_the_room_data_with_id_to_java(Integer int1) {
       Room actualroom = response.as(Room.class);
        System.out.println("actualroom = " + actualroom);
    }

    @And("user verifies the status code is {int}")
    public void user_verifies_the_status_code_is(Integer int1) {
        response.then().assertThat().statusCode(int1);
    }

    @Given("user does assertion the roomType is {string} roomNumber is {int} id is {int}")
    public void user_does_assertion_the_room_type_is_room_number_is_id_is(String string, Integer int1, Integer int2) {
        response.then().assertThat().body("roomType", equalTo(string),
                "roomNumber", equalTo(int1),
                "id", equalTo(int2));
        Room expectedRoom = new Room ("mark","2022-03-02T15:16:36.005709Z",11552,777,"TWIN",false,5.00,"Jack");
        Room actualroom = response.as(Room.class);
        Assert.assertEquals(expectedRoom.getCreatedBy(),actualroom.getCreatedBy());
        Assert.assertEquals(expectedRoom.getCreatedDate(),actualroom.getCreatedDate());
        Assert.assertEquals(expectedRoom.getId(),actualroom.getId());
        Assert.assertEquals(expectedRoom.getRoomNumber(),actualroom.getRoomNumber());
        Assert.assertEquals(expectedRoom.getRoomType(),actualroom.getRoomType());
        Assert.assertEquals(expectedRoom.getDescription(),actualroom.getDescription());
        Assert.assertEquals(expectedRoom.getPriceint(),actualroom.getPriceint());

    }


}
