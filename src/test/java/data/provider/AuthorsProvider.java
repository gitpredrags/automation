package data.provider;

import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.authors.AuthorRequest;

public class AuthorsProvider {

    public static AuthorRequest createAuthorRequest() {
        AuthorRequest createAuthorRequest = new AuthorRequest();
        createAuthorRequest.setId(ValueChoosers.getRandomId());
        createAuthorRequest.setFirstName(Faker.instance().dragonBall().character());
        createAuthorRequest.setLastName(Faker.instance().funnyName().name());
        createAuthorRequest.setIdBook(ValueChoosers.getRandomId());
        return createAuthorRequest;
    }

    public static AuthorRequest updateAuthorRequest(){
        AuthorRequest updateAuthorRequest = new AuthorRequest();
        updateAuthorRequest.setId(ValueChoosers.getRandomId());
        updateAuthorRequest.setFirstName(Faker.instance().funnyName().name());
        updateAuthorRequest.setLastName(Faker.instance().backToTheFuture().character());
        updateAuthorRequest.setIdBook(ValueChoosers.getRandomId());
        return updateAuthorRequest;
    }
}
