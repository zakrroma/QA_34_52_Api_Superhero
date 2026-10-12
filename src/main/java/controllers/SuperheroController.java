package controllers;

import dto.Superhero;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseApi;

import static io.restassured.RestAssured.given;

public class SuperheroController implements BaseApi {
    public Response createSuperhero(Superhero hero) {
        return given()
                .body(hero)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + POST_URL)
                .thenReturn();
    }

    public Response getAllSuperheroes() {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + GET_ALL_URL)
                .thenReturn();
    }

    public Response getSuperheroByID(String id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + GET_URL + id)
                .thenReturn();
    }

    public Response deleteSuperheroByID(String id) {
        return given()
                .contentType(ContentType.JSON)
                .when()
                .delete(BASE_URL + DELETE_URL + id)
                .thenReturn();
    }
}
