package utilities;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(){
        //set the url
        spec.pathParams("first","api","second","authenticate");

        //set the expected data
        Map<String, Object> expectedData= new HashMap<>();
        expectedData.put("password","vusalgasimov");
        expectedData.put("rememberMe",true);
        expectedData.put("username","vusalgasimov");

        //send request and get response
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(expectedData).when().
                post("/{first}/{second}");

        response.prettyPeek();

        JsonPath json = response.jsonPath();

        return json.getString("id_token");


    }
}

