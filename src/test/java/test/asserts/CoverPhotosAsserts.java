package test.asserts;

import data.models.coverPhotos.CoverPhotosRequest;
import data.models.coverPhotos.CoverPhotosResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import test.common.TestBaseCoverPhotos;
import test.suite.CoverPhotosTests;

public class CoverPhotosAsserts extends TestBaseCoverPhotos {

    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfCoverPhotos(CoverPhotosResponse[] getListOfCoverPhotosResponse) {
        for (int i =1; i< getListOfCoverPhotosResponse.length; i++) {
            softAssert.assertFalse(getListOfCoverPhotosResponse[i].getUrl().isEmpty(), "URL is empty");
        }
        softAssert.assertAll();
    }

    public void assertCoverPhoto(CoverPhotosResponse createCoverPhotoResponse, CoverPhotosRequest createCoverPhotoRequest){
        softAssert.assertEquals(createCoverPhotoResponse.getUrl(), createCoverPhotoRequest.getUrl(), "URL doesn't match");
        softAssert.assertEquals(createCoverPhotoResponse.getId(), createCoverPhotoRequest.getId(), "ID doesn't match");
        softAssert.assertEquals(createCoverPhotoResponse.getIdBook(), createCoverPhotoRequest.getIdBook(), "Book ID doesn't match");
        softAssert.assertAll();
    }

    public void assertCoverPhotoById (CoverPhotosResponse getCoverPhotoByIdResponse){
        Assert.assertEquals(getCoverPhotoByIdResponse.getId().toString(), CoverPhotosTests.testID, "ID doesn't match");
    }

    public void assertDeleteCoverPhoto (CoverPhotosResponse[] getListOfCoverPhotosResponse) {
        for (int i = 1; i < getListOfCoverPhotosResponse.length; i++) {
            softAssert.assertNotEquals(getListOfCoverPhotosResponse[i].getUrl(), CoverPhotosTests.deleteID);
        }
        softAssert.assertAll();
    }
}
