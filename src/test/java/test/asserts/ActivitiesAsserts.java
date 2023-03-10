package test.asserts;

import data.models.activites.*;
import org.testng.asserts.SoftAssert;
import test.common.TestBaseActivities;

public class ActivitiesAsserts extends TestBaseActivities {

    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfActivities(GetActivitiesResponse[] getActivitiesResponses) {
        for (int i = 0; i <getActivitiesResponses.length; i++){
            softAssert.assertFalse(getActivitiesResponses[i].getTitle().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertCreatedActivity (CreateActivityResponse createActivityResponse, ActivityRequest createActivityRequest) {
        softAssert.assertEquals(createActivityResponse.getId(), createActivityRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(createActivityResponse.getTitle(), createActivityRequest.getTitle(), "Title doesn't match");
        softAssert.assertEquals(createActivityResponse.getDueDate(), createActivityRequest.getDueDate(), "Due date doesn't match");
        softAssert.assertEquals(createActivityResponse.getCompleted(), createActivityRequest.getCompleted(), "Completed status doesn't match");
        softAssert.assertAll();
    }

    public void assertGetById (GetActivityByIdResponse getActivityByIdResponse){
        softAssert.assertEquals(getActivityByIdResponse.getId(), getActivityByIdResponse.getId(), "ID doesn't match");
        softAssert.assertEquals(getActivityByIdResponse.getTitle(), getActivityByIdResponse.getTitle(), "Title doesn't match");
        softAssert.assertEquals(getActivityByIdResponse.getDueDate(), getActivityByIdResponse.getDueDate(), "Due date doesn't match");
        softAssert.assertEquals(getActivityByIdResponse.getCompleted(), getActivityByIdResponse.getCompleted(), "Completed status doesn't match");
        softAssert.assertAll();
    }

    public void assertUpdateActivity (UpdateActivityResponse updateActivityResponse, ActivityRequest updateActivityRequest){
        softAssert.assertEquals(updateActivityResponse.getId(), updateActivityRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(updateActivityResponse.getCompleted(), updateActivityRequest.getCompleted(), "Completed status doesn't match");
        softAssert.assertEquals(updateActivityResponse.getDueDate(), updateActivityRequest.getDueDate(), "Due date doesn't match");
        softAssert.assertEquals(updateActivityRequest.getTitle(), updateActivityRequest.getTitle(), "Title doesn't match");
        softAssert.assertAll();
    }

    public void assertDeleteActivity (GetActivitiesResponse[] getActivitiesResponses){
        for (int i = 0; i<getActivitiesResponses.length; i++){
            softAssert.assertNotEquals(getActivitiesResponses[3].getId().toString(), "4", "Crocodile is not deleted");
        }
        softAssert.assertAll();
    }
}

