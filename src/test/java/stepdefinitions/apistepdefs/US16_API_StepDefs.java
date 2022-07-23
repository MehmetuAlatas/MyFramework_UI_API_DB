package stepdefinitions.apistepdefs;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import pojos.Room;
import pojos.RoomPut;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static utilities.Authentication.generateToken;
import static utilities.MehmetWriter.*;
import static utilities.MehmetWriter.savingRoomNumber;

public class US16_API_StepDefs {
    Response response;
    Room createdRoom;
    RoomPut roomPut;

    @Given("user sends a get request for room data with {int} id")
    public void user_sends_a_get_request_for_room_data_with_id(Integer int1) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().get(ConfigurationReader.getProperty("getRoomEndpoint") + "/" + int1);
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
        //do assertion with pojo aswell

    }

    @Given("user set the roomdata")
    public void user_set_the_roomdata_with_created_by_created_date_description_price_room_number_room_type_status_true() {
        Faker faker = new Faker();
        int roomNumber = faker.number().numberBetween(3137317, 999999999);
        int price = 13;
        String createdBy = "mhmt api automation";
        String createdDate = "2022-07-22T10:45:35.301Z";
        String description = "optional";
        String roomType = "TWIN";

        createdRoom = new Room(createdBy, createdDate, description, price, roomNumber, roomType, true);
        System.out.println("createdRoom = " + createdRoom);
        savingRoomNumber(createdRoom.getRoomNumber());
    }

    @Given("user sends a post request for room")
    public void user_sends_a_post_request_for_room() {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                contentType(ContentType.JSON).body(createdRoom).
                when().post(ConfigurationReader.getProperty("getRoomEndpoint"));
        response.prettyPeek();
    }

    @Given("user does assertion the room data")
    public void user_does_assertion_the_roomdata() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        Room actual = obj.readValue(response.asString(), Room.class);
        System.out.println("actual = " + actual);
        System.out.println(createdRoom.getCreatedBy() + "<<= ?createdby? =>> " + actual.getCreatedBy());
        System.out.println(createdRoom.getCreatedDate() + "<<= ?date? =>> " + actual.getCreatedDate());

        Assert.assertEquals(createdRoom.getDescription(), actual.getDescription());
        Assert.assertEquals(createdRoom.getRoomType(), actual.getRoomType());
        Assert.assertEquals(createdRoom.getRoomNumber(), actual.getRoomNumber());
        Assert.assertEquals(createdRoom.isStatus(), actual.isStatus());

    }

    @Given("user set the roomdata for updating")
    public void user_set_the_roomdata_for_updating() throws IOException {
        List<String> rooms = Files.lines(Paths.get(ConfigurationReader.getProperty("rooms"))).collect(Collectors.toList());
        System.out.println("rooms = " + rooms);
        //int roomNumber = Integer.parseInt(rooms.get(0));
        int roomNumber = 13311331;
        int price = 313;
        int id = 132298;
        String createdBy = "mhmtapiautomation";
        String createdDate = "2022-07-23T10:45:35.301Z";
        String description = "optional";
        String roomType = "DAYCARE";
        //  updatedRoom = new Room(createdBy,createdDate,roomNumber,id,roomType,true,price,description);
        roomPut = new RoomPut(createdBy, createdDate, description, id, price, roomNumber, roomType, true);
        System.out.println("roomPut = " + roomPut);


    }

    @Given("user sends a put request for room")
    public void user_sends_a_put_request_for_room() {
        System.out.println("roomPut = " + roomPut);
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).
                contentType(ContentType.JSON).body(roomPut).
                when().put(ConfigurationReader.getProperty("getRoomEndpoint"));
        response.prettyPeek();
    }

    @Given("user does assertion the updated room data")
    public void user_does_assertion_the_updated_room_data() throws IOException {

        ObjectMapper obj = new ObjectMapper();
        Room actual = obj.readValue(response.asString(), Room.class);
        System.out.println("actual = " + actual);
        System.out.println(roomPut.getCreatedBy() + "<<= ?createdby? =>> " + actual.getCreatedBy());
        System.out.println(roomPut.getCreatedDate() + "<<= ?date? =>> " + actual.getCreatedDate());

        Assert.assertEquals(roomPut.getDescription(), actual.getDescription());
        Assert.assertEquals(roomPut.getRoomType(), actual.getRoomType());
        Assert.assertEquals(roomPut.getRoomNumber(), actual.getRoomNumber());
        Assert.assertEquals(roomPut.isStatus(), actual.isStatus());
    }

    @Given("user sends a delete request for room with {int} id")
    public void user_sends_a_delete_request_for_room_with_id(Integer int1) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON).

                when().delete(ConfigurationReader.getProperty("getRoomEndpoint") + "/" + int1);
        response.prettyPeek();
    }
    /**given()
     .accept("application/json")
     .when()
     .get("/employees")
     .then()
     .assertThat().statusCode(200)
     .and()
     .assertThat().contentType("application/json")
     .log().ifError()
     .log().all(true)
     *
     */


}
