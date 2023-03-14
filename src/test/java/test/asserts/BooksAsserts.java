package test.asserts;

import data.models.books.BookRequest;
import data.models.books.BookResponse;
import org.testng.asserts.SoftAssert;
import test.suite.BooksTests;

public class BooksAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfBooks(BookResponse[] getBooksResponses){
        for (int i = 0; i < getBooksResponses.length; i++){
            softAssert.assertFalse(getBooksResponses[i].getTitle().isEmpty(), "Title is not empty");
        }
    }

    public void assertBook(BookResponse createBookResponse, BookRequest createBookRequest){
        softAssert.assertEquals(createBookResponse.getTitle(), createBookRequest.getTitle(), "Title doesn't match");
        softAssert.assertEquals(createBookResponse.getId(), createBookRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(createBookResponse.getDescription(), createBookRequest.getDescription(), "Description doesn't match");
        softAssert.assertEquals(createBookResponse.getExcerpt(), createBookRequest.getExcerpt(), "Excerpt doesn't match");
        softAssert.assertEquals(createBookResponse.getPageCount(), createBookRequest.getPageCount(), "Page count doesn't match");
        softAssert.assertEquals(createBookResponse.getPublishDate(), createBookRequest.getPublishDate(), "Publish date doesn't match");
        softAssert.assertAll();
    }

    public void assertBookById(BookResponse[] getBookByIdResponse){
        for (int i = 1; i <getBookByIdResponse.length; i++){
            softAssert.assertEquals(getBookByIdResponse[i].getId().toString(), BooksTests.testId, "ID doesn't match");
        }
        softAssert.assertAll();
    }

    public void assertDeleteBook(BookResponse[] getBookResponse) {
        for (int i = 1; i< getBookResponse.length; i++) {
            softAssert.assertNotEquals(getBookResponse[i].getId().toString(), BooksTests.deleteId, "Book is not deleted");
        }
        softAssert.assertAll();
    }
}
