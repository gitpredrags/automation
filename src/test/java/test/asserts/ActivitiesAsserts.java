package test.asserts;

import data.models.activites.*;
import org.testng.asserts.SoftAssert;
import test.common.TestBaseActivities;
import test.suite.ActivitiesTests;

public class ActivitiesAsserts extends TestBaseActivities {

    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfActivities(ActivityResponse[] getActivitiesResponses) {
        for (int i = 0; i <getActivitiesResponses.length; i++){
            softAssert.assertFalse(getActivitiesResponses[i].getTitle().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertActivity (ActivityResponse createActivityResponse, ActivityRequest createActivityRequest) {
        softAssert.assertEquals(createActivityResponse.getId(), createActivityRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(createActivityResponse.getTitle(), createActivityRequest.getTitle(), "Title doesn't match");
        softAssert.assertEquals(createActivityResponse.getDueDate(), createActivityRequest.getDueDate(), "Due date doesn't match");
        softAssert.assertEquals(createActivityResponse.getCompleted(), createActivityRequest.getCompleted(), "Completed status doesn't match");
        softAssert.assertAll();
    }

    public void assertGetById (ActivityResponse getActivityByIdResponse){
        softAssert.assertEquals(getActivityByIdResponse.getId().toString(), ActivitiesTests.testID, "ID doesn't match");
        softAssert.assertAll();
    }

    public void assertDeleteActivity (ActivityResponse[] getActivitiesResponses){
        for (int i = 0; i<getActivitiesResponses.length; i++){
            softAssert.assertNotEquals(getActivitiesResponses[i].getId().toString(), ActivitiesTests.deleteID, "Crocodile is not deleted");
        }
        softAssert.assertAll();
    }
}

