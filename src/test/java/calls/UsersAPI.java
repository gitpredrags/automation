package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.common.EmptyResponse;
import data.models.users.UsersRequest;
import data.models.users.UsersResponse;
import test.common.TestBaseUsers;

public class UsersAPI extends TestBaseUsers {

    public static UsersResponse[] getUsersResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.USERS2), UsersResponse[].class);
    }

    public static UsersResponse createUserResponse(UsersRequest createUserRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.USERS2, createUserRequest), UsersResponse.class);
    }

    public static UsersResponse getUserByIdResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_USER2(id)), UsersResponse.class);
    }

    public static UsersResponse updateUserResponse(String id, UsersRequest updateUserRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_USER2(id), updateUserRequest), UsersResponse.class);
    }

    public static EmptyResponse deleteUser(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.SINGLE_USER2(id)), EmptyResponse.class);
    }
}
