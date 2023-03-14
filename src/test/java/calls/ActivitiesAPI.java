package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.activites.*;
import data.models.common.EmptyResponse;
import test.common.TestBaseActivities;

public class ActivitiesAPI extends TestBaseActivities {

    public static ActivityResponse[] getActivitiesResponses() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.ACTIVITIES), ActivityResponse[].class);
    }

    public static ActivityResponse createActivityResponse(ActivityRequest createActivityRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.ACTIVITIES, createActivityRequest), ActivityResponse.class);
    }

    public static ActivityResponse getActivityByIdResponse(String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_ACTIVITY(id)), ActivityResponse.class);
    }

    public static ActivityResponse updateActivityResponse(String id, ActivityRequest updateActivityRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_ACTIVITY(id),updateActivityRequest), ActivityResponse.class);
    }

    public static EmptyResponse deleteActivityResponse(String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.SINGLE_ACTIVITY(id)), EmptyResponse.class);
    }
}
