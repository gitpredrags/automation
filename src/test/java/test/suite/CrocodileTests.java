package test.suite;

import calls.CrocodileAPI;
import data.models.*;
import data.provider.CrocodileProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public static String publicID = "2";
    public static String testId;

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
    CreateCrocodileRequest createCrocodileRequest = CrocodileProvider.createCrocodileRequest();
    UpdateCrocodileRequest updateCrocodileRequest = CrocodileProvider.updateCrocodileRequest();
    UpdateNameFieldRequest updateNameFieldRequest = CrocodileProvider.updateNameFieldRequest();

   @BeforeClass
   public void createTestCrocodile() {
       CreateCrocodileResponse createCrocodileResponse = CrocodileAPI.createNewCrocodile(accessToken, createCrocodileRequest);

       testId = createCrocodileResponse.getId().toString();
   }

   @Test
   @Description("Public crocodile list")
   public void getListOfPublicCrocodiles() {
       GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodileAPI.getPublicCrocodileResponse();

       crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
   }

   @Test
   @Description("Public crocodile by ID test")
   public void getCrocodileById() {
       GetPublicCrocodileByIdResponse getPublicCrocodileByIdResponse = CrocodileAPI.getPublicCrocodileById();

       crocodileAsserts.assertCrocodileById(getPublicCrocodileByIdResponse);
   }

    @Test
    @Description("Login test")
    public void loginTest(){
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("Private crocodile list")
    public void getListOfPrivateCrocodiles() {
        GetPrivateCrocodileResponse[] getPrivateCrocodileResponses = CrocodileAPI.getPrivateCrocodileResponses(accessToken);

        crocodileAsserts.assertListOfPrivateCrocodiles(getPrivateCrocodileResponses);
    }

    @Test
    @Description("Get private crocodile by ID test")
    public void getPrivateCrocodileById(){
       GetPrivateCrocodileByIdResponse getPrivateCrocodileByIdResponse = CrocodileAPI.getPrivateCrocodileByIdResponse(testId, accessToken);

        crocodileAsserts.assertPrivateCrocodileById(getPrivateCrocodileByIdResponse, createCrocodileRequest);
    }

    @Test
    @Description("Verify that crocodile is updated")
    public void updateCrocodileTest(){
       UpdateCrocodileResponse updateCrocodileResponse = CrocodileAPI.updateCrocodile(testId, accessToken, updateCrocodileRequest);

       crocodileAsserts.assertUpdateCrocodile(updateCrocodileResponse, updateCrocodileRequest);
    }

    @Test
    @Description("Verify that name is updated")
    public void updateCrocodileNameTest(){
       UpdateNameFieldResponse updateNameFieldResponse = CrocodileAPI.updateNameFieldResponse(testId, accessToken, updateNameFieldRequest);

       crocodileAsserts.assertUpdateCrocodileName(updateNameFieldResponse, updateNameFieldRequest);
    }

    @Test
    @Description("delete")
    public void deleteCrocodile() {
        CreateCrocodileResponse createCrocodileResponse = CrocodileAPI.createNewCrocodile(accessToken, createCrocodileRequest);
        String deleteId = createCrocodileResponse.getId().toString();
        DeleteCrocodileResponse deleteCrocodileResponse = CrocodileAPI.deleteCrocodileResponse(deleteId, accessToken);

        GetPrivateCrocodileResponse[] getPrivateCrocodileResponses = CrocodileAPI.getPrivateCrocodileResponses(accessToken);

        crocodileAsserts.assertDeleteCrocodile(getPrivateCrocodileResponses);
    }
    @AfterClass
    @Description("Delete crocodile")
    public void deleteAfterClassCrocodile(){
       DeleteCrocodileResponse deleteCrocodileResponse = CrocodileAPI.deleteCrocodileResponse(testId, accessToken);

       GetPrivateCrocodileResponse[] getPrivateCrocodileResponses = CrocodileAPI.getPrivateCrocodileResponses(accessToken);

       crocodileAsserts.assertDeleteCrocodile(getPrivateCrocodileResponses);
    }
}
