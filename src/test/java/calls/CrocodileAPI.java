package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.*;
import test.common.TestBase;

public class CrocodileAPI extends TestBase {

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.USERS), GetPublicCrocodileResponse[].class);
    }

    public static GetPublicCrocodileByIdResponse getPublicCrocodileById(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_USER("2")), GetPublicCrocodileByIdResponse.class);
    }

    public static LoginResponse login(LoginRequest loginRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.AUTHORIZATION, loginRequest), LoginResponse.class);
    }

    public static GetPrivateCrocodileResponse[] getPrivateCrocodileResponses(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.PRIVATE_USERS, accessToken), GetPrivateCrocodileResponse[].class);
    }

    public static GetPrivateCrocodileByIdResponse getPrivateCrocodileByIdResponse(String id, String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.GET_PRIVATE_USER(id), accessToken), GetPrivateCrocodileByIdResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.PRIVATE_USERS, accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static UpdateCrocodileResponse updateCrocodile(String id, String accessToken, CreateCrocodileRequest createCrocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.GET_PRIVATE_USER(id), accessToken, createCrocodileRequest), UpdateCrocodileResponse.class);
    }

    public static UpdateNameFieldResponse updateNameFieldResponse(String id, String accessToken, UpdateNameFieldRequest updateNameFieldRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.GET_PRIVATE_USER(id), accessToken, updateNameFieldRequest), UpdateNameFieldResponse.class);
    }

    public static DeleteCrocodileResponse deleteCrocodileResponse(String id, String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.GET_PRIVATE_USER(id), accessToken), DeleteCrocodileResponse.class);
    }

    public static DeleteTestCrocodileResponse deleteTestCrocodileResponse(String testId, String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.GET_PRIVATE_USER(testId), accessToken), DeleteTestCrocodileResponse.class);
    }
}
