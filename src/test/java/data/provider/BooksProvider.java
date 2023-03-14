package data.provider;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import common.ValueChoosers;
import data.models.books.BookRequest;

public class BooksProvider {

    public static BookRequest createBookRequest() {
        BookRequest createBookRequest = new BookRequest();
        createBookRequest.setTitle(Faker.instance().book().title());
        createBookRequest.setDescription(Faker.instance().book().genre());
        createBookRequest.setId(ValueChoosers.getRandomId());
        createBookRequest.setPublishDate(ValueChoosers.getRandomDueDate());
        createBookRequest.setExcerpt(Faker.instance().book().publisher());
        createBookRequest.setPageCount(Faker.instance().random().nextInt(1, 320));
        return createBookRequest;
    }

    public static BookRequest updateBookRequest() {
        BookRequest updateBookRequest = new BookRequest();
        updateBookRequest.setTitle(Faker.instance().book().title());
        updateBookRequest.setDescription(Faker.instance().book().genre());
        updateBookRequest.setId(ValueChoosers.getRandomId());
        updateBookRequest.setPublishDate(ValueChoosers.getRandomDueDate());
        updateBookRequest.setExcerpt(Faker.instance().book().publisher());
        updateBookRequest.setPageCount(Faker.instance().random().nextInt(1, 320));
        return updateBookRequest;
    }
}
