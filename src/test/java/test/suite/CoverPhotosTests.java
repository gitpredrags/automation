package test.suite;

import calls.CoverPhotosAPI;
import com.github.javafaker.Faker;
import data.models.common.EmptyResponse;
import data.models.coverPhotos.CoverPhotosRequest;
import data.models.coverPhotos.CoverPhotosResponse;
import data.provider.CoverPhotoProvider;
import jdk.jfr.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.CoverPhotosAsserts;
import test.common.TestBaseCoverPhotos;

public class CoverPhotosTests extends TestBaseCoverPhotos {

    public static String testID;
    public static String deleteID;

    CoverPhotosRequest createCoverPhotoRequest = CoverPhotoProvider.createCoverPhotoRequest();
    CoverPhotosRequest updateCoverPhotoRequest = CoverPhotoProvider.updateCoverPhotoRequest();

    public CoverPhotosAsserts coverPhotosAsserts = new CoverPhotosAsserts();

    @BeforeClass
    public void testCoverPhoto() {
        int i = Faker.instance().random().nextInt(0,199);
        CoverPhotosResponse[] getListOfCoverPhotos = CoverPhotosAPI.getCoverPhotos();
        testID = getListOfCoverPhotos[i].getId().toString();
    }

    @Test
    @Description("Get list of cover photos")
    public void getListOfCoverPhotos() {
        CoverPhotosResponse[] getListOfCoverPhotos = CoverPhotosAPI.getCoverPhotos();
        coverPhotosAsserts.assertListOfCoverPhotos(getListOfCoverPhotos);
    }

    @Test
    @Description("Create Cover Photo")
    public void createCoverPhoto() {
        CoverPhotosResponse createCoverPhotoResponse = CoverPhotosAPI.createPhotoCoverResponse(createCoverPhotoRequest);
        coverPhotosAsserts.assertCoverPhoto(createCoverPhotoResponse, createCoverPhotoRequest);
    }

    @Test
    @Description("Get cover photo by ID")
    public void getCoverPhotoById() {
        CoverPhotosResponse getCoverPhotoByIdResponse = CoverPhotosAPI.getCoverPhotoById(testID);
        coverPhotosAsserts.assertCoverPhotoById(getCoverPhotoByIdResponse);
    }

    @Test
    @Description("Update cover photo")
    public void updateCoverPhoto() {
        CoverPhotosResponse updateCoverPhotoResponse = CoverPhotosAPI.updateCoverPhotoResponse(testID, updateCoverPhotoRequest);
        coverPhotosAsserts.assertCoverPhoto(updateCoverPhotoResponse, updateCoverPhotoRequest);
    }

    @Test
    @Description("Delete cover photo")
    public void deleteCoverPhoto() {
        CoverPhotosResponse createCoverPhotoResponse = CoverPhotosAPI.createPhotoCoverResponse(createCoverPhotoRequest);
        deleteID = createCoverPhotoResponse.getId().toString();
        EmptyResponse deleteCoverPhoto = CoverPhotosAPI.deleteCoverPhotoResponse(deleteID);
        CoverPhotosResponse[] getListOfCoverPhotos = CoverPhotosAPI.getCoverPhotos();
        coverPhotosAsserts.assertDeleteCoverPhoto(getListOfCoverPhotos);
    }

    @AfterClass
    public void deleteTestCoverPhoto() {
        EmptyResponse deleteTestCoverPhoto = CoverPhotosAPI.deleteCoverPhotoResponse(testID);
        CoverPhotosResponse[] getListOfCoverPhotos = CoverPhotosAPI.getCoverPhotos();
        coverPhotosAsserts.assertDeleteCoverPhoto(getListOfCoverPhotos);
    }
}
