package data.provider;

import com.github.javafaker.Faker;
import data.models.coverPhotos.CoverPhotosRequest;

public class CoverPhotoProvider {

    public static CoverPhotosRequest createCoverPhotoRequest() {
        CoverPhotosRequest createCoverPhotoRequest = new CoverPhotosRequest();
        createCoverPhotoRequest.setId(Faker.instance().random().nextInt(200,400));
        createCoverPhotoRequest.setUrl(Faker.instance().address().fullAddress());
        createCoverPhotoRequest.setIdBook(Faker.instance().random().nextInt(500,800));
        return createCoverPhotoRequest;
    }

    public static CoverPhotosRequest updateCoverPhotoRequest() {
        CoverPhotosRequest updateCoverPhotoRequest = new CoverPhotosRequest();
        updateCoverPhotoRequest.setId(Faker.instance().random().nextInt(799,1000));
        updateCoverPhotoRequest.setUrl(Faker.instance().address().secondaryAddress());
        updateCoverPhotoRequest.setIdBook(Faker.instance().random().nextInt(1001,2000));
        return updateCoverPhotoRequest;
    }
}
