package test.suite;

import calls.UsersAPI;
import com.github.javafaker.Faker;
import data.models.common.EmptyResponse;
import data.models.users.UsersRequest;
import data.models.users.UsersResponse;
import data.provider.UserProvider;
import jdk.jfr.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.UsersAsserts;
import test.common.TestBaseUsers;

public class UsersTests extends TestBaseUsers {

    public static String testID;
    public static String deleteID;

    public UsersAsserts usersAsserts = new UsersAsserts();

    UsersRequest createUserRequest = UserProvider.createUserRequest();
    UsersRequest updateUserRequest = UserProvider.updateUserRequest();

    @BeforeClass
    public void testUser() {
        int i = Faker.instance().random().nextInt(1,5);
        UsersResponse[] getUserResponse = UsersAPI.getUsersResponse();
        testID = getUserResponse[i].getId().toString();
    }

    @Test
    @Description("Get list of users")
    public void getListOfUsers() {
        UsersResponse[] getUsersResponse = UsersAPI.getUsersResponse();
        usersAsserts.assertListOfUsers(getUsersResponse);
    }

    @Test
    @Description("Create user")
    public void createSingleUser() {
        UsersResponse createUserResponse = UsersAPI.createUserResponse(createUserRequest);
        usersAsserts.assertUser(createUserResponse, createUserRequest);
    }

    @Test
    @Description("Get user by ID")
    public void getUserById() {
        UsersResponse getUserByIdResponse = UsersAPI.getUserByIdResponse(testID);
        usersAsserts.assertUserById(getUserByIdResponse);
    }

    @Test
    @Description("Update user")
    public void updateUser() {
        UsersResponse updateUserResponse = UsersAPI.updateUserResponse(testID, updateUserRequest);
        usersAsserts.assertUser(updateUserResponse, updateUserRequest);
    }

    @Test
    @Description("Delete user")
    public void deleteUser() {
        UsersResponse createUserResponse = UsersAPI.createUserResponse(createUserRequest);
        deleteID = createUserResponse.getId().toString();
        EmptyResponse deleteUser = UsersAPI.deleteUser(deleteID);
        UsersResponse[] getUsersResponse = UsersAPI.getUsersResponse();
        usersAsserts.assertDeleteUser(getUsersResponse);
    }

    @AfterClass
    public void deleteTestUser() {
        EmptyResponse deleteTestUser = UsersAPI.deleteUser(testID);
        UsersResponse[] getUserResponse = UsersAPI.getUsersResponse();
        usersAsserts.assertDeleteUser(getUserResponse);
    }
}
