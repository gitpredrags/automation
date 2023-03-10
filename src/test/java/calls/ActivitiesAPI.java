package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.activites.*;
import data.models.common.EmptyResponse;
import test.common.TestBaseActivities;

public class ActivitiesAPI extends TestBaseActivities {

    public static GetActivitiesResponse[] getActivitiesResponses() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.ACTIVITIES), GetActivitiesResponse[].class);
    }

    public static CreateActivityResponse createActivityResponse(ActivityRequest createActivityRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.ACTIVITIES, createActivityRequest), CreateActivityResponse.class);
    }

    public static GetActivityByIdResponse getActivityByIdResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_ACTIVITY(id)), GetActivityByIdResponse.class);
    }

    public static UpdateActivityResponse updateActivityResponse(String id, ActivityRequest updateActivityRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_ACTIVITY(id),updateActivityRequest), UpdateActivityResponse.class);
    }

    public static EmptyResponse deleteActivityResponse(String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.SINGLE_ACTIVITY(id)), EmptyResponse.class);
    }
}
