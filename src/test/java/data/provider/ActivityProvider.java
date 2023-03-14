package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.activites.ActivityRequest;

public class ActivityProvider {

    public static ActivityRequest createActivityRequest() {
        ActivityRequest createActivityRequest = new ActivityRequest();
        createActivityRequest.setId(ValueChoosers.getRandomId());
        createActivityRequest.setTitle(Faker.instance().book().title());
        createActivityRequest.setDueDate(ValueChoosers.getRandomDueDate());
        createActivityRequest.setCompleted(Faker.instance().random().nextBoolean());
        return createActivityRequest;
    }

    public static ActivityRequest updateActivityRequest() {
        ActivityRequest updateActivityRequest = new ActivityRequest();
        updateActivityRequest.setId(ValueChoosers.getRandomId());
        updateActivityRequest.setTitle(Faker.instance().book().title());
        updateActivityRequest.setDueDate(ValueChoosers.getRandomDueDate());
        updateActivityRequest.setCompleted(Faker.instance().random().nextBoolean());
        return updateActivityRequest;
    }
}