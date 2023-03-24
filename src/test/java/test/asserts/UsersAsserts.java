package test.asserts;

import data.models.users.UsersRequest;
import data.models.users.UsersResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test.common.TestBaseUsers;
import test.suite.UsersTests;

public class UsersAsserts extends TestBaseUsers {

    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfUsers (UsersResponse[] getUsersResponse){
        for (int i = 1; i < getUsersResponse.length; i++) {
            softAssert.assertFalse(getUsersResponse[i].getUserName().isEmpty(), "Username is empty");
        }
    }

    public void assertUser (UsersResponse createUserResponse, UsersRequest createUserRequest){
        softAssert.assertEquals(createUserResponse.getUserName(), createUserRequest.getUserName(), "Username doesn't match");
        softAssert.assertEquals(createUserResponse.getPassword(), createUserRequest.getPassword(), "Password doesn't match");
        softAssert.assertEquals(createUserResponse.getId(), createUserRequest.getId(), "ID doesn't match");
        softAssert.assertAll();
    }

    public void assertUserById (UsersResponse getUserByIdResponse){
        Assert.assertEquals(getUserByIdResponse.getId().toString(), UsersTests.testID, "ID doesn't match");
    }

    public void assertDeleteUser (UsersResponse[] getUsersResponse) {
        for (int i = 1; i < getUsersResponse.length; i++) {
            softAssert.assertNotEquals(getUsersResponse[i].getId().toString(), UsersTests.testID);
        }
    }
}
