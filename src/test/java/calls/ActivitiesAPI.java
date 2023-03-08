package calls;

import com.google.gson.Gson;
import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.activites.*;
import test.common.TestBaseActivities;

public class ActivitiesAPI extends TestBaseActivities {

    public static GetActivitiesResponse[] getActivitiesResponses() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.ACTIVITIES), GetActivitiesResponse[].class);
    }

    public static CreateActivityResponse createActivityResponse(CreateActivityRequest createActivityRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.ACTIVITIES, createActivityRequest), CreateActivityResponse.class);
    }

    public static GetActivityByIdResponse getActivityByIdResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_ACTIVITY(id)), GetActivityByIdResponse.class);
    }

    public static UpdateActivityResponse updateActivityResponse(String id, UpdateActivityRequest updateActivityRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_ACTIVITY(id),updateActivityRequest), UpdateActivityResponse.class);
    }

    public static DeleteActivityResponse deleteActivityResponse(String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(id), DeleteActivityResponse.class);
    }
}
