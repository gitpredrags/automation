package test.suite;

import calls.AuthorsAPI;
import common.ValueChoosers;
import data.models.activites.GetActivityByIdResponse;
import data.models.authors.*;
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

    CreateAuthorRequest createAuthorRequest = AuthorsProvider.createAuthorRequest();
    UpdateAuthorRequest updateAuthorRequest = AuthorsProvider.updateAuthorRequest();

    @BeforeClass
    public void createAuthor() {
        CreateAuthorResponse createAuthorResponse = AuthorsAPI.createAuthorResponse(createAuthorRequest);
        authorsAsserts.assertCreatedAuthor(createAuthorResponse, createAuthorRequest);

        testId = createAuthorRequest.getId().toString();
    }

    @Test
    @Description("Get list of authors")
    public void getListOfAuthors() {
        GetAuthorsResponse[] getAuthorsResponses = AuthorsAPI.getAuthorsResponses();
        authorsAsserts.assertListOfAuthors(getAuthorsResponses);
    }

    @Test
    @Description("Get book by ID")
    public void getBookById() {
        bookId = ValueChoosers.getRandomBookId();
        GetBookByIdResponse[] getBookByIdResponse = AuthorsAPI.getBookByIdResponse(bookId);
        authorsAsserts.assertBookSelectedById(getBookByIdResponse);
    }

    @Test
    @Description("Get author by ID")
    public void getAuthorById() {
        GetActivityByIdResponse getActivityByIdResponse = AuthorsAPI.getActivityByIdResponse(testId);
        authorsAsserts.assertAuthorById(getActivityByIdResponse);
    }

    @Test
    @Description("Update author")
    public void updateAuthor() {
        UpdateAuthorResponse updateAuthorResponse = AuthorsAPI.updateAuthorResponse(testId, updateAuthorRequest);
        authorsAsserts.assertUpdateAuthor(updateAuthorResponse, updateAuthorRequest);
    }

    @Test
    @Description("Delete author")
    public void deleteAuthor() {
        CreateAuthorResponse createAuthorResponse = AuthorsAPI.createAuthorResponse(createAuthorRequest);
        String deleteId = createAuthorResponse.getId().toString();
        DeleteAuthorResponse deleteAuthorResponse = AuthorsAPI.deleteAuthorResponse(deleteId);
        GetAuthorsResponse[] getAuthorsResponses = AuthorsAPI.getAuthorsResponses();
        authorsAsserts.assertDeleteAuthor(getAuthorsResponses);
    }

    @AfterClass
    public void deleteTestAuthor() {
        DeleteAuthorResponse deleteAuthorResponse = AuthorsAPI.deleteAuthorResponse(testId);
        GetAuthorsResponse[] getAuthorsResponses = AuthorsAPI.getAuthorsResponses();
        authorsAsserts.assertDeleteAuthor(getAuthorsResponses);
    }


}
