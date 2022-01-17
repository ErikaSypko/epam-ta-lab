package service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.Constants;

import static io.restassured.RestAssured.given;

public class AuthorService {
    private static Response response;

    public static Response getAuthorById(Long id) {
        response = given()
                .log().all()
                .when()
                .get(String.format(Constants.AUTHOR_BY_ID_URL, id))
                .then().log().all()
                .extract().response();
        return response;
    }

    public static Response createNewAuthor(String author) {
        response = given()
                .body(author)
                .contentType(ContentType.JSON)
                .when()
                .post(Constants.AUTHOR_URL)
                .then().log().all()
                .extract().response();
        return response;

    }

    public static Response updateAuthor(String author) {
        response = given().body(author)
                .contentType(ContentType.JSON)
                .log().all()
                .when().put(Constants.AUTHOR_URL)
                .then().log().all()
                .extract().response();
        return response;
    }


    public static Response deleteAuthor(Long id) {
        response = given()
                .when()
                .delete(String.format(Constants.AUTHOR_BY_ID_URL, id))
                .then()
                .extract().response();
        return response;
    }

    public static int getStatusCode() {
        return response.getStatusCode();
    }

    public static <T> T extractResponseAsObject(Class<T> tClass) {
        return response.as(tClass);
    }

    public static String extractResponseAttributeValue(String msg){
       return response.getBody().jsonPath().getString(msg);
    }
}