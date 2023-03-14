package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.books.BookRequest;
import data.models.books.BookResponse;
import data.models.common.EmptyResponse;
import test.common.TestBaseBooks;

public class BooksAPI extends TestBaseBooks {

    public static BookResponse[] getBookResponses(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.BOOKS), BookResponse[].class);
    }

    public static BookResponse createBookResponse(BookRequest createBookRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.BOOKS,createBookRequest), BookResponse.class);
    }

    public static BookResponse[] getBookByIdResponse(String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.BOOK(id)), BookResponse[].class);
    }

    public  static BookResponse updateBookResponse (String id, BookRequest updateBookRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.BOOK(id), updateBookRequest), BookResponse.class);
    }

    public static EmptyResponse deleteBookResponse (String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.BOOK(id)), EmptyResponse.class);
    }
}
