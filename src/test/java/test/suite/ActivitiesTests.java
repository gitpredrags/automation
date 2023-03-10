package test.suite;

import calls.ActivitiesAPI;
import data.models.activites.*;
import data.models.common.EmptyResponse;
import data.provider.ActivityProvider;
import jdk.jfr.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.ActivitiesAsserts;
import test.common.TestBaseActivities;

public class ActivitiesTests extends TestBaseActivities {

    public static String testID;
    public static String updateId;
    public static String deleteID;
    public ActivitiesAsserts activitiesAsserts = new ActivitiesAsserts();

    ActivityRequest createActivityRequest = ActivityProvider.createActivityRequest();
    ActivityRequest updateActivityRequest = ActivityProvider.updateActivityRequest();


    @BeforeClass
    public void createActivity() {
        ActivityResponse createActivityResponse = ActivitiesAPI.createActivityResponse(createActivityRequest);
        activitiesAsserts.assertActivity(createActivityResponse, createActivityRequest);

        testID = ActivitiesAPI.getActivitiesResponses()[3].getId().toString();
    }

    @Test
    @Description("Get list of activities")
    public void getListOfActivities() {
        ActivityResponse[] getActivitiesResponses = ActivitiesAPI.getActivitiesResponses();

        activitiesAsserts.assertListOfActivities(getActivitiesResponses);
    }

    @Test
    @Description("Get activity by ID")
    public void getActivityById() {
        ActivityResponse getActivityByIdResponse = ActivitiesAPI.getActivityByIdResponse(testID);

        activitiesAsserts.assertGetById(getActivityByIdResponse);
    }

    @Test
    @Description("Update activity")
    public void updateActivity() {
        updateId = updateActivityRequest.getId().toString();
        ActivityResponse updateActivityResponse = ActivitiesAPI.updateActivityResponse(updateId,updateActivityRequest);

        activitiesAsserts.assertActivity(updateActivityResponse, updateActivityRequest);
    }

    @Test
    @Description("Delete activity")
    public void deleteActivity() {
        ActivityResponse createActivityResponse = ActivitiesAPI.createActivityResponse(createActivityRequest);
        deleteID = createActivityResponse.getId().toString();
        EmptyResponse deleteActivity = ActivitiesAPI.deleteActivityResponse(deleteID);
        ActivityResponse[] getActivitiesResponses = ActivitiesAPI.getActivitiesResponses();
        activitiesAsserts.assertDeleteActivity(getActivitiesResponses);
    }

    @AfterClass
    public void deleteTestActivity() {
        EmptyResponse deleteActivity = ActivitiesAPI.deleteActivityResponse(testID);
        ActivityResponse[] getActivitiesResponses = ActivitiesAPI.getActivitiesResponses();
        activitiesAsserts.assertDeleteActivity(getActivitiesResponses);
    }
}
