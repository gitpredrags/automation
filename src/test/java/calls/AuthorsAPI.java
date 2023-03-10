package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.activites.GetActivityByIdResponse;
import data.models.authors.*;
import test.common.TestBaseAuthors;

public class AuthorsAPI extends TestBaseAuthors {

    public static GetAuthorsResponse[] getAuthorsResponses(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.AUTHORS), GetAuthorsResponse[].class);
    }

    public static CreateAuthorResponse createAuthorResponse(CreateAuthorRequest createAuthorRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.AUTHORS,createAuthorRequest), CreateAuthorResponse.class);
    }

    public static GetBookByIdResponse[] getBookByIdResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_BOOK(id)), GetBookByIdResponse[].class);
    }

    public static GetActivityByIdResponse getActivityByIdResponse(String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_AUTHOR(id)), GetActivityByIdResponse.class);
    }

    public static UpdateAuthorResponse updateAuthorResponse(String id, UpdateAuthorRequest updateAuthorRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_AUTHOR(id), updateAuthorRequest), UpdateAuthorResponse.class);
    }

    public static DeleteAuthorResponse deleteAuthorResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.SINGLE_AUTHOR(id)), DeleteAuthorResponse.class);
    }
}
