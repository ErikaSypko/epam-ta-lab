package smoke;

import com.google.gson.Gson;
import service.AuthorService;
import io.restassured.RestAssured;
import model.Author;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import util.Constants;
import util.Parser;
import verifier.Verifier;

public class SmokeTests {
    Author author = new Parser().convertToAuthor(Constants.JSON_FILE_NAME);
    Author authorUpdated = new Parser().convertToAuthor(Constants.JSON_UPDATED_FILE_NAME);

    @BeforeSuite
    public void setUrl() {
        RestAssured.baseURI = Constants.DEFAULT_URL;
    }

    @Test(priority = 1)
    public void createNewAuthorPositiveTest() {
        AuthorService.createNewAuthor(new Gson().toJson(author));
        new Verifier()
                .checkThatStatusCodeEqualsResponse(HttpStatus.SC_CREATED)
                .checkThatResponseEqualsObject(author);
    }

    @Test(priority = 2)
    public void createNewAuthorNegativeTest() {
        AuthorService.createNewAuthor(new Gson().toJson(author));
        new Verifier()
                .checkThatStatusCodeEqualsResponse(HttpStatus.SC_CONFLICT)
                .checkResponseBodyAttributeValue(Constants.AUTHOR_WITH_ID_ALREADY_EXISTS_MESSAGE, "errorMessage")
                .checkResponseBodyAttributeValue(Constants.CONFLICT, "error");
    }

    @Test(priority = 3)
    public void getAuthorByIdPositiveTest() {
        AuthorService.getAuthorById(author.getAuthorId());
        new Verifier().checkThatStatusCodeEqualsResponse(HttpStatus.SC_OK)
                .checkThatResponseEqualsObject(author);
    }


    @Test(priority = 4)
    public void updateAuthorPositiveTest() {
        AuthorService.updateAuthor(new Gson().toJson(authorUpdated));
        new Verifier().checkThatStatusCodeEqualsResponse(HttpStatus.SC_OK)
                .checkThatResponseEqualsObject(authorUpdated);
    }

    @Test(priority = 5)
    public void deleteAuthorPositiveTest() {
        AuthorService.deleteAuthor(authorUpdated.getAuthorId());
        new Verifier().checkThatStatusCodeEqualsResponse(HttpStatus.SC_NO_CONTENT);
    }

    @Test(priority = 6)
    public void deleteAuthorNegativeTest() {
        AuthorService.deleteAuthor(authorUpdated.getAuthorId());
        new Verifier()
                .checkThatStatusCodeEqualsResponse(HttpStatus.SC_NOT_FOUND)
                .checkResponseBodyAttributeValue(String.format(Constants.AUTHOR_TO_DELETE_NOT_FOUND_MESSAGE, authorUpdated.getAuthorId()), "errorMessage")
                .checkResponseBodyAttributeValue(Constants.NOT_FOUND, "error");
    }

    @Test(priority = 7)
    public void updateAuthorNegativeTest() {
        AuthorService.updateAuthor(new Gson().toJson(authorUpdated));
        new Verifier()
                .checkThatStatusCodeEqualsResponse(HttpStatus.SC_NOT_FOUND)
                .checkResponseBodyAttributeValue(String.format(Constants.AUTHOR_TO_DELETE_NOT_FOUND_MESSAGE, authorUpdated.getAuthorId()), "errorMessage")
                .checkResponseBodyAttributeValue(Constants.NOT_FOUND, "error");
    }

    @Test(priority = 8)
    public void getAuthorByIdNegativeTest() {
        AuthorService.getAuthorById(authorUpdated.getAuthorId());
        new Verifier()
                .checkThatStatusCodeEqualsResponse(HttpStatus.SC_NOT_FOUND)
                .checkResponseBodyAttributeValue(String.format(Constants.AUTHOR_TO_DELETE_NOT_FOUND_MESSAGE, authorUpdated.getAuthorId()), "errorMessage")
                .checkResponseBodyAttributeValue(Constants.NOT_FOUND, "error");
    }
}
