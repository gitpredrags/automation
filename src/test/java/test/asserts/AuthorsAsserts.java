package test.asserts;

import data.models.activites.GetActivityByIdResponse;
import data.models.authors.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test.suite.AuthorsTests;

public class AuthorsAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfAuthors(GetAuthorsResponse[] getAuthorsResponses) {
        for (int i = 0; i <getAuthorsResponses.length; i++){
            softAssert.assertFalse(getAuthorsResponses[i].getFirstName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertCreatedAuthor(CreateAuthorResponse createAuthorResponse, CreateAuthorRequest createAuthorRequest){
        softAssert.assertEquals(createAuthorResponse.getFirstName(), createAuthorRequest.getFirstName(), "First name doesn't match");
        softAssert.assertEquals(createAuthorResponse.getLastName(), createAuthorRequest.getLastName(), "Last name doesn't match");
        softAssert.assertEquals(createAuthorResponse.getId(), createAuthorRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(createAuthorResponse.getIdBook(), createAuthorRequest.getIdBook(), "Book ID doesn't match");
        softAssert.assertAll();
    }

    public void assertBookSelectedById (GetBookByIdResponse[] getBookByIdResponse){
        for (int i = 0; i < getBookByIdResponse.length; i++){
            softAssert.assertEquals(getBookByIdResponse[i].getIdBook().toString(), AuthorsTests.bookId, "Book ID doesn't match");
        }
        softAssert.assertAll();
    }

    public void assertAuthorById(GetActivityByIdResponse getActivityByIdResponse){
        Assert.assertEquals(getActivityByIdResponse.getId().toString(), AuthorsTests.testId, "ID doesn't match");
    }

    public void assertUpdateAuthor(UpdateAuthorResponse updateAuthorResponse, UpdateAuthorRequest updateAuthorRequest){
        softAssert.assertEquals(updateAuthorResponse.getFirstName(), updateAuthorRequest.getFirstName(), "First name doesn't match");
        softAssert.assertEquals(updateAuthorResponse.getLastName(), updateAuthorRequest.getLastName(), "Last name doesn't match");
        softAssert.assertEquals(updateAuthorResponse.getId(), updateAuthorRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(updateAuthorResponse.getIdBook(), updateAuthorRequest.getIdBook(), "Book ID doesn't match");
        softAssert.assertAll();
    }

    public void assertDeleteAuthor (GetAuthorsResponse[] getAuthorsResponses){
        for (int i = 0; i<getAuthorsResponses.length; i++){
            softAssert.assertNotEquals(getAuthorsResponses[i].getId().toString(), AuthorsTests.deleteId, "Author is not deleted");
        }
        softAssert.assertAll();
    }
}
