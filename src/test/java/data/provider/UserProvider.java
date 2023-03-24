package data.provider;

import com.github.javafaker.Faker;
import data.models.users.UsersRequest;

public class UserProvider {

    public static UsersRequest createUserRequest() {
        UsersRequest createUserRequest = new UsersRequest();
        createUserRequest.setId(Faker.instance().random().nextInt(11,500));
        createUserRequest.setUserName(Faker.instance().funnyName().name());
        createUserRequest.setPassword(Faker.instance().animal().name());
        return createUserRequest;
    }

    public static UsersRequest updateUserRequest() {
        UsersRequest updateUserRequest = new UsersRequest();
        updateUserRequest.setId(Faker.instance().random().nextInt(501,800));
        updateUserRequest.setUserName(Faker.instance().dragonBall().character());
        updateUserRequest.setPassword(Faker.instance().avatar().toString());
        return updateUserRequest;
    }
}
