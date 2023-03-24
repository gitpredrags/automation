package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.authors.*;
import data.models.common.EmptyResponse;
import test.common.TestBaseAuthors;

public class AuthorsAPI extends TestBaseAuthors {

    public static AuthorResponse[] getAuthorsResponses(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.AUTHORS), AuthorResponse[].class);
    }

    public static AuthorResponse createAuthorResponse(AuthorRequest createAuthorRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.AUTHORS,createAuthorRequest), AuthorResponse.class);
    }

    public static AuthorResponse[] getBookByIdResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_BOOK(id)), AuthorResponse[].class);
    }

    public static AuthorResponse getAuthorByIdResponse(String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_AUTHOR(id)), AuthorResponse.class);
    }

    public static AuthorResponse updateAuthorResponse(String id, AuthorRequest updateAuthorRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_AUTHOR(id), updateAuthorRequest), AuthorResponse.class);
    }

    public static EmptyResponse deleteAuthorResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.SINGLE_AUTHOR(id)), EmptyResponse.class);
    }
}
