package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.*;
import test.common.TestBase;

public class CrocodileAPI extends TestBase {

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), GetPublicCrocodileResponse[].class);
    }

    public static GetPublicCrocodileByIdResponse getPublicCrocodileById(){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/2/"), GetPublicCrocodileByIdResponse.class);
    }

    public static LoginResponse login(LoginRequest loginRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("/auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static GetPrivateCrocodileResponse[] getPrivateCrocodileResponses(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken), GetPrivateCrocodileResponse[].class);
    }

    public static GetPrivateCrocodileByIdResponse getPrivateCrocodileByIdResponse(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/12203162/", accessToken), GetPrivateCrocodileByIdResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("/my/crocodiles/", accessToken, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static UpdateCrocodileResponse updateCrocodile(String accessToken, UpdateCrocodileRequest updateCrocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("/my/crocodiles/12203178/", accessToken, updateCrocodileRequest), UpdateCrocodileResponse.class);
    }

    public static UpdateNameFieldResponse updateNameFieldResponse(String accessToken, UpdateNameFieldRequest updateNameFieldRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/12203178/", accessToken, updateNameFieldRequest), UpdateNameFieldResponse.class);
    }

    public static DeleteCrocodileResponse deleteCrocodileResponse(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/12203178/", accessToken), DeleteCrocodileResponse.class);
    }

    public static DeleteTestCrocodileResponse deleteTestCrocodileResponse(String url, String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(url, accessToken), DeleteTestCrocodileResponse.class);
    }
}
