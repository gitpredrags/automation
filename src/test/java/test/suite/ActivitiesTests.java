package test.suite;

import calls.ActivitiesAPI;
import data.models.activites.*;
import data.provider.ActivityProvider;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.ActivitiesAsserts;
import test.common.TestBaseActivities;

public class ActivitiesTests extends TestBaseActivities {

    public static String testID;
    public static String updateId;
    public static String deleteID;
    public ActivitiesAsserts activitiesAsserts = new ActivitiesAsserts();

    CreateActivityRequest createActivityRequest = ActivityProvider.createActivityRequest();
    UpdateActivityRequest updateActivityRequest = ActivityProvider.updateActivityRequest();


    @BeforeClass
    public void createActivity() {
        CreateActivityResponse createActivityResponse = ActivitiesAPI.createActivityResponse(createActivityRequest);
        activitiesAsserts.assertCreatedActivity(createActivityResponse, createActivityRequest);

        testID = ActivitiesAPI.getActivitiesResponses()[3].getId().toString();
    }

    @Test
    @Description("Get list of activities")
    public void getListOfActivities() {
        GetActivitiesResponse[] getActivitiesResponses = ActivitiesAPI.getActivitiesResponses();

        activitiesAsserts.assertListOfActivities(getActivitiesResponses);
    }

    @Test
    @Description("Get activity by ID")
    public void getActivityById() {
        GetActivityByIdResponse getActivityByIdResponse = ActivitiesAPI.getActivityByIdResponse(testID);

        activitiesAsserts.assertGetById(getActivityByIdResponse);
    }

    @Test
    @Description("Update activity")
    public void updateActivity() {
        updateId = updateActivityRequest.getId().toString();
        UpdateActivityResponse updateActivityResponse = ActivitiesAPI.updateActivityResponse(updateId,updateActivityRequest);

        activitiesAsserts.assertUpdateActivity(updateActivityResponse, updateActivityRequest);
    }

    @Test
    @Description("Delete activity")
    public void deleteActivity() {
        deleteID = ActivitiesAPI.getActivitiesResponses()[3].getId().toString();
        DeleteActivityResponse deleteActivityResponse = ActivitiesAPI.deleteActivityResponse(deleteID);
        GetActivitiesResponse[] getActivitiesResponse = ActivitiesAPI.getActivitiesResponses();
        activitiesAsserts.assertDeleteActivity(getActivitiesResponse);
    }
}
