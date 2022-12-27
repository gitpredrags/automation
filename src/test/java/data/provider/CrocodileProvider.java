package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.CreateCrocodileRequest;
import data.models.UpdateNameFieldRequest;

public class CrocodileProvider {

    public static CreateCrocodileRequest createCrocodileRequest() {
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest();
        createCrocodileRequest.setName(Faker.instance().gameOfThrones().character());
        createCrocodileRequest.setSex(ValueChoosers.getRandomSex());
        createCrocodileRequest.setDateOfBirth(ValueChoosers.getRandomDate());
        return createCrocodileRequest;
    }


    public static UpdateNameFieldRequest updateNameFieldRequest() {
        UpdateNameFieldRequest updateNameFieldRequest = new UpdateNameFieldRequest();
        updateNameFieldRequest.setName(Faker.instance().dragonBall().character());
        return updateNameFieldRequest;
    }
}
