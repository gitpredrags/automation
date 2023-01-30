package test.asserts;

import data.models.*;
import org.testng.asserts.SoftAssert;
import test.common.TestBase;
import test.suite.CrocodileTests;

public class CrocodileAsserts extends TestBase {
    public SoftAssert softAssert = new SoftAssert();

    public void assertListOfPublicCrocodiles (GetPublicCrocodileResponse[] getPublicCrocodileResponses){
        for (int i = 0; i < getPublicCrocodileResponses.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponses[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertCrocodileById (GetPublicCrocodileByIdResponse getPublicCrocodileByIdResponse){
        softAssert.assertEquals(getPublicCrocodileByIdResponse.getId().toString(), CrocodileTests.publicID , "ID don't match");
           softAssert.assertAll();
    }


    public void assertListOfPrivateCrocodiles (GetPrivateCrocodileResponse[] getPrivateCrocodileResponses){
        for (int i = 0; i < getPrivateCrocodileResponses.length; i++) {
            softAssert.assertFalse(getPrivateCrocodileResponses[i].getName().isEmpty(), "Name is empty");
            softAssert.assertFalse(getPrivateCrocodileResponses[i].getSex().isEmpty(), "Sex is empty");
            softAssert.assertFalse(getPrivateCrocodileResponses[i].getDateOfBirth().isEmpty(), "Date of birth is empty");
        }
        softAssert.assertAll();
    }

    public void assertPrivateCrocodileById (GetPrivateCrocodileByIdResponse getPrivateCrocodileByIdResponse, CreateCrocodileRequest createCrocodileRequest){
        softAssert.assertEquals(getPrivateCrocodileByIdResponse.getId().toString(), CrocodileTests.testId, "ID don't match");
        softAssert.assertEquals(getPrivateCrocodileByIdResponse.getName(),createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(getPrivateCrocodileByIdResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertEquals(getPrivateCrocodileByIdResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertAll();
    }

    public void assertCrocodileNewCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "Date of birth didn't match");
        softAssert.assertAll();
    }

    public void assertUpdateCrocodile (UpdateCrocodileResponse updateCrocodileResponse, UpdateCrocodileRequest updateCrocodileRequest){
        softAssert.assertEquals(updateCrocodileResponse.getName(), updateCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getSex(), updateCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertEquals(updateCrocodileResponse.getDateOfBirth(), updateCrocodileRequest.getDateOfBirth(), "Date if birth didn't match");
        softAssert.assertAll();
    }

    public void assertUpdateCrocodileName (UpdateNameFieldResponse updateNameFieldResponse, UpdateNameFieldRequest updateNameFieldRequest){
        softAssert.assertEquals(updateNameFieldRequest.getName(), updateNameFieldResponse.getName(), "Name is not updated");
        softAssert.assertAll();
    }

    public void assertDeleteCrocodile (GetPrivateCrocodileResponse[] getPrivateCrocodileResponse){
        for (int i = 0; i<getPrivateCrocodileResponse.length; i++){
            softAssert.assertNotEquals(getPrivateCrocodileResponse[i].getId().toString(), "12203160", "Crocodile is not deleted");
        }
        softAssert.assertAll();
    }
}
