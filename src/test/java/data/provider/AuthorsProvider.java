package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.authors.CreateAuthorRequest;
import data.models.authors.UpdateAuthorRequest;

public class AuthorsProvider {

    public static CreateAuthorRequest createAuthorRequest() {
        CreateAuthorRequest createAuthorRequest = new CreateAuthorRequest();
        createAuthorRequest.setId(ValueChoosers.getRandomId());
        createAuthorRequest.setFirstName(Faker.instance().dragonBall().character());
        createAuthorRequest.setLastName(Faker.instance().funnyName().name());
        createAuthorRequest.setIdBook(ValueChoosers.getRandomId());
        return createAuthorRequest;
    }

    public static UpdateAuthorRequest updateAuthorRequest(){
        UpdateAuthorRequest updateAuthorRequest = new UpdateAuthorRequest();
        updateAuthorRequest.setId(ValueChoosers.getRandomId());
        updateAuthorRequest.setFirstName(Faker.instance().funnyName().name());
        updateAuthorRequest.setLastName(Faker.instance().backToTheFuture().character());
        updateAuthorRequest.setIdBook(ValueChoosers.getRandomId());
        return updateAuthorRequest;
    }
}
