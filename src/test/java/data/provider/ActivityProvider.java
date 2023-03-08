package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.activites.CreateActivityRequest;
import data.models.activites.UpdateActivityRequest;

public class ActivityProvider {

    public static CreateActivityRequest createActivityRequest() {
        CreateActivityRequest createActivityRequest = new CreateActivityRequest();
        createActivityRequest.setId(ValueChoosers.getRandomId());
        createActivityRequest.setTitle(Faker.instance().book().title());
        createActivityRequest.setDueDate(ValueChoosers.getRandomDueDate());
        createActivityRequest.setCompleted(Faker.instance().random().nextBoolean());
        return createActivityRequest;
    }

    public static UpdateActivityRequest updateActivityRequest() {
        UpdateActivityRequest updateActivityRequest = new UpdateActivityRequest();
        updateActivityRequest.setId(ValueChoosers.getRandomId());
        updateActivityRequest.setTitle(Faker.instance().book().title());
        updateActivityRequest.setDueDate(ValueChoosers.getRandomDueDate());
        updateActivityRequest.setCompleted(Faker.instance().random().nextBoolean());
        return updateActivityRequest;
    }
}