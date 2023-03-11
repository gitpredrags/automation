package test.suite;

import calls.AuthorsAPI;
import common.ValueChoosers;
import data.models.authors.*;
import data.models.common.EmptyResponse;
import data.provider.AuthorsProvider;
import jdk.jfr.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.AuthorsAsserts;
import test.common.TestBaseAuthors;

public class AuthorsTests extends TestBaseAuthors {

    public AuthorsAsserts authorsAsserts = new AuthorsAsserts();
    public static String testId;
    public static String bookId;
    public static String deleteId;

    AuthorRequest createAuthorRequest = AuthorsProvider.createAuthorRequest();
    AuthorRequest updateAuthorRequest = AuthorsProvider.updateAuthorRequest();

    @BeforeClass
    public void createAuthor() {
        AuthorResponse createAuthorResponse = AuthorsAPI.createAuthorResponse(createAuthorRequest);
        authorsAsserts.assertAuthor(createAuthorResponse, createAuthorRequest);

        testId = createAuthorRequest.getId().toString();
    }

    @Test
    @Description("Get list of authors")
    public void getListOfAuthors() {
        AuthorResponse[] getAuthorsResponses = AuthorsAPI.getAuthorsResponses();
        authorsAsserts.assertListOfAuthors(getAuthorsResponses);
    }

    @Test
    @Description("Get book by ID")
    public void getBookById() {
        bookId = ValueChoosers.getRandomBookId();
        AuthorResponse[] getBookByIdResponse = AuthorsAPI.getBookByIdResponse(bookId);
        authorsAsserts.assertBookSelectedById(getBookByIdResponse);
    }

    @Test
    @Description("Get author by ID")
    public void getAuthorById() {
        AuthorResponse getAuthorByIdResponse = AuthorsAPI.getAuthorByIdResponse(testId);
        authorsAsserts.assertAuthorById(getAuthorByIdResponse);
    }

    @Test
    @Description("Update author")
    public void updateAuthor() {
        AuthorResponse updateAuthorResponse = AuthorsAPI.updateAuthorResponse(testId, updateAuthorRequest);
        authorsAsserts.assertAuthor(updateAuthorResponse, updateAuthorRequest);
    }

    @Test
    @Description("Delete author")
    public void deleteAuthor() {
        AuthorResponse createAuthorResponse = AuthorsAPI.createAuthorResponse(createAuthorRequest);
        String deleteId = createAuthorResponse.getId().toString();
        EmptyResponse deleteAuthorResponse = AuthorsAPI.deleteAuthorResponse(deleteId);
        AuthorResponse[] getAuthorsResponses = AuthorsAPI.getAuthorsResponses();
        authorsAsserts.assertDeleteAuthor(getAuthorsResponses);
    }

    @AfterClass
    public void deleteTestAuthor() {
        EmptyResponse deleteAuthorResponse = AuthorsAPI.deleteAuthorResponse(testId);
        AuthorResponse[] getAuthorsResponses = AuthorsAPI.getAuthorsResponses();
        authorsAsserts.assertDeleteAuthor(getAuthorsResponses);
    }


}
