package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.CreateCrocodileRequest;
import data.models.UpdateCrocodileRequest;
import data.models.UpdateNameFieldRequest;

public class CrocodileProvider {

    public static CreateCrocodileRequest createCrocodileRequest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest();
        createCrocodileRequest.setName(Faker.instance().gameOfThrones().character());
        createCrocodileRequest.setSex(ValueChoosers.getRandomSex());
        createCrocodileRequest.setDateOfBirth(ValueChoosers.getRandomDate());
        return createCrocodileRequest;
    }

    public static UpdateCrocodileRequest updateCrocodileRequest() {
        UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest();
        updateCrocodileRequest.setName(Faker.instance().artist().name());
        updateCrocodileRequest.setSex(ValueChoosers.getRandomSex());
        updateCrocodileRequest.setDateOfBirth(ValueChoosers.getRandomDate());
        return updateCrocodileRequest;
    }


    public static UpdateNameFieldRequest updateNameFieldRequest() {
        UpdateNameFieldRequest updateNameFieldRequest = new UpdateNameFieldRequest();
        updateNameFieldRequest.setName(Faker.instance().dragonBall().character());
        return updateNameFieldRequest;
    }
}
