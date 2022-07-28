package stepdefinitions.apistepdefs;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class APICountrySteps {

    Response response;

    @Given("kullanici medunna apiden {string} ulke bilgilerini okur")
    public void kullanici_medunna_apiden_ulke_bilgilerini_okur(String url) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract()
                .response();
        response.prettyPrint();

    }


    @Given("kullanici api end point {string} den {string} ve {string} kullanarak ulke olusturur")
    public void kullanici_api_end_point_den_ve_kullanarak_ulke_olusturur(String url, String type, String country) {

        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\""+type+"\":\""+country+"\"}")
                .post(url)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }

    @Given("kullanici api end point {string} den {string} ve {string} kullanarak guncelleme yapar")
    public void kullanici_api_end_point_den_ve_kullanarak_guncelleme_yapar(String endPoint, String id, String name) {

        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\"id\": "+id+",\"name\": \""+name+"\"}")
                .put(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }

    @Given("kullanici endpoint {string} ve id ile {string} ulke siler")
    public void kullanici_endpoint_ve_id_ile_ulke_siler(String endPoint, String id) {

        response =given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .delete(endPoint + id)
                .then()
                .extract()
                .response();
    }
}
