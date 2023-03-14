package test.suite;

import calls.BooksAPI;
import common.ValueChoosers;
import data.models.books.BookRequest;
import data.models.books.BookResponse;
import data.models.common.EmptyResponse;
import data.provider.BooksProvider;
import jdk.jfr.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.BooksAsserts;
import test.common.TestBaseBooks;

public class BooksTests extends TestBaseBooks {

    public BooksAsserts booksAsserts = new BooksAsserts();
    public static String testId;
    public static String bookId;
    public static String deleteId;

    BookRequest createBookRequest = BooksProvider.createBookRequest();
    BookRequest updateBookRequest = BooksProvider.updateBookRequest();

    @BeforeClass
    public void createBook(){
        BookResponse createBookResponse = BooksAPI.createBookResponse(createBookRequest);
        booksAsserts.assertBook(createBookResponse, createBookRequest);

        testId = createBookResponse.getId().toString();
    }

    @Test
    @Description("Get list of books")
    public void getListOfBooks() {
        BookResponse[] getBookResponse = BooksAPI.getBookResponses();
        booksAsserts.assertListOfBooks(getBookResponse);
    }

    @Test
    @Description("Get book by ID")
    public void getBookById() {
        bookId = ValueChoosers.getRandomBookId();
        BookResponse[] getBookByIdResponse = BooksAPI.getBookByIdResponse(bookId);
        booksAsserts.assertBookById(getBookByIdResponse);
    }

    @Test
    @Description("Update book")
    public void updateBook() {
        BookResponse updateBookResponse = BooksAPI.updateBookResponse(testId, updateBookRequest);
        booksAsserts.assertBook(updateBookResponse, updateBookRequest);
    }

    @Test
    @Description("Delete book")
    public void deleteBook() {
        BookResponse createBookResponse = BooksAPI.createBookResponse(createBookRequest);
        deleteId = createBookResponse.getId().toString();
        EmptyResponse deleteBookResponse = BooksAPI.deleteBookResponse(deleteId);
        BookResponse[] getBookResponse = BooksAPI.getBookResponses();
        booksAsserts.assertDeleteBook(getBookResponse);
    }

    @AfterClass
    public void deleteTestBook() {
        EmptyResponse deleteTestBookResponse = BooksAPI.deleteBookResponse(testId);
        BookResponse[] getBookResponse = BooksAPI.getBookResponses();
        booksAsserts.assertDeleteBook(getBookResponse);
    }
}
