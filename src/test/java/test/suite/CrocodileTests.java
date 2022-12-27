package test.suite;

import calls.CrocodileAPI;
import data.models.*;
import data.provider.CrocodileProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();
    CreateCrocodileRequest createCrocodileRequest;
    UpdateNameFieldRequest updateNameFieldRequest;


   @BeforeMethod
   public void prepareTestData() {
       createCrocodileRequest = CrocodileProvider.createCrocodileRequest();
       updateNameFieldRequest = CrocodileProvider.updateNameFieldRequest();
   }

   @BeforeClass
   public void createTestCrocodile() {
       createCrocodileRequest = CrocodileProvider.createCrocodileRequest();
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

        crocodileAsserts.assertPrivateCrocodileById(getPrivateCrocodileByIdResponse);
    }

    /*@Test
    @Description("Verify crocodile is created")
    public void createCrocodileTest(){
        CreateCrocodileResponse createCrocodileResponse = CrocodileAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCrocodileNewCrocodile(createCrocodileResponse, createCrocodileRequest);
    }*/

    @Test
    @Description("Verify that crocodile is updated")
    public void updateCrocodileTest(){
       UpdateCrocodileResponse updateCrocodileResponse = CrocodileAPI.updateCrocodile(testId, accessToken, createCrocodileRequest);

       crocodileAsserts.assertUpdateCrocodile(updateCrocodileResponse, createCrocodileRequest);
    }

    @Test
    @Description("Verify that name is updated")
    public void updateCrocodileNameTest(){
       UpdateNameFieldResponse updateNameFieldResponse = CrocodileAPI.updateNameFieldResponse(testId, accessToken, updateNameFieldRequest);

       crocodileAsserts.assertUpdateCrocodileName(updateNameFieldResponse, updateNameFieldRequest);
    }

    @AfterClass
    @Description("Delete crocodile")
    public void deleteCrocodile(){
       DeleteCrocodileResponse deleteCrocodileResponse = CrocodileAPI.deleteCrocodileResponse(testId, accessToken);

       GetPrivateCrocodileResponse[] getPrivateCrocodileResponses = CrocodileAPI.getPrivateCrocodileResponses(accessToken);

       crocodileAsserts.assertDeleteCrocodile(getPrivateCrocodileResponses);
    }

    /*@AfterClass
    public void afterClass() {
        DeleteTestCrocodileResponse deleteTestCrocodileResponse = CrocodileAPI.deleteTestCrocodileResponse("my/crocodiles/" + testId+  "/", accessToken);
    }*/
}
